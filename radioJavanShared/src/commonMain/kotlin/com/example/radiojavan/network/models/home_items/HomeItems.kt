package com.example.radiojavan.network.models.home_items


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeItems(
    @SerialName("sections")
    val sections: List<Section>?
)