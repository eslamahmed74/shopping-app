package com.example.shoppingapp.uiComponet

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource


@Composable
fun CircularImage(resource: Int, modifier: Modifier=Modifier) {
    Image(
        painter = painterResource(id = resource), contentDescription = "", modifier = modifier
    )
}


