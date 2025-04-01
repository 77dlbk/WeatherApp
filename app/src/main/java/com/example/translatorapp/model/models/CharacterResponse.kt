package com.example.translatorapp.model.models


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    @SerialName("info")
    var info: Info? = null,
    @SerialName("results")
    var results: List<Result?>? = null
) {
    @Serializable
    data class Info(
        @SerialName("count")
        var count: Int? = null,
        @SerialName("next")
        var next: String? = null,
        @SerialName("pages")
        var pages: Int? = null,


    )

    @Serializable
    @Parcelize
    data class Result(
        @SerialName("created")
        var created: String? = null,
        @SerialName("episode")
        var episode: List<String?>? = null,
        @SerialName("gender")
        var gender: String? = null,
        @SerialName("id")
        var id: Int? = null,
        @SerialName("image")
        var image: String? = null,
        @SerialName("name")
        var name: String? = null,
        @SerialName("species")
        var species: String? = null,
        @SerialName("status")
        var status: String? = null,
        @SerialName("type")
        var type: String? = null,
        @SerialName("url")
        var url: String? = null
    ) : Parcelable {
        @Serializable
        data class Location(
            @SerialName("name")
            var name: String? = null,
            @SerialName("url")
            var url: String? = null
        )

        @Serializable
        data class Origin(
            @SerialName("name")
            var name: String? = null,
            @SerialName("url")
            var url: String? = null
        )
    }
}