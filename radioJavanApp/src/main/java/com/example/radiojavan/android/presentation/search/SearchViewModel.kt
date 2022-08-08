package com.example.radiojavan.android.presentation.search

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.radiojavan.network.models.search_results.SearchResults
import com.example.radiojavan.repository.RadioJavanRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class SearchViewModel(
    private val repository: RadioJavanRepository
) : ViewModel() {
    var loading by mutableStateOf(false)
    var query by mutableStateOf("")
    var results by mutableStateOf<SearchResults?>(null)
    var errorMessage by mutableStateOf<String?>(null)


    fun onTriggerEvent(query : String){
        Log.d("AppDebug", "onTriggerEvent: Hello")
        repository.search(query).onEach {
            loading = it.loading
            it.error?.let { error ->
                errorMessage = error
                Log.d("AppDebug", "onTriggerEvent: $error")

            }
            it.data?.let { data ->
                Log.d("AppDebug", "onTriggerEvent: $data")
                results = data

            }
        }.launchIn(viewModelScope)
    }


    fun onQueryChanged(q : String){
            onTriggerEvent(q)
            query = q

    }

}