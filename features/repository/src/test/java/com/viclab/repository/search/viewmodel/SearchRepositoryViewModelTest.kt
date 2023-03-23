package com.viclab.repository.search.viewmodel

import com.viclab.repository.search.RepositoriesPagingSource
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Test

internal class SearchRepositoryViewModelTest {

    private val repositoriesPagingSource : RepositoriesPagingSource = mockk()
    private val viewModel = SearchRepositoryViewModel(repositoriesPagingSource, UnconfinedTestDispatcher())

    @Test
    fun testPagerConfiguration() = runBlocking {
        // Given
        val expectedLanguage = "kotlin"
        val expectedSort = "stars"

        // When
        viewModel.repositories()

        // Then
        verify {
            repositoriesPagingSource.apply {
                language = expectedLanguage
                sort = expectedSort
            }
        }
    }
}