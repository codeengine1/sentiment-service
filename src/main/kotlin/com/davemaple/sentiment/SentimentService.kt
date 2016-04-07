package com.davemaple.sentiment


import org.slf4j.LoggerFactory
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * @author <a href="mailto:d@davemaple.com">David Maple</a>
 */
class SentinetService {

    private val dictionary: MutableMap<String, Double>
    private val logger = LoggerFactory.getLogger(SentinetService::class.java)

    init {
        dictionary = mutableMapOf()
        val tempDictionary: MutableMap<String, HashMap<Int, Double>> = mutableMapOf()

        var sentiwordnet: BufferedReader = BufferedReader(InputStreamReader(
                this.javaClass.classLoader.getResourceAsStream("sentiwordnet.txt"), "UTF-8"))
        var lineNumber = 0

        for (line in sentiwordnet.lineSequence()) {
            lineNumber++

            if (!line.trim { it <= ' ' }.startsWith("#")) {
                val data = line.split("\t".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                val wordTypeMarker = data[0]

                if (data.size != 6) {
                    logger.error("Incorrect format in sentiwordnet, line: " + lineNumber)
                    continue
                }

                val synsetScore = java.lang.Double.parseDouble(data[2]) - java.lang.Double.parseDouble(data[3])
                val synTermsSplit = data[4].split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

                for (synTermSplit in synTermsSplit) {
                    val synTermAndRank = synTermSplit.split("#".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                    val synTerm = synTermAndRank[0] + "#" + wordTypeMarker
                    val synTermRank = Integer.parseInt(synTermAndRank[1])

                    if (!tempDictionary.containsKey(synTerm)) {
                        tempDictionary.put(synTerm, HashMap<Int, Double>())
                    }

                    tempDictionary[synTerm]?.put(synTermRank, synsetScore)
                }
            }
        }

        for ((word, synSetScoreMap) in tempDictionary) {

            var score = 0.0
            var sum = 0.0

            for (setScore in synSetScoreMap.entries) {
                score += setScore.value / setScore.key
                sum += 1.0 / setScore.key
            }

            score /= sum
            dictionary.put(word, score)
        }
    }

    /**
     * @param word
     * @param partOfSpeech
     * @return score
     */
    fun classify(word: String, partOfSpeech: String): Double? {
        return dictionary[word + "#" + partOfSpeech]
    }
}