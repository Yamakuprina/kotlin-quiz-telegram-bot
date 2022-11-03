package com.yamakuprina.kotlinquiztelegrambot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan("com.yamakuprina.kotlinquiztelegrambot.config")
class KotlinQuizTelegramBotApplication

fun main(args: Array<String>) {
    runApplication<KotlinQuizTelegramBotApplication>(*args)
}
