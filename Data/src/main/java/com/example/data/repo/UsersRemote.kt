package com.example.data.repo

import com.example.data.model.UsersEntity
import io.reactivex.Observable

interface UsersRemote {
        fun getUsers():Observable<List<UsersEntity>>
}