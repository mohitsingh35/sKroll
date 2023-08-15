package com.ncs.skroll

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ncs.skroll.models.NewsData

@Composable
fun resbanner(
    items: NewsData) {
    Column(modifier = Modifier.fillMaxWidth()) {
        for (i in 0 until items.articles.size){
            resbannerItem(item = items, i = i )
        }

    }
}

@Composable
fun resbannerItem(
    item: NewsData,
    i:Int
) {

    Card(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)
        ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .clip(RoundedCornerShape(8.dp))){
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.3f)
                )
                 {
                AsyncImage(model = item.articles[i].urlToImage, contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
            }
                Box (modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .fillMaxHeight(0.7f)){
                    Column {
                        Text(text = item.articles[i].title, fontWeight = FontWeight.Normal, fontSize = 16.sp, color = Color.White)
                    }
                }
            } 
        }
        
        


    }
}