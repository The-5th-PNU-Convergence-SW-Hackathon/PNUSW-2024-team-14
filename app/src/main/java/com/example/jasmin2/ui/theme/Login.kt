package com.example.jasmin2.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun loginScreen() {
    Scaffold(
        topBar = {
            TopBarlog("로그인")
        }

    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarlog(title: String) {
    Column {
        CenterAlignedTopAppBar(
            modifier = Modifier.height(50.dp), // 원하는 폭으로 설정
            title = {
                Row(
                    modifier = Modifier.height(25.dp),
                ) {
                    Text(
                        text = title,
                        fontSize = 15.sp // 여기서 텍스트 크기를 조절합니다.

                    )

                }
            },
            navigationIcon = {
                UpButton()
            }
        )
        Divider(
            color = Color.Gray,
            thickness = 1.dp
        )
    }
}