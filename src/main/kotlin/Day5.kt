package org.rossignoli

import org.rossignoli.Utils.Companion.readFile

class Day5 {
    companion object {
        private val stackLines = readFile("input5_stack.txt")
        private val instructionsLine = readFile("input5_instructions.txt")
        private val stacksMap = HashMap<Int, ArrayDeque<Char>>()
        private val regex = "^\\w+\\s*(\\d+)\\s*\\w+\\s*(\\d+)\\s*\\w+\\s*(\\d+)".toRegex()

        fun part1() {
            stackLines.forEachIndexed { i, line ->
                val stack = ArrayDeque<Char>()
                line.forEach { char: Char -> stack.addLast(char) }
                stacksMap[i + 1] = stack
            }

            instructionsLine.forEach { instruction ->
                val result = regex.find(instruction)
                val (n, source, destination) = result!!.destructured
                moveCrates(n.toInt(), source.toInt(), destination.toInt())
            }

            println(stacksMap)

            stacksMap.entries.forEach { mutableEntry ->
                println(mutableEntry.value)
            }
        }

        private fun moveCrates(n: Int, source: Int, destination: Int) {
            val sourceStack = stacksMap[source]!!
            val destinationStack = stacksMap[destination]!!
            for (i in 1..n) {
                val curr = sourceStack.removeLast()
                destinationStack.addLast(curr)
            }
        }
    }
}