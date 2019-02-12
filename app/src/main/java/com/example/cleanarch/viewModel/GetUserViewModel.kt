package com.example.cleanarch.viewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.domain.interactor.GetUsers
import com.example.domain.model.UserData
import io.reactivex.observers.DisposableObserver

class GetUserViewModel(private val getUserUseCase: GetUsers):ViewModel() {
    var listOfUsers:MutableLiveData<List<UserData>> = MutableLiveData()
    fun getUsers(): MutableLiveData<List<UserData>> {
        return listOfUsers
    }
    fun fetchData(){
            getUserUseCase.execute(object : DisposableObserver<List<UserData>>(){
            override fun onComplete() {
            }
            override fun onNext(t: List<UserData>) {
                listOfUsers.postValue(t)
            }
            override fun onError(e: Throwable) {
            }
        })

    }
    override fun onCleared() {
        getUserUseCase.dispose()
        super.onCleared()
    }
}