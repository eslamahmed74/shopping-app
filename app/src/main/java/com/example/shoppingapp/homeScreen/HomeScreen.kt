package com.example.shoppingapp.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shoppingapp.Constants
import com.example.shoppingapp.R
import com.example.shoppingapp.uiComponet.VerticalSpacer


@Composable
fun HomeScreenState(viewModel: HomeViewModel = hiltViewModel()) {
    val searchState by viewModel.searchState.collectAsState()
    val selectedState by viewModel.selectedState.collectAsState()
    HomeScreen(
        searchState,
        viewModel::setSearchFiledState,
        selectedState,
        viewModel::setSelectedState
    )
}

@Composable
fun HomeScreen(
    state: String,
    onTextChange: (String) -> Unit,
    selectedState: Boolean,
    setSelectedState: () -> Unit
) {
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

        VerticalSpacer(value = 15)

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
                isItemSelected(
                    item = it, state = selectedState,
                    setSelectedState
                )
            }
        }
        LazyRow(modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(5.dp)) {
            items(Constants.furnitureList)
            {
                furnitureCart(it)
            }
        }

        VerticalSpacer(value = 20)

        Text(
            text = "Best Seller",
            modifier = Modifier.padding(start = 20.dp, bottom = 10.dp),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.blue)
        )

        LazyRow(modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(5.dp)) {
            items(Constants.furnitureList)
            {
                furnitureCart(it)
            }
        }
    }
}

@Composable
fun furnitureCart(item: FurnitureItem){
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .width(180.dp)
            .height(190.dp)
            .padding(start = 16.dp, end = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Box {
            Column(
                modifier=Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Spacer(modifier = Modifier.height(30.dp))

                Image(
                    painter = painterResource(id = item.img),
                    contentDescription = "shoe",
                    modifier = Modifier
                        .padding(8.dp)
                        .size(width = 80.dp, height = 80.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = item.name,
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.labelLarge,
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.blue)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = item.price,
                    color = colorResource(id = R.color.blue),
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.labelSmall
                )
            }

//            Image(
//                painter = painterResource(id = R.drawable.ic_heart),
//                contentDescription = "fav",
//                modifier = Modifier
//                    .padding(12.dp)
//                    .size(24.dp)
//                    .align(Alignment.TopEnd)
//                    .padding(2.dp)
//            )

            Image(
                painter = painterResource(id = R.drawable.ic_ribbon),
                contentDescription = "fav",
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 4.dp, y = (-4).dp)
                    .clip(RoundedCornerShape(8.dp)),
                colorFilter = ColorFilter.tint(colorResource(id = R.color.blue)),
                contentScale = ContentScale.Crop
            )
        }
    }
}


@Composable
fun furniture(item: FurnitureItem) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .border(
                width = 1.dp, color = colorResource(
                    id = R.color.blue
                )
            )
    ) {
        Column(
            modifier = Modifier
                .height(190.dp)
                .width(160.dp)
                .background(colorResource(id = R.color.white)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            VerticalSpacer(value = 10)
            Image(
                painter = painterResource(id = item.img),
                contentDescription = "content"
            )
            Text(text = item.name, color = colorResource(id = R.color.blue))
            VerticalSpacer(value = 20)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = item.price, color = colorResource(id = R.color.blue))
                Spacer(modifier = Modifier.width(40.dp))
                FloatingActionButton(
                    onClick = { },
                    modifier = Modifier
                        .height(30.dp)
                        .width(50.dp)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_ios_24),
                        contentDescription = "search"
                    )
                }
            }
        }
    }
}

@Composable
fun isItemSelected(item: String, state: Boolean, function: () -> Unit) {
    Card(
        modifier = Modifier
            .clip(RectangleShape)
            .clickable { }
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier.background(
                if (state) colorResource(id = R.color.blue) else colorResource(id = R.color.off_white)
            )
        ) {
            Text(
                text = item,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable { function() },
                color = if (state) colorResource(
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