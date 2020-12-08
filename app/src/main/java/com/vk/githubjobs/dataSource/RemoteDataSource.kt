package com.vk.githubjobs.dataSource

import com.vk.githubjobs.model.JobPost
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiGitHubJobs {
    @GET("/positions.json")
    suspend fun getJobPosts(
        @Query("description")description: String, //"python"
        @Query("location")location: String //"sf"
    ): List<JobPost>
}

object RemoteDataSource {
    private val BASE_URL = "https://jobs.github.com"
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
    val retrofitService : ApiGitHubJobs = retrofit.create(ApiGitHubJobs::class.java)

/*    suspend fun getJobPosts(description: String, location: String): List<JobPost>{
        return retrofitService.getJobPosts(description, location)
    }*/
}

