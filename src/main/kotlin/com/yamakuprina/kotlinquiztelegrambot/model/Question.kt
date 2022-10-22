package com.yamakuprina.kotlinquiztelegrambot.model

import javax.persistence.*

@Entity
@Table(name = "questions")
data class Question (
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L,

    @Column(name = "question", length = 1000)
    val question: String,

    @Column(name = "answer_correct")
    val correctAnswer: String,

    @Column(name = "option1")
    val optionOne: String,

    @Column(name = "option2")
    val optionTwo: String,

    @Column(name = "option3")
    val optionThree: String,
)