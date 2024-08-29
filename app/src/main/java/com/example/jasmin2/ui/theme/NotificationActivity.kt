package com.example.jasmin2.ui.theme

import android.Manifest
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class NotificationTestActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NotificationTestScreen()
        }
    }

    // onRequestPermissionsResult 메서드 정의를 하나로 통일합니다.
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, // Array<String>으로 정의
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
fun NotificationTestScreen() {
    val context = LocalContext.current

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
}