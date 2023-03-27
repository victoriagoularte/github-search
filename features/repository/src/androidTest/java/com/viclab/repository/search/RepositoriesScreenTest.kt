package com.viclab.repository.search

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.paging.PagingData
import com.viclab.repository.mock.MockResult
import com.viclab.repository.search.viewmodel.SearchRepositoryViewModel
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import org.junit.Rule
import org.junit.Test

class RepositoriesScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val viewModel: SearchRepositoryViewModel = mockk(relaxed = true) {
        every { repositories() } returns flowOf(PagingData.from(MockResult.fakeRepositoryList().repositoryList))
    }

    @Test
    fun whenOpenApp_shouldShowRepositoryList() {
        composeTestRule.setContent {
            SearchScreen(viewModel)
        }

        composeTestRule.onNodeWithText("android/sunflower").assertExists()
        composeTestRule.onNodeWithText("nickbutcher/plaid").assertExists()
    }
}