package manager

import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class NetworkManagerTest {
    @Test
    fun getPLP() = runTest {
        val result = NetworkManager.getPLP(region = RegionManager.Region.US)
        // 200
        assertEquals(HttpStatusCode.OK, result.status)
        // valid sorts
        assertNotNull(result.value.pagination.links.sorting)
    }
}