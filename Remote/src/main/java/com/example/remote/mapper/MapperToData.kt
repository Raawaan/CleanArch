package com.example.remote.mapper

import com.example.data.model.UsersEntity
import com.example.remote.model.RequestedUserData

class MapperToData{
    fun fromRequestedDataToUserEntity(requestedData:RequestedUserData):UsersEntity{
        return UsersEntity(requestedData.name,requestedData.email,
            requestedData.icon,requestedData.category)

    }
}