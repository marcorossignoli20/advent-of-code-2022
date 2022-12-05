package org.rossignoli

import org.rossignoli.Utils.Companion.readFile

class Day2 {
    companion object{

        /*
        * A = X = rock = 1
        * B = Y = paper = 2
        * C = Z = scissors = 3
        *
        * Win = 6
        * Draw = 3
        * Lose = 0
        *
        * paper > rock > scissors
        * scissor > paper
        */

        fun part1() {
            val plays = readFile("input2.txt")
            val rockPaperScissorMap = HashMap<String, Int>()
            rockPaperScissorMap["A"] = 1
            rockPaperScissorMap["X"] = 1
            rockPaperScissorMap["B"] = 2
            rockPaperScissorMap["Y"] = 2
            rockPaperScissorMap["C"] = 3
            rockPaperScissorMap["Z"] = 3

            var totalScore = 0
            plays.forEach { match ->
                val result = match.split(" ").map { rockPaperScissorMap[it] }
                totalScore += if (isDraw(result)) {
                    3 + result[1]!!
                } else if (isWin(result)) {
                    6 + result[1]!!
                } else {
                    result[1]!!
                }
            }

            print(totalScore)
        }


        private fun isDraw(result: List<Int?>) = result[1]!! == result[0]!!

        private fun isWin(result: List<Int?>) =
            (result[1]!! == 1 && result[0]!! == 3) || (result[1]!! == 2 && result[0]!! == 1) || (result[1]!! == 3 && result[0]!! == 2)

        fun part2() {
            val plays = readFile("input2.txt")
            val rockPaperScissorMap = HashMap<String, Int>()
            rockPaperScissorMap["A"] = 1
            rockPaperScissorMap["X"] = 1
            rockPaperScissorMap["B"] = 2
            rockPaperScissorMap["Y"] = 2
            rockPaperScissorMap["C"] = 3
            rockPaperScissorMap["Z"] = 3

            var totalScore = 0
            plays.forEach { match ->
                val result = match.split(" ").map { rockPaperScissorMap[it] }
                val play = result[0]
                val outcome = result[1]

                totalScore +=
                    when (outcome) {
                        2 -> {
                            3 + play!!
                        }

                        1 -> {
                            getMyPlay(play!!, outcome!!)
                        }

                        else -> {
                            6 + getMyPlay(play!!, outcome!!)
                        }
                    }
            }

            print(totalScore)
        }

        /*
        * A = rock = 1
        * B = paper = 2
        * C = scissors = 3
        *
        * X = Lose = 1
        * Y = Draw = 2
        * Z = Win = 3
        *
        * Win = 6
        * Draw = 3
        * Lose = 0
        *
        * paper > rock > scissors
        * scissor > paper
        */

        private fun getMyPlay(play: Int, outcome: Int): Int {
            var result: Int = 0
            when (play) {
                1 -> {
                    if (outcome == 1) {
                        result = 3
                    } else if (outcome == 3) {
                        result = 2
                    }
                }

                2 -> {
                    if (outcome == 1) {
                        result = 1
                    } else if (outcome == 3) {
                        result = 3
                    }
                }

                3 -> {
                    if (outcome == 1) {
                        result = 2
                    } else if (outcome == 3) {
                        result = 1
                    }
                }
            }
            return result
        }
    }
}