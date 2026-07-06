package com.miko.app.voice

import java.util.LinkedList
import java.util.Queue

object ReplyQueue {

    private val queue: Queue<String> = LinkedList()

    fun add(reply: String) {

        queue.add(reply)

    }

    fun next(): String? {

        return if (queue.isEmpty()) {

            null

        } else {

            queue.poll()

        }

    }

    fun clear() {

        queue.clear()

    }

    fun hasReply(): Boolean {

        return queue.isNotEmpty()

    }

}
