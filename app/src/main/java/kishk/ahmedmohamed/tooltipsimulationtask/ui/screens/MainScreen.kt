package kishk.ahmedmohamed.tooltipsimulationtask.ui.screens

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kishk.ahmedmohamed.tooltipsimulationtask.ui.AppNavDestination
import kishk.ahmedmohamed.tooltipsimulationtask.ui.components.AppNavigationBar
import kishk.ahmedmohamed.tooltipsimulationtask.ui.components.MyTopBar

@Composable
fun MainScreen(
    navController: NavHostController,
    startDestination: AppNavDestination = AppNavDestination.Home
) {
    var currentDestination by remember { mutableStateOf(startDestination) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            AppNavigationBar(
                currentDestination = currentDestination,
                onDestinationClick = { clickedDest ->
                    navController.navigate(clickedDest) {
                        popUpTo(clickedDest) {
                            inclusive = true
                        }
                    }
                }
            )
        },
        topBar = {
            MyTopBar(currentDestination)
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = startDestination,
                enterTransition = {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                    ) + fadeIn(tween(700))
                },
                exitTransition = {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                    ) + fadeOut(tween(700))
                },
                popEnterTransition = {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                    ) + fadeIn(tween(700))
                },
                popExitTransition = {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                    ) + fadeOut(tween(700))
                }
            ) {
                composable<AppNavDestination.Home> {
                    HomeScreen()
                    currentDestination = AppNavDestination.Home
                }
                composable<AppNavDestination.Connect> {
                    ConnectScreen()
                    currentDestination = AppNavDestination.Connect
                }
                composable<AppNavDestination.Questions> {
                    QuestionsScreen()
                    currentDestination = AppNavDestination.Questions
                }
                composable<AppNavDestination.Tools> {
                    ToolsScreen()
                    currentDestination = AppNavDestination.Tools
                }
                composable<AppNavDestination.Profile> {
                    ProfileScreen()
                    currentDestination = AppNavDestination.Profile
                }
            }
        }
    }
}