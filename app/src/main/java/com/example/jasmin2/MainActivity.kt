package com.example.jasmin2

import Explain2
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jasmin2.ui.theme.CloseScreen
import com.example.jasmin2.ui.theme.Explain1
import com.example.jasmin2.ui.theme.GymInfoScreen
import com.example.jasmin2.ui.theme.LoginScreen
import com.example.jasmin2.ui.theme.MyDetailScreen

import com.example.jasmin2.ui.theme.MyScroll
import com.example.jasmin2.ui.theme.MypageScreen
import com.example.jasmin2.ui.theme.NotificationTestScreen
import com.example.jasmin2.ui.theme.PayScreen
import com.example.jasmin2.ui.theme.RefundCompleteScreen
import com.example.jasmin2.ui.theme.RefundScreen
import com.example.jasmin2.ui.theme.ReportCompleteScreen
import com.example.jasmin2.ui.theme.ReportScreen
import com.example.jasmin2.ui.theme.StartScreen
import com.example.jasmin2.ui.theme.showNotification

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val navController = rememberNavController() // NavHostController를 가져옴
            NavGraph(navController = navController, initialIntent = intent)
        }
    }
}




@Preview(showBackground = true)
@Composable
fun MyAppContentPreview() {
    val navController = rememberNavController()
    NavGraph(navController = navController, initialIntent = null)
}

@Composable
fun NavGraph(navController: NavController, initialIntent: Intent?) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "start") {
        composable("start") { StartScreen(navController) }
        composable("mypage") { MypageScreen(navController) }
        composable("explain1"){Explain1(navController)}
        composable("explain2"){Explain2(navController)}
        composable("home"){GymInfoScreen(navController)}
        composable("login"){ LoginScreen(navController)}
        composable("scroll"){ MyScroll(navController)}
        composable("detail"){ MyDetailScreen()}
        composable("close"){CloseScreen(navController)}
        composable("notitest"){
            NotificationTestScreen(navController, initialIntent)
        }
        composable("refund"){ RefundScreen(navController)}
        composable("refundcomplete"){ RefundCompleteScreen(navController)}
        composable("report"){ ReportScreen(navController)}
        composable("reportcomplete"){ ReportCompleteScreen(navController)}
        composable("pay"){ PayScreen(navController)}

    }
}



