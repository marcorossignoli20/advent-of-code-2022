package org.rossignoli

import java.io.File

class Utils {
    companion object{
        fun readFile(fileName: String): MutableList<String> {
            val lines: MutableList<String> = emptyList<String>().toMutableList()
            File(basePath + fileName).forEachLine { lines.add(it) }
            return lines
        }
    }
}