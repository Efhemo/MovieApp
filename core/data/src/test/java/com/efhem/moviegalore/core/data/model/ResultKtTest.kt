package com.efhem.moviegalore.core.data.model

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Test

class ResultKtTest {

    @Test
    fun `result catches errors`() = runTest {
        flow {
            emit(1)
            throw Exception("Test Done")
        }
            .asResult()
            .test {
                assertThat(Result.Loading).isEqualTo(awaitItem())
                assertThat(Result.Success(1)).isEqualTo(awaitItem())

                when (val errorResult = awaitItem()) {
                    is Result.Error -> assertThat(
                        "Test Done"
                    ).isEqualTo(errorResult.exception?.message)
                    Result.Loading,
                    is Result.Success -> throw IllegalStateException(
                        "The flow should have emitted an Error Result"
                    )
                }

                awaitComplete()
            }
    }
}