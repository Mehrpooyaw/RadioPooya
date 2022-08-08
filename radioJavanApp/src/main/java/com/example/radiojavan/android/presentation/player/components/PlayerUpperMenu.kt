package com.example.radiojavan.android.presentation.player.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.radiojavan.android.presentation.track.TextWithShadow

@Composable
fun PlayerUpperMenu(
    modifier : Modifier,
    onBackButtonClicked : () -> Unit,
    onLikeButtonClicked : (Boolean) -> Unit,
    isFavoriteTrack : Boolean,
    smallImageUrl : String?,
    trackTitle : String?,
    tint : Color,
    isSmallTitleAndImageVisible : Boolean
    ){
    var isFavorite by rememberSaveable {
        mutableStateOf(isFavoriteTrack)
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Brush.verticalGradient(
                listOf(
                    tint,
                    Color.Transparent,
                )
            ))
            .height(60.dp)
    ){
        Spacer(modifier = modifier
            .fillMaxSize()
           )
        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onBackButtonClicked) {
                    Icon(Icons.Rounded.ArrowBack, null, tint = Color.White)
                }
                AnimatedVisibility(visible = isSmallTitleAndImageVisible) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Card(
                            elevation = 30.dp,
                            shape = CircleShape
                        ) {
                            Image(
                                painter = rememberImagePainter(data = smallImageUrl),
                                contentDescription = "player_upper_menu_small_image",
                                modifier = modifier.size(30.dp),
                                contentScale = ContentScale.FillBounds
                            )
                        }
                        Spacer(modifier = modifier.size(10.dp))

                        if (trackTitle != null) {
                            TextWithShadow(trackTitle,modifier = modifier, style = MaterialTheme.typography.subtitle2)
                        }
                    }
                }
            }
        }

    }
}