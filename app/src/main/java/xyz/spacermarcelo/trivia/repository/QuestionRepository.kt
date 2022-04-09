package xyz.spacermarcelo.trivia.repository

import android.util.Log
import xyz.spacermarcelo.trivia.data.DataOrException
import xyz.spacermarcelo.trivia.model.QuestionItem
import xyz.spacermarcelo.trivia.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val api: QuestionApi
) {
    private val dataOrException =
        DataOrException<ArrayList<QuestionItem>,
                Boolean,
                Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()

            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false

        } catch (e: Exception) {
            dataOrException.e = e
            Log.e("Exc", "getAllQuestions: ${dataOrException.e!!.localizedMessage}")
        }
        return dataOrException
    }
}