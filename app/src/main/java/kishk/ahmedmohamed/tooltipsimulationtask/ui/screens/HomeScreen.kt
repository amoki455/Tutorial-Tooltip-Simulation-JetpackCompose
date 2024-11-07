package kishk.ahmedmohamed.tooltipsimulationtask.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kishk.ahmedmohamed.tooltipsimulationtask.data.StudyPlanStep
import kishk.ahmedmohamed.tooltipsimulationtask.data.studyPlanSteps
import kishk.ahmedmohamed.tooltipsimulationtask.ui.components.studyplan.PlanStep
import kishk.ahmedmohamed.tooltipsimulationtask.ui.theme.TooltipSimulationTaskTheme

@Composable
fun HomeScreen() {
    Column {
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            WelcomeMessage()
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Study Plan",
                color = MaterialTheme.colorScheme.tertiary,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))
        }

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            itemsIndexed(studyPlanSteps) { x, it ->
                PlanStep(
                    title = it.title,
                    subTitle = it.subTitle,
                    step = x + 1,
                    enabled = it.enabled,
                    hasNext = it.hasNext,
                )
            }
        }
    }
}

@Composable
private fun WelcomeMessage(
    modifier: Modifier = Modifier,
    username: String = "User Name"
) {
    Text(
        modifier = modifier,
        text = buildAnnotatedString {
            append("Hi  ")
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.tertiary,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append(username)
            }
        },
        fontSize = 24.sp
    )
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    TooltipSimulationTaskTheme {
        HomeScreen()
    }
}