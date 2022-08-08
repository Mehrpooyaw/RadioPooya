package com.example.radiojavan.android.presentation.track

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.List
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.media3.common.MediaItem
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import com.example.radiojavan.android.R
import com.example.radiojavan.android.models.SimilarMode
import com.example.radiojavan.android.presentation.player.components.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerScope
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.fade
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer
import com.google.accompanist.placeholder.placeholder
import kotlinx.coroutines.*
import org.koin.androidx.compose.getViewModel


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TrackView(
    modifier : Modifier = Modifier,
    colorCallBack : (Color) -> Unit,
    id : Int,
    onBackClicked : () -> Unit
    ) {

    val vm = getViewModel<TrackViewModel>()
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    var similarMode by remember {
        mutableStateOf(SimilarMode.GRID)
    }
    LaunchedEffect(key1 = "launch" ){
        vm.getTrack(id)
    }
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceAround) {
        if (vm.loading && vm.track == null) {
            Box(
                modifier = modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Card(
                    modifier = modifier.size(100.dp),
                    shape = RoundedCornerShape(10.dp),
                    elevation = 20.dp
                ){
                    Box(modifier = modifier
                        .fillMaxSize()
                        .background(
                            Brush.linearGradient(
                                listOf(
                                    Color.Red, Color.Blue
                                )
                            )
                        ), contentAlignment = Alignment.Center){
                        CircularProgressIndicator(color = Color.White)
                    }
                }
            }

        } else if (vm.error != null) {
            Text(vm.error!!)
        } else if (vm.track != null) {
            LaunchedEffect(key1 = "color_callback" ){
                vm.track!!.bgColors?.get(0)?.let { colorCallBack(it.color) }
            }
            var isActivated by remember { mutableStateOf(true)}
            var backgroundColor by remember {
                mutableStateOf(vm.track!!.bgColors ?: listOf("#000000","#000000") )
            }
            var trackPhoto by remember {
                mutableStateOf(vm.track!!.photo)
            }
            var musicPlayer : ExoPlayer = remember {
                ExoPlayer.Builder(context)
                    .build()
                    .apply {
                        val defaultDataSourceFactory = DefaultDataSource.Factory(context)
                        val dataSourceFactory: DataSource.Factory = DefaultDataSource.Factory(
                            context,
                            defaultDataSourceFactory
                        )
                        val source = ProgressiveMediaSource.Factory(dataSourceFactory)
                            .createMediaSource(MediaItem.fromUri(vm.track?.link ?: ""))

                        setMediaSource(source)
                        prepare()
                        playWhenReady = true
                    }
            }
            if (isActivated) {
                LaunchedEffect("Loop") {
                    CoroutineScope(Dispatchers.IO).launch {
                        while (isActivated) {
                            if (vm.isPlaying) {
                                CoroutineScope(Dispatchers.Main).launch {
                                    vm.currentPosition =
                                        musicPlayer.currentPosition / 1000f
                                    println(vm.currentPosition / 1000)
                                }
                            }
                            delay(300)
                        }
                    }
                }
            }
            Box {
                var isSmallTextAndImageVisible by remember { mutableStateOf(false)}
                val verticalState = rememberPagerState()
                isSmallTextAndImageVisible = verticalState.currentPage > 0

                PlayerBackground(modifier = modifier, backgroundImageUrl = trackPhoto , colors = backgroundColor )
                Column(
                    modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    PlayerUpperMenu(
                        modifier = modifier,
                        onBackButtonClicked = {
                            musicPlayer.stop()
                            onBackClicked() },
                        onLikeButtonClicked = {},
                        isFavoriteTrack = vm.track!!.isFavorite,
                        smallImageUrl = vm.track!!.photo240,
                        trackTitle = vm.track!!.title,
                        isSmallTitleAndImageVisible = isSmallTextAndImageVisible,
                        tint = backgroundColor[0]?.color ?: Color.Transparent
                    )
                    VerticalPager(
                        modifier = modifier.fillMaxSize(),
                        count = 2,
                        state = verticalState
                        ) { page ->
                        when (page) {
                            0 -> {
                                Column(
                                    modifier = modifier
                                        .fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.SpaceEvenly
                                    ) {
                                    Spacer(modifier = modifier.size(10.dp))
                                    Column() {
                                        trackPhoto?.let {
                                            PlayerImage(
                                                modifier = modifier,
                                                imageUrl = it,
                                                isExpanded = vm.isImageExpanded,
                                                onImageClicked = {
                                                    vm.isImageExpanded.value =
                                                        !vm.isImageExpanded.value
                                                }
                                            )
                                        }
                                    }

                                    Spacer(modifier = modifier.height(20.dp))
                                    if (vm.loading) {
                                        Box(
                                            modifier = modifier
                                                .padding(5.dp)
                                                .fillMaxWidth()
                                                .height(295.dp)
                                                .padding(5.dp)
                                                .clip(RoundedCornerShape(15.dp))
                                                .placeholder(
                                                    true, Color.Black.copy(alpha = 0.3f),
                                                    shape = null,
                                                    highlight = PlaceholderHighlight.shimmer()
                                                ),

                                                    ) {
                                                    Spacer(
                                                        modifier = modifier
                                                            .fillMaxSize()
                                                            .background(Color.Black.copy(0.4f))
                                                            .blur(30.dp)
                                                    )
                                                }
                                    }else {
                                        PlayerButtons(
                                            modifier = modifier,
                                            onPlayPauseClicked = {
                                                if (musicPlayer.isPlaying) {
                                                    musicPlayer.pause()
                                                } else {
                                                    musicPlayer.play()
                                                }
                                                vm.isPlaying = !vm.isPlaying
                                            },
                                            onNextClicked = {
                                                musicPlayer.stop()
                                                musicPlayer.removeMediaItem(0)
                                                isActivated = false
                                                musicPlayer.seekToDefaultPosition()
                                                vm.track!!.related?.get(0)?.let { related ->
                                                    trackPhoto = related.photo
                                                    related.bgColors?.get(0)
                                                        ?.let { colorCallBack(it.color) }
                                                    backgroundColor = related.bgColors!!
                                                    related.id?.let { it1 ->
                                                        vm.getTrack(
                                                            it1
                                                        )
                                                    }
                                                }
                                            },
                                            onPreviousClicked = {
                                                musicPlayer.stop()
                                                musicPlayer.removeMediaItem(0)
                                                isActivated = false
                                                musicPlayer.seekToDefaultPosition()
                                                vm.track!!.related?.get(vm.track!!.related!!.size - 1)
                                                    ?.let { related ->
                                                        trackPhoto = related.photo
                                                        related.bgColors?.get(0)
                                                            ?.let { colorCallBack(it.color) }
                                                        backgroundColor = related.bgColors!!
                                                        related.id?.let { it1 ->
                                                            vm.getTrack(
                                                                it1
                                                            )
                                                        }
                                                    }

                                            },
                                            trackTitle = vm.track!!.title,
                                            onSliderValueChanged = {
                                                musicPlayer.seekTo((it * 1000).toLong())
                                                vm.currentPosition = it
                                            },
                                            totalMinutes = vm.track!!.duration?.toFloat(),
                                            currentSliderValue = vm.currentPosition,
                                            isPlaying = vm.isPlaying,
                                            likes = vm.track!!.likes ?: "0",
                                            dislike = vm.track!!.dislikes ?: "0",
                                            plays = vm.track!!.plays ?: "0"
                                        )
                                    }
                                        Column(
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            TextWithShadow(text = "MORE", modifier = modifier , style = MaterialTheme.typography.caption )
                                                IconWithShadow(
                                                    modifier = modifier,
                                                    icon = Icons.Rounded.ArrowDropDown
                                                )
                                            }
                                        }

                            }

                            1 -> {
                                Column(
                                    modifier = modifier
                                        .fillMaxSize()
                                        .verticalScroll(
                                            rememberScrollState()
                                        )
                                ) {
                                    if (vm.track!!.related != null) {
                                        Row(
                                            modifier = modifier
                                                .fillMaxWidth()
                                                .padding(horizontal = 10.dp, vertical = 10.dp),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            TextWithShadow(
                                                "More like this ...",
                                                style = MaterialTheme.typography.h6,
                                                modifier = modifier
                                            )
                                            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                                                IconButton(onClick = {
                                                    similarMode = SimilarMode.LIST
                                                }) {
                                                    IconWithShadow(
                                                        icon = Icons.Rounded.List,
                                                        modifier = modifier
                                                    )
                                                }
                                                IconButton(onClick = {
                                                    similarMode = SimilarMode.GRID
                                                }) {
                                                    IconWithShadow(
                                                        resId = R.drawable.ic_baseline_apps_24,
                                                        modifier = modifier
                                                    )
                                                }
                                            }
                                        }

                                        PlayerRelatedList(
                                            modifier = modifier,
                                            related = vm.track!!.related!!,
                                            onRelatedItemClicked = { related ->
                                                trackPhoto = related.photo
                                                backgroundColor = related.bgColors!!
                                                related.bgColors?.get(0)?.color?.let { colorCallBack(it) }
                                                musicPlayer.stop()
                                                musicPlayer.removeMediaItem(0)
                                                isActivated = false
                                                musicPlayer.seekToDefaultPosition()
                                                related.id?.let { vm.getTrack(it) }
                                                coroutineScope.launch {
                                                    verticalState.animateScrollToPage(0)
                                                }
                                            },
                                            mode = similarMode
                                        )
                                        Spacer(modifier = modifier.size(20.dp))
                                    }
                                }
                            }
                        }
                    }
                }
            }
            BackHandler() {
                musicPlayer.stop()
                onBackClicked()
            }
        }

    }

}
val String.color
    get() = Color(android.graphics.Color.parseColor(this))


@Composable
fun TextWithShadow(
    text: String,
    modifier: Modifier,
    style : TextStyle
) {
    Box() {
        Text(
            text = text,
            color = Color.DarkGray,
            style = style,
            modifier = modifier
                .offset(
                    x = 2.dp,
                    y = 2.dp
                )
                .alpha(0.75f)
        )
        Text(
            text = text,
            color = Color.White,
            style = style,
            modifier = modifier
        )
    }
}
@Composable
fun IconWithShadow(
    icon : ImageVector? = null,
    resId : Int? = null,
    modifier : Modifier,
){
    Box() {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.DarkGray,
                modifier = modifier
                    .offset(2.dp, 2.dp)
                    .alpha(0.75f)
            )
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.White,
                modifier = modifier
            )
        } else {
            if (resId != null) {
                Icon(
                    painter = painterResource(id = resId),
                    contentDescription = null,
                    tint = Color.DarkGray,
                    modifier = modifier
                        .offset(2.dp, 2.dp)
                        .alpha(0.75f)
                )
                Icon(
                    painter = painterResource(id = resId),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = modifier
                )
            }
        }
    }
}