package com.example.jasmin2.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jasmin2.R
import java.time.format.TextStyle

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RefundCompleteScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFFF3F5F7)),
                    ) {
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFF3F5F7) // TopAppBar 배경 색상을 동일하게 설정
                )
            )
        }
    ) {
        RefundCompleteForm(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RefundCompleteForm(navController: NavController) {
    var bankName by remember { mutableStateOf(TextFieldValue("")) }
    var accountNumber by remember { mutableStateOf(TextFieldValue("")) }
    var accountHolder by remember { mutableStateOf(TextFieldValue("")) }
    var phoneNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F5F7)),
        verticalArrangement = Arrangement.Center, // 상단과 하단에 요소 배치
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(modifier = Modifier.height(80.dp))

        Image(
            painter = painterResource(id = R.drawable.check),
            contentDescription = "체크 표시",
            contentScale = ContentScale.Fit,
            modifier = Modifier

                .scale(1.2f)
                .padding(top=200.dp)

        )

        Text(
            text = "완료되었습니다!",
            color = Color.Black,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 50.dp)
        )












        Spacer(modifier = Modifier.weight(1f))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)


        ) {
            Button(
                onClick = {
                    navController.navigate("home")
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
                        text = "확인",
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
fun RefundCompletePreview() {
    RefundCompleteScreen(navController = rememberNavController())
}