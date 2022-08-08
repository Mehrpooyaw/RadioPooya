package com.example.radiojavan.repository

import com.example.radiojavan.domain.data.DataState
import com.example.radiojavan.network.models.search_results.Artist
import com.example.radiojavan.network.models.search_results.SearchResults
import com.example.radiojavan.network.models.track.Track
import com.example.radiojavan.repository.remote_source.RemoteSource
import io.ktor.utils.io.errors.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

class RadioJavanRepository : KoinComponent {
     val remoteSource : RemoteSource = get(null)

     fun search(query : String) : Flow<DataState<SearchResults?>> = flow {
        emit(DataState.loading())
        try {
            emit(DataState.success(remoteSource.search(query)))
        }catch (e : Exception){
            emit(DataState.error(e.message?:"Unknown error."))
        }

    }

     fun getTrackFromNetwork(id : Int) : Flow<DataState<Track?>> = flow {
        emit(DataState.loading())
        try {
            emit(DataState.success(remoteSource.getTrack(id)))

        }catch (e : Exception){
            emit(DataState.error(e.message?:"Unknown error."))
        }
    }

     fun getArtistFromNetwork(query : String) : Flow<DataState<Artist>> = flow {
        emit(DataState.loading())
        try {
            emit(DataState.success(remoteSource.getArtist(query)))

        }catch (e : Exception){
            emit(DataState.error(e.message?:"Unknown error."))
        }
    }
}