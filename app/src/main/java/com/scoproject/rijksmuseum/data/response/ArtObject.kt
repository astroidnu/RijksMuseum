package com.scoproject.rijksmuseum.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
sealed class ArtObject {

    data class Response (
          @SerializedName("artObjects")
          @Expose
          val data : List<ArtObjects>? = null
    )

    data class ArtObjects(
            @SerializedName("links")
            @Expose
            val links: links? = null,
            @SerializedName("id")
            @Expose
            val id: String? = null,
            @SerializedName("objectNumber")
            @Expose
            val objectNumber: String? = null,
            @SerializedName("title")
            @Expose
            val title: String? = null,
            @SerializedName("hasImage")
            @Expose
            val hasImage: Boolean? = null,
            @SerializedName("principalOrFirstMaker")
            @Expose
            val principalOrFirstMaker: String? = null,
            @SerializedName("longTitle")
            @Expose
            val longTitle: String? = null,
            @SerializedName("showImage")
            @Expose
            val showImage: Boolean? = null,
            @SerializedName("permitDownload")
            @Expose
            val permitDownload: Boolean? = null,
            @SerializedName("webImage")
            @Expose
            val webImage: webImage? = null,
            @SerializedName("headerImage")
            @Expose
            val headerImage: headerImage? = null,
            @SerializedName("productionPlaces")
            @Expose
            val productionPlaces: List<String>? = null
    )

    data class links (
            @SerializedName("self")
            @Expose
            val self: String? = null,
            @SerializedName("web")
            @Expose
            val web: String? = null
    )

    data class webImage (
            @SerializedName("guid")
            @Expose
            val guid: String? = null,
            @SerializedName("offsetPercentageX")
            @Expose
            val offsetPercentageX: Int? = null,
            @SerializedName("offsetPercentageY")
            @Expose
            val offsetPercentageY: Int? = null,
            @SerializedName("width")
            @Expose
            val width: Int? = null,
            @SerializedName("height")
            @Expose
            val height: Int? = null,
            @SerializedName("url")
            @Expose
            val url: String? = null
    )

    data class headerImage (
            @SerializedName("guid")
            @Expose
            val guid: String? = null,
            @SerializedName("offsetPercentageX")
            @Expose
            val offsetPercentageX: Int? = null,
            @SerializedName("offsetPercentageY")
            @Expose
            val offsetPercentageY: Int? = null,
            @SerializedName("width")
            @Expose
            val width: Int? = null,
            @SerializedName("height")
            @Expose
            val height: Int? = null,
            @SerializedName("url")
            @Expose
            val url: String? = null
    )
}