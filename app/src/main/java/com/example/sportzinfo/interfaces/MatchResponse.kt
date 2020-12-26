package com.example.sportzinfo.interfaces

import com.example.sportzinfo.model.MatchResult
import retrofit2.Call
import retrofit2.http.GET

interface MatchResponse {
    @GET("json/sapk01222019186652.json")
    fun getMatchData(): Call<MatchResult>
}