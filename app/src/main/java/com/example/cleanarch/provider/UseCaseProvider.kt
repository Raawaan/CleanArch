package com.example.cleanarch.provider

import com.example.data.Store.DataStoreFactory
import com.example.data.Store.UsersRemoteDataStore
import com.example.data.UserDataRepo
import com.example.data.mapper.UserMapper
import com.example.domain.interactor.GetUsers
import com.example.remote.UsersRemoteImp
import com.example.remote.mapper.MapperToData
import io.reactivex.android.schedulers.AndroidSchedulers

object UseCaseProvider {
    fun getUserUseCase():GetUsers{
        return GetUsers(RepoProvider.getRepo(), AndroidSchedulers.mainThread())
    }
}