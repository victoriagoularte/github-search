package com.viclab.repository.datasource

import com.viclab.core.test.extension.dispatchRequest
import com.viclab.core.test.extension.startOn
import com.viclab.core.test.extension.with
import com.viclab.core.test.mockwebserver.MockWebServerTestRule
import com.viclab.repository.datasource.remote.RepositoryRemoteDataSourceImpl
import com.viclab.repository.mock.MockResponse
import com.viclab.repository.remote.RepositoryService
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertThrows
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
    fun `repositories should return a correct ListRepositoryResponse when service returns success`() = runBlocking {
        // Given
        val expected = MockResponse.fakeRepositoryListResponse()
        dispatchRequest { CODE_SUCCESS_RESPONSE with PATH_SUCCESS_RESPONSE startOn mockWebServer.server }

        // when
        val result = dataSource.repositories("kotlin", "stars", 1, 10)

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `repositories should return a throwable when service returns error`() {
        // Given
        dispatchRequest { CODE_NOT_FOUND with "" startOn mockWebServer.server }

        // Then
        assertThrows(Throwable::class.java) {
            runBlocking {
                dataSource.repositories("kotlin", "stars", 1, 10)
            }
        }
    }
}