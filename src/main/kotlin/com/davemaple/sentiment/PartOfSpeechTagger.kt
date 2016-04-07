package com.davemaple.sentiment

import edu.stanford.nlp.tagger.maxent.MaxentTagger

/**
 * @author <a href="mailto:d@davemaple.com">David Maple</a>
 */
class PartOfSpeechTagger {
    fun tag(phrase: String): String {
        val tagger = MaxentTagger("models/english-left3words-distsim.tagger");
        return tagger.tagString(phrase)
    }
}