package com.example.kitsumanga.models

import com.example.kitsumanga.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class MangaResponse(
    @SerializedName("data")
    val data: List<MangaModel>
)
data class MangaModel (
    @SerializedName("id")
    override val id: Int,
    @SerializedName("attributes")
    val attributes: Attributes
): IBaseDiffModel<Int>

data class Attributes (
    @SerializedName("canonicalTitle")
    val canonicalTitle: String,
    @SerializedName("posterImage")
    val posterImage: PosterImage
)

data class PosterImage (
    @SerializedName("original")
    val original: String
)