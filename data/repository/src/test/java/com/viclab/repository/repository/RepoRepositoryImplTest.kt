package com.viclab.repository.repository

import app.cash.turbine.test
import com.viclab.repository.datasource.RepositoryRemoteDataSource
import com.viclab.repository.mock.MockResponse
import com.viclab.repository.model.mapper.asRepositoryList
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

private const val ONCE = 1

internal class RepoRepositoryImplTest {

    private val dataSource: RepositoryRemoteDataSource = mockk()
    private val repository = RepoRepositoryImpl(dataSource)

    @Test
    fun `repositories should return repository list domain flow when RepositoryRemoteDataSource returns succeeded response`() = runTest {
        // Given
        val dataResponse = MockResponse.fakeRepositoryListResponse()
        val expected = dataResponse.asRepositoryList()

        every { dataSource.repositories(any(), any(), any(), any()) } returns flowOf(dataResponse)

        // When
        val result = repository.repositories("kotlin", "stars", 1, 1)

        // Then
         result.test {
             verify(exactly = ONCE) { dataSource.repositories(any(), any(), any(), any()) }
             assertEquals(expected, awaitItem())
             awaitComplete()
         }
    }

    @Test
    fun `repositories should return error flow when RepositoryRemoteDataSource returns error response`() =
        runTest {
            // Given
            val error = Exception()
            every { dataSource.repositories(any(), any(), any(), any()) } returns flow { throw error }

            // When
            val result = repository.repositories("kotlin", "stars", 1, 1)

            // Then
            result.test {
                verify(exactly = ONCE) { dataSource.repositories(any(), any(), any(), any()) }
                awaitError()
            }
        }
}