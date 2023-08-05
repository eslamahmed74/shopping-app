package com.example.shoppingapp.presentation.uiComponet

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.lifecycle.ViewModel
import com.example.shoppingapp.R
import kotlinx.coroutines.flow.StateFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextFiled(state:String, label:String,onValueChange:(String)->Unit) {
    OutlinedTextField(
        value = state,
        onValueChange = onValueChange,
        label = {
            Text(text = label, color = Color.White)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = colorResource(id = R.color.blue),
            focusedBorderColor = colorResource(id = R.color.white),
            unfocusedBorderColor = colorResource(id = R.color.white)
             , textColor = colorResource(id = R.color.white)
        ),
    )


}

