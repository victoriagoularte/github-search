package com.viclab.core.test.mockwebserver

import com.viclab.core.network.di.NetworkModule
import okhttp3.mockwebserver.MockWebServer
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class MockWebServerTestRule : TestWatcher() {

    val server = MockWebServer()
    private val baseUrl = server.url("/").toString()

    override fun starting(description: Description) {
        super.starting(description)
    }

    override fun finished(description: Description) {
        server.shutdown()
    }

    fun providesRetrofit() = NetworkModule.provideRetrofit(
        NetworkModule.providesOkHttpClient(
            NetworkModule.providesHttpLoggingInterceptor(),
            NetworkModule.providesDefaultInterceptorQueryParameter()
        )
    )
}