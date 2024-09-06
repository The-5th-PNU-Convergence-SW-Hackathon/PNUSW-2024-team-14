package com.example.jasmin2.ui.theme

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun LoadingAnimation(
    modifier: Modifier = Modifier,
    circleSize: Dp = 25.dp,
    circleColor: Color = MaterialTheme.colorScheme.primary,
    spaceBetween: Dp = 10.dp,
    travelDistance: Dp = 20.dp
) {

    val circles = listOf(
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) }
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F5F7)),
        contentAlignment = Alignment.Center
    ) {
        circles.forEachIndexed { index, animatable ->
            LaunchedEffect(key1 = animatable) {
                delay(index * 150L)
                animatable.animateTo(
                    targetValue = 1f,
                    animationSpec = infiniteRepeatable(
                        animation = keyframes {
                            durationMillis = 1200
                            0.0f at 0 with LinearOutSlowInEasing
                            1.0f at 300 with LinearOutSlowInEasing
                            0.0f at 600 with LinearOutSlowInEasing
                            0.0f at 1200 with LinearOutSlowInEasing
                        },
                        repeatMode = RepeatMode.Restart
                    )

                )
            }
        }


        val circleValues = circles.map { it.value }
        val distance = with(LocalDensity.current) { travelDistance.toPx() }
        val lastCircle = circleValues.size - 1

        Row(modifier = modifier) {
            circleValues.forEachIndexed { index, value ->
                Box(
                    modifier = Modifier
                        .size(circleSize)
                        .graphicsLayer {
                            translationY = -value * distance
                        }
                        .background(
                            brush= Brush.linearGradient(colors= JasminGrad, start= Offset.Zero,end= Offset.Infinite),
                            shape = CircleShape
                        )
                )
                if (index != lastCircle) {
                    Spacer(modifier = Modifier.width(spaceBetween))
                }
            }
        }
        Text(
            text = "정보가 입력되고 있습니다",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(top=77.dp)

        )
    }
}