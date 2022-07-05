package com.alexbondarenko.ewallekt.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alexbondarenko.ewallekt.R
import com.alexbondarenko.ewallekt.models.Friend
import com.alexbondarenko.ewallekt.models.HomeModel
import com.alexbondarenko.ewallekt.models.Service
import com.alexbondarenko.ewallekt.presenters.HomeFragmentPresenter
import com.alexbondarenko.ewallekt.ui.FriendAdapter
import com.alexbondarenko.ewallekt.ui.FriendHeaderAdapter
import com.alexbondarenko.ewallekt.ui.ServiceAdapter

class HomeFragment(private val onMenuButtonClick: View.OnClickListener) :
    Fragment(R.layout.fragment_home),
    HomeFragmentPresenter.View {

    private var textViewBalance: TextView? = null
    private var recyclerViewFriends: RecyclerView? = null
    private var recyclerViewServices: RecyclerView? = null
    private var menuButton: ImageView? = null
    private var presenter: HomeFragmentPresenter? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerViewFriends = view.findViewById(R.id.fh_recyclerViewFriends)
        recyclerViewServices = view.findViewById(R.id.fh_recyclerViewServices)
        textViewBalance = view.findViewById(R.id.fh_balanceTextView)
        menuButton = view.findViewById(R.id.fh_menu_button)
        menuButton?.setOnClickListener(onMenuButtonClick)

        presenter = HomeFragmentPresenter(this, context)
        val homeModel: HomeModel? = context?.let { HomeModel.getInstance(it) }

        if (homeModel != null) {
            presenter!!.updateBalance(homeModel.balance)
            presenter!!.updateFriendList(homeModel.friends)
            presenter!!.updateServiceList(homeModel.services)
        }

        return view
    }

    private fun initFriendList(friends: ArrayList<Friend>) {
        val layoutManager =
            context?.let { LinearLayoutManager(it, LinearLayoutManager.HORIZONTAL, false) }
        recyclerViewFriends!!.layoutManager = layoutManager

        val friendAdapter = FriendAdapter(context, friends)
        val friendHeaderAdapter = FriendHeaderAdapter()
        val concatenated = ConcatAdapter(friendHeaderAdapter, friendAdapter)
        recyclerViewFriends!!.adapter = concatenated
    }

    private fun initServiceList(services: ArrayList<Service>) {
        val layoutManager: LinearLayoutManager =
            GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
        recyclerViewServices!!.layoutManager = layoutManager
        val adapter = ServiceAdapter(context, services)
        recyclerViewServices!!.adapter = adapter
    }

    override fun updateBalanceTextView(newBalance: String) {
        textViewBalance?.text = newBalance
    }

    override fun updateFriendRecyclerView(friends: ArrayList<Friend>) {
        initFriendList(friends)
    }

    override fun updateServiceRecyclerView(services: ArrayList<Service>) {
        initServiceList(services)
    }


}