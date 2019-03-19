package com.example.data.Store

import com.example.data.repo.UserDataStore

class DataStoreFactory(private val userRemoteDataStore: UsersRemoteDataStore) {

    //based on condition this will choose to retrieve data from database or api call
    //here we call the same api but in different ways
    fun getDataStore():UserDataStore{
        return userRemoteDataStore
    }
    fun getDataStoreKtor():UserDataStore{
        return userRemoteDataStore
    }
}