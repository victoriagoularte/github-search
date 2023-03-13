package com.viclab.repository.datasource

import app.cash.turbine.test
import com.viclab.core.test.extension.dispatchRequest
import com.viclab.core.test.extension.startOn
import com.viclab.core.test.extension.with
import com.viclab.core.test.mockwebserver.MockWebServerTestRule
import com.viclab.repository.datasource.RepositoryRemoteDataSourceImpl
import com.viclab.repository.mock.MockResponse
import com.viclab.repository.remote.RepositoryService
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

private const val CODE_SUCCESS_RESPONSE = 200
private const val CODE_NOT_FOUND = 404
private const val PATH_SUCCESS_RESPONSE = "api-response/repository-success.json"

internal class RepositoryRemoteDataSourceImplTest {

    @get:Rule
    val mockWebServer = MockWebServerTestRule()

    private val service = mockWebServer.providesRetrofit().create(RepositoryService::class.java)
    private val dataSource = RepositoryRemoteDataSourceImpl(service)

    @Test
    fun `repositories should emit a ListRepositoryResponse flow when service returns success`() {
        // Given
        val expected = MockResponse.fakeRepositoryListResponse()
        dispatchRequest { CODE_SUCCESS_RESPONSE with PATH_SUCCESS_RESPONSE startOn mockWebServer.server }

        // when
        val result = dataSource.repositories("kotlin", "stars", 1, 1)

        // Then
        runBlocking {
            result.test {
                assertEquals(expected, awaitItem())
                awaitComplete()
            }
        }
    }

    @Test
    fun `repositories should emit a throwable when service returns error`() {
        // Given
        val errorResponseMessage = "HTTP 404 Client Error"
        dispatchRequest { CODE_NOT_FOUND with "" startOn mockWebServer.server }

        // when
        val result = dataSource.repositories("kotlin", "stars", 1, 1)

        // Then
        runBlocking {
            result.test {
                assertEquals(errorResponseMessage, awaitError().message)
            }
        }
    }
}