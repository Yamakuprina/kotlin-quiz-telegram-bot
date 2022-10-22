package com.yamakuprina.kotlinquiztelegrambot.repository

import com.yamakuprina.kotlinquiztelegrambot.model.Question
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QuestionRepository : JpaRepository<Question, Long> {
}