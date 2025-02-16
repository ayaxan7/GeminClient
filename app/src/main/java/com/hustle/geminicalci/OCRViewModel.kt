package com.hustle.geminicalci

import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import kotlinx.coroutines.tasks.await
class OCRViewModel : ViewModel() {
    private val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

    suspend fun processImage(bitmap: Bitmap): String? {
        Log.d("OCRViewModel", "Processing Image: $bitmap")
        return try {
            val image = InputImage.fromBitmap(bitmap, 0)
            val result = recognizer.process(image).await()
            Log.d("OCRViewModel", "OCR Result: ${result.text}")
            return result.text // Fix: Ensure the extracted text is returned
        } catch (e: Exception) {
            Log.e("OCRViewModel", "Error processing image", e)
            null
        }
    }
}
