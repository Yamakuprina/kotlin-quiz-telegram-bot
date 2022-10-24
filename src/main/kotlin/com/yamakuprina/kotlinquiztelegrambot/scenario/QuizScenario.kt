package com.yamakuprina.kotlinquiztelegrambot.scenario

import com.justai.jaicf.builder.createModel
import com.justai.jaicf.model.scenario.Scenario
import com.justai.jaicf.reactions.toState
import com.justai.jaicf.reactions.buttons
import com.yamakuprina.kotlinquiztelegrambot.model.Question
import com.yamakuprina.kotlinquiztelegrambot.repository.QuestionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class QuizScenario(
    @Autowired
    val questionRepository: QuestionRepository
) : Scenario {
    var randomQuestions : MutableList<Question> = mutableListOf()
    var wrongAnswers : MutableMap<Question,String> = mutableMapOf()

    override val model = createModel {
        state("main") {
            activators {
                regex("/start")
            }

            action {
                reactions.run {
                    sayRandom("Hi!", "Hello there!","Greetings!")
                    say("Want to start quiz?")
                    buttons("quiz" toState "/main/quiz")
                }
            }

            state("quiz"){
                var score:Int = 0

                activators {
                    intent("quiz")
                }

                action {
                    randomQuestions = questionRepository.getRandomQuestions().toMutableList()
                    if(randomQuestions.size==0){
                        reactions.go("/errorFallback")
                    }
                    wrongAnswers = mutableMapOf()
                    score = 0
                    reactions.go("/main/quiz/question")
                }

                state("question"){
                    var question:Question? = null
                    var options : List<String> = listOf()

                    activators {
                        regex("/question")
                    }

                    action {
                        question = randomQuestions.removeLast()
                        options = mutableListOf(question!!.optionOne,question!!.optionTwo,question!!.optionThree,question!!.correctAnswer).shuffled()

                        var questionMessage : String = question!!.question + "\n"
                        for(i in 1..4){
                            questionMessage+="\n ${i}. ${options[i-1]}"
                        }
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

                    state("1"){
                        activators{
                            intent("1")
                        }
                        action {
                            if(options[0]==question!!.correctAnswer){
                                score+=1
                            } else {
                                wrongAnswers[question!!] = options[0]
                            }
                            if (randomQuestions.size==0){
                                reactions.go("/main/quiz/score")
                            } else {
                                reactions.go("/main/quiz/question")
                            }
                        }
                    }

                    state("2"){
                        activators{
                            intent("2")
                        }
                        action {
                            if(options[1]==question!!.correctAnswer){
                                score+=1
                            } else {
                                wrongAnswers[question!!] = options[1]
                            }
                            if (randomQuestions.size==0){
                                reactions.go("/main/quiz/score")
                            } else {
                                reactions.go("/main/quiz/question")
                            }
                        }
                    }

                    state("3"){
                        activators{
                            intent("3")
                        }
                        action {
                            if(options[2]==question!!.correctAnswer){
                                score+=1
                            } else {
                                wrongAnswers[question!!] = options[2]
                            }
                            if (randomQuestions.size==0){
                                reactions.go("/main/quiz/score")
                            } else {
                                reactions.go("/main/quiz/question")
                            }
                        }
                    }

                    state("4"){
                        activators{
                            intent("4")
                        }
                        action {
                            if(options[3]==question!!.correctAnswer){
                                score+=1
                            } else {
                                wrongAnswers[question!!] = options[3]
                            }
                            if (randomQuestions.size==0){
                                reactions.go("/main/quiz/score")
                            } else {
                                reactions.go("/main/quiz/question")
                            }
                        }
                    }
                }

                state("score"){
                    action {
                        reactions.run {
                            say("You finished test!")
                            say("Your score: $score out of 20")
                            if(wrongAnswers.isNotEmpty()){
                                reactions.buttons("Show wrong answers" toState "/main/quiz/score/wrongAnswers")
                            }
                        }
                    }

                    state("wrongAnswers"){
                        action{
                            for(entry in wrongAnswers){
                                reactions.run{
                                    val questionMessage1 = "Question:" + "\n"+
                                            entry.key.question + "\n\n"+
                                            "Correct answer:" +"\n"+
                                            entry.key.correctAnswer+"\n"+
                                            "Your answer:" +"\n"+
                                            entry.value
                                    say(questionMessage1)
                                }
                            }
                        }
                    }

                }
            }

        }
        state("errorFallback"){
            action{
                reactions.say("Something went wrong :( \nTry another time!")
            }
        }
    }
}