package kishk.ahmedmohamed.tooltipsimulationtask.data

data class OralQuestion(
    val tags: List<String>,
    val content: String,
    val answers: Int,
    val date: String
)

val oralQuestions = listOf(
    OralQuestion(
        tags = listOf("Events", "Task 1"),
        content = "Could you elaborate on the specific route that will be taken during the upcoming marathon, including any notable landmarks or challenging sections that participants should be aware of?",
        answers = 5,
        date = "10 March 2023"
    ),
    OralQuestion(
        tags = listOf("Sports", "Task 2"),
        content = "Can you provide detailed information about the duration of the race this year, including any changes from previous years and how it might affect the participants' training schedules?",
        answers = 8,
        date = "15 April 2023"
    ),
    OralQuestion(
        tags = listOf("Health", "Task 3"),
        content = "Who are the main participants in this year's race, and could you share some background information about their previous performances and what makes them stand out in the running community?",
        answers = 12,
        date = "20 May 2023"
    ),
    OralQuestion(
        tags = listOf("Community", "Task 4"),
        content = "What time does the race start, and are there any pre-race activities or ceremonies that participants and spectators should be aware of to enhance their experience?",
        answers = 3,
        date = "25 June 2023"
    ),
    OralQuestion(
        tags = listOf("Fitness", "Task 5"),
        content = "Are there any age restrictions for participants in the race, and how do these restrictions impact the overall inclusivity of the event for younger and older runners?",
        answers = 7,
        date = "30 July 2023"
    ),
    OralQuestion(
        tags = listOf("Events", "Task 6"),
        content = "What is the registration fee for the race, and could you explain what this fee covers in terms of amenities, support during the race, and post-race activities?",
        answers = 4,
        date = "5 August 2023"
    ),
    OralQuestion(
        tags = listOf("Running", "Task 7"),
        content = "Will there be refreshments available during the race, and if so, what types of food and drink can participants expect to find at the various aid stations along the route?",
        answers = 6,
        date = "10 September 2023"
    ),
    OralQuestion(
        tags = listOf("Charity", "Task 8"),
        content = "Is the race supporting any charitable cause this year, and how can participants contribute to these efforts while also enjoying the event?",
        answers = 9,
        date = "15 October 2023"
    ),
    OralQuestion(
        tags = listOf("Training", "Task 9"),
        content = "What training tips do you recommend for individuals preparing for the race, particularly for those who may be new to long-distance running and looking to improve their performance?",
        answers = 11,
        date = "20 November 2023"
    ),
    OralQuestion(
        tags = listOf("Events", "Task 10"),
        content = "How can I volunteer for the event, and what roles are typically available for volunteers to help ensure the race runs smoothly and safely for all participants?",
        answers = 2,
        date = "25 December 2023"
    )
)
