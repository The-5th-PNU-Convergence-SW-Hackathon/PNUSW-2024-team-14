package com.example.jasmin2.ui.theme

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// 뒤로가기 버튼
@Composable
fun UpButton(){
    IconButton(
        onClick = { /*TODO*/ },
        modifier = Modifier.size(50.dp)

    ) {
        Icon(imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = "upbutton",
            modifier = Modifier.size(30.dp),
            tint = Color.Gray

            )
    }
}

