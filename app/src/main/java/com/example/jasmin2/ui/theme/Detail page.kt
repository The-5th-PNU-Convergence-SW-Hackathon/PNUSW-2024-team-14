package com.example.jasmin2.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jasmin2.R

@Composable
fun MyDetailScreen(){
    Column {
        DetailImageCard()
        DetailGymInfo()
        MembershipScreen()
    }
}

@Composable
fun DetailImageCard(){
    val isFavorite = remember{
        mutableStateOf(false)
    }
    Card(
        shape = RectangleShape
    ){
        Box(
            modifier = Modifier
                .size(395.dp, 350.dp) // Box 크기 지정
                .clip(RectangleShape) // 크롭을 위한 클리핑
            ,
            ){
            Image(painter = painterResource(id = R.drawable.gym2),
                contentDescription = "헬스장 이미지",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            //아이콘
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomEnd
            ){
                IconButton(
                    onClick = {
                        isFavorite.value = !isFavorite.value },
                    modifier = Modifier
                        .size(80.dp) // IconButton의 크기

                ) {
                    Icon(
                        imageVector = if (isFavorite.value) Icons.Default.Favorite else Icons.Default.FavoriteBorder ,
                        contentDescription = "Favorite",
                        tint = Color.White,
                        modifier = Modifier
                            .size(50.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun DetailGymInfo(){
    Column {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(horizontal = 15.dp)
            .padding(vertical = 5.dp)
        ){
            Text(
                text = "ABC 헬스장",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Divider(
            color = Color.Gray, // 선의 색상
            thickness = 1.dp,  // 선의 두께
            modifier = Modifier.padding(vertical = 8.dp) // 선 주위의 패딩
        )
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(25.dp)
            .padding(horizontal = 15.dp)
        ){
            Text(
                text = "부산 금정구 장전동",
                fontSize = 15.sp,
                color = Color.Gray
            )
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(25.dp)
            .padding(horizontal = 15.dp)
            .padding(vertical = 3.dp)
        ){
            // 별점
            Row {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Star",
                    modifier = Modifier.size(20.dp),
                    tint = Color(0xFFFFD700), // 진한 노란색
                )
                Text(
                    text = " 4.2",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun MembershipCard(title: String, price: String){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(horizontal = 30.dp)
            .padding(vertical = 8.dp)
            .shadow(4.dp)
            .background(Color.White)
            .padding(15.dp)

    ) {
        Column {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color.Black
            )
            Box( modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
                contentAlignment = Alignment.BottomEnd) {
                Text(
                    text = price,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black,
                )
            }
        }
    }
}

@Composable
fun MembershipScreen() {
    Column {
        MembershipCard(title = "1개월 회원권", price = "35000원~/월")
        MembershipCard(title = "3개월 회원권", price = "35000원~/월")
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppContentPreview() {
    //MyScroll()
    MyDetailScreen()
}
