package com.davemaple.sentiment

import org.junit.Test
import java.util.*

/**
 * @author <a href="mailto:d@davemaple.com">David Maple</a>
 */
class SentimentClassifierTest {

    val service = SentinetService();

    @Test fun `Test Classify Word`() {
        println("awesome#a " + service.classifyWord("awesome", "a"))
        println("crappy#a " + service.classifyWord("crappy", "a"))
        println("well#a " + service.classifyWord("well", "a"))
        println("well#n " + service.classifyWord("well", "n"))
    }

    @Test fun `Test Classify Phrase`() {
        val phrase = "I loved the tuna and scallops."
        val score = service.classifyPhrase(phrase)
        println(score)
    }

    @Test fun `Test Classify Negative Phrase`() {
        val phrase = "The food was aweful and the service was terrible."
        val score = service.classifyPhrase(phrase)
        println(score)
    }

    @Test fun `Test Classify Mildly Negative Phrase`() {
        val phrase = "this restaurant was good at sucking"
        val score = service.classifyPhrase(phrase)
        println(score)
    }

    @Test fun `Test Classify By Sentences`() {
        val longPhrase = "I hated the restaurant. The food was cold, the beef was old, and the service sucked. I will never go here again"
        val shortPhrase = "This place is terrible"

        println("long: ${service.classifySentences(longPhrase)}, short: ${service.classifySentences(shortPhrase)}")
    }
}