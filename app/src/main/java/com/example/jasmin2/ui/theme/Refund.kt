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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import java.time.format.TextStyle

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RefundScreen(navController: NavController) {
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
                            text = "환불",
                            color = Color.Black,
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(Alignment.Center)
                        )

                        Button(
                            onClick = {
                                navController.navigate("close")
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent, // 버튼의 기본 배경색을 투명하게 설정
                            ),
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .offset((-20).dp)
                        ) {
                            Text(
                                text = "< 뒤로",
                                fontSize = 17.sp,
                                style = androidx.compose.ui.text.TextStyle(
                                    brush = Brush.linearGradient(
                                        colors = JasminGrad
                                    )
                                ),
                                modifier = Modifier
                                    .padding(start = 0.dp)
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
            // 로딩 애니메이션을 표시
            LoadingAnimation()

            // 4초 후 화면을 전환
            LaunchedEffect(Unit) {
                delay(4000L) // 4초 대기
                navController.navigate("refundcomplete")
            }
        } else {
            RefundForm(navController = navController, onSubmit = { isLoading = true })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RefundForm(navController: NavController, onSubmit: () -> Unit) {
    var bankName by remember { mutableStateOf(TextFieldValue("")) }
    var accountNumber by remember { mutableStateOf(TextFieldValue("")) }
    var accountHolder by remember { mutableStateOf(TextFieldValue("")) }
    var phoneNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F5F7)),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))

        OutlinedTextField(
            value = bankName,
            onValueChange = { bankName = it },
            label = { Text(text = "지갑 주소") },
            modifier = Modifier.width(350.dp),
            singleLine = true,
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
            label = { Text(text = "예금주") },
            modifier = Modifier.width(350.dp),
            singleLine = true,
            shape = RoundedCornerShape(30.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                containerColor = Color.White,
                focusedTextColor = Color.Black
            )
        )

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text(text = "전화번호") },
            modifier = Modifier.width(350.dp),
            singleLine = true,
            shape = RoundedCornerShape(30.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
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
                    ),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.White
                ),
                content = {
                    Text(
                        text = "승인",
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
fun RefundScreenPreview() {
    RefundScreen(navController = rememberNavController())
}