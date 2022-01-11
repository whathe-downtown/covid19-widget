package org.techtown.air.pollution.covid19_app.data.models.covid19domestic


import com.google.gson.annotations.SerializedName

data class Covid19MeasuredValue(
    @SerializedName("caseCount")
    val caseCount: Int?,
    @SerializedName("casePercentage")
    val casePercentage: Int?,
    @SerializedName("checkingCounter")
    val checkingCounter: Int?,
    @SerializedName("checkingPercentage")
    val checkingPercentage: Int?,
    @SerializedName("city1n")
    val city1n: String?,
    @SerializedName("city1p")
    val city1p: String?,
    @SerializedName("city2n")
    val city2n: String?,
    @SerializedName("city2p")
    val city2p: String?,
    @SerializedName("city3n")
    val city3n: String?,
    @SerializedName("city3p")
    val city3p: String?,
    @SerializedName("city4n")
    val city4n: String?,
    @SerializedName("city4p")
    val city4p: String?,
    @SerializedName("city5n")
    val city5n: String?,
    @SerializedName("city5p")
    val city5p: String?,
    @SerializedName("deathPercentage")
    val deathPercentage: Double?,
    @SerializedName("notcaseCount")
    val notcaseCount: Int?,
    @SerializedName("notcasePercentage")
    val notcasePercentage: Int?,
    @SerializedName("NowCase")
    val nowCase: String?,
    @SerializedName("recoveredPercentage")
    val recoveredPercentage: Double?,
    @SerializedName("resultCode")
    val resultCode: String?,
    @SerializedName("resultMessage")
    val resultMessage: String?,
    @SerializedName("source")
    val source: String?,
    @SerializedName("TodayDeath")
    val todayDeath: Int?,
    @SerializedName("TodayRecovered")
    val todayRecovered: Int?,
    @SerializedName("TotalCase")
    val totalCase: String?,
    @SerializedName("TotalCaseBefore")
    val totalCaseBefore: String?,
    @SerializedName("TotalChecking")
    val totalChecking: Int?,
    @SerializedName("TotalDeath")
    val totalDeath: String?,
    @SerializedName("TotalRecovered")
    val totalRecovered: String?,
    @SerializedName("updateTime")
    val updateTime: String?
)