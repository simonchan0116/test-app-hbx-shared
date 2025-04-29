package manager

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequest
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.request
import io.ktor.http.HttpStatusCode
import io.ktor.http.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import model.HBXProductListResponse

expect fun genHttpClient(config: HttpClientConfig<*>.() -> Unit = {}): HttpClient

object NetworkManager {
    val client = genHttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getPLP(region: RegionManager.Region): NetworkResult<HBXProductListResponse> {
        val result = this.client.get("https://hbx.com/men/brands/hypebeast") {
            headers {
                headers.append("X-Api-Version", "3.1")
                headers.append("Accept", "application/json")
                headers.append("Accept-Language", region.lang)
            }
            url {
                parameters.append("limit", "10")
                parameters.append("page", "1")
            }
        }
        return result.asResult()
    }
}

suspend inline fun <reified T> HttpResponse.asResult(): NetworkResult<T> =
    NetworkResult<T>(request = this.request, status = this.status, value = this.body())

data class NetworkResult<T>(val request: HttpRequest, val status: HttpStatusCode, val value: T)