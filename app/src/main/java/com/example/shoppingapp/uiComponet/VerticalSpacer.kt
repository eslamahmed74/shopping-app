package com.example.shoppingapp.uiComponet

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun VerticalSpacer(value:Int){
    Spacer(modifier = Modifier.height(value.dp))

}