package com.hotels.app.data.datasource

import com.hotels.app.core.network.HotelApiService
import com.hotels.app.core.network.models.HotelsListResponse

/**
 * Источник данных для сетевых запросов
 */
class HotelRemoteDataSource(
    private val apiService: HotelApiService
) {

    suspend fun getHotels(page: Int = 0, limit: Int = 100): HotelsListResponse {
        return apiService.getHotels(page, limit)
    }

    suspend fun searchHotels(query: String, limit: Int = 50): HotelsListResponse {
        return apiService.searchHotels(query, limit)
    }
}
