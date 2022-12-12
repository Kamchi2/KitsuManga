package com.example.kitsumanga.ui.adapters.youtube

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.kitsumanga.base.BaseDiffUtilItemCallback
import com.example.kitsumanga.databinding.ItemMangaBinding
import com.example.kitsumanga.models.MangaModel


class MangaListAdapter :
    ListAdapter<MangaModel, MangaListAdapter.FilmsViewHolder>(BaseDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FilmsViewHolder(
        ItemMangaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        getItem(position).let { holder.onBind(it) }
    }

    inner class FilmsViewHolder(private val binding: ItemMangaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: MangaModel) {
            binding.mangaIconRv.load(model.attributes.posterImage.original)
            binding.mangaTitleTv.text = model.attributes.canonicalTitle
        }
    }
}