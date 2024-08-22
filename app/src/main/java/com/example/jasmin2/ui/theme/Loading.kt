package com.example.jasmin2.ui.theme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle


import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import kotlinx.coroutines.delay


enum class ImageState(val alpha: Float) {
    INVISIBLE(0f),   // INVISIBLE은 alpha 값이 0f로, 아이콘이 완전히 투명(보이지 않음)을 의미합니다.
    VISIBLE(1f)  }  // VISIBLE은 alpha 값이 1f로, 아이콘이 완전히 불투명(보임)을 의미합니다.
    @Composable
    fun StartScreen(navController: NavController) {
        var imageState by remember { mutableStateOf(ImageState.INVISIBLE) }
        val imageAlpha by animateFloatAsState(
            targetValue = imageState.alpha,
            animationSpec = tween(3000),
            label = "ImageAlpha"
        )

        var payperVisible by remember { mutableStateOf(true) }
        var finalTextVisible by remember { mutableStateOf(false) }
        var loginButtonVisible by remember { mutableStateOf(false) }
        var payperOffset by remember { mutableStateOf(0f) }

        val animatedPayperOffset by animateFloatAsState(
            targetValue = if (payperVisible) 0f else -60f,  // 슬라이드 위치
            animationSpec = tween(durationMillis = 1000),
            finishedListener = {
                if (!payperVisible) {
                    payperOffset = -60f // 애니메이션이 끝나면 고정 위치 설정
                }
            }
        )

        LaunchedEffect(Unit) {
            imageState = ImageState.VISIBLE
            delay(3000)
            payperVisible = false // "pay per" 슬라이드 아웃 트리거
            delay(1000)
            finalTextVisible = true // 최종 텍스트 표시
            loginButtonVisible = true // 로그인 버튼 표시
        }

        StartIcons(
            alpha = imageAlpha,
            animatedPayperOffset = animatedPayperOffset,
            finalTextVisible = finalTextVisible,
            loginButtonVisible = loginButtonVisible,
            navController = navController
        )
    }

    @Composable
    private fun StartIcons(
        alpha: Float,
        animatedPayperOffset: Float,
        finalTextVisible: Boolean,
        loginButtonVisible: Boolean,
        navController: NavController
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(colors = JasminGrad)
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // "pay per" 텍스트와 슬라이드 애니메이션 적용
            Text(
                text = "pay per",
                fontFamily = montsFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp,
                style = TextStyle(color = Color.White),
                modifier = Modifier
                    .alpha(alpha)
                    .offset(y = animatedPayperOffset.dp)
            )

            // 최종 텍스트 나타남
            AnimatedVisibility(
                visible = finalTextVisible,
                enter = slideInVertically(
                    initialOffsetY = { 200 }, // 200px 아래에서부터 슬라이드 인
                    animationSpec = tween(durationMillis = 3000) // 슬라이드 인 애니메이션 지속 시간
                )
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "헬스장을 결심하는 단 하나의",
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        style = TextStyle(color = Color.White),
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .alpha(alpha)
                    )
                    Text(
                        text = "안심 결제 서비스",
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        style = TextStyle(color = Color.White),
                        modifier = Modifier
                            .alpha(alpha)
                    )
                }
            }
        }

        // 로그인 버튼 (화면 하단에 위치)
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            AnimatedVisibility(
                visible = loginButtonVisible,
                enter = slideInVertically(
                    initialOffsetY = { 200 }, // 200px 아래에서부터 슬라이드 인
                    animationSpec = tween(durationMillis = 1000)
                )
            ) {
                Button(
                    onClick = {
                        navController.navigate("login")
                    },
                    modifier = Modifier
                        .padding(bottom = 32.dp)
                        .alpha(alpha)
                        .width(300.dp)
                        .height(40.dp)

                        .clip(RoundedCornerShape(19.dp)),
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White // 원하는 색상으로 변경
                    ),

                    content = {
                        Text(
                            text = "로그인",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                brush = Brush.linearGradient(
                                   colors = JasminGrad)
                            )
                        )
                    }
                )
            }
        }
    }

    @Preview(showSystemUi = true, showBackground = true)
    @Composable
    private fun StartPreview() {
        val navController = rememberNavController()
        Jasmin2Theme {
            StartScreen(navController = navController)
        }
    }
