package com.example.jasmin2.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
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
import kotlinx.coroutines.delay

@Composable
fun Explain1(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.explain1),
            contentDescription = "고양이미오",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
                .scale(1.1f)
                .offset(x = 15.dp, y = 18.dp)
        )

        Text(
            text = "이용중인 헬스장이 폐업할까",
            style = TextStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight(900)
            ),
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 450.dp)
        )

        Text(
            text = "걱정하고 계신가요?",
            style = TextStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold
            ),
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 516.dp)
        )
        Text(
            text = "이젠 걱정 마세요!",
            style = TextStyle(
                fontSize = 13.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Gray
            ),
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 568.dp)
            
        )

        Button(
            onClick = {

                navController.navigate("explain2")
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
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
    }
}

@Preview(showBackground = true)
@Composable
private fun Explain1Preview() {
    Explain1(navController = rememberNavController())
}