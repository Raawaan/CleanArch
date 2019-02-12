package com.example.cleanarch.mapper

import com.example.cleanarch.model.UsersDataUI
import com.example.domain.model.UserData

object MapToUIUserData{
    fun fromRequestedDataToUserEntity(userData:UserData): UsersDataUI {
        return UsersDataUI(
            userData.name, userData.email,
            userData.icon, userData.category
        )
    }
}