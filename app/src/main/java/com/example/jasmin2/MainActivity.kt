package com.example.jasmin2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jasmin2.ui.theme.MyDetailpage
import com.example.jasmin2.ui.theme.MyScroll
import com.example.jasmin2.ui.theme.StartScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          StartScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppContentPreview() {
    //MyScroll()
  StartScreen()
}


