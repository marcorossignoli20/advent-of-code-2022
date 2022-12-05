package org.rossignoli

import org.rossignoli.Utils.Companion.readFile

class Day1 {
    companion object {

        fun part1() {
            val fileLines = readFile("input1.txt")
            var max = 0
            var sum = 0
            fileLines.forEach {
                if (it.isNullOrEmpty()) {
                    if (sum > max) {
                        max = sum
                    }
                    sum = 0
                } else {
                    sum += it.toInt()
                }
            }

            print(max)
        }

        fun part2() {
            val fileLines = readFile("input1.txt")
            var max = emptyList<Int>().toMutableList()
            var sum = 0
            fileLines.forEach { line ->
                if (line.isNullOrEmpty()) {
                    max.add(sum)
                    sum = 0
                } else {
                    sum += line.toInt()
                }
            }
            max.sort()

            print(max[max.size - 1] + max[max.size - 2] + max[max.size - 3])
        }
    }
}