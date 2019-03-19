package com.example.data

import com.example.data.Store.UsersRemoteDataStore
import com.example.data.factory.UserDataFactor
import com.example.data.model.UsersEntity
import com.example.data.repo.UsersRemote
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UserRemoteDataStoreTest{
    @Mock
    lateinit var remoteDataStore: UsersRemote
    lateinit var store:UsersRemoteDataStore
    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        store=UsersRemoteDataStore(remoteDataStore)
    }
    private fun stubGetUsers(observable: Observable<List<UsersEntity>>){
        Mockito.`when`(remoteDataStore.getUsers()).thenReturn(observable)
    }

    @Test
    fun getUsersComplete(){
        stubGetUsers(Observable.just(listOf(UserDataFactor.makeEntity())))
        val testObservable= remoteDataStore.getUsers().test()
        testObservable.assertComplete()
    }
    @Test
    fun getUsersReturnData(){
        val users=listOf(UserDataFactor.makeEntity())
        stubGetUsers(Observable.just(users))
        val testObservable= remoteDataStore.getUsers().test()
        testObservable.assertValue(users)
    }

}