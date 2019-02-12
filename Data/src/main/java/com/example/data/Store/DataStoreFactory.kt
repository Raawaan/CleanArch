package com.example.data.Store

import com.example.data.repo.UserDataStore

class DataStoreFactory(private val userRemoteDataStore: UsersRemoteDataStore) {
    //based in condition will choose for example to retrieve data from database for api call
    fun getDataStore():UserDataStore{
    return userRemoteDataStore
}
}