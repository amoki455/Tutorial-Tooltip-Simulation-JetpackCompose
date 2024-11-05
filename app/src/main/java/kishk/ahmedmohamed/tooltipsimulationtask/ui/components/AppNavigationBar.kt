package kishk.ahmedmohamed.tooltipsimulationtask.ui.components

import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import kishk.ahmedmohamed.tooltipsimulationtask.ui.AppNavDestination
import androidx.compose.material3.NavigationBarItem
import androidx.compose.ui.tooling.preview.Preview
import kishk.ahmedmohamed.tooltipsimulationtask.ui.theme.TooltipSimulationTaskTheme

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
) {
    NavigationBar {
        for (destination in navBarDestinations) {
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

@Preview(showBackground = true)
@Composable
private fun Preview() {
    TooltipSimulationTaskTheme {
        AppNavigationBar(
            currentDestination = AppNavDestination.Home,
            onDestinationClick = {}
        )
    }
}