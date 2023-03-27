package com.viclab.repository.usecase

import com.viclab.repository.MockResult
import com.viclab.repository.repository.RepoRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertThrows
import org.junit.Test
import kotlin.test.assertEquals

private const val ONCE = 1

internal class RepositoryListUseCaseTest {

    private val repository: RepoRepository = mockk()
    private val useCase = RepositoryListUseCase(repository)

    @Test
    fun `invoke should return RepositoryList from repository when returns success`() = runTest {
        // Given
        val expected = MockResult.fakeRepositoryList().repositoryList
        coEvery { repository.repositories(any(), any(), any(), any()) } returns expected

        // When
        val result = useCase("kotlin", "stars", 1, 10)

        // Then
        assertEquals(expected, result)

    }

    @Test
    fun `invoke should throws exception from repository when returns error`() = runTest {
        // Given
        val error = Throwable()
        coEvery { repository.repositories(any(), any(), any(), any()) } throws error


        // Then
        assertThrows(Throwable::class.java) {
            runBlocking {
                useCase("kotlin", "stars", 1, 10)
            }
        }
    }
}