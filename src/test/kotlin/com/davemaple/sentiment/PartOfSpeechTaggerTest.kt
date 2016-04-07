package com.davemaple.sentiment

import org.junit.Test

/**
 * @author <a href="mailto:d@davemaple.com">David Maple</a>
 */
class PartOfSpeechTaggerTest {
    val tagger = PartOfSpeechTagger()
    val phrase = "I like to swim in the pond. It's still cold this time of year."

    @Test fun `Test Tag As String`() {
        val taggedString = tagger.tagAsString(phrase)
        println(taggedString)
    }

    @Test fun `Test Tag Phrase`() {
        val taggedWords = tagger.tag(phrase)

        for (taggedWord in taggedWords) {
            println("${taggedWord.value()}: ${taggedWord.tag()}")
        }
    }
}