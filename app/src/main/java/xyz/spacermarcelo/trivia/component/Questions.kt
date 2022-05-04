package xyz.spacermarcelo.trivia.component

import android.util.Log
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import xyz.spacermarcelo.trivia.screens.QuestionsViewModel

@Composable
fun Questions(viewModel: QuestionsViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()
    if (viewModel.data.value.loading == true) {
        CircularProgressIndicator()
    } else {
        questions?.forEach { questionItem ->
            Log.d("Result", "Questions: ${questionItem.question}")
        }
    }
}

@Preview
@Composable
fun QuestionDisplay() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(4.dp)
    ) {

    }
}