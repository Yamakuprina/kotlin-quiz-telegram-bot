package com.yamakuprina.kotlinquiztelegrambot.bot

import com.justai.jaicf.BotEngine
import com.justai.jaicf.activator.regex.RegexActivator
import com.justai.jaicf.model.scenario.Scenario
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class QuizBot(
    @Autowired
    val scenario: Scenario
) : BotEngine(
    scenario = scenario,
    activators = arrayOf(
        RegexActivator
    )
)
