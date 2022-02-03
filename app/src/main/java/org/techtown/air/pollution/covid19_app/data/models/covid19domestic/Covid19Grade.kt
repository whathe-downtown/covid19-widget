package org.techtown.air.pollution.covid19_app.data.models.covid19domestic

import com.google.gson.annotations.SerializedName

enum class Covid19Grade {  // 나중에 기능

    @SerializedName("1") //1~100명
    GOOD,
    @SerializedName("2") //100~500명
    NORMAL,
    @SerializedName("3")//500~1000명
    BAD,
    @SerializedName("4") // 1000 ~4000명명
    AWFUL
}