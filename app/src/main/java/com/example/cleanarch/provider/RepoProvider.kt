package com.example.cleanarch.provider

import com.example.data.Store.DataStoreFactory
import com.example.data.Store.UsersRemoteDataStore
import com.example.data.UserDataRepo
import com.example.data.mapper.UserMapper
import com.example.remote.UsersRemoteImp
import com.example.remote.mapper.MapperToData

object RepoProvider {
    private val mapperToData= MapperToData()
    private val usersRemoteImp= UsersRemoteImp(mapperToData)
    private val userRemoteDataStore = UsersRemoteDataStore(usersRemoteImp)
    private val dataStoreFactory = DataStoreFactory(userRemoteDataStore)
    private val mapper= UserMapper()
    fun getRepo(): UserDataRepo {
        return UserDataRepo(mapper,dataStoreFactory)

    }
}