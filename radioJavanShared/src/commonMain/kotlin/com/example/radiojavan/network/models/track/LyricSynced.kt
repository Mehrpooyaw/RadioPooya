package com.example.radiojavan.network.models.track


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LyricSynced(
    @SerialName("text")
    val text: String?,
    @SerialName("time")
    val time: Double?
)