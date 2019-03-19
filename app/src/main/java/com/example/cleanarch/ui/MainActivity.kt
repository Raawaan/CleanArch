package com.example.cleanarch.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.cleanarch.R
import com.example.cleanarch.viewModel.GetUserViewModel
import com.example.domain.interactor.GetUsers
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import android.arch.lifecycle.ViewModel
import com.example.cleanarch.mapper.MapToUIUserData
import com.example.data.UserDataRepo
import com.example.domain.interactor.GetUserKtor
import io.ktor.http.parametersOf
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class MainActivity : AppCompatActivity() {
    private val mapToUIUserData:MapToUIUserData by inject()
    private val viewModel:GetUserViewModel by viewModel()
    private val usersAdapter: UsersAdapter by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getUsers().observe(this, Observer {
            usersAdapter.stationsList=it?.map { userData ->
                mapToUIUserData.fromRequestedDataToUserEntity(userData)
            }
            rvListOfUsers.adapter=usersAdapter
        })
//        viewModel.fetchDataKtor()
        viewModel.fetchData()
        rvListOfUsers.layoutManager = LinearLayoutManager(this)
    }
}
