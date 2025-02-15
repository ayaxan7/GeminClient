package com.hustle.geminicalci.network

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Headers

interface ApiService {
    @POST("/api/generate")
    @Headers("Content-Type: application/json")
    suspend fun generate(@Body request: Request): Response
}
data class Response(val result: String)
data class Request(val prompt: String)