package com.example.jasmin2.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jasmin2.R

@Composable
fun CloseScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF3F5F7)),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(90.dp))
        Text(
            text = "이용중인 헬스장이\n부득이하게 폐업하게 되었습니다",
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black,

        )

        Spacer(modifier = Modifier.height(30.dp))

        GymInfoCard()

        Spacer(modifier = Modifier.height(16.dp))

        RefundInfo()

        Spacer(modifier = Modifier.height(60.dp))
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ){
        Button(
            onClick = {

            },
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-25).dp)
                .padding(bottom = 16.dp)
                .width(300.dp)  // 버튼의 가로 길이
                .height(40.dp)
                .clip(RoundedCornerShape(19.dp))
                .background(
                    brush = Brush.linearGradient(
                        colors = JasminGrad,
                        start = Offset.Zero,
                        end = Offset.Infinite
                    )
                )
            , // 버튼의 높이

            shape= RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent, // 버튼의 기본 배경색을 투명하게 설정
                contentColor = Color.White // 텍스트 색상
            ),
            content= {
                Text(
                    text = "다음",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        )
    }}
}

@Composable
fun GymInfoCard() {
    Column(
        modifier = Modifier
            .height(150.dp)
            .width(330.dp)
            .background(Color.White, shape = RoundedCornerShape(25.dp))
            .padding(26.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.gym2), // Replace with your actual image resource
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(15.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "워너짐 장전점",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "결제일: 8월 18일\n3개월권\n회원권 이용기간: 8월 18일 ~ 9월 18일\n회원명: 이준영",
                    fontSize = 11.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun RefundInfo() {
    Column(
        modifier = Modifier
            .height(90.dp)
            .width(330.dp)
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "결제 금액: 180000원",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(8.dp))


        Text(
            text = "환불 금액: 130000원",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(8.dp))
    }
    Spacer(modifier = Modifier.height(8.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()

    ){
    Text(
        text = "환불 정책 자세히 보기",
        fontSize = 11.sp,
        fontWeight = FontWeight.Medium,
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = JasminGrad)),
        modifier = Modifier
            .align(Alignment.CenterEnd)
    )}

    Spacer(modifier = Modifier.height(130.dp))

Box(
    modifier = Modifier
        .fillMaxWidth()
){
    Column (
        modifier = Modifier
            .fillMaxWidth() // Column이 Box의 가로 길이를 전부 차지
            .align(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally, // Column 내의 요소들을 수평 중앙 정렬
        verticalArrangement = Arrangement.Center // Column 내의 요소들을 수직 중앙 정렬

    ){

    Text(
        text = "하지만 걱정마세요!",
        fontSize = 14.sp,
        color = Color.Gray,
        fontWeight = FontWeight.Medium,
        modifier = Modifier


    )

    Text(
        text = "payper가 환불 정책에 따라",
        fontSize = 24.sp,
        color = Color.Black,
        fontWeight = FontWeight.ExtraBold,
        modifier = Modifier

    )
    Row(){
    Text(
        text = "130000원",
        fontSize = 24.sp,
        color = Color.Black,
        fontWeight = FontWeight.ExtraBold,
        style = TextStyle(
        brush = Brush.linearGradient(
            colors = JasminGrad))
    )

    Text(
        text = " 환불해드릴게요!",
        fontSize = 24.sp,
        color = Color.Black,
        fontWeight = FontWeight.ExtraBold
    )}}}
}

@Preview(showBackground = true)
@Composable
fun ClosePreview() {

        CloseScreen()

}