package com.example.radiojavan.repository.remote_source

import com.example.radiojavan.network.NetworkService
import com.example.radiojavan.util.DispatcherProvider
import kotlinx.coroutines.withContext

class DefaultRemoteSource(
    private val dispatcherProvider: DispatcherProvider,
    private val networkService: NetworkService
) : RemoteSource {
    override suspend fun search(query: String) = withContext(dispatcherProvider.io) {
        networkService.search(query)
    }
    override suspend fun getTrack(id: Int) = withContext(dispatcherProvider.io) {
        networkService.getTrack(id)
    }
    override suspend fun getArtist(query: String) = withContext(dispatcherProvider.io) {
        networkService.getArtist(query)
    }
}