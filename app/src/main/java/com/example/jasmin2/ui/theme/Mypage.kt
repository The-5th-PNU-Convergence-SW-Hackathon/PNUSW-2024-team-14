package com.example.jasmin2.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jasmin2.R

@Composable
fun MypageScreen(navController: NavController) {
    //topbar로 수정할려면 scaffold로 리팩토링
    Column(
        verticalArrangement = Arrangement.Top, //top에서부터 수직으로 정렬
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center, // Row 안의 항목들을 수평 중앙에 배치
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "마이페이지",
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
        Column(
            modifier = Modifier
                .height(190.dp) //???
                .border(
                    width = 1.dp, color = Color(0xFFF0F0F0)
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.gym2),
                    contentDescription = "고양이미오",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(85.dp)
                        .align(Alignment.CenterStart)
                        .offset(x = 10.dp, y = 0.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = "페이퍼",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .offset(x = (-67).dp, y = (-15).dp)
                )

                Text(
                    text = "paper123@naver.com",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .offset(x = (-25).dp, y = 6.dp),
                    style = TextStyle(color = Color.Gray)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
            ) {
                Text(
                    text = "포인트",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .offset(x = 16.dp),
                    style = TextStyle(color = Color.Gray)
                )
                Text(
                    text = "쿠폰",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .offset(x = 80.dp),
                    style = TextStyle(color = Color.Gray)
                )
                Text(
                    text = "찜",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset(x = (-50).dp),
                    style = TextStyle(color = Color.Gray)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
            ) {
                Text(
                    text = "2000p",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .offset(x = 16.dp, y = (-10).dp),
                )
                Text(
                    text = "3개",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .offset(x = 80.dp, y = (-10).dp),
                )
                Text(
                    text = "찜",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset(x = (-50).dp, y = (-10).dp),
                )
            }
        }

        // 광고 넣을곳
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .background(color = Color(0xFFF3F5F7))
        ) {
            // 둥근 모서리를 가진 Button으로 텍스트 감싸기
            Button(
                onClick = {
                    navController.navigate("report")
                },
                shape = RoundedCornerShape(16.dp), // 둥근 모서리 설정
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White, // 버튼 배경색 설정
                    contentColor = Color.Black // 버튼 텍스트 색상 설정
                ),
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .width(500.dp)
                    .height(400.dp)
                    .padding(25.dp) // 주변 여백

            ) {
                Column(modifier = Modifier
                    .padding(end=70.dp, top = 10.dp)) {
                    Text(
                        text = "소비자 신고 센터",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text(
                        text = "폐업한 것 같은 헬스장을 신고해주세요!",
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(color = Color.Gray),
                        fontSize = 13.sp,
                        modifier = Modifier.padding(top = 4.dp) // 텍스트 간 간격을 위해 padding 추가
                    )
                    Text(
                        text = "즉시 확인 후 연락드리겠습니다",
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(color = Color.Gray),
                        fontSize = 13.sp,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }
        // 공통된 박스 항목을 위한 재사용 가능한 컴포저블 호출
        MypageNavItem(title = "결제내역")
        MypageNavItem(title = "회원권")
        MypageNavItem(title = "후기관리")
        MypageNavItem(title = "문의")
        MypageNavItem(title = "로그아웃")
    }
}

@Composable
fun MypageNavItem(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .border(
                width = 1.dp, color = Color(0xFFE2E2E2)
            )
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = 16.dp)
        )
        Image(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "arrow image",
            modifier = Modifier
                .size(30.dp)
                .align(Alignment.CenterEnd)
                .offset(x = (-16).dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MypagePreview() {
    MypageScreen(navController = rememberNavController())
}
