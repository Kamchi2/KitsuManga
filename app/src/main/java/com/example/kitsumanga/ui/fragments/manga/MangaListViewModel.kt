package com.example.kitsumanga.ui.fragments.manga

import com.example.kitsumanga.base.BaseViewModel
import com.example.kitsumanga.data.repositorys.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaListViewModel @Inject constructor(private val repository: MangaRepository) :
BaseViewModel() {

    fun fetchManga(limit: Int, offset: Int) = repository.fetchManga(limit, offset)

}
