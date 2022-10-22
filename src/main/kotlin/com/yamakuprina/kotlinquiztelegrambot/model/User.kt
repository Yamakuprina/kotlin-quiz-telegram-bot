package com.yamakuprina.kotlinquiztelegrambot.model

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L,

    @Column(name = "name", length = 200)
    val name: String = "",

    @Column(name = "score")
    val score : Int,

    @Column(name = "state")
    val state : QuizState
)