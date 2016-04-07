package com.davemaple.sentiment

import org.junit.Test

/**
 * @author <a href="mailto:d@davemaple.com">David Maple</a>
 */
class SentimentClassifierTest {

    val service = SentinetService();

    @Test fun `Test Classify Words`() {
        println("awesome#a " + service.score("awesome", "a"))
        println("crappy#a " + service.score("crappy", "a"))
        println("well#a " + service.score("well", "a"))
        println("well#n " + service.score("well", "n"))
    }

    @Test fun `Test Classify Phrase`() {
        val phrase = "I loved the tuna and scallops."
        val score = service.score(phrase)
        println(score)
    }

    @Test fun `Test Classify Negative Phrase`() {
        val phrase = "The food was aweful and the service was terrible."
        val score = service.score(phrase)
        println(score)
    }

    @Test fun `Test Classify Mildly Negative Phrase`() {
        val phrase = "The food was terrible but the service was ok."
        val score = service.score(phrase)
        println(score)
    }
}