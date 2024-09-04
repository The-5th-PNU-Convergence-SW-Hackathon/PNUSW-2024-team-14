package com.example.jasmin2.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.jasmin2.FitnessList
import com.example.jasmin2.MainViewModel
import com.example.jasmin2.R

@Composable
fun MyDetailScreen(fitnessId: Long, fitness: FitnessList){
    val fitnessViewModel: MainViewModel = viewModel()
    val fitnessDetailState by fitnessViewModel.fitnessDetail

    LaunchedEffect(fitnessId) {
        fitnessViewModel.fetchFitnessDetail(fitnessId)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // 세로 스크롤 추가
    ) {
        DetailImageCard(fitness)
        DetailGymInfo(fitness)
        Spacer(modifier = Modifier.height(15.dp))
        MembershipScreen(fitness)
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun DetailImageCard(fitness: FitnessList){
    val isFavorite = remember{
        mutableStateOf(false)
    }
    Card(
        shape = RectangleShape
    ){
        Box(
            modifier = Modifier
                .size(450.dp) // Box 크기 지정
                .clip(RectangleShape) // 크롭을 위한 클리핑
            ,
        ){
            //업체 이미지
            Image(painter = rememberAsyncImagePainter(fitness.imgtegst),
                contentDescription = "헬스장 이미지",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            // 불투명 박스 + 헬스장명, 주소
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.35f)) // 불투명한 박스 설정
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = fitness.name,
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = fitness.address,
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    // 운영중 + 로고
                    Row(
                        verticalAlignment =  Alignment.CenterVertically
                    ) {
                        Text(
                            text = "운영중",
                            color = Color.White,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Image(painter = painterResource(id = R.drawable.logo),
                            contentDescription = "로고",
                            modifier = Modifier.size(80.dp)
                        )

                        Spacer(modifier = Modifier.width(150.dp))


                        IconButton(
                            onClick = {
                                isFavorite.value = !isFavorite.value },
                            modifier = Modifier
                                .size(80.dp) // IconButton의 크기

                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.CenterEnd // 왼쪽 상단에 정렬
                            ) {
                                Icon(
                                    imageVector = if (isFavorite.value) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                    contentDescription = "Favorite",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(50.dp)
                                        .padding(end = 10.dp)
                                )
                            }
                        }

                    }


                }

            }

        }
    }
}

/*
@Composable
fun DetailGymInfo(){
    Column {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(horizontal = 15.dp)
            .padding(vertical = 5.dp)
        ){
            /*Text(
                text = "ABC 헬스장",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold
            )*/
        }

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

 */

@Composable
fun DetailGymInfo(fitness: FitnessList){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(top = 25.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally // 가로 방향으로 가운데 정렬
            ) {
                Text(
                    text = "평점",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(15.dp))
                Row {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Star",
                        modifier = Modifier.size(20.dp),
                        tint = Color(0xFFFFD700), // 진한 노란색
                    )
                    Text(
                        text = " ${fitness.rating}",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray,
                        modifier = Modifier.padding(top=2.dp)
                    )
                }

            }
        }

        Divider(
            color = Color.LightGray,
            modifier = Modifier
                .height(110.dp) // Row의 전체 높이만큼 세로선
                .width(2.dp) // 선의 두께
                .padding(top = 10.dp)
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .padding(top = 25.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally // 가로 방향으로 가운데 정렬
            ) {
                Text(
                    text = "영업 중",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp

                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = fitness.weekdaytime,
                    color = Color.Gray
                )
            }

        }

        Divider(
            color = Color.LightGray,
            modifier = Modifier
                .height(110.dp) // Row의 전체 높이만큼 세로선
                .width(2.dp) // 선의 두께
                .padding(top = 10.dp)
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .padding(top = 25.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally // 가로 방향으로 가운데 정렬
            ) {
                Text(
                    text = "리뷰 수",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp

                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "3",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "전체 리뷰 보기",
                    fontSize =12.sp,
                    color = Color.Gray,
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline // 밑줄 추가
                    ),

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
            .height(110.dp)
            .padding(horizontal = 30.dp)
            .padding(vertical = 8.dp)
            .shadow(4.dp, RoundedCornerShape(16.dp)) // 그림자 추가 및 모양 설정
            .background(Color.White)
            .padding(15.dp)
            .clip(RoundedCornerShape(16.dp)) // 모서리가 둥근 사각형으로 자르기

    ) {
        Column {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                color = Color.Black
            )
            Box( modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
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
fun MembershipScreen(fitness: FitnessList) {
    Column {
        MembershipCard(title = "1개월 회원권", price = "${fitness.monthprice}원~/월")
        Spacer(modifier = Modifier.height(5.dp))
        MembershipCard(title = "3개월 회원권", price = "${fitness.threeprice}원~/월")
        Spacer(modifier = Modifier.height(5.dp))
        MembershipCard(title = "6개월 회원권", price = "${fitness.sixprice}원~/월")
    }
}

//@Preview(showBackground = true)
//@Composable
//fun MyAppContentPreview() {
//    //MyScroll()
//    MyDetailScreen()
//}
