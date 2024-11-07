package kishk.ahmedmohamed.tooltipsimulationtask.ui.tutorial

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TutorialViewModel : ViewModel() {
    private val _currentStage = mutableStateOf(TutorialStage.Start)
    val currentStage: State<TutorialStage> = _currentStage

    private val _tooltipMessage = mutableStateOf("")
    val tooltipMessage: State<String> = _tooltipMessage

    fun changeStage(stage: TutorialStage) {
        viewModelScope.launch {
            _currentStage.value = stage
            _tooltipMessage.value = when (stage) {
                TutorialStage.Start, TutorialStage.Finish -> ""
                TutorialStage.HomeNavigation -> "You will find your study plan here"
                TutorialStage.ConnectNavigation -> "Here you will find study partners and people to connect with"
                TutorialStage.QuestionsNavigation -> "Here are the questions with model answers"
                TutorialStage.QuestionsFilter -> "You can filter to see an exact type of questions"
                TutorialStage.QuestionsCard -> "Click here to view by categories with progression"
            }
        }
    }
}