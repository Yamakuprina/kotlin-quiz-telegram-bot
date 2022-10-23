package com.yamakuprina.kotlinquiztelegrambot.scenario

import com.justai.jaicf.builder.createModel
import com.justai.jaicf.model.scenario.Scenario
import org.springframework.stereotype.Component

@Component
class QuizScenario : Scenario {
    override val model = createModel {
        state("main") {
            activators {
                regex("/start")
            }

            action {
                reactions.run {
                    sayRandom("Hi!", "Hello there!")
                    say("What is your name?")
                }
            }

            state("name"){
                activators {
                    catchAll()
                }

                action {
                    context.client["name"] = request.input
                    reactions.say("Nice to meet you ${context.client["name"]}")
                }
            }

        }

    }
}