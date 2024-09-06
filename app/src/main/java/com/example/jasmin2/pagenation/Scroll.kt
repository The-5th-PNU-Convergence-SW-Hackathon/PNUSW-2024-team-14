package com.example.jasmin2.pagenation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.jasmin2.fitness.FitnessList
import com.example.jasmin2.MainViewModel

data class Gym(val name: String)


@Composable
fun MyScroll(navController: NavController) {
    Scaffold(
        topBar = {
            TopBar(navController)
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
            MyAppContent(navController)
        }
    }
}


@Composable
fun MyAppContent(navController: NavController) {

    val fitnessViewModel: MainViewModel = viewModel()
    val viewstate by fitnessViewModel.categorieState

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            // 데이터 로딩 중일 때 로딩 인디케이터를 표시합니다.
            viewstate.loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            // 에러가 발생한 경우 에러 메시지를 표시합니다.
            viewstate.error != null -> {
                Text(
                    text = "ERROR OCCURRED: ${viewstate.error}",
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            else -> {
                LazyColumn(
                    modifier = Modifier
                        .background(color = Color.White)
                        .fillMaxSize(),
                    contentPadding = PaddingValues(5.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    // chunked : 리스트로 받은 데이터 작은 데이터 2개로 나누기. 나눠서 두 열에 각각 넣음
                    items(viewstate.list.chunked(2)) { pair ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            // Box 2개 Row로 배치. 이후 각각의 Row에 각각의 chunked list가 들어가도록 함
                            pair.forEach { fitness ->
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(320.dp),
                                    contentAlignment = Alignment.TopCenter
                                ) {
                                    GymInfo(navController, fitness)
                                }
                            }
                            // 나누어진 pair가 홀수개라 하나만 남는경우 empty하게 출력
                            if (pair.size < 2) {
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(320.dp)
                                ) {

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

//헬스장 정보 한칸
@Composable
fun GymInfo(navController: NavController, fitness: FitnessList,
            modifier: Modifier = Modifier){
    Column {
        ImageCard(navController, fitness)
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(5.dp)
        ){
            Text(
                text = fitness.name,
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
                text = fitness.address,
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
                    text = fitness.rating.toString(),
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
                text = "${fitness.monthprice}원~/월",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        }


    }
}

// 이미지와 아이콘
@Composable
fun ImageCard(navController: NavController, fitness: FitnessList){
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
            Image(painter = rememberAsyncImagePainter(fitness.imgtegst),
                contentDescription = "헬스장 이미지",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        // 이미지 클릭 시 네비게이션 실행
                        navController.navigate("detail/${fitness.id}")
                    }
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
fun TopBar(navController: NavController){
    CenterAlignedTopAppBar(
        title = {
            Row(
                modifier = Modifier.height(30.dp),
            ) {
                Text(
                    text = "부산 금정구 장전동",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold)
                )

                ArrowDownIcon()
            }
        },
        actions = {
            AlarmIcon()
        },
        navigationIcon = {
            UpButton(navController)
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
        modifier = Modifier.size(35.dp)

    ) {
        Icon(imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = "arrawdown",
            modifier = Modifier.size(35.dp)
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
fun UpButton(navController: NavController){
    IconButton(
        onClick = {
            navController.navigate("home")
        },
        modifier = Modifier.size(50.dp)

    ) {
        Icon(imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = "upbutton",
            modifier = Modifier.size(30.dp),

            )
    }
}

@Preview(showBackground = true)
@Composable
private fun ScrollPreview() {
    MyScroll(navController = rememberNavController())
}

