package com.example.remote

import com.example.data.model.UsersEntity
import com.example.data.repo.UsersRemote
import com.example.domain.model.UserData
import com.example.remote.mapper.MapperToData
import com.example.remote.service.UsersService
import com.example.remote.service.UsersServiceAPI
import com.example.remote.service.UsersServiceImp
import io.ktor.client.engine.okhttp.OkHttpConfig
import io.ktor.client.engine.okhttp.OkHttpEngine
import io.reactivex.Observable
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class UsersRemoteImp(private var usersService: UsersService,
                     private val mapperToData: MapperToData):UsersRemote, CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job

    override fun getUsersUsingKtor() :List<UserData>{
        var list:List<UserData> = listOf(UserData("asf","asf","asf","asf"))
       val radioAPI = UsersServiceAPI(OkHttpEngine(OkHttpConfig()))
        launch(Dispatchers.Main) {
            try {
                list=  withContext(Dispatchers.IO)
                { radioAPI.fetchWeather() }.map {
                    UserData(it.name, it.id, it.icon, it.cat)
                }
            } catch (e: Exception) {
//              Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
            }

        }
        return list
    }
    override fun getUsers(): Observable<List<UsersEntity>> {
        return usersService.getData().map {
            it.map {
                mapperToData.fromRequestedDataToUserEntity(it)
            }
        }
    }
}