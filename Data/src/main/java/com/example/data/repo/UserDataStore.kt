package com.example.data.repo

import com.example.data.model.UsersEntity
import io.reactivex.Observable
//da ely fe nos
interface UserDataStore {
    fun getUsers(): Observable<List<UsersEntity>>
}