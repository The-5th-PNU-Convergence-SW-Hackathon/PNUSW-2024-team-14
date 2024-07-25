package com.example.jasmin2.ui.theme

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jasmin2.R


enum class ImageState(val alpha: Float) {
    INVISIBLE(0f),   // INVISIBLE은 alpha 값이 0f로, 아이콘이 완전히 투명(보이지 않음)을 의미합니다.
    VISIBLE(1f)    // VISIBLE은 alpha 값이 1f로, 아이콘이 완전히 불투명(보임)을 의미합니다.
}


@Composable
fun StartScreen() {
    var imageState by remember { mutableStateOf(ImageState.INVISIBLE) }
    val imageAlpha by animateFloatAsState(
        targetValue = imageState.alpha,
        animationSpec = tween(4000),
        label = "ImageAlpha"
    )
    LaunchedEffect(Unit) {

        imageState = ImageState.VISIBLE
    }

    StartIcons(alpha = imageAlpha)
}

@Composable
private fun StartIcons(
    alpha : Float
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally, //수평에서 중앙에 오게
        verticalArrangement = Arrangement.Bottom //수직에서 밑에오게
    ) {
        Text(
            text = "PAY PER",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 40.sp,
            modifier = Modifier
                .padding(bottom=16.dp)
                .alpha(alpha)
        )

        Image(
            painter = painterResource(id = R.drawable.`startimage2`),
            contentDescription = "start image",
            modifier = Modifier
                .size(400.dp)
                .padding(top = 40.dp)
                .offset(x = (-13).dp)
                .alpha(alpha)

        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun StartPreview() {
    StartScreen()
}
