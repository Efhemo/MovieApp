package com.efhem.moviegalore.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*


class ExampleUnitTest {
    suspend fun fetchData(): String {
        delay(1000L)
        return "Hello world"
    }

    fun doSomething(): Flow<Int> = flow {
        var i = 0
        while (true) {
            emit(i++)
            delay(5000L)
        }
    }

    @Test
    fun testFlow() = runTest {
        val result = doSomething().take(3).toList()

        assertEquals(listOf(0, 1, 2), result)
    }

    @Test
    fun dataShouldBeHelloWorld() = runTest {
        val data = fetchData()
        assertEquals("Hello world", data)
    }

}