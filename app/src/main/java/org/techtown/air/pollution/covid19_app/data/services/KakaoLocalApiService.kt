package org.techtown.air.pollution.covid19_app.data.services

import org.techtown.air.pollution.covid19_app.BuildConfig
import org.techtown.air.pollution.covid19_app.data.models.tmcoordinates.TmcoordinatesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface KakaoLocalApiService {

    @Headers("Authorization: KakaoAK ${BuildConfig.KAKAO_API_KEY}")   //인증 정보를 Header로 전송함
    @GET( "v2/local/geo/transcoord.json?=output_coord") // xml로 받을거면 .xml로
    suspend fun getTmCoordinate(
        @Query ("x") longitude: Double,
        @Query("y") latitude: Double
    ): Response<TmcoordinatesResponse>
}