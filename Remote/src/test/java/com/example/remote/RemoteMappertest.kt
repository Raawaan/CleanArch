package com.example.remote

import com.example.data.model.UsersEntity
import com.example.remote.factory.RemoteDataFactory
import com.example.remote.mapper.MapperToData
import com.example.remote.model.RequestedUserData
import org.junit.Assert.assertEquals
import org.junit.Test

class RemoteMappertest {
    private val mapperToData=MapperToData()

    @Test
    fun mapFromRequestedToEntity(){
        val requestedUserData= RequestedUserData(
            RemoteDataFactory.randomUuId(),
            RemoteDataFactory.randomUuId(), RemoteDataFactory.randomUuId(),
                    RemoteDataFactory.randomUuId())
       val usersEntity= mapperToData.fromRequestedDataToUserEntity(requestedUserData)
        assertRequestedAndEntityDataEquals(requestedUserData,usersEntity)
    }
    private fun assertRequestedAndEntityDataEquals(requestedUserData: RequestedUserData,
                                                   usersEntity: UsersEntity){
        assertEquals(requestedUserData.name,usersEntity.name)
        assertEquals(requestedUserData.icon,usersEntity.icon)
        assertEquals(requestedUserData.cat,usersEntity.category)
        assertEquals(requestedUserData.id,usersEntity.email)
    }
}