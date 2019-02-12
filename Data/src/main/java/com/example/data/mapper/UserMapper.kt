package com.example.data.mapper

import com.example.data.model.UsersEntity
import com.example.domain.model.UserData

class UserMapper:EntityMapper<UsersEntity,UserData>{
    override fun mapFromEntity(entity: UsersEntity): UserData {
        return UserData(entity.name,entity.email,entity.icon,entity.category)
    }
    override fun mapToEntity(domain: UserData): UsersEntity {
        return UsersEntity(domain.name,domain.email,domain.icon,domain.category)
    }
}