package com.example.cleanarch.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import com.example.domain.interactor.GetUserKtor
import com.example.domain.interactor.GetUsers
import com.example.domain.model.UserData
import org.junit.Test


import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cleanarch.DataFactory
import com.example.cleanarch.mapper.MapToUIUserData
import com.example.cleanarch.model.UsersDataUI
import com.example.data.Store.DataStoreFactory
import com.nhaarman.mockito_kotlin.*
import io.reactivex.observers.DisposableObserver
import org.junit.Rule
import kotlin.test.assertEquals

class GetUserViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

     var getUser=mock<GetUsers>()
     var getUserKto= mock<GetUserKtor>()
     var viewModel:GetUserViewModel=GetUserViewModel(getUser,getUserKto)
    var mapper= mock<MapToUIUserData>()

    var captor = argumentCaptor<DisposableObserver<List<UserData>>>()
    @Test
    fun getUsers() {
        viewModel.fetchData()
        verify(getUser).execute(any(),eq(null))
    }
    @Test
    fun fetchProjectReturnSuccess(){
        val userData=DataFactory.makeUserDataList(2)
        val userUI = DataFactory.makeUserUIList(2)
        stubUserDataAndUi(userData[0],userUI[0])
        stubUserDataAndUi(userData[1],userUI[1])
        viewModel.fetchData()
        verify(getUser).execute(captor.capture(),eq(null))
        captor.firstValue.onNext(userData)
        assertEquals(userData[0].name, viewModel.getUsers().value?.get(0)?.name)

    }
    fun stubUserDataAndUi(userData: UserData,usersDataUI: UsersDataUI){
        whenever(mapper.fromRequestedDataToUserEntity(userData)).thenReturn(usersDataUI)
    }

}
