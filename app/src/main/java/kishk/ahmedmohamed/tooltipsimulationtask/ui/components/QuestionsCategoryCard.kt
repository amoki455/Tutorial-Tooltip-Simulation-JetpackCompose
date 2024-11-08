package kishk.ahmedmohamed.tooltipsimulationtask.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kishk.ahmedmohamed.tooltipsimulationtask.ui.theme.TooltipSimulationTaskTheme

@Composable
fun QuestionsCategoryCard(
    modifier: Modifier = Modifier,
    total: Int,
    remaining: Int,
    name: String,
    icon: ImageVector
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 7.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            RemainingText(total, remaining)
            Spacer(modifier = Modifier.height(8.dp))
            IconAndName(icon, name)
            Spacer(modifier = Modifier.height(8.dp))
            Progress(total.toDouble(), remaining.toDouble())
        }
    }
}

@Composable
private fun RemainingText(
    total: Int,
    remaining: Int,
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(2.dp),
        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 4.dp),
            text = "$remaining out of $total Questions",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}

@Composable
private fun IconAndName(
    icon: ImageVector,
    name: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = name,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
    }
}

@Composable
private fun Progress(
    total: Double,
    remaining: Double,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            text = "Progress ${((remaining / total) * 100).toInt()}%",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(),
            gapSize = 0.dp,
            progress = {
                (remaining / total).toFloat()
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun QuestionsCategoryCardPreview() {
    TooltipSimulationTaskTheme {
        QuestionsCategoryCard(
            modifier = Modifier
                .padding(36.dp)
                .height(150.dp),
            total = 10,
            remaining = 5,
            name = "Art and Culture",
            icon = Icons.Default.Edit
        )
    }
}