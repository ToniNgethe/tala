package com.tala.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tala.core_data.domain.models.Loan
import com.tala.core_design.navigation.Routes
import com.tala.core_design.navigation.UiEvent
import com.tala.core_design.theme.DarkPrimary
import com.tala.core_design.theme.TalaTheme
import com.tala.feature_loans.presentation.LoansPage
import com.tala.feature_selected_loan.presentation.SelectedLoanPage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TalaTheme {
                val systemUiController = rememberSystemUiController()
                val userDarkIcons = MaterialTheme.colors.isLight
                val context = LocalContext.current

                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = DarkPrimary, darkIcons = userDarkIcons
                    )
                    systemUiController.setStatusBarColor(DarkPrimary)
                    systemUiController.setNavigationBarColor(if (userDarkIcons) Color.White else Color.Black)
                }

                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    NavHost(navController = navController, startDestination = Routes.splashPage) {
                        composable(route = Routes.splashPage) {
                            SplashPage { event ->
                                if (event is UiEvent.OnNavigate) {
                                    navController.navigate(Routes.loansPage){
                                        popUpTo(0)
                                    }
                                }
                            }
                        }

                        composable(route = Routes.loansPage) {
                            LoansPage {
                                if (it is UiEvent.OnNavigate) {
                                    navController.navigate(it.route)
                                }
                            }
                        }

                        composable(
                            route = Routes.selectedLoanPage,
                            arguments = listOf(navArgument("loan") {})
                        ) {
                            val loan: Loan =
                                Json.decodeFromString(it.arguments?.getString("loan")!!)
                            SelectedLoanPage(
                                context,
                                loan
                            ) { event ->
                                if (event is UiEvent.NavigateUp) {
                                    navController.navigateUp()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TalaTheme {
        Greeting("Android")
    }
}