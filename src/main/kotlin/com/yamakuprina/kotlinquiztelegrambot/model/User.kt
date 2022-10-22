package com.yamakuprina.kotlinquiztelegrambot.model

import javax.persistence.*
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.Size

@Entity
@Table(name = "users")
data class User(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L,

    @Column(name = "name")
    @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
    val name: String = "",

    @Column(name = "score")
    @Min(value = 0, message = "Score can not be less than 0")
    @Max(value = 20, message = "Score can not be greater than 20")
    val score : Int,

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    val state : QuizState
)