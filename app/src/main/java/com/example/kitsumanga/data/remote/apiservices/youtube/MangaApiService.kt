package com.example.kitsumanga.data.remote.apiservices.youtube

import com.example.kitsumanga.models.MangaResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MangaApiService {
    @GET("manga")
    suspend fun fetchManga(
        @Query("page[limit]") limit: Int = 24,
        @Query("page[offset]") offset: Int = 0
    ): Response<MangaResponse>
}
