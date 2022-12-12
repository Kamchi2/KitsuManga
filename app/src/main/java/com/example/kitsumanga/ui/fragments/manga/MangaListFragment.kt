package com.example.kitsumanga.ui.fragments.manga

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsumanga.R
import com.example.kitsumanga.base.BaseFragment
import com.example.kitsumanga.databinding.FragmentMangaListBinding
import com.example.kitsumanga.ui.adapters.youtube.MangaListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaListFragment : BaseFragment<FragmentMangaListBinding, MangaListViewModel>(R.layout.fragment_manga_list) {

    override val binding by viewBinding(FragmentMangaListBinding::bind)
    override val viewModel: MangaListViewModel by viewModels()
    private val mangaAdapter = MangaListAdapter()

    var limit = 18
    var offset = 0

    override fun setupListeners() = with(binding) {
        mangaRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    offset += 18
                    subscribeToManga()
                }
            }
        })
    }

    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupSubscribes() {
        subscribeToManga()
    }

    private fun subscribeToManga() {
        viewModel.fetchManga(limit, offset).subscribe(
            onSuccess = {
                mangaAdapter.submitList(it.data)
            },
            onError = {
                Log.e("log", it)
            }
        )
    }

    private fun setupRecyclerView() {
        binding.mangaRv.adapter = mangaAdapter
    }
}