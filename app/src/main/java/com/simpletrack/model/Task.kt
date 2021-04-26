package com.simpletrack.model

import java.util.Date

class Task(x: Date = Date(0), y: Date = Date(0)) {
    var start: Date? = x
        private set
    var stop: Date? = y
        private set

    fun startTime() {
        if (start == null) {
            start = Date()
        }
    }

    /**
     * returns stopped time in milliseconds
     */
    fun stopTime(): Long {
        if (start == null || stop != null) {
            return -1
        }
        stop = Date()

        return stop!!.time - start!!.time
    }

    fun isStopped(): Boolean {
        return start != null && stop != null
    }

    fun running(): Boolean {
        return start != null && stop == null
    }
}
