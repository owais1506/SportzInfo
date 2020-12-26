package com.example.sportzinfo.network

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstance : Application() {
    private  var  mInstance: RetrofitInstance = this

    @Synchronized
    fun getInstance(): RetrofitInstance {
        return mInstance
    }
    override fun onCreate() {
        super.onCreate()
        mInstance = this
        com.facebook.stetho.Stetho.initializeWithDefaults(this)
    }

    private var retrofit: Retrofit? = null

    @Synchronized
    fun getClient(): Retrofit? {
        val httpClient = OkHttpClient.Builder()
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl("https://cricket.yahoo.net/sifeeds/cricket/live/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(
                    OkHttpClient.Builder()
                        .connectTimeout(10, TimeUnit.MINUTES)
                        .readTimeout(1, TimeUnit.MINUTES)
                        .retryOnConnectionFailure(true)
                        .addNetworkInterceptor(StethoInterceptor())
                        .build()
                )
                .build()
        }
        return retrofit
    }
    public fun inNetwork(): Boolean {
        var isConnected = false
        val manager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var nInfo: NetworkInfo? = null
        if (manager != null) {
            nInfo = manager.activeNetworkInfo
        }
        if (nInfo != null && nInfo.isConnectedOrConnecting) isConnected = true
        return isConnected
    }
}