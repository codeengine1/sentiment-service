package com.davemaple.sentiment

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Particle

/**
 * @author <a href="mailto:d@davemaple.com">David Maple</a>
 */
data class PartOfSpeech(val pennTreeTag: String, val desc: String, val wordnetTag: String) {
    companion object {
        val COORDINATING_CONJUNCTION = PartOfSpeech("CC", "Coordinating conjunction", "")
        val CARDINAL_NUMBER = PartOfSpeech("CD", "Cardinal number", "")
        val DETERMINER = PartOfSpeech("DT", "Determiner", "")
        val EXISTENTIAL_THERE = PartOfSpeech("EX", "Existential there", "")
        val FOREIGN_WORD = PartOfSpeech("FW", "Foreign word", "")
        val PREPOSITION_OR_SUBORDINATING_CONJUNCTION = PartOfSpeech("IN", "Preposition or subordinating conjunction", "")
        val ADJECTIVE = PartOfSpeech("JJ", "Adjective", "a")
        val ADJECTIVE_COMPARTIVE = PartOfSpeech("JJR", "Adjective, comparative", "a")
        val ADJECTIVE_SUPERLATIVE = PartOfSpeech("JJS", "Adjective, superlative", "a")
        val LIST_ITEM_MARKER = PartOfSpeech("LS", "List item marker", "")
        val MODAL = PartOfSpeech("MD", "Modal", "")
        val NOUN_SINGULAR_OR_MASS = PartOfSpeech("NN", "Noun, singular or mass", "n")
        val NOUN_PLURAL = PartOfSpeech("NNS", "Noun, plural", "n")
        val PROPER_NOUN_SINGULAR = PartOfSpeech("NNP", "Proper noun, singular", "n")
        val PROPER_NOUN_PLURAL = PartOfSpeech("NNPS", "Proper noun, plural", "n")
        val PREDETERMINER = PartOfSpeech("PDT", "Predeterminer", "")
        val POSSESSIVE_ENDING = PartOfSpeech("POS", "Possessive ending", "")
        val PERSONAL_PRONOUN = PartOfSpeech("PRP", "Personal pronoun", "")
        val POSSESSIVE_PRONOUN = PartOfSpeech("PRP$", "Possessive pronoun", "")
        val ADVERB = PartOfSpeech("RB", "Adverb", "r")
        val ADVERB_COMPARATIVE = PartOfSpeech("RBR", "Adverb, comparative", "r")
        val ADVERB_SUPERLATIVE = PartOfSpeech("RBS", "Adverb, superlative", "r")
        val PARTICLE = PartOfSpeech("RP", "Particle", "")
        val SYMBOL = PartOfSpeech("SYM", "Symbol", "")
        val TO = PartOfSpeech("TO", "to", "")
        val INTERJECTION = PartOfSpeech("UH", "Interjection", "")
        val VERB = PartOfSpeech("VB", "Verb, base form", "v")
        val VERB_PAST_TENSE = PartOfSpeech("VBD", "Verb, past tense", "v")
        val GERUND_OR_PRESENT_PARTICIPLE = PartOfSpeech("VBG", "Verb, gerund or present participle", "v")
        val VERB_PAST_PARTICIPLE = PartOfSpeech("VBN", "Verb, past participle", "v")
        val VERB_NON_3RD_PERSON_SINGULAR_PRESENT = PartOfSpeech("VBP", "Verb, non-3rd person singular present", "v")
        val VERB_3RD_PERSON_SINGULAR_PRESENT = PartOfSpeech("VBZ", "Verb, 3rd person singular present", "v")
        val WH_DETERMINER = PartOfSpeech("WDT", "Wh-determiner", "")
        val WH_PRONOUN = PartOfSpeech("WP", "Wh-pronoun", "")
        val POSSESSIVE_WH_PRONOUN = PartOfSpeech("WP$", "Possessive wh-pronoun", "")
        val WH_ADVERB = PartOfSpeech("WRB", "Wh-adverb", "r")

        val PENN_TAG_MAP = mapOf<String, PartOfSpeech>(
                COORDINATING_CONJUNCTION.pennTreeTag to COORDINATING_CONJUNCTION,
                CARDINAL_NUMBER.pennTreeTag to CARDINAL_NUMBER,
                DETERMINER.pennTreeTag to DETERMINER,
                EXISTENTIAL_THERE.pennTreeTag to EXISTENTIAL_THERE,
                FOREIGN_WORD.pennTreeTag to FOREIGN_WORD,
                PREPOSITION_OR_SUBORDINATING_CONJUNCTION.pennTreeTag to PREPOSITION_OR_SUBORDINATING_CONJUNCTION,
                ADJECTIVE.pennTreeTag to ADJECTIVE,
                ADJECTIVE_COMPARTIVE.pennTreeTag to ADJECTIVE_COMPARTIVE,
                ADJECTIVE_SUPERLATIVE.pennTreeTag to ADJECTIVE_SUPERLATIVE,
                LIST_ITEM_MARKER.pennTreeTag to LIST_ITEM_MARKER,
                MODAL.pennTreeTag to MODAL,
                NOUN_SINGULAR_OR_MASS.pennTreeTag to NOUN_SINGULAR_OR_MASS,
                NOUN_PLURAL.pennTreeTag to NOUN_PLURAL,
                PROPER_NOUN_SINGULAR.pennTreeTag to PROPER_NOUN_SINGULAR,
                PROPER_NOUN_PLURAL.pennTreeTag to PROPER_NOUN_PLURAL,
                PREDETERMINER.pennTreeTag to PREDETERMINER,
                POSSESSIVE_ENDING.pennTreeTag to POSSESSIVE_ENDING,
                PERSONAL_PRONOUN.pennTreeTag to PERSONAL_PRONOUN,
                POSSESSIVE_PRONOUN.pennTreeTag to POSSESSIVE_PRONOUN,
                ADVERB.pennTreeTag to ADVERB,
                ADVERB_COMPARATIVE.pennTreeTag to ADVERB_COMPARATIVE,
                ADVERB_SUPERLATIVE.pennTreeTag to ADVERB_SUPERLATIVE,
                PARTICLE.pennTreeTag to PARTICLE,
                SYMBOL.pennTreeTag to SYMBOL,
                TO.pennTreeTag to TO,
                INTERJECTION.pennTreeTag to INTERJECTION,
                VERB.pennTreeTag to VERB,
                VERB_PAST_TENSE.pennTreeTag to VERB_PAST_TENSE,
                GERUND_OR_PRESENT_PARTICIPLE.pennTreeTag to GERUND_OR_PRESENT_PARTICIPLE,
                VERB_PAST_PARTICIPLE.pennTreeTag to VERB_PAST_PARTICIPLE,
                VERB_NON_3RD_PERSON_SINGULAR_PRESENT.pennTreeTag to VERB_NON_3RD_PERSON_SINGULAR_PRESENT,
                VERB_3RD_PERSON_SINGULAR_PRESENT.pennTreeTag to VERB_3RD_PERSON_SINGULAR_PRESENT,
                WH_DETERMINER.pennTreeTag to WH_DETERMINER,
                WH_PRONOUN.pennTreeTag to WH_PRONOUN,
                POSSESSIVE_WH_PRONOUN.pennTreeTag to POSSESSIVE_WH_PRONOUN,
                WH_ADVERB.pennTreeTag to WH_ADVERB
        )

        /**
         * @param pennTag
         * @return sentiTag
         */
        fun pennToSentiPOS(pennTag: String): String {
            if (!PENN_TAG_MAP.containsKey(pennTag)) {
                return ""
            }

            return PENN_TAG_MAP.get(pennTag)!!.wordnetTag
        }
    }
}