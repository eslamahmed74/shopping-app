package com.example.shoppingapp.uiComponet

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ExtendedFloatingActionButtonCuston(
    title: String,
    widthValue:Int=0,
    onButtonCLick: () -> Unit
) {
    ExtendedFloatingActionButton(
        onClick = onButtonCLick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        containerColor = Color(0xFF22516D)
    )
    {
        Text(text = title, modifier = Modifier, color = Color.White)

    }
}