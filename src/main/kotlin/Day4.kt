package org.rossignoli

import org.rossignoli.Utils.Companion.readFile

class Day4 {
    companion object {
        fun part1() {
            val lines = readFile("input4.txt")
            val pairs = lines.map { Pair(it.split(",")[0], it.split(",")[1]) }
            var total = 0

            pairs.forEach {
                if (isOneContained(it.first, it.second)) {
                    println(it)
                    total++
                }
            }
            println(total)
        }

        private fun isOneContained(first: String, second: String): Boolean {
            val firstRange = Pair(first.split("-")[0].toInt(), first.split("-")[1].toInt())
            val secondRange = Pair(second.split("-")[0].toInt(), second.split("-")[1].toInt())

            return (firstRange.first >= secondRange.first && firstRange.second <= secondRange.second)
                    || (secondRange.first >= firstRange.first && secondRange.second <= firstRange.second)
                    || (firstRange.first < secondRange.first && firstRange.second >= secondRange.first)
                    || (secondRange.first < firstRange.first && secondRange.second >= firstRange.first)
        }
    }
}