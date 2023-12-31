package com.example.giphysearch.domain.model

import com.squareup.moshi.Json
data class TrendingNetworkResponse(
    @Json(name = "data")
    val data: List<TrendingData>,
    val meta: Meta,
    val pagination: Pagination,
)

data class TrendingData(
    val analytics_response_payload: String,
    val bitly_gif_url: String,
    val bitly_url: String,
    val content_url: String,
    val embed_url: String,
    val id: String,
    val images: Images,
    val import_datetime: String,
    val is_sticker: Int,
    val rating: String,
    val slug: String,
    val source: String,
    val source_post_url: String,
    val source_tld: String,
    val title: String,
    val trending_datetime: String,
    val type: String,
    val url: String,
    val username: String,
)

data class Meta(
    val msg: String,
    val response_id: String,
    val status: Int,
)

data class Pagination(
    val count: Int,
    val offset: Int,
    val total_count: Int,
)

data class Images(
    val fixed_height: FixedHeight,
    val fixed_width: FixedWidth,
    val original: Original,
)

data class FixedHeight(
    val height: String,
    val mp4: String? = null,
    val mp4_size: String? = null,
    val size: String,
    val url: String,
    val webp: String? = null,
    val webp_size: String? = null,
    val width: String,
)

data class FixedWidth(
    val height: String,
    val mp4: String? = null,
    val mp4_size: String? = null,
    val size: String,
    val url: String,
    val webp: String? = null,
    val webp_size: String? = null,
    val width: String,
)

data class Original(
    val frames: String,
    val hash: String,
    val height: String,
    val mp4: String? = null,
    val mp4_size: String? = null,
    val size: String,
    val url: String,
    val webp: String? = null,
    val webp_size: String? = null,
    val width: String,
)