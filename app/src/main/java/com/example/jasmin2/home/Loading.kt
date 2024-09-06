package com.example.jasmin2.home

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween


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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle


import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jasmin2.ui.theme.Jasmin2Theme
import com.example.jasmin2.ui.theme.JasminGrad
import com.example.jasmin2.ui.theme.montsFamily

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
    var finalTextAlpha by remember { mutableStateOf(0f) }
    var loginButtonAlpha by remember { mutableStateOf(0f) }
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
        finalTextAlpha = 1f // 최종 텍스트 표시
        loginButtonAlpha = 1f // 로그인 버튼 표시
    }

    StartIcons(
        alpha = imageAlpha,
        animatedPayperOffset = animatedPayperOffset,
        finalTextAlpha = finalTextAlpha,
        loginButtonAlpha = loginButtonAlpha,
        navController = navController
    )
}

@Composable
private fun StartIcons(
    alpha: Float,
    animatedPayperOffset: Float,
    finalTextAlpha: Float,
    loginButtonAlpha: Float,
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
            fontSize = 53.sp,
            style = TextStyle(color = Color.White),
            modifier = Modifier
                .alpha(alpha)
                .offset(y = animatedPayperOffset.dp)
        )

        // 최종 텍스트 나타남 (서서히 나타나게)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.alpha(finalTextAlpha)
        ) {
            val finalTextAlphaAnim by animateFloatAsState(
                targetValue = finalTextAlpha,
                animationSpec = tween(3000)  // 서서히 나타나는 애니메이션
            )

            Text(
                text = "헬스장을 결심하는 단 하나의",
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                style = TextStyle(color = Color.White),
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .alpha(finalTextAlphaAnim)
            )
            Text(
                text = "안심 결제 서비스",
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                style = TextStyle(color = Color.White),
                modifier = Modifier
                    .alpha(finalTextAlphaAnim)
            )
        }
    }

    // 로그인 버튼 (화면 하단에 위치, 서서히 나타나게)
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        val loginButtonAlphaAnim by animateFloatAsState(
            targetValue = loginButtonAlpha,
            animationSpec = tween(3000)  // 서서히 나타나는 애니메이션
        )

        Button(
            onClick = {
                navController.navigate("login")
            },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .alpha(loginButtonAlphaAnim)
                .width(300.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(19.dp)),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            content = {
                Text(
                    text = "로그인",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        brush = Brush.linearGradient(
                            colors = JasminGrad
                        )
                    )
                )
            }
        )
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
