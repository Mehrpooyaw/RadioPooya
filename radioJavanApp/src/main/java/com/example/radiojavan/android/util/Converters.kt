package com.example.radiojavan.android.util

fun convertSecondsToMinutesString(seconds : Float) : String {
   val minutesStr = if ((seconds / 60).toInt() < 10) "0${(seconds / 60).toInt()}"  else "${(seconds / 60).toInt()}"
   val secondsStr =  if ((seconds % 60).toInt() < 10) "0${(seconds % 60).toInt()}"  else "${(seconds % 60).toInt()}"
   return "$minutesStr:$secondsStr"
}