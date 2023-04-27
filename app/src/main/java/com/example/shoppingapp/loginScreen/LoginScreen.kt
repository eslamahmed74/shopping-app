package com.example.shoppingapp.loginScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shoppingapp.R
import com.example.shoppingapp.uiComponet.CircularImage
import com.example.shoppingapp.uiComponet.CustomTextFiled
import com.example.shoppingapp.uiComponet.ExtendedFloatingActionButtonCuston
import com.example.shoppingapp.uiComponet.VerticalSpacer


@Composable
fun LoginState(onNavigateToHome:()->Unit,viewModel: LoginScreenViewModel = hiltViewModel()) {
    val state by viewModel.loginState.collectAsState()
    LoginScreen(state, viewModel::onChangeEmail, viewModel::onChangePassword,onNavigateToHome)
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    state: LoginUiState,
    onChangeEmail: (String) -> Unit,
    onChangePassword: (String) -> Unit,
    onNavigateToHome: () -> Unit
) {
    Scaffold(topBar = {
        TopAppBar(title = {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Sign up",
                    textAlign = TextAlign.Right,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(horizontal = 10.dp),
                    color = colorResource(id = R.color.blue)
                )
                Image(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = "back arrow",
                )
            }
        })
    }) {

    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome Back",
            modifier = Modifier,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.blue)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 40.dp)
                .clip(RoundedCornerShape(topStart = 60.dp))
                .background(
                    colorResource(id = R.color.blue)
                ), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            VerticalSpacer(value = 80)
            CustomTextFiled(
                state = state.email,
                label = "Email Address",
                onValueChange = onChangeEmail
            )
            VerticalSpacer(value = 20)
            CustomTextFiled(
                state = state.password,
                label = "Password",
                onValueChange = onChangePassword
            )
            VerticalSpacer(value = 40)
            Text(text = "Or Sign In With", modifier = Modifier, color = Color.White)
            VerticalSpacer(value = 20)
            Row(
                modifier = Modifier
                    .fillMaxWidth(), horizontalArrangement = Arrangement.Center
            ) {
                CircularImage(
                    resource = R.drawable.google_0hlu7xuhis2m,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .clip(CircleShape)
                        .border(width = 1.dp, shape = CircleShape, color = Color.White)
                        .padding(10.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
                CircularImage(
                    resource = R.drawable.facebook_heihll5cutth,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .clip(CircleShape)
                        .border(width = 1.dp, shape = CircleShape, color = Color.White)
                )
            }
            VerticalSpacer(value = 15)
            Text(
                text = "Forget Password?",
                modifier = Modifier,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.white)
            )
            VerticalSpacer(value = 30)
            Column(modifier = Modifier.fillMaxWidth().padding(30.dp)) {

                ExtendedFloatingActionButtonCuston(
                    title = "Login",
                    widthValue = 0, onButtonCLick = onNavigateToHome
                )
            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun displayFunction() {
    LoginState({})
}
