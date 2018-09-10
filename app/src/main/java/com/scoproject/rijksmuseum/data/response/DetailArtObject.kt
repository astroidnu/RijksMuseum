package com.scoproject.rijksmuseum.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
sealed class DetailArtObject {
    data class Response(
        @SerializedName("artObject")
        @Expose
        val artObject : Data? = null
    )

    data class Data(
            @SerializedName("id")
            @Expose
            val id: String? = null,
            @SerializedName("objectNumber")
            @Expose
            val objectNumber: String? = null,
            @SerializedName("webImage")
            @Expose
            val webImage: WebImage? = null,
            @SerializedName("label")
            @Expose
            val label: Label? = null
    )

    data class WebImage (
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


    data class Label(
            @SerializedName("title")
            @Expose
            val title: String? = null,
            @SerializedName("makerLine")
            @Expose
            val makerLine: String? = null,
            @SerializedName("description")
            @Expose
            val description: String? = null,
            @SerializedName("notes")
            @Expose
            val notes: String? = null,
            @SerializedName("date")
            @Expose
            val date: String? = null
    )


}