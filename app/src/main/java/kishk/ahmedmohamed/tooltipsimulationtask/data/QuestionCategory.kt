package kishk.ahmedmohamed.tooltipsimulationtask.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

data class QuestionCategory(
    val total: Int,
    val remaining: Int,
    val name: String,
    val icon: ImageVector
)

// List of icons to use for dummy instances
private val icons: List<ImageVector> = listOf(
    Icons.Filled.Build,
    Icons.Filled.Info,
    Icons.Filled.CheckCircle,
    Icons.Filled.Share,
    Icons.Filled.Clear,
    Icons.Filled.Star,
    Icons.Filled.Favorite,
    Icons.Filled.Person,
    Icons.Filled.Settings,
    Icons.Filled.ShoppingCart
)

val dummyQuestionsCategories = listOf(
    QuestionCategory(
        total = 30,
        remaining = 15,
        name = "Mystery of the Mind",
        icon = icons[0]
    ),
    QuestionCategory(
        total = 25,
        remaining = 10,
        name = "Trivia Titans",
        icon = icons[1]
    ),
    QuestionCategory(
        total = 40,
        remaining = 20,
        name = "Science Sleuths",
        icon = icons[2]
    ),
    QuestionCategory(
        total = 20,
        remaining = 5,
        name = "History Hunters",
        icon = icons[3]
    ),
    QuestionCategory(
        total = 35,
        remaining = 15,
        name = "Geography Gurus",
        icon = icons[4]
    ),
    QuestionCategory(
        total = 50,
        remaining = 25,
        name = "Pop Culture Pioneers",
        icon = icons[5]
    ),
    QuestionCategory(
        total = 15,
        remaining = 7,
        name = "Literary Legends",
        icon = icons[6]
    ),
    QuestionCategory(
        total = 45,
        remaining = 22,
        name = "Art Aficionados",
        icon = icons[7]
    ),
    QuestionCategory(
        total = 10,
        remaining = 3,
        name = "Culinary Connoisseurs",
        icon = icons[8]
    ),
    QuestionCategory(
        total = 60,
        remaining = 30,
        name = "Tech Titans",
        icon = icons[9]
    )
)