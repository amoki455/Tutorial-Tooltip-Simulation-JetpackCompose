package kishk.ahmedmohamed.tooltipsimulationtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import kishk.ahmedmohamed.tooltipsimulationtask.ui.screens.MainScreen
import kishk.ahmedmohamed.tooltipsimulationtask.ui.theme.TooltipSimulationTaskTheme
import kishk.ahmedmohamed.tooltipsimulationtask.ui.tutorial.TutorialViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val tutorialViewModel = viewModel<TutorialViewModel>()
            val tutorialStage by tutorialViewModel.currentStage
            val tutorialTooltipMessage by tutorialViewModel.tooltipMessage

            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                TooltipSimulationTaskTheme {
                    MainScreen(
                        navController = navController,
                        tutorialStage = tutorialStage,
                        tutorialToolTipMessage = tutorialTooltipMessage,
                        onTutorialProgress = { nextStage ->
                            tutorialViewModel.changeStage(nextStage)
                        }
                    )
                }
            }
        }
    }
}
