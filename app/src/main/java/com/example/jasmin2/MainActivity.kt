package com.example.jasmin2

import com.example.jasmin2.home.Explain2
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jasmin2.ui.theme.CloseScreen
import com.example.jasmin2.home.Explain1
import com.example.jasmin2.home.GymInfoScreen
import com.example.jasmin2.login.LoginScreen
import com.example.jasmin2.pagenation.MyDetailScreen

import com.example.jasmin2.pagenation.MyScroll
import com.example.jasmin2.pagenation.MypageScreen
import com.example.jasmin2.ui.theme.NotificationTestScreen
import com.example.jasmin2.ui.theme.PayScreen
import com.example.jasmin2.completepage.RefundCompleteScreen
import com.example.jasmin2.loadinganimation.RefundLoading
import com.example.jasmin2.ui.theme.RefundScreen
import com.example.jasmin2.completepage.ReportCompleteScreen
import com.example.jasmin2.loadinganimation.ReportLoading
import com.example.jasmin2.ui.theme.ReportScreen
import com.example.jasmin2.login.SignupScreen
import com.example.jasmin2.home.StartScreen

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
        composable("explain1"){ Explain1(navController) }
        composable("explain2"){ Explain2(navController) }
        composable("home"){ GymInfoScreen(navController) }
        composable("login"){ LoginScreen(navController) }

        composable("signup") { SignupScreen(navController = navController, viewModel = viewModel()) }

        composable("scroll"){ MyScroll(navController) }

        composable(
            "detail/{fitnessId}",
            arguments = listOf(navArgument("fitnessId") { type = NavType.LongType })
        ) { backStackEntry ->
            val fitnessId = backStackEntry.arguments?.getLong("fitnessId")
            val fitnessViewModel: MainViewModel = viewModel()

            fitnessId?.let { id ->
                val fitness = fitnessViewModel.getFitnessById(id)
                fitness?.let {
                    MyDetailScreen(fitnessId = id, fitness = it,navController = navController) // id와 fitness 객체를 전달
                }
            }
        }

        composable("close"){CloseScreen(navController)}
        composable("notitest"){
            NotificationTestScreen(navController, initialIntent)
        }
        composable("refund"){ RefundScreen(navController)}
        composable("refundcomplete"){ RefundCompleteScreen(navController) }
        composable("report"){ ReportScreen(navController)}
        composable("reportcomplete"){ ReportCompleteScreen(navController) }
        composable(
            "pay/{fitnessId}",
            arguments = listOf(navArgument("fitnessId") { type = NavType.LongType })
        ) { backStackEntry ->
            val fitnessId = backStackEntry.arguments?.getLong("fitnessId")
            val fitnessViewModel: MainViewModel = viewModel()

            // fitnessId로 데이터를 가져와 PayScreen에 전달
            fitnessId?.let { id ->
                val fitness = fitnessViewModel.getFitnessById(id)
                fitness?.let {
                    PayScreen(navController = navController, fitness = it, fitnessId = id)
                }
            }
        }

        composable("RefundLoading") {
            RefundLoading(navController = navController) // 로딩 화면 추가
        }

        composable("ReportLoading") {
            ReportLoading(navController = navController)
        }

    }
}
