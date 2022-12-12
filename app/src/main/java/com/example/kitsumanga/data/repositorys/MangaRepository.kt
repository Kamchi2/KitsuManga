package com.example.kitsumanga.data.repositorys

import com.example.kitsumanga.base.BaseRepository
import com.example.kitsumanga.data.remote.apiservices.youtube.MangaApiService
import javax.inject.Inject

class MangaRepository @Inject constructor(private val service: MangaApiService): BaseRepository() {

    fun fetchManga(limit: Int, offset: Int) = doRequest {
        service.fetchManga(limit, offset)
    }
}