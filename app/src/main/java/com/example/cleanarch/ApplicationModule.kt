package com.example.cleanarch

import com.example.cleanarch.mapper.MapToUIUserData
import com.example.cleanarch.ui.UsersAdapter
import com.example.cleanarch.viewModel.GetUserViewModel
import com.example.data.Store.DataStoreFactory
import com.example.data.Store.UsersRemoteDataStore
import com.example.data.UserDataRepo
import com.example.data.mapper.UserMapper
import com.example.data.repo.UsersRemote
import com.example.domain.interactor.GetUserKtor
import com.example.domain.interactor.GetUsers
import com.example.domain.repo.UsersRepo
import com.example.remote.UsersRemoteImp
import com.example.remote.mapper.MapperToData
import com.example.remote.service.UsersServiceImp
import io.reactivex.android.schedulers.AndroidSchedulers
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module



val appModule =module {
    //mapper
    factory { MapperToData() }
    //UsersService
    factory {  UsersServiceImp.createBuilder() }
    //repo
    factory<UsersRemote> { UsersRemoteImp(usersService = get(), mapperToData = get()) }

    factory {  UsersRemoteDataStore(get()) }
    factory { DataStoreFactory(get()) }
    factory { UserMapper() }
    factory<UsersRepo> { UserDataRepo(get(),get()) }

    //adapter
    factory { UsersAdapter() }
    //for view model initialization
    factory { GetUsers(get(),AndroidSchedulers.mainThread()) }
    factory { GetUserKtor(get()) }

    //view model
    viewModel { GetUserViewModel(get(),get()) }

    factory { MapToUIUserData() }
}