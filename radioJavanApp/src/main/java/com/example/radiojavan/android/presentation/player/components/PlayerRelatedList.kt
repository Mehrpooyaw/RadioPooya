package com.example.radiojavan.android.presentation.player.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.radiojavan.android.R
import com.example.radiojavan.android.models.SimilarMode
import com.example.radiojavan.android.presentation.track.color
import com.example.radiojavan.android.util.convertSecondsToMinutesString
import com.example.radiojavan.network.models.track.Related
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun PlayerRelatedList(
    modifier : Modifier,
    related : List<Related?>,
    onRelatedItemClicked : (Related) -> Unit,
    mode : SimilarMode
){
    when (mode) {

        SimilarMode.LIST -> {
            Column(
                modifier = modifier.fillMaxWidth()
            ) {
                related.forEach {
                    if (it != null) {
                        PlayerRelatedItem(
                            modifier = modifier,
                            related = it,
                            onClick = onRelatedItemClicked
                        )
                    }

                }
            }
        }
        SimilarMode.GRID -> {
            Column(
                modifier = modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                    FlowRow() {
                        related.forEach {
                        if (it != null) {
                            PlayerRelatedGridItem(modifier = modifier, related = it , onClick =onRelatedItemClicked)
                        }
                    }
                }
            }

        }

    }
}

@Composable
fun PlayerRelatedGridItem(
    modifier : Modifier,
    related: Related,
    onClick : (Related) -> Unit
){
    Card(
        modifier = modifier
            .padding(5.dp)
            .fillMaxWidth(0.3f).aspectRatio(1f),
        backgroundColor = related.bgColors?.get(0)?.color ?: Color.Black,
        contentColor = Color.White,
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)

    ) {
        Box() {
            Spacer(modifier = modifier
                .fillMaxWidth()
                .background(Color.Black.copy(0.4f))
                .blur(30.dp))
            Column(
                modifier
                    .fillMaxWidth()
                    .padding(10.dp,), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = modifier
                        .weight(0.9f)

                ) {
                    Card(
                        modifier = modifier.fillMaxWidth().clickable {
                            onClick(related)
                        },
                        elevation = 10.dp,
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Image(
                            painter = rememberImagePainter(data = related.photo),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PlayerRelatedItem(
    modifier : Modifier,
    related: Related,
    onClick : (Related) -> Unit
){
    Card(
        modifier = modifier
            .padding(5.dp)
            .fillMaxWidth(),
        backgroundColor = related.bgColors?.get(0)?.color ?: Color.Black,
            contentColor = Color.White,
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)

    ) {
        Box() {
            Spacer(modifier = modifier
                .fillMaxWidth()
                .background(Color.Black.copy(0.4f))
                .blur(30.dp))
            Row(
                modifier
                    .fillMaxWidth()
                    .padding(10.dp,), verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = modifier
                        .weight(0.9f)

                ) {
                    Card(
                        modifier = modifier.size(50.dp),
                        elevation = 10.dp,
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Image(
                            painter = rememberImagePainter(data = related.photo),
                            contentDescription = null
                        )
                    }
                    Spacer(modifier = modifier.size(10.dp))
                    Column(
                        modifier = modifier.fillMaxWidth()
                    ) {
                        related.title?.let { Text(text = it) }
                        Row(
                            modifier = modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            related.duration?.let {
                                Text(convertSecondsToMinutesString(it.toFloat()))
                            }
                            Text(related.plays + " plays")
                        }
                    }

                }
                IconButton(onClick = {  onClick(related)  }, modifier.weight(0.1f)) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_round_play_arrow_24),
                        contentDescription = null
                    )
                }
            }
        }
    }
}