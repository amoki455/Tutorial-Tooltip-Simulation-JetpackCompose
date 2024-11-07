package kishk.ahmedmohamed.tooltipsimulationtask.data

data class StudyPlanStep(
    val title: String = "",
    val subTitle: String = "",
    val hasNext: Boolean = true,
    val enabled: Boolean = true
)

// using dummy data, since the purpose is just demonstration
val studyPlanSteps = listOf(
    StudyPlanStep("Unite 1:", subTitle = "What is success"),
    StudyPlanStep("Unite 2:", subTitle = "What is CTF", enabled = false),
    StudyPlanStep(subTitle = "Writing tasks", enabled = false),
    StudyPlanStep(subTitle = "Oral task", enabled = false),
    StudyPlanStep(subTitle = "Oral task", enabled = false),
    StudyPlanStep(subTitle = "Oral task", enabled = false),
    StudyPlanStep(subTitle = "Oral task", enabled = false, hasNext = false),
)