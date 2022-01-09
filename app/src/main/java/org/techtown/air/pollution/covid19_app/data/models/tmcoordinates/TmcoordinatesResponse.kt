package org.techtown.air.pollution.covid19_app.data.models.tmcoordinates


import com.google.gson.annotations.SerializedName

data class TmcoordinatesResponse(
    @SerializedName("documents")
    val documents: List<Document>?,
    @SerializedName("meta")
    val meta: Meta?
)