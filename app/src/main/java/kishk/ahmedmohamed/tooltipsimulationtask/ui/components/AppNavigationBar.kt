package kishk.ahmedmohamed.tooltipsimulationtask.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import kishk.ahmedmohamed.tooltipsimulationtask.ui.AppNavDestination
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kishk.ahmedmohamed.tooltipsimulationtask.ui.theme.TooltipSimulationTaskTheme
import kishk.ahmedmohamed.tooltipsimulationtask.ui.tutorial.TutorialStage

val navBarDestinations = listOf(
    AppNavDestination.Home,
    AppNavDestination.Connect,
    AppNavDestination.Questions,
    AppNavDestination.Tools,
    AppNavDestination.Profile
)

@Composable
fun AppNavigationBar(
    currentDestination: AppNavDestination,
    onDestinationClick: (AppNavDestination) -> Unit,
    tutorialStage: TutorialStage,
    tutorialToolTipMessage: String,
    onTutorialProgress: (nextStage: TutorialStage) -> Unit
) {
    NavigationBar {
        for (destination in navBarDestinations) {
            Highlight(
                modifier = Modifier.weight(1f),
                onClickOutside = {
                    onTutorialProgress(getNextTutorialStage(currentStage = tutorialStage))
                },
                highlighted = isNavItemHighlighted(tutorialStage, destination),
                disableClickWhenHighlighted = true,
                tooltipContent = {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = tutorialToolTipMessage,
                        fontSize = 14.sp
                    )
                }
            ) {
                NavigationBarItem(
                    selected = currentDestination == destination,
                    onClick = { onDestinationClick(destination) },
                    icon = destination.icon,
                    label = { destination.Label() },
                    alwaysShowLabel = true
                )
            }
        }
    }
}

private fun isNavItemHighlighted(tutorialStage: TutorialStage, destination: AppNavDestination): Boolean {
    return tutorialStage == TutorialStage.HomeNavigation && destination == AppNavDestination.Home
            || tutorialStage == TutorialStage.ConnectNavigation && destination == AppNavDestination.Connect
            || tutorialStage == TutorialStage.QuestionsNavigation && destination == AppNavDestination.Questions
}

private fun getNextTutorialStage(currentStage: TutorialStage): TutorialStage {
    return when (currentStage) {
        TutorialStage.Start -> TutorialStage.HomeNavigation
        TutorialStage.HomeNavigation -> TutorialStage.ConnectNavigation
        TutorialStage.ConnectNavigation -> TutorialStage.QuestionsNavigation
        TutorialStage.QuestionsNavigation -> TutorialStage.QuestionsFilter
        TutorialStage.QuestionsFilter -> TutorialStage.QuestionsCard
        TutorialStage.QuestionsCard -> TutorialStage.Finish
        TutorialStage.Finish -> TutorialStage.Finish
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    TooltipSimulationTaskTheme {
        AppNavigationBar(
            currentDestination = AppNavDestination.Home,
            onDestinationClick = {},
            tutorialToolTipMessage = "Hello world",
            onTutorialProgress = {},
            tutorialStage = TutorialStage.HomeNavigation
        )
    }
}