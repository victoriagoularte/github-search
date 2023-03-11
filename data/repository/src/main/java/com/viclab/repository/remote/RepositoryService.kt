package com.viclab.repository.remote

import com.viclab.repository.model.response.RepositoryListResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface RepositoryService {

    @GET("/search/repositories?q=language:kotlin&sort=stars&page=1")
    suspend fun repositories(
        @Query("language") language: String = "kotlin",
        @Query("sort") sort: String = "stars",
        @Query("page") page: Int = 0,
        @Query("per_page") perPage: Int = 0,
    ): RepositoryListResponse

}