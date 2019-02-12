package com.example.cleanarch.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.cleanarch.R
import com.example.cleanarch.provider.RepoProvider
import com.example.cleanarch.viewModel.GetUserViewModel
import com.example.domain.interactor.GetUsers
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import android.arch.lifecycle.ViewModel
import com.example.cleanarch.mapper.MapToUIUserData


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel:GetUserViewModel
    private lateinit var usersAdapter: UsersAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this,viewModelFactory()).get(GetUserViewModel::class.java)
        viewModel.getUsers().observe(this, Observer {
            usersAdapter= UsersAdapter(it?.map { userData ->
                                MapToUIUserData.fromRequestedDataToUserEntity(userData)
                            })
         rvListOfUsers.adapter=usersAdapter
        })
        viewModel.fetchData()
        rvListOfUsers.layoutManager = LinearLayoutManager(this)
    }
    private fun viewModelFactory():ViewModelProvider.Factory{
       return object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return GetUserViewModel(
                    GetUsers(RepoProvider.getRepo(), AndroidSchedulers.mainThread())
                ) as T
            }
        }
    }
}
