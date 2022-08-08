package com.example.radiojavan.android.presentation.player.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.radiojavan.android.R
import com.example.radiojavan.android.util.convertSecondsToMinutesString

@Composable
fun PlayerButtons(
    modifier: Modifier,
    onPlayPauseClicked: () -> Unit,
    onNextClicked: () -> Unit,
    onPreviousClicked: () -> Unit,
    trackTitle: String?,
    onSliderValueChanged: (Float) -> Unit,
    totalMinutes: Float?,
    isPlaying : Boolean,
    currentSliderValue: Float,
    likes : String,
    dislike : String,
    plays : String
){
    Box(
        modifier = modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(295.dp)
            .padding(5.dp)
            .clip(RoundedCornerShape(15.dp))
    ) {
        Spacer(
            modifier = modifier
                .fillMaxSize()
                .background(Color.Black.copy(0.4f))
                .blur(30.dp)
        )
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            if (trackTitle != null) {
                Text(trackTitle,color = Color.White,style = MaterialTheme.typography.subtitle2)
            }

            Spacer(modifier = modifier.size(10.dp))
            if (totalMinutes != null) {
                Slider(value = currentSliderValue, onValueChange =onSliderValueChanged, valueRange = 1f..totalMinutes.toFloat(),
                colors = SliderDefaults.colors(
                    thumbColor = Color.White,
                    activeTrackColor = Color.Gray,
                    activeTickColor = Color.White
                )
                )
                Row(
                    modifier = modifier.fillMaxWidth().padding(horizontal = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(convertSecondsToMinutesString(currentSliderValue), color = Color.White)
                    Text(convertSecondsToMinutesString(totalMinutes), color = Color.White)
                }
            }
            Spacer(modifier = modifier.size(5.dp))
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                IconButton(
                    onClick = { onPreviousClicked()}) {
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_skip_previous_24), contentDescription = null,tint = Color.White )
                }
                IconButton(
                    onClick = {
                    onPlayPauseClicked(
                )}) {
                    Icon(painter = painterResource(id = if (isPlaying) R.drawable.ic_round_pause_24 else R.drawable.ic_round_play_arrow_24) , contentDescription = null,tint = Color.White ,modifier = modifier.size(80.dp))
                }
                IconButton(
                    onClick = { onNextClicked() }) {
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_skip_next_24), contentDescription = null,tint = Color.White )
                }
            }
            Spacer(modifier = modifier.size(15.dp))

            Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Row( verticalAlignment = Alignment.CenterVertically) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_round_thumb_up_alt_24),
                            contentDescription = null,
                            tint = Color.Green,
                            modifier = modifier.size(20.dp)
                        )
                        Spacer(modifier = modifier.size(7.dp))
                        Text(
                            text = likes.toString(),
                            style = MaterialTheme.typography.caption,
                            color = Color.Green
                        )
                    }
                    Spacer(modifier = modifier.size(20.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_round_thumb_down_alt_24),
                            contentDescription = null,
                            tint = Color.Red,
                            modifier = modifier.size(20.dp)
                        )
                        Spacer(modifier = modifier.size(7.dp))
                        Text(
                            text = dislike.toString(),
                            style = MaterialTheme.typography.caption,
                            color = Color.Red
                        )
                    }
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(painter = painterResource(id = R.drawable.ic_round_play_arrow_24), contentDescription = null, tint = Color.Cyan,modifier =modifier.size(20.dp))
                    Spacer(modifier = modifier.size(7.dp))
                    Text(text = plays.toString(), style = MaterialTheme.typography.caption, color = Color.Cyan)
                }
            }

        }
    }
}