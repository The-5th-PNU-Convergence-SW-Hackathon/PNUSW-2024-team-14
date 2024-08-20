package com.example.jasmin2.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*



import androidx.compose.foundation.shape.CircleShape

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
            onSearch = { searchQuery -> /* 검색 로직 처리 */ })

        Spacer(modifier = Modifier.height(20.dp))

        // 헬스장 정보 카드
        GymInfoCard(navController)
    }
}

@Composable
fun TopSearchBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    onSearch: (String) -> Unit
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
        Text(
            text = "  부산 금정구 장전동",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

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
                                fontSize = 15.sp)
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
        contentAlignment = Alignment.Center
    ){
        Surface(
            shape = RoundedCornerShape(16.dp),
            shadowElevation = 8.dp,
            modifier = Modifier

                .width(360.dp)
                .height(500.dp)
                .padding(start = 26.dp),


        ) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.gym2), // Replace with actual image resource
                    contentDescription = null,
                    modifier = Modifier
                        .width(320.dp)
                        .height(340.dp)
                        .padding(start = 25.dp, top = 26.dp, end = 10.dp)
                        .clip(RoundedCornerShape(25.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "워너짐 장전동 ★4.8",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 25.dp, vertical = 3.dp)
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "올해 초 오픈한 신규 헬스장이에요! 최신 시설을\n검증된 트레이너와 함께 즐겨보아요.",
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
