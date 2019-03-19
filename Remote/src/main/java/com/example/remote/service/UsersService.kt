package com.example.remote.service

import com.example.remote.model.RequestedUserData
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.reactivex.Observable
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface UsersService{
    @GET("senders")
    fun getData(): Observable<List<RequestedUserData>>
//    companion object {
//        val baseLink:String ="http://demo8044805.mockable.io/"
//        fun createBuilder():UsersService{
//            val retrofit = Retrofit.Builder()
//                .baseUrl(baseLink)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create()).build()
//            return retrofit.create(UsersService::class.java)
//        }
//    }
}
