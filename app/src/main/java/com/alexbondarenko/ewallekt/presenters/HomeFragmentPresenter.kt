package com.alexbondarenko.ewallekt.presenters

import android.content.Context
import com.alexbondarenko.ewallekt.models.Friend
import com.alexbondarenko.ewallekt.models.HomeModel
import com.alexbondarenko.ewallekt.models.Service

class HomeFragmentPresenter(view: View, context: Context?) {
    private val homeModel: HomeModel
    private val view: View

    init {
        this.homeModel = context?.let { HomeModel.getInstance(it) }!!
        this.view = view
    }

    fun updateBalance(balance: String) {
        homeModel.balance = balance
        view.updateBalanceTextView(homeModel.balance)
    }

    fun updateFriendList(friends: ArrayList<Friend>) {
        homeModel.friends = friends
        view.updateFriendRecyclerView(homeModel.friends)
    }

    fun updateServiceList(services: ArrayList<Service>) {
        homeModel.services = services
        view.updateServiceRecyclerView(homeModel.services)
    }

    interface View {
        fun updateBalanceTextView(newBalance: String)
        fun updateFriendRecyclerView(friends: ArrayList<Friend>)
        fun updateServiceRecyclerView(services: ArrayList<Service>)
    }


}