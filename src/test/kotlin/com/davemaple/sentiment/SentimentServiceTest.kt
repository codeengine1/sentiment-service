package com.davemaple.sentiment

import org.junit.Test

/**
 * @author <a href="mailto:d@davemaple.com">David Maple</a>
 */
class SentimentServiceTest {

    val service = SentinetService();

    @Test fun `Test Classify Words`() {
        println("awesome#a " + service.classify("awesome", "a"))
        println("crappy#a " + service.classify("crappy", "a"))
        println("well#a " + service.classify("well", "a"))
        println("well#n " + service.classify("well", "n"))
    }
}