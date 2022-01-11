package org.techtown.air.pollution.covid19_app.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.techtown.air.pollution.covid19_app.BuildConfig
import org.techtown.air.pollution.covid19_app.data.models.airquality.MeasuredValue
import org.techtown.air.pollution.covid19_app.data.models.monitoringstation.MonitoringStation
import org.techtown.air.pollution.covid19_app.data.services.AirKoreaApiService
import org.techtown.air.pollution.covid19_app.data.services.Covid19DomesticApiService
import org.techtown.air.pollution.covid19_app.data.services.KakaoLocalApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Repository {

    suspend  fun getNearbyMonitoringStation(latitude: Double, longitude: Double): MonitoringStation?{
        val tmCoordinates = kakaoLocalApiService
            .getTmCoordinates(longitude, latitude)
            .body()   // body 값안에는 nullable이 있다
            ?.documents   // document 가 배열로 되어있다.
            ?.firstOrNull()  // 첫 번째가 없으면 Null 값을 반환함
        val tmX = tmCoordinates?.x
        val tmY=  tmCoordinates?.y

        return airKoreaApiService
            .getNearbyMonitoringStation(tmX!!,tmY!!)
            .body() // retrofit 응답의 body
            ?.response
            ?.body
            ?.monitoringStations  //items  0 ..n 개
            ?.minByOrNull { it.tm ?: Double.MAX_VALUE}  // 선택한 요소중에 작은 하나만 전달해준다. null 값은 자동으로 후순위
    }

    suspend fun getLatestAirQualityData(stationName: String): MeasuredValue? =
        airKoreaApiService
            .getRealtimeAirQualties(stationName)
            .body()
            ?.response
            ?.body
            ?.measuredValues
            ?.firstOrNull()

    suspend fun getLatestCovid19DomesticData(TotalCaseBefore: String): Covid19DomesticApiService? =
        covid19DomesticApiService
            .getRealtimeCovid19Infection(TotalCaseBefore)






        private val kakaoLocalApiService: KakaoLocalApiService by lazy {
        Retrofit.Builder()
            .baseUrl(Url.KAKAO_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(buildHttpClient())
            .build()
            .create()

    }

    private val airKoreaApiService: AirKoreaApiService by lazy {
        Retrofit.Builder()
            .baseUrl(Url.AIR_KOREA_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(buildHttpClient())
            .build()
            .create()

    }
    private val covid19DomesticApiService: Covid19DomesticApiService by lazy{
        Retrofit.Builder()
            .baseUrl(Url.COVID_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(buildHttpClient())
            .build()
            .create()
    }


    private fun buildHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = if(BuildConfig.DEBUG){
                        HttpLoggingInterceptor.Level.BODY
                    } else{
                        HttpLoggingInterceptor.Level.NONE
                    }
                }
            )
            .build()
}