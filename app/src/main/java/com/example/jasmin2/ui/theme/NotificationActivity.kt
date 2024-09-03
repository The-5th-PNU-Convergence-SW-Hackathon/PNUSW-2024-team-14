package com.example.jasmin2.ui.theme

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class NotificationTestActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 인텐트 확인
        val navigateToClose = intent?.getBooleanExtra("navigateToClose", false) ?: false

        setContent {
            navController = rememberNavController()

            if (navigateToClose) {
                // 인텐트에 따라 바로 "close" 화면으로 네비게이션
                navController.navigate("close")
            } else {
                // 기본 화면 표시
                NotificationTestScreen(navController, intent)
            }
        }
    }

    // 권한 요청 결과 처리
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                // 권한이 허용되면 알림을 표시합니다.
                showNotification(this)
            } else {
                // 권한이 거부된 경우, 필요한 처리를 여기서 합니다.
            }
        }
    }
}

@Composable
fun NotificationTestScreen(navController: NavHostController, intent: Intent?) {
    val context = LocalContext.current

    val currentIntent = rememberUpdatedState(intent)

    // 인텐트가 변경될 때마다 네비게이션 트리거
    LaunchedEffect(currentIntent.value) {
        currentIntent.value?.let {
            if (it.getBooleanExtra("navigateToClose", false)) {
                navController.navigate("close")
            }
        }
    }
    if (intent != null) {
        if (intent.getBooleanExtra("showButton", true)){
            Column(modifier = Modifier.padding(16.dp)) {
                Button(onClick = {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        if (ContextCompat.checkSelfPermission(
                                context,
                                Manifest.permission.POST_NOTIFICATIONS
                            ) != PackageManager.PERMISSION_GRANTED
                        ) {
                            ActivityCompat.requestPermissions(
                                context as ComponentActivity,
                                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                                1
                            )
                        } else {
                            // 이미 권한이 허용된 경우 즉시 알림을 표시합니다.
                            showNotificationWithDelay(context)
                        }
                    } else {
                        // Android 13 이하 버전에서는 권한 없이도 알림을 보낼 수 있습니다.
                        showNotificationWithDelay(context)
                    }
                }) {
                    Text(text = "Show Notification")
                }
            }
        }}
    }
