package com.example.domain.interactor

import com.example.domain.interactor.GetUsers
import com.example.domain.model.UserData
import com.example.domain.repo.UsersRepo
import com.example.domain.test.UserDataFactor
import io.reactivex.Observable
import io.reactivex.Scheduler
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class TestGetUsers(){
    private lateinit var getuser:GetUsers
    @Mock lateinit var getRepo: UsersRepo
    @Mock lateinit var scheduler: Scheduler

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        getuser = GetUsers(getRepo,scheduler)
    }
    @Test
    fun getUsersComplete(){
        stubGetUsers(Observable.just(UserDataFactor.makeUserList(2)))
        val testObserver= getuser
            .buildUseCaseObservable().test()
        testObserver.assertComplete()
    }
    @Test
    fun getUsersReturns(){
        val users=UserDataFactor.makeUserList(2)
        stubGetUsers(Observable.just(users))
        val testObserver= getuser
            .buildUseCaseObservable().test()
        testObserver.assertValue(users)
    }
    private fun stubGetUsers(observable: Observable<List<UserData>>) {
        `when`(getRepo.getUsersData()).thenReturn(observable)
    }
}