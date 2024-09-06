package com.example.jasmin2.loadinganimation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import kotlinx.coroutines.delay


@Composable
fun RefundLoading(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LoadingAnimation()

        // 4초 후에 확인 페이지로 이동
        LaunchedEffect(Unit) {
            delay(4000L) // 4초 대기
            navController.navigate("refundcomplete") {
                popUpTo("pay") { inclusive = true } // 이전 결제 페이지는 스택에서 제거
            }
        }
    }
}