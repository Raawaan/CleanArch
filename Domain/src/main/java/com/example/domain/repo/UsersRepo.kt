package com.example.domain.repo

import com.example.domain.model.UserData
import io.reactivex.Observable

interface UsersRepo{
    fun getUsersData():Observable<List<UserData>>
}