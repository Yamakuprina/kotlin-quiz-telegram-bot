package com.yamakuprina.kotlinquiztelegrambot.scenario

import com.justai.jaicf.builder.createModel
import com.justai.jaicf.model.scenario.Scenario
import com.justai.jaicf.reactions.buttons
import com.justai.jaicf.reactions.toState
import com.yamakuprina.kotlinquiztelegrambot.model.Question
import com.yamakuprina.kotlinquiztelegrambot.repository.QuestionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class QuizScenario(
    @Autowired
    val questionRepository: QuestionRepository,
    @Autowired
    val defaultQuestions: List<Question>
) : Scenario {
    //var randomQuestions: MutableList<Question> = mutableListOf()
    //var wrongAnswers: MutableMap<Question, String> = mutableMapOf()

    override val model = createModel {
        state("main") {
            activators {
                regex("/start")
            }

            action {
                reactions.run {
                    sayRandom("Hi!", "Hello there!", "Greetings!")
                    say("Want to start quiz?")
                    buttons("quiz" toState "/main/quiz")
                }
            }

            state("quiz") {
                //var score: Int = 0

                activators {
                    intent("quiz")
                }

                action {
                    context.session["randomQuestions"]=questionRepository.getRandomQuestions().toMutableList()
                    //randomQuestions = questionRepository.getRandomQuestions().toMutableList()
                    if ((context.session["randomQuestions"] as MutableList<*>).size < 20){
                        context.session["randomQuestions"] = defaultQuestions.shuffled().toMutableList()
                    }
                    if ((context.session["randomQuestions"] as MutableList<*>).size == 0) {
                        reactions.go("/errorFallback")
                    }
                    context.session["wrongAnswers"] = mutableMapOf<Question, String>()
                    //wrongAnswers = mutableMapOf()
                    //score = 0
                    context.session["questionNumber"] = 0
                    context.session["score"] = 0
                    reactions.go("/main/quiz/question")
                }

                state("question") {
                    //var question: Question? = null
                    //var options: List<String> = listOf()


                    activators {
                        regex("/question")
                    }

                    action {
                        context.session["question"] = (context.session["randomQuestions"] as MutableList<*>).removeLast() as Question
                        //question = (context.session["randomQuestions"] as MutableList<*>).removeLast() as Question?
                        context.session["options"] = mutableListOf(
                            (context.session["question"] as Question).optionOne,
                            (context.session["question"] as Question).optionTwo,
                            (context.session["question"] as Question).optionThree,
                            (context.session["question"] as Question).correctAnswer
                        ).shuffled()
//                        options = mutableListOf(
//                            question!!.optionOne,
//                            question!!.optionTwo,
//                            question!!.optionThree,
//                            question!!.correctAnswer
//                        ).shuffled()
                        context.session.compute("questionNumber") { _, v -> v as Int + 1}
                        val questionMessage: String ="Question "+ (context.session["questionNumber"] as Int) + " of 20"+"\n\n"+
                            (context.session["question"] as Question).question + "\n" +
                                "\n1. ${(context.session["options"] as MutableList<*>)[0]}" +
                                "\n2. ${(context.session["options"] as MutableList<*>)[1]}" +
                                "\n3. ${(context.session["options"] as MutableList<*>)[2]}" +
                                "\n4. ${(context.session["options"] as MutableList<*>)[3]}"
                        reactions.run {
                            say(questionMessage)
                            buttons(
                                "1" toState "/main/quiz/question/1",
                                "2" toState "/main/quiz/question/2",
                                "3" toState "/main/quiz/question/3",
                                "4" toState "/main/quiz/question/4"
                            )
                        }
                    }

                    state("1") {
                        activators {
                            intent("1")
                        }
                        action {
                            if ((context.session["options"] as MutableList<*>)[0] == (context.session["question"] as Question).correctAnswer) {
                                context.session.compute("score") { _, v -> v as Int + 1}
                                //score += 1
                            } else {
                                (context.session["wrongAnswers"] as MutableMap<Question, String>)[(context.session["question"] as Question)]=(context.session["options"] as MutableList<*>)[0] as String
                                //wrongAnswers[question!!] = options[0]
                            }
                            if ((context.session["randomQuestions"] as MutableList<*>).size == 0) {
                                reactions.go("/main/quiz/score")
                            } else {
                                reactions.go("/main/quiz/question")
                            }
                        }
                    }

                    state("2") {
                        activators {
                            intent("2")
                        }
                        action {
                            if ((context.session["options"] as MutableList<*>)[1] == (context.session["question"] as Question).correctAnswer) {
                                context.session.compute("score") { _, v -> v as Int + 1}
                                //score += 1
                            } else {
                                (context.session["wrongAnswers"] as MutableMap<Question, String>)[(context.session["question"] as Question)]=(context.session["options"] as MutableList<*>)[1] as String
                                //wrongAnswers[question!!] = options[1]
                            }
                            if ((context.session["randomQuestions"] as MutableList<*>).size == 0) {
                                reactions.go("/main/quiz/score")
                            } else {
                                reactions.go("/main/quiz/question")
                            }
                        }
                    }

                    state("3") {
                        activators {
                            intent("3")
                        }
                        action {
                            if ((context.session["options"] as MutableList<*>)[2] == (context.session["question"] as Question).correctAnswer) {
                                context.session.compute("score") { _, v -> v as Int + 1}
                                //score += 1
                            } else {
                                (context.session["wrongAnswers"] as MutableMap<Question, String>)[(context.session["question"] as Question)]=(context.session["options"] as MutableList<*>)[2] as String
                                //wrongAnswers[question!!] = options[2]
                            }
                            if ((context.session["randomQuestions"] as MutableList<*>).size == 0) {
                                reactions.go("/main/quiz/score")
                            } else {
                                reactions.go("/main/quiz/question")
                            }
                        }
                    }

                    state("4") {
                        activators {
                            intent("4")
                        }
                        action {
                            if ((context.session["options"] as MutableList<*>)[3] == (context.session["question"] as Question).correctAnswer) {
                                context.session.compute("score") { _, v -> v as Int + 1}
                                //score += 1
                            } else {
                                (context.session["wrongAnswers"] as MutableMap<Question, String>)[(context.session["question"] as Question)]=(context.session["options"] as MutableList<*>)[3] as String
                                //wrongAnswers[question!!] = options[3]
                            }
                            if ((context.session["randomQuestions"] as MutableList<*>).size == 0) {
                                reactions.go("/main/quiz/score")
                            } else {
                                reactions.go("/main/quiz/question")
                            }
                        }
                    }
                }

                state("score") {
                    action {
                        reactions.run {
                            say("You finished test!")
                            say("Your score: ${context.session["score"]} out of 20")
                            if ((context.session["wrongAnswers"] as MutableMap<*, *>).isNotEmpty()) {
                                reactions.buttons("Show wrong answers" toState "/main/quiz/score/wrongAnswers")
                            }
                        }
                    }

                    state("wrongAnswers") {
                        action {
                            for (entry in (context.session["wrongAnswers"] as MutableMap<Question, String>)) {
                                reactions.run {
                                    val questionMessage1 = "Question:" + "\n" +
                                            entry.key.question + "\n\n" +
                                            "Correct answer:" + "\n" +
                                            entry.key.correctAnswer + "\n\n" +
                                            "Your answer:" + "\n" +
                                            entry.value
                                    say(questionMessage1)
                                }
                            }
                        }
                    }

                }
            }

        }
        state("errorFallback") {
            action {
                reactions.say("Something went wrong :( \nTry another time!")
            }
        }
    }
}