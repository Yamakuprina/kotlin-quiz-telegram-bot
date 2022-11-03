package com.yamakuprina.kotlinquiztelegrambot.config

import com.justai.jaicf.BotEngine
import com.justai.jaicf.activator.regex.RegexActivator
import com.justai.jaicf.api.BotApi
import com.justai.jaicf.channel.telegram.TelegramChannel
import com.justai.jaicf.model.scenario.Scenario
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@PropertySource("classpath:bot.properties")
class TelegramBotConfig(

    @Value("\${bot.telegramBotToken}")
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
    fun telegramChannel(bot: BotApi) : ApplicationRunner{
        return ApplicationRunner {
                args -> TelegramChannel(bot, telegramBotToken).run()
        }
    }
}