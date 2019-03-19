package com.example.remote

import com.example.data.model.UsersEntity
import com.example.remote.factory.RemoteDataFactory
import com.example.remote.mapper.MapperToData
import com.example.remote.model.RequestedUserData
import com.example.remote.service.UsersService
import com.example.remote.service.UsersServiceImp
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class UsersRemoteImpTest{
    @Mock lateinit var mapperToData: MapperToData
    @Mock lateinit var usersService:UsersService
    lateinit var usersRemoteImp:UsersRemoteImp

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        usersRemoteImp = UsersRemoteImp(usersService,mapperToData)
    }
    @Test
    fun getUserComplete(){
        stubRequestedData(Observable.just(RemoteDataFactory.makeReqUserList(2)))
        stubMapper(RemoteDataFactory.makeReqUser(),RemoteDataFactory.makeUser())
        val testObserver = usersRemoteImp.getUsers().test()
        testObserver.assertComplete()
    }
    @Test
    fun getUserCallServer(){
        stubRequestedData(Observable.just(RemoteDataFactory.makeReqUserList(2)))
        stubMapper(RemoteDataFactory.makeReqUser(),RemoteDataFactory.makeUser())
        usersRemoteImp.getUsers().test()
        verify(usersService).getData()
    }
    private fun stubMapper(requestedData: RequestedUserData,usersEntity: UsersEntity){
        `when`(mapperToData.fromRequestedDataToUserEntity(requestedData)).thenReturn(usersEntity)
    }
    private fun stubRequestedData(observable: Observable<List<RequestedUserData>>){
        `when`(usersService.getData()).thenReturn(observable)
    }
}