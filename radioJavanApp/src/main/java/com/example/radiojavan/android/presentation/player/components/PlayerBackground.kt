package com.example.radiojavan.android.presentation.player.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.BlurTransformation
import com.example.radiojavan.android.presentation.track.color

@Composable
fun PlayerBackground(
    modifier : Modifier,
    backgroundImageUrl : String?,
    colors : List<String?>
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Brush.horizontalGradient(
                if (colors.isNotEmpty()) {
                    colors.mapNotNull {
                        it?.color
                    }
                } else {
                    listOf(MaterialTheme.colors.background, MaterialTheme.colors.background)
                }
            ))
            .blur(30.dp)
    ) {
        Box() {
            Image(
                painter = rememberImagePainter(backgroundImageUrl, builder = {
                    transformations(
                        BlurTransformation(
                            radius = 8f,
                            context = LocalContext.current,
                            sampling = 3f
                        )
                    )
                }),
                contentDescription = "media_photo",
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f),
                contentScale = ContentScale.FillBounds,
            )

            Spacer(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f)
                    .blur(30.dp)
                    .background(
                        Brush.linearGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Transparent,
                                colors[0]?.color ?: Color.Transparent,
                                colors[1]?.color ?: Color.Transparent
                            )
                        )
                    )
            )
        }
    }
}