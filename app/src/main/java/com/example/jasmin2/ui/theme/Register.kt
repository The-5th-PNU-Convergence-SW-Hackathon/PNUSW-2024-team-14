package com.example.jasmin2.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.*

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jasmin2.MainViewModel

@Composable
fun SignupScreen(navController: NavController, viewModel: MainViewModel) {
    // 회원가입 상태 (성공/실패 여부 확인)
    val registerState by viewModel.registerState

    Scaffold(
        topBar = {
            TopBarlog(title = "회원가입", navController = navController)
        }
    ) {
        // 사용자 입력 상태를 관리 (아이디, 이름, 비밀번호)
        val usernameState = remember { mutableStateOf(TextFieldValue()) }
        val passwordState = remember { mutableStateOf(TextFieldValue()) }
        val displayNameState = remember { mutableStateOf(TextFieldValue()) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Spacer로 여백 조절
            Spacer(modifier = Modifier.height(20.dp))

            // 이름 입력 필드
            UnderlinedTextField(
                value = displayNameState.value,
                onValueChange = { displayNameState.value = it },
                label = { Text("이름") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // 아이디 입력 필드
            UnderlinedTextField(
                value = usernameState.value,
                onValueChange = { usernameState.value = it },
                label = { Text("아이디") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // 비밀번호 입력 필드
            UnderlinedTextField(
                value = passwordState.value,
                onValueChange = { passwordState.value = it },
                label = { Text("비밀번호") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(), // 비밀번호 숨기기 처리
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), // 비밀번호 입력 옵션
            )

            Spacer(modifier = Modifier.height(50.dp))

            // 회원가입 버튼
            Button(
                onClick = {
                    // 모든 필드가 비어 있지 않은지 확인 후 회원가입 요청
                    if (usernameState.value.text.isNotBlank() && passwordState.value.text.isNotBlank() && displayNameState.value.text.isNotBlank()) {
                        viewModel.register(usernameState.value.text, passwordState.value.text, displayNameState.value.text)
                    } else {
                        // 입력값이 누락된 경우 처리 (필요 시 메시지 추가 가능)
                    }
                },
                modifier = Modifier
                    .width(300.dp)
                    .height(40.dp)
                    .clip(RoundedCornerShape(19.dp))
                    .background(
                        brush = Brush.linearGradient(colors = JasminGrad, start = Offset.Zero, end = Offset.Infinite)
                    ), // 버튼 크기 및 모양
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent, // 버튼의 기본 배경색을 투명하게 설정
                    contentColor = Color.White // 텍스트 색상
                ),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(
                    text = "회원가입", // 버튼 텍스트
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            // 회원가입 성공 시 로그인 화면으로 이동
            if (registerState.success) {
                navController.navigate("login")
            }

            // 오류 메시지 표시
            registerState.error?.let {
                Text(text = it, color = Color.Red)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignupScreenPreview() {
    // 미리보기를 위한 NavController 및 ViewModel을 가상으로 생성
    SignupScreen(navController = rememberNavController(), viewModel = MainViewModel())
}
