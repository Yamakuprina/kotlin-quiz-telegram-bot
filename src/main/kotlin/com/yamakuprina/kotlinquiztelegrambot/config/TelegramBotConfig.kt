package com.yamakuprina.kotlinquiztelegrambot.config

import com.justai.jaicf.BotEngine
import com.justai.jaicf.activator.regex.RegexActivator
import com.justai.jaicf.api.BotApi
import com.justai.jaicf.channel.telegram.TelegramChannel
import com.justai.jaicf.model.scenario.Scenario
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TelegramBotConfig(

    @Value("5770927943:AAEhtHnyBM8azDuKSNZLwXtThUGnclqR24s")
    val telegramBotToken: String
) {

    @Bean
    fun botApi(scenario: Scenario): BotApi {
        return BotEngine(
            scenario = scenario,
            activators = arrayOf(
                RegexActivator
            )
        )
    }

    @Bean
    fun telegramChannel(bot: BotApi): TelegramChannel {
        val telegramChannel = TelegramChannel(bot, telegramBotToken)
        telegramChannel.run()
        return telegramChannel
    }
}