package com.alexbondarenko.ewallekt.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexbondarenko.ewallekt.R

class FriendHeaderAdapter : RecyclerView.Adapter<FriendHeaderAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.friend_list_header, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {}
    override fun getItemCount(): Int {
        return 1
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!)
}