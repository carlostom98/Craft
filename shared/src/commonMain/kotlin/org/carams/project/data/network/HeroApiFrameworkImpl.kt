package org.carams.project.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.carams.project.data.Secrets
import org.carams.project.data.model.ApiResponse
import org.carams.project.data.model.HeroVO
import org.carams.project.data.model.IHeroApiFramework

class HeroApiFrameworkImpl: IHeroApiFramework {

    private val authToken = Secrets.API_AUTH_TOKEN
    private val url = "https://superheroapi.com/api/$authToken/"

    private val httpClient = HttpClient {
        install(ContentNegotiation.Plugin) {
            json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Companion.Any)
        }
    }

    override suspend fun getHero(name: String): List<HeroVO> {
       val result = httpClient.get("$url/search/$name").body<ApiResponse>()
        return result.results
    }


}