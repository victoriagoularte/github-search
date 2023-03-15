package com.viclab.repository.usecase

import app.cash.turbine.test
import com.viclab.repository.MockResponse
import com.viclab.repository.repository.RepoRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

private const val ONCE = 1

internal class RepositoryListUseCaseTest {

    private val repository: RepoRepository = mockk()
    private val useCase = RepositoryListUseCase(repository)

    @Test
    fun `invoke should return RepositoryList from repository when returns success`() = runTest {
        // Given
        val expected = MockResponse.fakeRepositoryList()
        every { repository.repositories(any(), any(), any(), any()) } returns flowOf(expected)

        // When
        val result = useCase("kotlin", "stars", 1, 1)

        // Then
        result.test {
            verify(exactly = ONCE) { useCase(any(), any(), any(), any()) }
            assertEquals(expected, awaitItem())
            awaitComplete()
        }
    }

    @Test
    fun `invoke should throws exception from repository when returns error`() = runTest {
        // Given
        val error = Exception()
        every { repository.repositories(any(), any(), any(), any()) } returns flow { throw error }

        // When
        val result = useCase("kotlin", "stars", 1, 1)

        // Then
        result.test {
            verify(exactly = ONCE) { useCase(any(), any(), any(), any()) }
            awaitError()
        }
    }
}