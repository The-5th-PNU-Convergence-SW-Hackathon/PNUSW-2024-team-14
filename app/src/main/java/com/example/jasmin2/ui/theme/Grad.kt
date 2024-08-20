package com.example.jasmin2.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset


import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, widthDp =800, heightDp = 200)
@Composable
fun KotlinWorldModifier() {
    val JasminGrad = listOf(Color(0xFF6A11CB), Color(0xFF2575FC))
    Column(
        Modifier
            .background(
                brush = Brush.linearGradient(colors = JasminGrad, start = Offset.Zero, end = Offset.Infinite),
                shape = RectangleShape
            )
    ) {}
}
