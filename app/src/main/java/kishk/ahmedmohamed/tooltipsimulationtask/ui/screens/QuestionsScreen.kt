package kishk.ahmedmohamed.tooltipsimulationtask.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kishk.ahmedmohamed.tooltipsimulationtask.R
import kishk.ahmedmohamed.tooltipsimulationtask.data.dummyQuestionsCategories
import kishk.ahmedmohamed.tooltipsimulationtask.data.oralQuestions
import kishk.ahmedmohamed.tooltipsimulationtask.ui.components.Highlight
import kishk.ahmedmohamed.tooltipsimulationtask.ui.components.OralQuestionCard
import kishk.ahmedmohamed.tooltipsimulationtask.ui.components.QuestionsCategoryCard
import kishk.ahmedmohamed.tooltipsimulationtask.ui.theme.TooltipSimulationTaskTheme
import kishk.ahmedmohamed.tooltipsimulationtask.ui.tutorial.TutorialStage

@Composable
fun QuestionsScreen(
    tutorialStage: TutorialStage,
    tutorialTooltipMessage: String,
    onTutorialProgress: (nextStage: TutorialStage) -> Unit
) {
    var currentTab by remember { mutableIntStateOf(1) }
    Column {
        Tabs(
            selectedIndex = currentTab,
            onTabClick = {
                currentTab = it
            }
        )
        if (currentTab == 0) {
            WritingTabContent(tutorialStage, tutorialTooltipMessage, onTutorialProgress)
        } else {
            OralTabContent(tutorialStage, tutorialTooltipMessage, onTutorialProgress)
        }
    }

    LaunchedEffect(key1 = tutorialStage) {
        if (tutorialStage == TutorialStage.QuestionsCard) {
            currentTab = 0
        }
    }
}

@Composable
private fun WritingTabContent(
    tutorialStage: TutorialStage,
    tutorialTooltipMessage: String,
    onTutorialProgress: (nextStage: TutorialStage) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(dummyQuestionsCategories) { x, it ->
            if (x == 0) {
                Highlight(
                    onClickOutside = {
                        onTutorialProgress(TutorialStage.Finish)
                    },
                    tooltipContent = {
                        Text(
                            modifier = Modifier.padding(16.dp),
                            text = tutorialTooltipMessage
                        )
                    },
                    highlighted = tutorialStage == TutorialStage.QuestionsCard,
                    disableClickWhenHighlighted = true
                ) {
                    QuestionsCategoryCard(
                        modifier = Modifier.height(150.dp),
                        total = it.total,
                        remaining = it.remaining,
                        name = it.name,
                        icon = it.icon
                    )
                }
            } else {
                QuestionsCategoryCard(
                    modifier = Modifier.height(150.dp),
                    total = it.total,
                    remaining = it.remaining,
                    name = it.name,
                    icon = it.icon
                )
            }
        }
    }
}


@Composable
private fun OralTabContent(
    tutorialStage: TutorialStage,
    tutorialTooltipMessage: String,
    onTutorialProgress: (nextStage: TutorialStage) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Highlight(
                onClickOutside = {
                    onTutorialProgress(TutorialStage.QuestionsCard)
                },
                tooltipContent = {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = tutorialTooltipMessage
                    )
                },
                highlighted = tutorialStage == TutorialStage.QuestionsFilter,
                disableClickWhenHighlighted = true,
            ) {
                FilterButton(onClick = {})
            }
        }
        items(oralQuestions) {
            OralQuestionCard(
                content = it.content,
                tags = it.tags,
                answers = it.answers,
                date = it.date
            )
        }
    }
}

@Composable
private fun FilterButton(onClick: () -> Unit) {
    Surface(
        shape = RoundedCornerShape(4.dp),
        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.size(116.dp, 41.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Filter",
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_filter),
                contentDescription = "filter"
            )
        }
    }
}

@Composable
private fun Tabs(
    selectedIndex: Int,
    onTabClick: (Int) -> Unit
) {
    TabRow(selectedTabIndex = selectedIndex) {
        Tab(
            modifier = Modifier.fillMaxWidth(),
            selected = selectedIndex == 0,
            onClick = { onTabClick(0) },
            content = {
                MyTab(
                    text = "Writing",
                    iconPainter = painterResource(id = R.drawable.ic_pencil),
                    color = if (selectedIndex == 0) MaterialTheme.colorScheme.primary else
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
            }
        )
        Tab(
            modifier = Modifier.fillMaxWidth(),
            selected = selectedIndex == 1,
            onClick = { onTabClick(1) },
            content = {
                MyTab(
                    text = "Oral",
                    iconPainter = painterResource(id = R.drawable.ic_mic),
                    color = if (selectedIndex == 1) MaterialTheme.colorScheme.primary else
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
            }
        )
    }
}

@Composable
private fun MyTab(
    text: String,
    iconPainter: Painter,
    color: Color
) {
    Row(
        modifier = Modifier.padding(vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = iconPainter,
            contentDescription = "",
            tint = color,
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            color = color,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun QuestionsScreenPreview() {
    TooltipSimulationTaskTheme {
        QuestionsScreen(
            tutorialStage = TutorialStage.Start,
            tutorialTooltipMessage = "",
            onTutorialProgress = {}
        )
    }
}