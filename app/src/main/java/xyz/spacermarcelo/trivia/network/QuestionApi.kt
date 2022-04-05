package xyz.spacermarcelo.trivia.network

import retrofit2.http.GET
import xyz.spacermarcelo.trivia.model.Question
import javax.inject.Singleton

@Singleton
interface QuestionApi {
    @GET("world.json")
    suspend fun getAllQuestions(): Question
}