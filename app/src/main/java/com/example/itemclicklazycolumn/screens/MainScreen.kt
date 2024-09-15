package com.example.itemclicklazycolumn.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    imageId: Array<Int>,
    names: Array<String>,
    ingredients: Array<String>,
    navController: NavController
) {
    Column {
        Text(
            modifier = Modifier
                .padding(start = 24.dp, top = 50.dp),
            text = "My Fucking Play List🚀",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        LazyColumn(
            contentPadding = PaddingValues(16.dp)
        ) {
            val itemCount = imageId.size
            items(itemCount) {
                ColumnItem(
                    modifier,
                    painter = imageId,
                    title = names,
                    ingredients = ingredients,
                    itemIndex = it,
                    navController = navController
                )
            }
        }
    }

}

@Composable
fun ColumnItem(
    modifier: Modifier = Modifier,
    painter: Array<Int>,
    title: Array<String>,
    ingredients: Array<String>,
    itemIndex: Int,
    navController: NavController
) {
    Card(
        modifier
            .padding(10.dp)
            .height(140.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate("DetailScreen/$itemIndex")
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.elevatedCardElevation(6.dp)
    ) {
        Row(
            modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = title[itemIndex],
                modifier
                    .size(140.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier
                    .padding(12.dp)
            ) {
                Text(
                    text = title[itemIndex],
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = ingredients[itemIndex],
                    fontSize = 14.sp
                )
            }
        }
    }
}
