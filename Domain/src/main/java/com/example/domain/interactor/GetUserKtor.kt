package com.example.domain.interactor

import com.example.domain.model.UserData
import com.example.domain.repo.UsersRepo

class GetUserKtor(private val repo: UsersRepo){
    fun UserDataKtor(): List<UserData> {
     return repo.getUsersDataKtor()
    }
}