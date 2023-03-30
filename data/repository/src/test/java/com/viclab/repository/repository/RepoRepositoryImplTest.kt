package com.viclab.repository.repository

import com.viclab.repository.datasource.remote.RepositoryRemoteDataSource
import com.viclab.repository.mock.MockResponse
import com.viclab.repository.model.mapper.asRepository
import com.viclab.repository.model.response.RepositoryResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

internal class RepoRepositoryImplTest {

    private val dataSource: RepositoryRemoteDataSource = mockk()
    private val repository = RepositoryImpl(dataSource)

    @Test
    fun `repositories should return repository list domain when RepositoryRemoteDataSource returns succeeded response`() = runTest {
        // Given
        val dataResponse = MockResponse.fakeRepositoryListResponse()
        val expected = dataResponse.repositoryList.map(RepositoryResponse::asRepository)

        coEvery { dataSource.repositories(any(), any(), any(), any()) } returns dataResponse

        // When
        val result = repository.repositories("kotlin", "stars", 1, 1)

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `repositories should return error when RepositoryRemoteDataSource returns error response`() = runTest {
            // Given
            val error = Exception()
            coEvery { dataSource.repositories(any(), any(), any(), any()) } throws error

            // Then
            assertThrows(Throwable::class.java) {
                runBlocking {
                    repository.repositories("kotlin", "stars", 1, 1)
                }
            }
        }
}