package kishk.ahmedmohamed.tooltipsimulationtask.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kishk.ahmedmohamed.tooltipsimulationtask.R
import kishk.ahmedmohamed.tooltipsimulationtask.data.studyPartnerCards
import kishk.ahmedmohamed.tooltipsimulationtask.ui.components.StudyPartnerCard
import kishk.ahmedmohamed.tooltipsimulationtask.ui.theme.TooltipSimulationTaskTheme

@Composable
fun ConnectScreen() {
    Column {
        Tabs()
        SuggestionsTabContent()
    }
}

@Composable
private fun SuggestionsTabContent() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 28.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Suggested Study Partners:",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.secondary
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_filter),
                contentDescription = "filter",
                tint = MaterialTheme.colorScheme.primary
            )
        }
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(studyPartnerCards) {
                StudyPartnerCard(
                    modifier = Modifier.fillMaxWidth(),
                    name = it.name,
                    imageUrl = it.imageUrl,
                    imagePlaceholderText = it.imagePlaceholderText,
                    target = it.target,
                    age = it.age,
                    gender = it.gender,
                    lastSeen = it.lastSeen,
                    location = it.location,
                    languages = it.languages,
                    joinDate = it.joinDate
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Tabs() {
    PrimaryTabRow(selectedTabIndex = 0) {
        Tab(
            selected = true,
            onClick = { },
            text = { Text("Suggestions") }
        )
        Tab(
            selected = false,
            onClick = { },
            text = { Text("Chat") }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ConnectScreenPreview() {
    TooltipSimulationTaskTheme {
        ConnectScreen()
    }
}