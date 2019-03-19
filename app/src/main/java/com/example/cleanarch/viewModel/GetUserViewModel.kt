package com.example.cleanarch.viewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.cleanarch.model.UsersDataUI
import com.example.domain.interactor.GetUserKtor
import com.example.domain.interactor.GetUsers
import com.example.domain.model.UserData
import com.example.remote.service.UsersService
import com.example.remote.service.UsersServiceAPI
import io.ktor.client.engine.okhttp.OkHttpConfig
import io.ktor.client.engine.okhttp.OkHttpEngine
import io.reactivex.observers.DisposableObserver
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class GetUserViewModel(private val getUserUseCase: GetUsers,
                       private val getUserUseCaseKtor: GetUserKtor): ViewModel() {
    var listOfUsers: MutableLiveData<List<UserData>> = MutableLiveData()
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
//    private val job = Job()
//    override val coroutineContext: CoroutineContext
//        get() = job
//    fun fetchData(){
//        val radioAPI = UsersServiceAPI(OkHttpEngine(OkHttpConfig()))
//        launch(Dispatchers.Main) {
//            try {
//                listOfUsers.postValue(withContext(Dispatchers.IO)
//                { radioAPI.fetchWeather() }.map {
//                    UserData(it.name,it.id,it.icon,it.cat)
//                }
//                )
//            } catch (e: Exception) {
////              Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
//            }
//
//        }
//    }

    fun fetchDataKtor() {
        listOfUsers.postValue(getUserUseCaseKtor.UserDataKtor())
    }


    override fun onCleared() {
        getUserUseCase.dispose()
        super.onCleared()
    }
}