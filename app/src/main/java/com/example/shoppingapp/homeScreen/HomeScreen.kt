package com.example.shoppingapp.homeScreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shoppingapp.R
import com.example.shoppingapp.uiComponet.VerticalSpacer


@Composable
fun HomeScreenState(viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.searchState.collectAsState()
    HomeScreen(state, viewModel::setSearchFiledState)
}


@Composable
fun HomeScreen(state: String, onTextChange: (String) -> Unit) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Discover \nBest Furniture",
                modifier = Modifier,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.blue)
            )
            Spacer(modifier = Modifier.width(110.dp))
            Image(
                painter = painterResource(id = R.drawable.images_avatar),
                contentDescription = "profile image",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
        }

        VerticalSpacer(value = 40)

        Card(
            modifier = Modifier
                .height(45.dp)
                .fillMaxWidth()
                .border(
                    width = 1.dp, color = colorResource(
                        id = R.color.blue
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .padding(10.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_search_24),
                    contentDescription = "search"
                )
                BasicTextField(
                    value = state,
                    onValueChange = onTextChange,
                    modifier = Modifier
                        .width(230.dp),
                    textStyle = TextStyle(color = colorResource(id = R.color.blue))
                ) {
                    if (state.isEmpty())
                        Text(text = "Search")
                    else
                        Text(text = state)
                }
//                FloatingActionButton(onClick = { }, modifier = Modifier.clip(RectangleShape).fillMaxSize()) {
//                    Icon(
//                        imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_ios_24),
//                        contentDescription = "search"
//                    )
//                }
            }
        }

        VerticalSpacer(value = 20)

        Text(
            text = "Categories",
            modifier = Modifier,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.blue)
        )

    }
    Column {

        VerticalSpacer(value = 220)
        val furniture = listOf<String>(
            "Chairs",
            "Coffee Table",
            "Bookshelf",
            "Bed",
            "Dining Table",
            "Armchair",
            "TV Stand"
        )
        LazyRow(modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(5.dp)) {
            items(furniture) {
                isItemSelected(item = it)
            }
        }
        furniture()
    }
}

@Composable
fun furniture(){
    Column(modifier = Modifier.size(120.dp)) {
        Image(painter = painterResource(id = R.drawable.images_chair), contentDescription ="content" )
        Text(text = "Modern Chair")
        Row {
            Text(text = "185$")
            FloatingActionButton(
                onClick = { },
                modifier = Modifier
                    .clip(RectangleShape)
                    .fillMaxSize()
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = "search"
                )
            }
        }
    }
}

@Composable
fun isItemSelected(item: String) {
    var isSelectedState by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .clip(RectangleShape)
            .clickable {
                isSelectedState = !isSelectedState
                Log.e("TAG", isSelectedState.toString())
            }
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier.background(
                if (isSelectedState) colorResource(id = R.color.blue) else colorResource(id = R.color.off_white)
            )
        ) {
            Text(
                text = item,
                modifier = Modifier.padding(10.dp),
                color = if (isSelectedState) colorResource(
                    id = R.color.white
                ) else colorResource(id = R.color.blue)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun display() {
    HomeScreenState()
}