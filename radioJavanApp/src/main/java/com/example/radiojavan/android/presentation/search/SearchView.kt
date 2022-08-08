package com.example.radiojavan.android.presentation.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.radiojavan.android.presentation.player.components.PlayerRelatedItem
import com.example.radiojavan.network.models.search_results.Mp3
import com.example.radiojavan.network.models.search_results.SearchResultType
import com.example.radiojavan.network.models.search_results.Top
import com.example.radiojavan.network.models.track.Related
import com.google.accompanist.pager.HorizontalPagerIndicator
import org.koin.androidx.compose.getViewModel

@Composable
fun SearchView(modifier : Modifier,navigateToMusicScreen : (Int) -> Unit){
    val vm = getViewModel<SearchViewModel>()
    Scaffold {
        Column() {
            OutlinedTextField(
                value = vm.query, onValueChange = {
                    vm.onQueryChanged(it)
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Rounded.Search, contentDescription = null)
                },
                trailingIcon = {
                    AnimatedVisibility(visible = vm.query.isNotBlank()) {
                        IconButton(onClick = {vm.onTriggerEvent(vm.query) }) {
                            Icon(Icons.Rounded.ArrowForward, null)
                        }
                    }
                },
                modifier = modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                label = {
                    Text("Search in RadioPooya")
                }
            )
            if (vm.loading) {
                LinearProgressIndicator()
            }
            vm.results?.mp3s?.let { it1 ->
                SearchResultItems(
                    title = "Mp3s",
                    modifier = modifier,
                    results = it1,
                    type = SearchResultType.Mp3s,
                    onClick = navigateToMusicScreen
                )
            }
            vm.errorMessage?.let {
                Text(it)
            }
        }
    }
}


@Composable
fun SearchResultItems(
    title : String,
    modifier : Modifier,
    results : List<Any>,
    type : SearchResultType,
    onClick : (Int) -> Unit
){
    LazyColumn() {
        item(){Text(title, style = MaterialTheme.typography.subtitle1)}
        items(results){
            when (type){
                SearchResultType.Albums -> {
                }
                SearchResultType.AllArtists -> {

                }
                SearchResultType.Artists -> {

                }
                SearchResultType.Mp3s -> {
                    val mp3 = it as Mp3
                    PlayerRelatedItem(modifier = modifier, related = Related(
                        album = null,
                        artist = null,
                        artistFarsi = null,
                        artistTags = listOf(),
                        bgColors = mp3.bgColors,
                        createdAt = null,
                        dislikes = null,
                        downloads = null,
                        duration = null,
                        explicit = null,
                        hlsLink = null,
                        hqHls = null,
                        hqLink = null,
                        id = mp3.id,
                        likes = null,
                        link = null,
                        lqHls = null,
                        lqLink = null,
                        lufs = null,
                        permlink = null,
                        photo = mp3.photo,
                        photo240 = null,
                        photoPlayer = null,
                        plays = mp3.plays,
                        sampleStart = null,
                        shareLink = null,
                        song = null,
                        songFarsi = null,
                        thumbnail = null,
                        title = mp3.title,
                        type = null
                    ) , onClick ={
                        mp3.id?.let { it1 -> onClick(it1) }

                    } )
                }


                SearchResultType.Videos -> {

                }
            }
        }
    }

}

