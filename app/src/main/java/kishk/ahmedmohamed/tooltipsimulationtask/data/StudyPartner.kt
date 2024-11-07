package kishk.ahmedmohamed.tooltipsimulationtask.data

data class StudyPartner(
    val name: String,
    val imageUrl: String,
    val imagePlaceholderText: String,
    val target: String,
    val age: Int,
    val gender: String,
    val lastSeen: String,
    val location: String,
    val languages: List<String>,
    val joinDate: String
)

// using dummy data, since the purpose is just demonstration
val studyPartnerCards = listOf(
    StudyPartner(
        name = "Alice Smith",
        imageUrl = "https://example.com/image1.jpg",
        imagePlaceholderText = "AS",
        target = "A1",
        age = 24,
        gender = "Female",
        lastSeen = "Today",
        location = "USA",
        languages = listOf("English", "Spanish"),
        joinDate = "15 March 2023"
    ),
    StudyPartner(
        name = "Bob Johnson",
        imageUrl = "https://example.com/image2.jpg",
        imagePlaceholderText = "BJ",
        target = "B2",
        age = 22,
        gender = "Male",
        lastSeen = "2 days ago",
        location = "Canada",
        languages = listOf("English", "French"),
        joinDate = "10 April 2023"
    ),
    StudyPartner(
        name = "Charlie Brown",
        imageUrl = "https://example.com/image3.jpg",
        imagePlaceholderText = "CB",
        target = "C3",
        age = 27,
        gender = "Male",
        lastSeen = "Last week",
        location = "UK",
        languages = listOf("English", "German"),
        joinDate = "5 May 2023"
    ),
    StudyPartner(
        name = "Diana Prince",
        imageUrl = "https://example.com/image4.jpg",
        imagePlaceholderText = "DP",
        target = "D4",
        age = 23,
        gender = "Female",
        lastSeen = "Yesterday",
        location = "Australia",
        languages = listOf("English", "Mandarin"),
        joinDate = "20 June 2023"
    ),
    StudyPartner(
        name = "Ethan Hunt",
        imageUrl = "https://example.com/image5.jpg",
        imagePlaceholderText = "EH",
        target = "E5",
        age = 30,
        gender = "Male",
        lastSeen = "Today",
        location = "USA",
        languages = listOf("English", "Russian"),
        joinDate = "1 January 2023"
    ),
    StudyPartner(
        name = "Fiona Gallagher",
        imageUrl = "https://example.com/image6.jpg",
        imagePlaceholderText = "FG",
        target = "F6",
        age = 26,
        gender = "Female",
        lastSeen = "3 days ago",
        location = "Ireland",
        languages = listOf("English", "Irish"),
        joinDate = "12 February 2023"
    ),
    StudyPartner(
        name = "George Lucas",
        imageUrl = "https://example.com/image7.jpg",
        imagePlaceholderText = "GL",
        target = "G7",
        age = 29,
        gender = "Male",
        lastSeen = "Last month",
        location = "USA",
        languages = listOf("English", "Japanese"),
        joinDate = "30 March 2023"
    ),
    StudyPartner(
        name = "Hannah Montana",
        imageUrl = "https://example.com/image8.jpg",
        imagePlaceholderText = "HM",
        target = "H8",
        age = 21,
        gender = "Female",
        lastSeen = "Today",
        location = "USA",
        languages = listOf("English", "Korean"),
        joinDate = "25 April 2023"
    ),
    StudyPartner(
        name = "Ian Malcolm",
        imageUrl = "https://example.com/image9.jpg",
        imagePlaceholderText = "IM",
        target = "I9",
        age = 35,
        gender = "Male",
        lastSeen = "Last week",
        location = "New Zealand",
        languages = listOf("English", "Italian"),
        joinDate = "18 May 2023"
    ),
    StudyPartner(
        name = "Julia Roberts",
        imageUrl = "https://example.com/image10.jpg",
        imagePlaceholderText = "JR",
        target = "J10",
        age = 32,
        gender = "Female",
        lastSeen = "Yesterday",
        location = "USA",
        languages = listOf("English", "Portuguese"),
        joinDate = "8 June 2023"
    )
)
