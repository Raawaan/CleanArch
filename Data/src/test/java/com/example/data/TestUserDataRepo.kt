package com.example.data

import com.example.data.Store.DataStoreFactory
import com.example.data.factory.UserDataFactor
import com.example.data.mapper.UserMapper
import com.example.data.model.UsersEntity
import com.example.data.repo.UserDataStore
import com.example.domain.model.UserData
import io.reactivex.Observable
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class TestUserDataRepo {
    lateinit var usersRepo: UserDataRepo
    @Mock lateinit var mapper: UserMapper
    @Mock lateinit var dataStoreFactory: DataStoreFactory
    @Mock lateinit var store: UserDataStore

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        stubFactory()
        usersRepo= UserDataRepo(mapper,dataStoreFactory)
    }
    @Test
    fun getUsersTest(){
        val users= listOf(UserDataFactor.makeUser())
        stubGetUsersKtor(users)
        Assert.assertEquals(store.getUsersKto(), users)
    }
    @Test
    fun getUsersComplete(){
        stubGetUsers(Observable.just(listOf(UserDataFactor.makeEntity())))
        stubMappers(UserDataFactor.makeEntity(), UserDataFactor.makeUser())
        val testObservable= usersRepo.getUsersData().test()
        testObservable.assertComplete()
    }
    @Test
    fun getUsersReturnValue(){
        val entity = UserDataFactor.makeEntity()
        val domain = UserDataFactor.makeUser()
        stubGetUsers(Observable.just(listOf(entity)))
        stubMappers(entity,domain)
        val testObservable= usersRepo.getUsersData().test()
        testObservable.assertValue(listOf(domain))
    }
    private fun stubGetUsers(observable: Observable<List<UsersEntity>>){
        `when`(store.getUsers()).thenReturn(observable)
    }
    private fun stubGetUsersKtor(users: List<UserData>){
        `when`(store.getUsersKto()).thenReturn(users)
    }
    private fun stubFactory(){
        `when`(dataStoreFactory.getDataStore()).thenReturn(store)
    }
    private fun stubMappers(entity: UsersEntity,domain:UserData){
        `when`(mapper.mapFromEntity(entity)).thenReturn(domain)
    }
}