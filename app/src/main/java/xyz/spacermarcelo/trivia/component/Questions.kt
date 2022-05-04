package xyz.spacermarcelo.trivia.component

import android.util.Log
import androidx.compose.runtime.Composable
import xyz.spacermarcelo.trivia.screens.QuestionsViewModel

@Composable
fun Questions(viewModel: QuestionsViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()
    if (viewModel.data.value.loading == true) {
        Log.d("Loading", "Questions: Loading START...")
    } else {
        Log.d("Loading", "Questions: Loading STOPPED...")
        questions?.forEach { questionItem ->
            Log.d("Result", "Questions: ${questionItem.question}")
        }
    }

}