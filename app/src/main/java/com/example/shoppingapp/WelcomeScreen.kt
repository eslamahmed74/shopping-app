package com.example.shoppingapp

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonElevation
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppingapp.uiComponet.ExtendedFloatingActionButtonCuston

@Composable
fun WelcomeScreen(onNavigateToLogin:()->Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.images2),
            contentDescription = "welcome image",
            modifier = Modifier
                .height(400.dp)
                .width(600.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = "Enjoy Your",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold, color = colorResource(id = R.color.blue)
        )
        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = "Online Shopping",
            fontSize = 30.sp,
            fontWeight = FontWeight.Normal, color = colorResource(id = R.color.blue)
        )
        Spacer(modifier = Modifier.height(60.dp))
        ExtendedFloatingActionButtonCuston("Get Started", onButtonCLick = onNavigateToLogin)


    }
}