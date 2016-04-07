package com.davemaple.sentiment

import org.junit.Test

/**
 * @author <a href="mailto:d@davemaple.com">David Maple</a>
 */
class PartOfSpeechTaggerTest {
    val tagger = PartOfSpeechTagger()

    @Test fun `Test Tag Phrase`() {
        val phrase = "I like to swim in the pond."
        val tagged = tagger.tag(phrase)
        println(tagged)
    }
}