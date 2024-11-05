package kishk.ahmedmohamed.tooltipsimulationtask.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kishk.ahmedmohamed.tooltipsimulationtask.ui.AppNavDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(
    currentDestination: AppNavDestination,
) {
    TopAppBar(
        title = {
            currentDestination.Title()
        }
    )
}

@Preview
@Composable
private fun PreviewTopBar() {
    MyTopBar(
        currentDestination = AppNavDestination.Home,
    )
}