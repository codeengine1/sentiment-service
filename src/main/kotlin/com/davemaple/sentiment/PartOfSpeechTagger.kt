package com.davemaple.sentiment

import edu.stanford.nlp.ling.TaggedWord
import edu.stanford.nlp.process.PTBTokenizer
import edu.stanford.nlp.tagger.maxent.MaxentTagger
import edu.stanford.nlp.tagger.maxent.TaggerConfig
import java.io.StringReader
import java.util.*

/**
 * @author <a href="mailto:d@davemaple.com">David Maple</a>
 */
class PartOfSpeechTagger {
    val tokenizer = PTBTokenizer.PTBTokenizerFactory.newWordTokenizerFactory("");
    val config: TaggerConfig
    val tagger: MaxentTagger

    init {
        val properties = Properties()
        properties.put("model", "models/english-left3words-distsim.tagger")
        properties.put("outputFormatOptions", "lemmatize")
        config = TaggerConfig(properties)
        tagger = MaxentTagger(config);
    }

    /**
     * @param phrase
     * @return taggedWords
     */
    fun tag(phrase: String): Sequence<TaggedWord> {
        val tokenizedSentences = MaxentTagger.tokenizeText(StringReader(phrase), tokenizer)
        val taggedWords: MutableList<TaggedWord> = mutableListOf()

        for (sentence in tokenizedSentences) {
            taggedWords.addAll(tagger.tagSentence(sentence))
        }

        return taggedWords.asSequence()
    }

    /**
     * @param phrase
     * @return taggedWords
     */
    fun tagAsString(phrase: String): String {
        return tagger.tagString(phrase)
    }
}