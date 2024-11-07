package kishk.ahmedmohamed.tooltipsimulationtask.ui.components.studyplan

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kishk.ahmedmohamed.tooltipsimulationtask.R
import kishk.ahmedmohamed.tooltipsimulationtask.ui.theme.TooltipSimulationTaskTheme

@Composable
fun PlanStep(
    modifier: Modifier = Modifier,
    step: Int? = null,
    title: String = "",
    subTitle: String = "",
    enabled: Boolean = true,
    hasNext: Boolean = true,
) {
    val colorPrimary = if (enabled) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.outline
    }
    Column(
        modifier = modifier,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Ring(
                    modifier = Modifier.size(88.dp),
                    borderColor = colorPrimary
                )
                Ring(
                    modifier = Modifier.size(56.dp),
                    borderWidth = (1.38095).dp,
                    fillColor = if (enabled) colorPrimary.copy(alpha = 0.2f) else colorPrimary,
                    borderColor = colorPrimary
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        if (step != null) {
                            Text(
                                step.toString(),
                                color = if (enabled) colorPrimary else MaterialTheme.colorScheme.surface,
                                fontWeight = FontWeight.Bold,
                                fontSize = 33.sp
                            )
                        }
                    }
                }
                if (!enabled) {
                    Surface(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(28.dp),
                        shape = CircleShape,
                        color = colorPrimary
                    ) {
                        Box(
                            modifier = Modifier.size(DpSize(12.dp, 16.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_lock),
                                tint = MaterialTheme.colorScheme.surface,
                                contentDescription = "lock icon"
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                if (title.isNotEmpty()) {
                    Text(
                        text = title,
                        color = if (enabled) MaterialTheme.colorScheme.secondary else colorPrimary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        maxLines = 1,
                    )
                }
                if (subTitle.isNotEmpty()) {
                    Text(
                        text = subTitle,
                        color = if (enabled) MaterialTheme.colorScheme.secondary else colorPrimary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        maxLines = 1,
                    )
                }
            }
        }
        if (hasNext) {
            Row(
                modifier = Modifier.width(88.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    Modifier
                        .width(12.4.dp)
                        .height(36.dp)
                        .background(if (enabled) colorPrimary.copy(alpha = 0.2f) else colorPrimary)
                )
            }
        }
    }
}

@Composable
private fun Ring(
    modifier: Modifier = Modifier,
    fillColor: Color = Color.Transparent,
    borderColor: Color = MaterialTheme.colorScheme.primary,
    borderWidth: Dp = 6.dp,
    content: @Composable (() -> Unit)? = null
) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
        color = fillColor,
        border = BorderStroke(width = borderWidth, color = borderColor)
    ) {
        content?.invoke()
    }
}

@Preview(showBackground = true)
@Composable
private fun PlanStepPreview() {
    TooltipSimulationTaskTheme {
        Column {
            PlanStep(
                step = 1,
                title = "Unite 1:",
                subTitle = "Reading and Writing"
            )
            PlanStep(
                step = 2,
                title = "Task 1:",
                subTitle = "Complete training",
                enabled = false
            )
            PlanStep(
                step = 3,
                title = "Task 2:",
                subTitle = "Complete assessment",
                enabled = false,
                hasNext = false
            )
        }
    }
}