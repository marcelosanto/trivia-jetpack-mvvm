package xyz.spacermarcelo.trivia.repository

import xyz.spacermarcelo.trivia.data.DataOrException
import xyz.spacermarcelo.trivia.model.QuestionItem
import xyz.spacermarcelo.trivia.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val api: QuestionApi
) {
    private val listOfQuestions =
        DataOrException<ArrayList<QuestionItem>,
                Boolean,
                Exception>()


}