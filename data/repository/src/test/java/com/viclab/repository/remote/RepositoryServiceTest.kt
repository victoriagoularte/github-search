package com.viclab.repository.remote

import com.viclab.core.test.extension.dispatchRequest
import com.viclab.core.test.extension.startOn
import com.viclab.core.test.extension.with
import com.viclab.core.test.mockwebserver.MockWebServerTestRule
import com.viclab.repository.MockResponse
import com.viclab.repository.model.response.RepositoryListResponse
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import okhttp3.Response
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

private const val CODE_SUCCESS_RESPONSE = 200
private const val PATH_SUCCESS_RESPONSE = "api-response/repository-success.json"

class RepositoryServiceTest {

    @get:Rule
    val mockWebServer = MockWebServerTestRule()

    private val service = mockWebServer.providesRetrofit().create(RepositoryService::class.java)

    @Test
    fun `repositories should return a ListRepositoryResponse when returns success`() = runTest {
        // Given
        val expected = MockResponse.fakeRepositoryListResponse()
        dispatchRequest { CODE_SUCCESS_RESPONSE with PATH_SUCCESS_RESPONSE startOn mockWebServer.server }

        // When
        val result = service.repositories("kotlin", "stars", 1, 1)

        // Then
        assertEquals(expected, result)
    }
}