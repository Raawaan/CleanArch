package com.example.domain.interactor

import com.example.domain.model.UserData
import com.example.domain.repo.UsersRepo
import com.example.domain.test.UserDataFactor
import io.reactivex.Observable
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.util.*

class TestGetUsersKtor{
    lateinit var getUserKtor: GetUserKtor
    @Mock lateinit var usersRepo: UsersRepo

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        getUserKtor = GetUserKtor(usersRepo)
    }
    private fun stubUserData(users: List<UserData>){
        `when`(usersRepo.getUsersDataKtor()).thenReturn(users)
    }
    @Test
    fun getUsersTest(){
        val users= UserDataFactor.makeUserList(2)
        stubUserData(users)
        assertEquals(getUserKtor.UserDataKtor(),users)
    }
}