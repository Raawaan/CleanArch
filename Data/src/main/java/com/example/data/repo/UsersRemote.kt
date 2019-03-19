package com.example.data.repo

import com.example.data.model.UsersEntity
import com.example.domain.model.UserData
import io.reactivex.Observable

interface UsersRemote {
        fun getUsers():Observable<List<UsersEntity>>
        fun getUsersUsingKtor():List<UserData>
}