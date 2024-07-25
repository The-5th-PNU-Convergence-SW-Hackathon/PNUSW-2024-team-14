package com.example.jasmin2.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jasmin2.R

data class Gym(val name: String)

@Composable
fun ScrollScreen() {
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomBar()
        }

    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            MyAppContent()
        }
    }
}


@Composable
fun MyAppContent() {
    val gyms = List(10) { index -> Gym("헬스장 $index") }
    LazyColumn(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize(),
        contentPadding = PaddingValues(5.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // chunked : 리스트로 받은 데이터 작은 데이터 2개로 나누기. 나눠서 두 열에 각각 넣음
        items(gyms.chunked(2)) { pair ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Box 2개 Row로 배치. 이후 각각의 Row에 각각의 chunked list가 들어가도록 함
                pair.forEach { gym ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(320.dp),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        GymInfo()
                    }
                }
                // 나누어진 pair가 홀수개라 하나만 남는경우 empty하게 출력
                if (pair.size < 2) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(320.dp)
                    ){
                        GymInfo()
                    }
                }
            }
        }
    }
}

//헬스장 정보 한칸
@Composable
fun GymInfo(){
    Column {
        ImageCard()
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(5.dp)
        ){
            Text(
                text = "ABC 헬스장",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(15.dp)
            .padding(horizontal = 5.dp)
        ){
            Text(
                text = "부산 금정구 장전동",
                fontSize = 10.sp,
                color = Color.Gray
            )
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(20.dp)
            .padding(horizontal = 7.dp)
            .padding(vertical = 3.dp)
        ){
            // 별점
            Row {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Star",
                    modifier = Modifier.size(15.dp),
                    tint = Color(0xFFFFD700), // 진한 노란색
                )
                Text(
                    text = " 4.2",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp),
            contentAlignment = Alignment.BottomEnd // BottomEnd로 정렬
        )
        {
            Text(
                text = "3,5000원~/월",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        }


    }
}

// 이미지와 아이콘
@Composable
fun ImageCard(){
    val isFavorite = remember{
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier.padding(3.dp),
        shape = RectangleShape
    ){
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),

            ){
            Image(painter = painterResource(id = R.drawable.download),
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
                        .size(64.dp) // IconButton의 크기
                        .padding(10.dp) // 아이콘과 경계선 사이의 패딩.
                ) {
                    Icon(
                        imageVector = if (isFavorite.value) Icons.Default.Favorite else Icons.Default.FavoriteBorder ,
                        contentDescription = "Favorite",
                        tint = Color.White,
                        modifier = Modifier
                            .size(40.dp)
                    )
                }
            }
        }
    }
}

// TopBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){
    CenterAlignedTopAppBar(
        title = {
            Row(
                modifier = Modifier.height(30.dp),
            ) {
                Text("부산 금정구 장전동")
                ArrowDownIcon()
            }
        },
        actions = {
            AlarmIcon()
        },
        navigationIcon = {
            UpButton()
        }
    )
}

//BottomBar
@Composable
fun BottomBar(){

}


// 화살표 아래 아이콘 버튼
@Composable
fun ArrowDownIcon(){
    IconButton(
        onClick = { /*TODO*/ },
        modifier = Modifier.size(30.dp)

    ) {
        Icon(imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = "arrawdown",
        )
    }
}
// 알람 아이콘 버튼
@Composable
fun AlarmIcon(){
    IconButton(
        onClick = { /*TODO*/ },
        modifier = Modifier.size(60.dp)

    ) {
        Icon(imageVector = Icons.Default.Notifications,
            contentDescription = "alarm",
            modifier = Modifier.size(30.dp),

            )
    }
}

// 뒤로가기 버튼
@Composable
fun UpButton(){
    IconButton(
        onClick = { /*TODO*/ },
        modifier = Modifier.size(50.dp)

    ) {
        Icon(imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = "upbutton",
            modifier = Modifier.size(30.dp),

            )
    }
}

