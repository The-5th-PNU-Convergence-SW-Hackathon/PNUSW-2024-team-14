package com.example.jasmin2.ui.theme

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
fun LoginScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopBarlog(title = "로그인", navController = navController)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val emailState = remember { mutableStateOf(TextFieldValue()) }
            val passwordState = remember { mutableStateOf(TextFieldValue()) }


            Spacer(modifier = Modifier.height(20.dp))

            UnderlinedTextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                label = { Text("아이디") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            UnderlinedTextField(
                value = passwordState.value,
                onValueChange = { passwordState.value = it },
                label = { Text("비밀번호") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                ),
            )

            Spacer(modifier = Modifier.height(50.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Button(
                    onClick = {
                        navController.navigate("explain1")
                    },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .offset(y = (-25).dp)
                        .padding(bottom = 16.dp)
                        .width(300.dp)  // 버튼의 가로 길이
                        .height(40.dp)
                        .clip(RoundedCornerShape(19.dp))
                        .background(
                            brush= Brush.linearGradient(colors=JasminGrad, start= Offset.Zero,end= Offset.Infinite))
                    , // 버튼의 높이

                    shape= RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent, // 버튼의 기본 배경색을 투명하게 설정
                        contentColor = Color.White // 텍스트 색상
                    ),
                    content= {
                        Text(
                            text = "로그인",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                )}

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text("페이퍼가 처음이신가요?")
                Text(
                    text = "가입하기",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable {
                        navController.navigate("signup") },
                    color = Color(0xFF333599)
                )
            }
        }
    }
}

/*@Composable
fun SignupScreen(navController: NavController, viewModel: MainViewModel) {
    val registerState by viewModel.registerState

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val usernameState = remember { mutableStateOf(TextFieldValue()) }
        val passwordState = remember { mutableStateOf(TextFieldValue()) }
        val displayNameState = remember { mutableStateOf(TextFieldValue()) }

        Spacer(modifier = Modifier.height(20.dp))

        UnderlinedTextField(
            value = usernameState.value,
            onValueChange = { usernameState.value = it },
            label = { Text("아이디") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        UnderlinedTextField(
            value = displayNameState.value,
            onValueChange = { displayNameState.value = it },
            label = { Text("이름") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        UnderlinedTextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            label = { Text("비밀번호") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )

        Spacer(modifier = Modifier.height(50.dp))

        Button(
            onClick = {
                if (usernameState.value.text.isNotBlank() && passwordState.value.text.isNotBlank() && displayNameState.value.text.isNotBlank()) {
                    viewModel.register(usernameState.value.text, passwordState.value.text, displayNameState.value.text)
                } else {
                    // 입력값 검증 실패 시 처리
                }
            },
            modifier = Modifier.fillMaxWidth().height(50.dp),
            shape = RoundedCornerShape(19.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF333599),
                contentColor = Color.White
            )
        ) {
            Text(
                text = "회원가입",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }

        // 회원가입 성공 또는 오류 메시지 표시
        if (registerState.success) {
            navController.navigate("login")  // 회원가입 성공 시 로그인 화면으로 이동
        }
        registerState.error?.let {
            Text(text = it, color = Color.Red)
        }
    }
}*/



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarlog(title: String, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        CenterAlignedTopAppBar(
            modifier = Modifier.height(50.dp),
            title = {
                Row(
                    modifier = Modifier.padding(top=12.dp)
                ) {
                    Text(
                        text = title,
                        fontSize = 17.sp,
                        color = Color.Gray
                    )
                }
            },
            navigationIcon = {
                IconButton(onClick = { navController.navigate("start") }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        )
        Divider(
            color = Color.LightGray,
            thickness = 2.dp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnderlinedTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    label: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = label,
        modifier = modifier,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.Gray,
            disabledBorderColor = Color.Gray
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun LoginPreview() {
    LoginScreen(navController = rememberNavController())
}
