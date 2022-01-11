package org.techtown.air.pollution.covid19_app.data.services

import org.techtown.air.pollution.covid19_app.BuildConfig
import org.techtown.air.pollution.covid19_app.data.models.covid19domestic.Covid19MeasuredValue
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response

interface Covid19DomesticApiService {

    @GET("korea" +
            "?serviceKey=${BuildConfig.AIR_KOREA_SERVICE_KEY}"+
            "&returnType=json")
    suspend fun getRealtimeCovid19Infection(
    @Query("TotalCaseBefore") TotalCaseBefore: String
    ): Response<Covid19MeasuredValue>
}