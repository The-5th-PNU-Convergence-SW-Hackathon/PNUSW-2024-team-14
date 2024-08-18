package com.example.jasmin2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jasmin2.ui.theme.LoginScreen
import com.example.jasmin2.ui.theme.MyDetailScreen
import com.example.jasmin2.ui.theme.ScrollScreen
import com.example.jasmin2.ui.theme.SignupScreen

@Composable
fun CombinedScreens() {
    ScrollScreen()
    MyDetailScreen()
    LoginScreen()
    SignupScreen()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyDetailScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JasminPreview() {
    MyDetailScreen()
}
