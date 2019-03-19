package com.example.data

import com.example.data.factory.UserDataFactor
import com.example.data.mapper.UserMapper
import com.example.data.model.UsersEntity
import com.example.domain.model.UserData
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TestUserMapper {
    lateinit var userMapper: UserMapper
    @Before
    fun setUp(){
        userMapper= UserMapper()
    }
    private fun assertModelAndEntityEquals(entity: UsersEntity,
                                           domain: UserData){
        assertEquals(entity.name,domain.name)
        assertEquals(entity.category,domain.category)
        assertEquals(entity.email,domain.email)
        assertEquals(entity.icon,domain.icon)
    }
    @Test
    fun testFromEntityToDomain(){
        val entity: UsersEntity= UserDataFactor.makeEntity()
        val domain= userMapper.mapFromEntity(entity)
        assertModelAndEntityEquals(entity,domain)
    }
    @Test
    fun testFromDomainToEntity(){
        val domain: UserData= UserDataFactor.makeUser()
        val entity= userMapper.mapToEntity(domain)
        assertModelAndEntityEquals(entity,domain)
    }
}