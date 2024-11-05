package kishk.ahmedmohamed.tooltipsimulationtask.ui

import kotlinx.serialization.Serializable
import androidx.annotation.StringRes
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kishk.ahmedmohamed.tooltipsimulationtask.R

@Serializable
sealed class AppNavDestination(
    @StringRes val labelStringResourceId: Int,
    @StringRes val titleStringResourceId: Int,
    val icon: @Composable () -> Unit
) {
    @Serializable
    data object Home : AppNavDestination(
        labelStringResourceId = R.string.home,
        titleStringResourceId = R.string.home,
        icon = { Icon(painterResource(R.drawable.ic_home), "Home") }
    )

    @Serializable
    data object Connect : AppNavDestination(
        labelStringResourceId = R.string.connector,
        titleStringResourceId = R.string.connector,
        icon = { Icon(painterResource(R.drawable.ic_connect), "Connector") }
    )

    @kotlinx.serialization.Serializable
    data object Questions : AppNavDestination(
        labelStringResourceId = R.string.questions,
        titleStringResourceId = R.string.questions,
        icon = { Icon(painterResource(R.drawable.ic_question), "questions") }
    )

    @Serializable
    data object Tools : AppNavDestination(
        labelStringResourceId = R.string.tools,
        titleStringResourceId = R.string.tools,
        icon = { Icon(painterResource(R.drawable.ic_tools), "tools") }
    )

    @Serializable
    data object Profile : AppNavDestination(
        labelStringResourceId = R.string.profile,
        titleStringResourceId = R.string.profile,
        icon = { Icon(painterResource(R.drawable.ic_profile), "profile") }
    )

    @Composable
    fun Label() {
        Text(text = stringResource(id = labelStringResourceId))
    }

    @Composable
    fun Title() {
        Text(
            text = stringResource(id = titleStringResourceId),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}