package com.example.remote

import com.example.data.model.UsersEntity
import com.example.data.repo.UsersRemote
import com.example.remote.mapper.MapperToData
import com.example.remote.service.UsersService
import io.reactivex.Observable

class UsersRemoteImp(private val mapperToData: MapperToData):UsersRemote{
    override fun getUsers(): Observable<List<UsersEntity>> {
        return UsersService.createBuilder().getData().map {
            it.map {
                mapperToData.fromRequestedDataToUserEntity(it)
            }
        }
    }

}