package kishk.ahmedmohamed.tooltipsimulationtask.ui.screens

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kishk.ahmedmohamed.tooltipsimulationtask.ui.AppNavDestination
import kishk.ahmedmohamed.tooltipsimulationtask.ui.components.AppNavigationBar
import kishk.ahmedmohamed.tooltipsimulationtask.ui.components.MyTopBar
import kishk.ahmedmohamed.tooltipsimulationtask.ui.tutorial.TutorialStage

@Composable
fun MainScreen(
    navController: NavHostController,
    startDestination: AppNavDestination = AppNavDestination.Home,
    tutorialStage: TutorialStage,
    tutorialToolTipMessage: String,
    onTutorialProgress: (nextStage: TutorialStage) -> Unit
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
                },
                tutorialStage = tutorialStage,
                tutorialToolTipMessage = tutorialToolTipMessage,
                onTutorialProgress = onTutorialProgress
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
                    QuestionsScreen(tutorialStage, onTutorialProgress)
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

    if (tutorialStage == TutorialStage.Start) {
        Dialog(
            onDismissRequest = {
                onTutorialProgress(TutorialStage.HomeNavigation)
            },
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(MaterialTheme.colorScheme.inverseSurface.copy(alpha = 0.4f))
                    .clickable { onTutorialProgress(TutorialStage.HomeNavigation) },
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Text(
                        color = MaterialTheme.colorScheme.inverseOnSurface,
                        text = buildAnnotatedString {
                            append("welcome to: tutorial\n")
                            withStyle(
                                SpanStyle(
                                    color = MaterialTheme.colorScheme.primary,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append("Tap anywhere on the screen to continue")
                            }
                        },
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}