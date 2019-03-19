package com.example.cleanarch

import com.example.cleanarch.model.UsersDataUI
import com.example.data.model.UsersEntity
import com.example.domain.model.UserData
import com.example.remote.model.RequestedUserData
import java.util.*

object DataFactory {
    fun randomUuId():String{
        return UUID.randomUUID().toString()
    }
    fun makeUser(): UserData{
        return UserData(
            randomUuId(),
            randomUuId(),
            randomUuId(),
            randomUuId()
        )
    }
    fun makeUserUIList(count :Int): List<UsersDataUI> {
        val users = mutableListOf<UsersDataUI>()
        repeat(count){
            users.add(makeUserUI())
        }
        return users
    }
    fun makeUserDataList(count :Int): List<UserData> {
        val users = mutableListOf<UserData>()
        repeat(count){
            users.add(makeUser())
        }
        return users
    }
    fun makeUserUI():UsersDataUI{
        return  UsersDataUI(
            randomUuId(),
            randomUuId(),
            randomUuId(),
            randomUuId()
        )
    }
}