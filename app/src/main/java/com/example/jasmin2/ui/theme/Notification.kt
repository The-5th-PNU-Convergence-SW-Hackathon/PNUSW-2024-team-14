package com.example.jasmin2.ui.theme

import android.Manifest
import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.os.Looper
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.jasmin2.MainActivity
import com.example.jasmin2.R


fun showNotificationWithDelay(context: Context) {
    // 딜레이 시간 설정 (5초)
    val delayMillis: Long = 8000

    Handler(Looper.getMainLooper()).postDelayed({
        showNotification(context)
    }, delayMillis)
}
fun showNotification(context: Context) {
    // Android 13(API 33) 이상에서만 POST_NOTIFICATIONS 권한이 필요함
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // 권한이 없으므로 알림을 보낼 수 없음
            // 권한 요청 코드를 추가해야 함
            ActivityCompat.requestPermissions(
                (context as Activity),
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                1
            )
            return  // 권한이 없으면 알림을 보내지 않음
        }
    }

    // 알림 채널 생성 코드
    val channelId = "pay_per_channel"
    val channelName = "Pay Per Notifications"
    val importance = NotificationManager.IMPORTANCE_HIGH
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(channelId, channelName, importance).apply {
            description = "Notifications from Pay Per"
        }
        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    val intent = Intent(context, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

    }

    // 플래그 설정
    val pendingIntent: PendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)
    } else {
        PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    }

    val alarmSound: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

    val builder = NotificationCompat.Builder(context, channelId)
        .setSmallIcon(R.drawable.check)  // 적절한 아이콘 리소스를 사용
        .setContentTitle("pay per")
        .setContentText("이용중이신 헬스장이 폐업했습니다. 확인해보세요!")
        .setPriority(NotificationCompat.PRIORITY_MAX)
        .setSound(alarmSound)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        .setFullScreenIntent(pendingIntent, true)

    with(NotificationManagerCompat.from(context)) {
        notify(12345, builder.build())
    }
}
