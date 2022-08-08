package com.example.radiojavan.network.models.request_bodies

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchRequestBody(
    @SerialName("query")
    val query : String
)
