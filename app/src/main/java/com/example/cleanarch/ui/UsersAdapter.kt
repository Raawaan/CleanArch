package com.example.cleanarch.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cleanarch.R
import com.example.cleanarch.model.UsersDataUI
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_of_items.view.*

class UsersAdapter(private val stationsList: List<UsersDataUI>?)
    : RecyclerView.Adapter<UsersAdapter.StationHolderView>(){
    open class StationHolderView(itemView: View): RecyclerView.ViewHolder(itemView){}
    override fun onBindViewHolder(holder: StationHolderView, position: Int) {
        val listOfUsers = stationsList?.get(position)
        holder.itemView.tvUserName.text=listOfUsers?.name
            Picasso.get().load(listOfUsers?.icon).fit().centerCrop().into(holder.itemView.ivOfUsers)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationHolderView {
        return StationHolderView(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_of_items, parent, false)
        )
    }
    override fun getItemCount() = stationsList!!.size
}