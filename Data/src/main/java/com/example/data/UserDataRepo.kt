package com.example.data

import com.example.data.Store.DataStoreFactory
import com.example.data.mapper.UserMapper
import com.example.domain.model.UserData
import com.example.domain.repo.UsersRepo
import io.reactivex.Observable

class UserDataRepo(private val mapper: UserMapper,
                   private val dataStoreFactory:DataStoreFactory):UsersRepo{
    override fun getUsersData(): Observable<List<UserData>> {
              return  dataStoreFactory.getDataStore().getUsers().map {
                  it.map {
                      mapper.mapFromEntity(it)
                  }
              }
    }
}