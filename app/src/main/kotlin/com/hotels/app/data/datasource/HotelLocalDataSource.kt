package com.hotels.app.data.datasource

import com.hotels.app.core.database.dao.AmenityDao
import com.hotels.app.core.database.dao.HotelDao
import com.hotels.app.core.database.dao.RoomDao
import com.hotels.app.core.database.entities.AmenityEntity
import com.hotels.app.core.database.entities.HotelEntity
import com.hotels.app.core.database.entities.RoomEntity
import kotlinx.coroutines.flow.Flow

/**
 * Источник данных для локального хранилища
 */
class HotelLocalDataSource(
    private val hotelDao: HotelDao,
    private val amenityDao: AmenityDao,
    private val roomDao: RoomDao
) {

    // Hotel operations
    fun getHotels(limit: Int = 20, offset: Int = 0): Flow<List<HotelEntity>> {
        return hotelDao.getHotels(limit, offset)
    }

    suspend fun getHotelById(id: String): HotelEntity? {
        return hotelDao.getHotelById(id)
    }

    fun searchHotels(query: String): Flow<List<HotelEntity>> {
        return hotelDao.searchHotels(query)
    }

    fun getHotelsByCity(city: String): Flow<List<HotelEntity>> {
        return hotelDao.getHotelsByCity(city)
    }

    fun getCities(): Flow<List<String>> {
        return hotelDao.getCities()
    }

    fun getFavoriteHotels(): Flow<List<HotelEntity>> {
        return hotelDao.getFavoriteHotels()
    }

    fun getHotelsByRating(minRating: Float): Flow<List<HotelEntity>> {
        return hotelDao.getHotelsByRating(minRating)
    }

    fun getHotelsByPrice(minPrice: Double, maxPrice: Double): Flow<List<HotelEntity>> {
        return hotelDao.getHotelsByPrice(minPrice, maxPrice)
    }

    fun filterHotels(minPrice: Double, maxPrice: Double, minRating: Float): Flow<List<HotelEntity>> {
        return hotelDao.filterHotels(minPrice, maxPrice, minRating)
    }

    suspend fun insertHotel(hotel: HotelEntity) {
        hotelDao.insertHotel(hotel)
    }

    suspend fun insertHotels(hotels: List<HotelEntity>) {
        hotelDao.insertHotels(hotels)
    }

    suspend fun updateHotel(hotel: HotelEntity) {
        hotelDao.updateHotel(hotel)
    }

    suspend fun deleteAllHotels() {
        hotelDao.deleteAllHotels()
    }

    suspend fun toggleFavorite(hotelId: String, isFavorite: Boolean) {
        hotelDao.toggleFavorite(hotelId, isFavorite)
    }

    suspend fun getHotelsCount(): Int {
        return hotelDao.getHotelsCount()
    }

    // Amenity operations
    fun getAmenitiesByHotel(hotelId: String): Flow<List<AmenityEntity>> {
        return amenityDao.getAmenitiesByHotel(hotelId)
    }

    fun getFreeAmenitiesByHotel(hotelId: String): Flow<List<AmenityEntity>> {
        return amenityDao.getFreeAmenitiesByHotel(hotelId)
    }

    fun getPaidAmenitiesByHotel(hotelId: String): Flow<List<AmenityEntity>> {
        return amenityDao.getPaidAmenitiesByHotel(hotelId)
    }

    suspend fun insertAmenities(amenities: List<AmenityEntity>) {
        amenityDao.insertAmenities(amenities)
    }

    suspend fun deleteAmenitiesByHotel(hotelId: String) {
        amenityDao.deleteAmenitiesByHotel(hotelId)
    }

    // Room operations
    fun getRoomsByHotel(hotelId: String): Flow<List<RoomEntity>> {
        return roomDao.getRoomsByHotel(hotelId)
    }

    fun getRoomsByCapacity(hotelId: String, minCapacity: Int): Flow<List<RoomEntity>> {
        return roomDao.getRoomsByCapacity(hotelId, minCapacity)
    }

    fun getRoomsByPrice(hotelId: String, minPrice: Double, maxPrice: Double): Flow<List<RoomEntity>> {
        return roomDao.getRoomsByPrice(hotelId, minPrice, maxPrice)
    }

    fun getAvailableRooms(hotelId: String): Flow<List<RoomEntity>> {
        return roomDao.getAvailableRooms(hotelId)
    }

    fun getRoomTypes(hotelId: String): Flow<List<String>> {
        return roomDao.getRoomTypes(hotelId)
    }

    suspend fun insertRooms(rooms: List<RoomEntity>) {
        roomDao.insertRooms(rooms)
    }

    suspend fun deleteRoomsByHotel(hotelId: String) {
        roomDao.deleteRoomsByHotel(hotelId)
    }

    suspend fun getAveragePrice(hotelId: String): Double? {
        return roomDao.getAveragePrice(hotelId)
    }

    suspend fun getMinPrice(hotelId: String): Double? {
        return roomDao.getMinPrice(hotelId)
    }
}
