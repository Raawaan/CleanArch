package com.example.remote.factory

import com.example.data.model.UsersEntity
import com.example.remote.model.RequestedUserData
import java.util.*


object RemoteDataFactory {
    fun randomUuId():String{
        return UUID.randomUUID().toString()
    }
    fun makeUser():UsersEntity{
        return UsersEntity(
            randomUuId(),
            randomUuId(),
            randomUuId(),
            randomUuId()
        )
    }
    fun makeReqUser():RequestedUserData{
        return RequestedUserData(
            randomUuId(),
            randomUuId(),
            randomUuId(),
            randomUuId()
        )
    }
    fun makeUserList(count:Int):List<UsersEntity>{
        val users = mutableListOf<UsersEntity>()
        repeat(count){
            users.add(makeUser())
        }
        return users
    }
    fun makeReqUserList(count:Int):List<RequestedUserData>{
        val users = mutableListOf<RequestedUserData>()
        repeat(count){
            users.add(makeReqUser())
        }
        return users
    }
}