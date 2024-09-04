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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jasmin2.R

@Composable
fun PayScreen(navController: NavController) {
    val allChecked = remember { mutableStateOf(false) }
    val termsChecked = remember { mutableStateOf(false) }
    val privacyChecked = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF3F5F7)),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "결제하기",
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black,
            modifier = Modifier
                .offset(x=(-105).dp)

        )

        Spacer(modifier = Modifier.height(20.dp))

        InfoCard()

        Spacer(modifier = Modifier.height(16.dp))

        PayInfo()

        Spacer(modifier = Modifier.height(5.dp))

        // 추가된 PAYPER 문구 섹션
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.White, shape = RoundedCornerShape(12.dp))
                .padding(16.dp)
        ) {
            Text(
                text = "PAYPER로",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "거래시 PAYPER의 구매 안전 서비스를 이용 가능합니다.",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // 전체 동의와 개별 약관 체크박스 섹션
        Column(
            modifier = Modifier
                .fillMaxWidth()

                .padding(horizontal = 18.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        allChecked.value = !allChecked.value
                        termsChecked.value = allChecked.value
                        privacyChecked.value = allChecked.value
                    }
            ) {
                Checkbox(
                    checked = allChecked.value,
                    modifier = Modifier
                        .height(24.dp),
                    onCheckedChange = {
                        allChecked.value = it
                        termsChecked.value = it
                        privacyChecked.value = it
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "전체동의")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        termsChecked.value = !termsChecked.value
                        allChecked.value = termsChecked.value && privacyChecked.value
                    }
            ) {
                Checkbox(
                    checked = termsChecked.value,
                    modifier = Modifier
                        .height(24.dp),
                    onCheckedChange = {
                        termsChecked.value = it
                        allChecked.value = termsChecked.value && privacyChecked.value
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "전자금융거래 이용약관")
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "보기", style = TextStyle(
                    brush = Brush.linearGradient(
                        colors = JasminGrad)))
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        privacyChecked.value = !privacyChecked.value
                        allChecked.value = termsChecked.value && privacyChecked.value
                    }
            ) {
                Checkbox(
                    checked = privacyChecked.value,
                    modifier = Modifier
                        .height(24.dp),
                    onCheckedChange = {
                        privacyChecked.value = it
                        allChecked.value = termsChecked.value && privacyChecked.value
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "개인정보처리방침 이용약관")
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "보기",  style = TextStyle(
                    brush = Brush.linearGradient(
                        colors = JasminGrad)))
            }
        }

        Spacer(modifier = Modifier.height(50.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
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
                    ), // 버튼의 높이

                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent, // 버튼의 기본 배경색을 투명하게 설정
                    contentColor = Color.White // 텍스트 색상
                ),
                content = {
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
}

@Composable
fun InfoCard() {
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
                    text = "결제일: 8월 18일\n3개월권\n회원권 이용기간: 8월 18일 ~ 11월 18일\n회원명: 000",
                    fontSize = 11.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun PayInfo() {

    Text(
        text = "판매자 주소",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Gray,
        modifier = Modifier
            .offset(x=(-124).dp)
    )

    Spacer(modifier = Modifier.height(6.dp))



    Column(
        modifier = Modifier
            .height(60.dp)
            .width(330.dp)
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "0x19230392304910",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(8.dp))




        Spacer(modifier = Modifier.height(8.dp))
    }
    Spacer(modifier = Modifier.height(17.dp))
    Text(
        text = "가격",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Gray,
        modifier = Modifier
            .offset(x=(-140).dp)
    )

    Spacer(modifier = Modifier.height(6.dp))



    Column(
        modifier = Modifier
            .height(90.dp)
            .width(330.dp)
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "2024.08.18부터",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(8.dp))


        Text(
            text = "45000원/월",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,

        )

        Spacer(modifier = Modifier.height(2.dp))
    }









    }


@Preview(showBackground = true)
@Composable
fun PayPreview() {

    PayScreen(navController = rememberNavController())

}