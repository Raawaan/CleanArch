package com.example.remote.service

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object UsersServiceImp {
            fun createBuilder():UsersService{
                val baseLink ="http://demo8044805.mockable.io/"
                val retrofit = Retrofit.Builder()
                    .baseUrl(baseLink)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create()).build()
                return retrofit.create(UsersService::class.java)
            }
}