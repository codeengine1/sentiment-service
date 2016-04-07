package com.davemaple.sentiment

import org.junit.Test

/**
 * @author <a href="mailto:d@davemaple.com">David Maple</a>
 */
class SentimentServiceTest {

    val service = SentinetService();

    @Test fun `Test Extract`() {
        println("good#a " + service.extract("good", "a"))
        println("bad#a " + service.extract("bad", "a"))
        println("blue#a " + service.extract("blue", "a"))
        println("blue#n " + service.extract("blue", "n"))
    }
}