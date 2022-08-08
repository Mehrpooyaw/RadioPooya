package com.example.radiojavan.android.presentation.track

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.radiojavan.network.models.track.Track
import com.example.radiojavan.repository.RadioJavanRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class TrackViewModel(
    private val repository: RadioJavanRepository
) : ViewModel() {
    var loading by mutableStateOf(false)
    var track by mutableStateOf<Track?>(null)
    var error by mutableStateOf<String?>(null)
    var isPlaying by mutableStateOf(true)
    var currentPosition by mutableStateOf(0f)
    var isImageExpanded = mutableStateOf(false)

    fun getTrack(id : Int) {
        repository.getTrackFromNetwork(id).onEach {
            loading = it.loading
            it.data?.let { data ->
                resetParameters()
                track = null
                track = data
            }
            it.error?.let { error ->
                this.error = it.error
            }
        }.launchIn(viewModelScope)
    }
    private fun resetParameters(){
        isPlaying = true
        currentPosition = 0f
        isImageExpanded.value  = false

    }
}