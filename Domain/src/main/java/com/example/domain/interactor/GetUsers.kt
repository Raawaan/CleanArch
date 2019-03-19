package com.example.domain.interactor

import com.example.domain.model.UserData
import com.example.domain.repo.UsersRepo
import io.reactivex.Observable
import io.reactivex.Scheduler

class GetUsers(private val repo: UsersRepo,
               scheduler: Scheduler):ObservableUseCase<List<UserData>,Unit>(scheduler){
    override fun  buildUseCaseObservable(params: Unit?): Observable<List<UserData>> {
       return repo.getUsersData()
    }
}