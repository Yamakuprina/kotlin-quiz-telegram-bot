package com.yamakuprina.kotlinquiztelegrambot.repository

import com.yamakuprina.kotlinquiztelegrambot.model.Question
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface QuestionRepository : JpaRepository<Question, Long> {

    @Query(nativeQuery = true, value = "select * from questions order by random() limit 20")
    fun getRandomQuestions():List<Question>
}