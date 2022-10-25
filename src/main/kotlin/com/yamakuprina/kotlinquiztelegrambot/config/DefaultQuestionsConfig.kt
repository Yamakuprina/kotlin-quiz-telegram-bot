package com.yamakuprina.kotlinquiztelegrambot.config

import com.yamakuprina.kotlinquiztelegrambot.model.Question
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DefaultQuestionsConfig {
    @Bean
    fun defaultQuestions(): List<Question> {
        return listOf(
            Question(
                1L,
                "What’s the Target Platform of Kotlin?",
                "JVM",
                "JDK",
                "JDBC",
                "JPA"
            ),
            Question(
                2L,
                "How would you declare a String variable?",
                "val s: String = \"Hi\"",
            "String s = \"Hi\"",
            "s = \"Hi\"",
            "All options are wrong"
            ),
            Question(
                3L,
                "What’s the difference between val and var declaration?",
                "val variables cannot be changed, var can be reassigned",
                "val can be reassigned, var variables cannot be changed",
                "val can only access const variables",
                "there's no difference"
            ),
            Question(
                4L,
                "What option data class DOESNT offer?",
                "Auto-JSON conversion",
                "Generated copy() method",
                "Generated toString() method",
                "Generated equals() method"
            ),
            Question(
                5L,
                "Which of this targets Kotlin DOESNT support?",
                ".NET CLR",
                "JVM",
                "LLVM",
                "JavaScript"
            ),
            Question(
                6L,
                "What are Kotlin coroutines?",
                "Functions which provide asynchronous code without thread blocking",
                "Functions which accept other functions as arguments",
                "Another term for class methods",
                "Another term for equals() and hashCode() in data classes"
            ),
            Question(
                7L,
                "What is a correct syntax to output \"Hello World\" in Kotlin?",
                "println(\"Hello World\")",
                "System.Out.println(\"Hello World\")",
                "Console.println(\"Hello World\")",
                "cout <<\"Hello World\""
            ),
            Question(
                8L,
                "Which keyword is used to declare a function?",
                "fun",
                "function",
                "def",
                "define"
            ),
            Question(
                9L,
                "How do you insert COMMENTS in Kotlin code?",
                "//Comment",
                "/*Comment",
                "#Comment",
                "/Comment"
            ),
            Question(
                10L,
                "How can you create a variable with the numeric value 5?",
                "val num = 5",
                "num = 5 Int",
                "num = 5",
                "Int num = 5"
            ),
            Question(
                11L,
                "What is the output of the following code: println(5 > 3 && 5 < 10)",
                "true",
                "false",
                "5",
                "2"
            ),
            Question(
                12L,
                "To create an array in Kotlin, use: ",
                "arrayOf()",
                "[]",
                "{}",
                "None of these"
            ),
            Question(
                13L,
                "How can you create a range of numbers between 5 and 15 in Kotlin?",
                "for (x in 5..15)",
                "for (5..15)",
                "for (5 to 15)",
                "for (x in 5 to 15)"
            ),
            Question(
                14L,
                "What is the correct way to create an object called myObj of MyClass?",
                "val obj = MyClass()",
                "obj = MyClass.new()",
                "MyClass obj = new MyClass()",
                "MyClass(obj)"
            ),
            Question(
                15L,
                "What is the correct way to convert String \"42\" to a Long?",
                "val l: Long = \"42\".toLong()",
                "val l: Long = (Long)\"42\"",
                "val l: Long = Long.parseLong(\"42\")",
                "val l: Long = <Long>\"42\""
            ),
            Question(
                16L,
                "Does Kotlin provides primitive data types (int, long, float)?",
            "No, but compiler converts non-primitives to primitives for JVM if possible",
                "Yes, but Kotlin internally converts them to non-primitives",
                "No, Kotlin doesnt provide or use primitives",
                "Yes, Kotlin is similar to Java in this aspect"
            ),
            Question(
                17L,
                "What is the difference between String? and String data types?",
                "String can never become null",
                "String? is finalized",
                "String? is volatile as in Java",
                "String is finalized"
            ),
            Question(
                18L,
                "What does the !! operator do?",
                "It converts value to non-null type and throws exception if value is null",
                "It compares two values",
                "It's modulo operator similar to Java % operator",
                "It returns left operand if it's not null. Otherwise returns right operand"
            ),
            Question(
                19L,
                "What is the difference between Iterable<T> and Sequence<T>?",
                "Sequences processed lazily, Iterables eagerly",
                "Sequences processed eagerly, Iterables lazily",
                "Sequences processed sequentially. Iterables in parallel threads",
                "Iterables for the immutable collections, Sequences for the mutable"
            ),
            Question(
                20L,
                "What is Kotlin equivalent for static methods?",
                "Kotlin use companion objects",
                "Kotlin use @Static annotation",
                "Nothing, Kotlin use static method as well as Java",
                "Kotlin doesnt have any static-like functionality"
            )
        )
    }
}