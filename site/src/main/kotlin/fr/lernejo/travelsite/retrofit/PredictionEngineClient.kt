package fr.lernejo.travelsite.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface PredictionEngineClient {
    @GET("api/ping")
    fun getPing(): Call<String> // data class if custom type

    // TODO: Remove before push
    // getPing().enqueue(object: Callback<Type> {
    // onResponse -> if (response.isSuccessful && response.body() != null) response.body() (!!.varOfCustomType)
    // onFailure -> Logger.getGlobal().severe(t.stackTraceToString())
    // })

    // "/api/{vari}" -> @Path("vari") vari: String
    // "/api/req?a=b" -> @Query("a") a: String
}
