package ru.com.bulat.courutineflowsoumin.lessons.Lesson_14

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

suspend fun main(){
    val scope = CoroutineScope(Dispatchers.Default)

    var flow = MutableStateFlow(0)

    val producer = scope.launch {
        delay(500)
        repeat(10){
            println("Emitted: $it")
            flow.emit(it)
            println("After emitted: $it")
            delay(200)
        }
    }

    val consumer = scope.launch {
        flow.collect(){
            println("Collected: $it")
            delay(1000)
        }
    }

    producer.join()
    consumer.join()
}