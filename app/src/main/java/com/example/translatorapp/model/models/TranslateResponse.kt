package com.example.translatorapp.model.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

    @Serializable
    data class TranslateResponse(
        @SerialName("audio_links")
        var audioLinks: List<AudioLink?>? = null,
        @SerialName("featured")
        var featured: Boolean? = null,
        @SerialName("forms")
        var forms: List<Any?>? = null,
        @SerialName("grammar_info")
        var grammarInfo: Any? = null,
        @SerialName("pos")
        var pos: String? = null,
        @SerialName("text")
        var text: String? = null,
        @SerialName("translations")
        var translations: List<Translation?>? = null
    ) {
        @Serializable
        data class AudioLink(
            @SerialName("lang")
            var lang: String? = null,
            @SerialName("url")
            var url: String? = null
        )
    
        @Serializable
        data class Translation(
            @SerialName("audio_links")
            var audioLinks: Any? = null,
            @SerialName("examples")
            var examples: List<Example?>? = null,
            @SerialName("featured")
            var featured: Boolean? = null,
            @SerialName("pos")
            var pos: String? = null,
            @SerialName("text")
            var text: String? = null,
            @SerialName("usage_frequency")
            var usageFrequency: Any? = null
        ) {
            @Serializable
            data class Example(
                @SerialName("dst")
                var dst: String? = null,
                @SerialName("src")
                var src: String? = null
            )
        }
    }
