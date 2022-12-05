package org.rossignoli

import org.rossignoli.Utils.Companion.readFile

class Day3 {
    companion object {
        fun part1() {
            val alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
            val lines = readFile("input3.txt")
            var totalPriority = 0

            lines.forEach { line ->
                println(line)
                val firstHalf = line.substring(0, (line.length / 2))
                println(firstHalf)
                val secondHalf = line.substring(line.length / 2, line.length)
                println(secondHalf)
                run loop@{
                    firstHalf.forEach { char: Char ->
                        if (secondHalf.contains(char, ignoreCase = false)) {
                            totalPriority += alphabet.indexOf(char) + 1
                            return@loop
                        }
                    }
                }
            }
            println(totalPriority)
        }

        fun part2() {
            val alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
            val lines = readFile("input3.txt")
            var totalPriority = 0
            var currentLines = emptyList<String>().toMutableList()

            lines.groupBy {  }

            lines.forEachIndexed { i, line ->
                if(i != 0 && i.mod(3) == 0){
                    currentLines[0].forEach { char: Char ->
                        if(currentLines[1].contains(char) && currentLines[2].contains(char)){
                            totalPriority += alphabet.indexOf(char) + 1
                        }
                    }
                    currentLines = emptyList<String>().toMutableList()
                    currentLines.add(line)
                } else {
                    currentLines.add(line)
                }
            }
            println(totalPriority)
        }
    }
}