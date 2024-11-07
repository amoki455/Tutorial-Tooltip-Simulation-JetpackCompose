package kishk.ahmedmohamed.tooltipsimulationtask.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kishk.ahmedmohamed.tooltipsimulationtask.R
import kishk.ahmedmohamed.tooltipsimulationtask.ui.theme.TooltipSimulationTaskTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun StudyPartnerCard(
    modifier: Modifier = Modifier,
    name: String,
    imageUrl: String,
    imagePlaceholderText: String,
    target: String,
    lastSeen: String,
    languages: List<String>,
    location: String,
    gender: String,
    age: Int,
    joinDate: String
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 7.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                CardImage(imageUrl, imagePlaceholderText)
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    NameAndTarget(name, target)
                    Text(
                        text = "Last seen online: $lastSeen",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                    )
                    LanguagesTags(languages)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                UserInfo(iconPainter = painterResource(id = R.drawable.ic_location_on), value = location)
                if (gender == "Male") {
                    UserInfo(iconPainter = painterResource(id = R.drawable.ic_male), value = gender)
                } else {
                    UserInfo(iconPainter = painterResource(id = R.drawable.ic_female), value = gender)
                }
                UserInfo(iconPainter = painterResource(id = R.drawable.ic_birthday), value = age.toString())
                UserInfo(iconPainter = painterResource(id = R.drawable.ic_calender), value = joinDate)
            }
        }
    }
}

@Composable
private fun CardImage(imageUrl: String, placeholderText: String) {
    Surface(
        modifier = Modifier.size(48.dp),
        shape = CircleShape,
        color = MaterialTheme.colorScheme.secondary
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            // Currently displaying placeholder text for the image
            Text(text = placeholderText, fontSize = 16.sp)
        }
    }
}

@Composable
private fun NameAndTarget(name: String, target: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f, fill = false),
            text = name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorScheme.tertiary
        )
        Spacer(modifier = Modifier.width(8.dp))
        Surface(
            shape = RoundedCornerShape(2.dp),
            color = MaterialTheme.colorScheme.primary
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 2.dp),
                text = "Targeting: $target",
                lineHeight = 20.sp,
                textAlign = TextAlign.Center,
                fontSize = 12.sp
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun LanguagesTags(languages: List<String>) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        languages.forEach {
            Surface(
                shape = RoundedCornerShape(2.dp),
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    text = it,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
private fun UserInfo(iconPainter: Painter, value: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = iconPainter,
            contentDescription = "icon",
            tint = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.width(1.dp))
        Text(text = value, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f))
    }
}

@Preview(showBackground = true)
@Composable
private fun StudyPartnerCardPreview() {
    TooltipSimulationTaskTheme {
        StudyPartnerCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(36.dp),
            name = "John Doe",
            imageUrl = "",
            imagePlaceholderText = "JD",
            target = "B1",
            age = 26,
            gender = "Male",
            lastSeen = "Yesterday",
            location = "Egypt",
            languages = listOf("English", "Arabic", "French"),
            joinDate = "21 June 2023"
        )
    }
}