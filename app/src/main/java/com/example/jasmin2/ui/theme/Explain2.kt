package com.example.jasmin2.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jasmin2.R

@Composable
fun Explain2(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.g52),
            contentDescription = "고양이미오",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
                .offset(50.dp)
        )

        Button(
            onClick = {
                navController.navigate("explain1")
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-25).dp)
                .padding(bottom = 16.dp)
                .width(300.dp)  // 버튼의 가로 길이
                .height(40.dp), // 버튼의 높이
            colors = ButtonDefaults.buttonColors(
                containerColor =  Color(0xFF333599),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(0.dp),
            content = {
                Text(
                    text = "다음",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Explain2Preview() {
    Explain2(navController = rememberNavController())
}
