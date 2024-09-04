package com.example.jasmin2.ui.theme

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*



import androidx.compose.foundation.shape.CircleShape

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jasmin2.MapActivity
import com.example.jasmin2.R

@Composable
fun GymInfoScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F5F7))
    ) {
        // 상단 검색 바 영역
        var query by remember { mutableStateOf("") }
        TopSearchBar(
            query = query,
            onQueryChanged = { newQuery -> query = newQuery },
            onSearch = { searchQuery -> /* 검색 로직 처리 */ },
            navController = navController)


        Spacer(modifier = Modifier.height(20.dp))

        // 헬스장 정보 카드
        GymInfoCard(navController)
    }
}

@Composable
fun TopSearchBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    onSearch: (String) -> Unit,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    topStart = 0.dp, // 상단 왼쪽 모서리 각짐
                    topEnd = 0.dp, // 상단 오른쪽 모서리 각짐
                    bottomEnd = 35.dp, // 하단 오른쪽 모서리 둥글게
                    bottomStart = 35.dp // 하단 왼쪽 모서리 둥글게
                )
            )
            .background(
                brush = Brush.linearGradient(
                    colors = JasminGrad,
                    start = Offset.Zero,
                    end = Offset.Infinite
                )
            )
            .padding(15.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            // 검색바 텍스트
            Text(
                text = "부산 금정구 장전동",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )

            // 마이페이지 아이콘
            IconButton(
                onClick = {

                    navController.navigate("mypage")
                },
                modifier = Modifier
                    .size(30.dp)
                    .padding(end = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Person, // 원하는 아이콘으로 대체 가능
                    contentDescription = "My Page",
                    tint = Color.White


                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .padding(5.dp) // 패딩을 Row에 설정합니다.
        ) {
            TextField(
                value = query,
                onValueChange = { newQuery ->
                    onQueryChanged(newQuery)
                },
                trailingIcon = {
                    IconButton(onClick = { onSearch(query) }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Icon"
                        )
                    }
                },
                placeholder = {
                    Text(
                        text = "어떤 헬스장을 찾으시나요?",
                        fontSize = 15.sp
                    )
                },
                modifier = Modifier
                    .width(350.dp)
                    .padding(start = 5.dp, top = 35.dp, end = 0.dp, bottom = 16.dp)
                    .heightIn(20.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = Color.White // focusedContainerColor 및 unfocusedContainerColor 대신 사용
                ),
                shape = RoundedCornerShape(16.dp)
            )
        }
    }
}


@Composable
fun GymInfoCard(navController:NavController) {
    val imageState = remember { mutableStateOf(R.drawable.gym2) }
    val textState = remember { mutableStateOf("워너짐 장전동 ★4.8") }
    val ExplainState = remember { mutableStateOf("올해 초 오픈한 신규 헬스장이에요! 최신 시설을\n검증된 트레이너와 함께 즐겨보세요!") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {



            Text(
                text = "지금 할인중인\n안심 헬스장은🔥",
                color = Color.Black,
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .padding(start=12.dp, top=2.dp,end = 0.dp)
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "부산 금정구 장전동",
                color = Color.Gray,
                fontSize = 10.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .padding(start=15.dp, top=2.dp,end = 0.dp)
                    

            )
        }
        Spacer(modifier = Modifier.height(20.dp))




        // 헬스장 이미지
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        Box(modifier = Modifier.fillMaxWidth()) {
            IconButton(
                onClick = {
                    imageState.value = R.drawable.gym3
                    textState.value = "비너스짐 부산대점 ★4.6"
                    ExplainState.value = "근방에서 가장 회원 수가 많은 헬스장이에요!\n부산대역과 도보 5분거리에요!"
                },
                modifier = Modifier
                    .size(48.dp)
                    .align(Alignment.CenterEnd)

            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, // 표시할 아이콘
                    contentDescription = "Favorite Icon", // 접근성 설명
                    tint = Color.Gray, // 아이콘의 색상
                    modifier = Modifier
                        .size(48.dp)
                        .align(Alignment.CenterEnd)
                        .offset(x = (8).dp)
                )

            }
            IconButton(
                onClick = {
                    imageState.value = R.drawable.gym2
                    textState.value = "워너짐 장전점 ★4.8"
                    ExplainState.value = "올해 초 오픈한 신규 헬스장이에요! 최신 시설을\n검증된 트레이너와 함께 즐겨보세요!"
                },
                modifier = Modifier
                    .size(48.dp)
                    .align(Alignment.CenterStart)

            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, // 표시할 아이콘
                    contentDescription = "Favorite Icon", // 접근성 설명
                    tint = Color.Gray, // 아이콘의 색상
                    modifier = Modifier
                        .size(48.dp)
                        .align(Alignment.CenterStart)
                        .offset(x = (-8).dp)
                )

            }
        }


        Surface(
            shape = RoundedCornerShape(16.dp),
            shadowElevation = 8.dp,
            modifier = Modifier
                .width(320.dp)
                .height(510.dp)
                .align(Alignment.Center)

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)

            ) {
                Image(
                    painter = painterResource(id = imageState.value), // Replace with actual image resource
                    contentDescription = null,
                    modifier = Modifier
                        .width(320.dp)
                        .height(360.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(20.dp)
                        .clip(RoundedCornerShape(25.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(0.dp))

                Text(
                    text = textState.value,
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 20.dp)
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = ExplainState.value,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 25.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {navController.navigate("scroll")},
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(300.dp)  // 버튼의 가로 길이
                        .height(38.dp)
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(19.dp))
                        .background(
                            brush = Brush.linearGradient(
                                colors = JasminGrad,
                                start = Offset.Zero,
                                end = Offset.Infinite
                            )
                        ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent, // 버튼의 기본 배경색을 투명하게 설정
                        contentColor = Color.White // 텍스트 색상
                    )
                ) {
                    Text(
                        text = "주변 운동시설 더 보기",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))


            }
        }
        }
    Spacer(modifier = Modifier.height(15.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Button(
            onClick = {
                val context = navController.context
                val intent = Intent(context, MapActivity::class.java)
                context.startActivity(intent)
                      //맵으로 네비게이션
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White, // 버튼의 기본 배경색을 설정
            ),
            modifier = Modifier
                .shadow(
                    elevation = 5.dp, // 그림자 깊이 설정
                    shape = RoundedCornerShape(19.dp), // 모서리 모양
                    clip = false // 그림자가 잘리지 않도록 설정
                )
                .width(70.dp) // 버튼의 가로 길이
                .height(38.dp)
                .clip(RoundedCornerShape(19.dp)) // 그림자와 같은 모서리 모양 적용
                .align(Alignment.BottomCenter) // 원하는 위치에 배치
        )  {
            Image(
                painter = painterResource(id = R.drawable.map), // Replace with actual image resource
                contentDescription = "map icon",
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
                    .align(Alignment.CenterVertically)


            )
    }
    }

    }


@Preview(showBackground = true)
@Composable
fun PreviewGymInfoScreen() {
    GymInfoScreen(navController = rememberNavController())
}
