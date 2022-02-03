package org.techtown.air.pollution.covid19_app.data.services

import org.techtown.air.pollution.covid19_app.data.models.covid19domestic.Covid19MeasuredValue
import retrofit2.Call
import retrofit2.http.GET

interface CovidApiService {

    @GET("/korea/?serviceKey=PpdhkzURX5CJFts7Lvm4ylKnTSHNuI92A")
    fun getCovid(): Call<Covid19MeasuredValue>
}