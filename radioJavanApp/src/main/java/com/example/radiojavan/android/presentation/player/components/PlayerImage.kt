package com.example.radiojavan.android.presentation.player.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.fade
import com.google.accompanist.placeholder.placeholder

@Composable
fun PlayerImage(
    modifier : Modifier,
    imageUrl : String,
    isExpanded : MutableState<Boolean>,
    onImageClicked : () -> Unit
){
    val painter = rememberImagePainter(data = imageUrl)
    var isImageLoaded by remember {mutableStateOf(false)}
    isImageLoaded = painter.state is ImagePainter.State.Success

    val imageScale by animateFloatAsState(targetValue = if (isExpanded.value) 1f else 0.7f)
    val roundedCornerRadius by animateDpAsState(targetValue = if (isExpanded.value) 10.dp else 200.dp)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                onImageClicked()
            }, contentPadding = PaddingValues(0.dp),
            modifier = modifier
                .padding(10.dp)
                .fillMaxWidth(imageScale)
                .aspectRatio(1f)
                .placeholder(
                    visible = !isImageLoaded,
                    shape = RoundedCornerShape(roundedCornerRadius),
                    color = Color.LightGray,
                    highlight = PlaceholderHighlight.fade()
                ),
            shape = RoundedCornerShape(roundedCornerRadius),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 30.dp,
                pressedElevation = 0.dp
            )
        ) {
            Image(
                painter = painter,
                contentDescription = "player_image",
                contentScale = ContentScale.FillBounds,
                modifier = modifier.fillMaxSize()
            )
        }
    }
}



