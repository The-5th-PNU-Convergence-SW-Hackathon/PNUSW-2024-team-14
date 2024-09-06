package com.example.jasmin2.ui.theme


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box


import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jasmin2.loadinganimation.LoadingAnimation
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ReportScreen(navController: NavController) {
    var isLoading by remember { mutableStateOf(false) } // 로딩 상태 관리

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFFF3F5F7)),
                    ) {
                        Text(
                            text = "소비자 신고 센터",
                            color = Color.Black,
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.Center)
                        )

                        Button(
                            onClick = {
                                navController.navigate("mypage") // 뒤로가기 버튼 클릭 시 동작
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent // 버튼의 기본 배경색을 투명하게 설정
                            ),
                            modifier = Modifier
                                .width(100.dp)
                                .height(50.dp)
                                .align(Alignment.CenterStart)
                                .offset(x = (-20).dp)
                        ) {
                            Text(
                                text = "< 뒤로",
                                fontSize = 17.sp,
                                style = androidx.compose.ui.text.TextStyle(
                                    brush = Brush.linearGradient(
                                        colors = JasminGrad
                                    )
                                )
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFF3F5F7) // TopAppBar 배경 색상을 동일하게 설정
                )
            )
        }
    ) {
        if (isLoading) {
            // 로딩 애니메이션 표시
            LoadingAnimation()

            // 4초 후 화면을 전환
            LaunchedEffect(Unit) {
                delay(4000L) // 4초 대기
                navController.navigate("reportcomplete")
            }
        } else {
            ReportForm(navController = navController, onSubmit = { isLoading = true })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportForm(navController: NavController, onSubmit: () -> Unit) {
    var bankName by remember { mutableStateOf(TextFieldValue("")) }
    var accountNumber by remember { mutableStateOf(TextFieldValue("")) }
    var accountHolder by remember { mutableStateOf(TextFieldValue("")) }
    var phoneNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F5F7)),
        verticalArrangement = Arrangement.spacedBy(16.dp), // 상단과 하단에 요소 배치
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))

        OutlinedTextField(
            value = bankName,
            onValueChange = { bankName = it },
            label = { Text(text = "지역") },
            modifier = Modifier.width(350.dp),
            shape = RoundedCornerShape(30.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White, // 포커스 되었을 때 테두리 색상
                unfocusedBorderColor = Color.White, // 포커스되지 않았을 때 테두리 색상
                containerColor = Color.White, // 텍스트 필드 내부 배경색
                focusedTextColor = Color.Black
            )
        )

        OutlinedTextField(
            value = accountNumber,
            onValueChange = { accountNumber = it },
            label = { Text(text = "헬스장 이름") },
            modifier = Modifier.width(350.dp),
            shape = RoundedCornerShape(30.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                containerColor = Color.White,
                focusedTextColor = Color.Black
            )
        )

        OutlinedTextField(
            value = accountHolder,
            onValueChange = { accountHolder = it },
            label = { Text(text = "신고 사유") },
            modifier = Modifier
                .width(350.dp)
                .height(400.dp),
            shape = RoundedCornerShape(30.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                containerColor = Color.White,
                focusedTextColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Button(
                onClick = {
                    onSubmit() // 버튼을 누르면 로딩 상태로 전환
                },
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(y = (-25).dp)
                    .padding(bottom = 16.dp)
                    .width(300.dp)
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
                    containerColor = Color.Transparent,
                    contentColor = Color.White
                ),
                content = {
                    Text(
                        text = "다음",
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReportScreenPreview() {
    ReportScreen(navController = rememberNavController())
}


