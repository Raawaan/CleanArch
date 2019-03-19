package com.example.data.factory

import com.example.data.model.UsersEntity
import com.example.domain.model.UserData
import java.util.*


object UserDataFactor {
    fun randomUuId():String{
        return UUID.randomUUID().toString()
    }
    fun makeUser(): UserData {
        return UserData(
            randomUuId(),
            randomUuId(),
            randomUuId(),
            randomUuId()
        )
    }
    fun makeEntity(): UsersEntity {
        return UsersEntity(
            randomUuId(),
            randomUuId(),
            randomUuId(),
            randomUuId()
        )
    }
}