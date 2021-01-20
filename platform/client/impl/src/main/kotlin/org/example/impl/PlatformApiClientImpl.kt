package org.example.impl

import org.example.api.PlatformApi
import org.example.client.api.PlatformApiClient

class PlatformApiClientImpl : PlatformApiClient {
    override val platform: PlatformApi = object: PlatformApi {
        override fun print(message: String) {
            println(message)
        }
    }
}
