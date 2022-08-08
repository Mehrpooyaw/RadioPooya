package com.example.radiojavan.network

import com.example.radiojavan.network.models.search_results.Artist
import com.example.radiojavan.network.models.search_results.SearchResults
import com.example.radiojavan.network.models.track.Track

interface NetworkService {

    suspend fun search(
        query : String
    ) : SearchResults

    suspend fun getTrack(
        id : Int
    ) : Track?


    suspend fun getArtist(
        query : String
    ) : Artist
}