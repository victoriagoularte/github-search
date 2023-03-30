package com.viclab.repository.remote

import com.viclab.repository.model.response.RepositoryListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface RepositoryService {

    @GET("/search/repositories")
    suspend fun repositories(
        @Query("q") language: String = "kotlin",
        @Query("sort") sort: String = "stars",
        @Query("page") page: Int = 0,
        @Query("per_page") perPage: Int = 0,
    ): RepositoryListResponse

}