package com.yamakuprina.kotlinquiztelegrambot.model

import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "questions")
data class Question (
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L,

    @Column(name = "question", length = 1000)
    @Size(min = 5, max = 1000, message = "Question must be between 5 and 1000 characters")
    val question: String,

    @Column(name = "answer_correct")
    @Size(min = 1, max = 255, message = "Correct Answer must be between 1 and 255 characters")
    val correctAnswer: String,

    @Column(name = "option1")
    @Size(min = 1, max = 255, message = "Option 1 must be between 1 and 255 characters")
    val optionOne: String,

    @Column(name = "option2")
    @Size(min = 1, max = 255, message = "Option 2 must be between 1 and 255 characters")
    val optionTwo: String,

    @Column(name = "option3")
    @Size(min = 1, max = 255, message = "Option 3 must be between 1 and 255 characters")
    val optionThree: String,
)