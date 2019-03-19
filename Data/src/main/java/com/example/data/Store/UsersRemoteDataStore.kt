package com.example.data.Store

import com.example.data.model.UsersEntity
import com.example.data.repo.UserDataStore
import com.example.data.repo.UsersRemote
import com.example.domain.model.UserData
import io.reactivex.Observable

class UsersRemoteDataStore(val remoteDataStore: UsersRemote):UserDataStore{
    override fun getUsersKto(): List<UserData> {
        return remoteDataStore.getUsersUsingKtor()
    }

    override fun getUsers(): Observable<List<UsersEntity>> {
       return remoteDataStore.getUsers()
    }
}