package xyz.spacermarcelo.trivia.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import xyz.spacermarcelo.trivia.data.DataOrException
import xyz.spacermarcelo.trivia.model.QuestionItem
import xyz.spacermarcelo.trivia.repository.QuestionRepository
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(private val repository: QuestionRepository) :
    ViewModel() {
    private val data: MutableState<DataOrException<ArrayList<QuestionItem>,
            Boolean, Exception>> = mutableStateOf(
        DataOrException(null, true, Exception(""))
    )

    init {
        getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllQuestions()

            if (data.value.data.toString().isNotEmpty()) {
                data.value.loading = false
            }
        }
    }
}