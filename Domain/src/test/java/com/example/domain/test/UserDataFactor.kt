package com.example.domain.test

import com.example.domain.model.UserData
import java.util.*

object UserDataFactor {
    fun randomUuId():String{
        return UUID.randomUUID().toString()
    }
    fun makeUser():UserData{
        return UserData(randomUuId(), randomUuId(), randomUuId(), randomUuId())
    }
    fun makeUserList(count:Int):List<UserData>{
        val users = mutableListOf<UserData>()
        repeat(count){
            users.add(makeUser())
        }
        return users
    }
}