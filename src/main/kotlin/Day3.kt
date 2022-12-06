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
            var c = 0

            lines.forEach { line ->
                c++
                currentLines.add(line)
                if(c.mod(3) == 0){
                    currentLines[0].forEach { char: Char ->
                        if(currentLines[1].contains(char, ignoreCase = false) && currentLines[2].contains(char, ignoreCase = false)){
                            totalPriority += alphabet.indexOf(char)+1
                            println("$currentLines \n$char \n${alphabet.indexOf(char)+1}")
                        }
                    }
                    currentLines = emptyList<String>().toMutableList()
                }
            }
            println(totalPriority)
        }
    }
}