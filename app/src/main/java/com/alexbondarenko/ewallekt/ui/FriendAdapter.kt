package com.alexbondarenko.ewallekt.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alexbondarenko.ewallekt.R
import com.alexbondarenko.ewallekt.models.Friend
import com.mikhaellopez.circularimageview.CircularImageView

class FriendAdapter(context: Context?, friends: List<Friend>) :
    RecyclerView.Adapter<FriendAdapter.ViewHolder>() {
    private val inflater: LayoutInflater
    private val friends: List<Friend>

    init {
        inflater = LayoutInflater.from(context)
        this.friends = friends
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = inflater.inflate(R.layout.friend_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val friend: Friend = friends[position]
        holder.tvName.text = friend.friendName
        holder.ivAvatar.setImageDrawable(friend.friendAvatar)
    }

    override fun getItemCount(): Int {
        return friends.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView
        val ivAvatar: CircularImageView

        init {
            tvName = itemView.findViewById(R.id.friend_name)
            ivAvatar = itemView.findViewById(R.id.fm_user_avatar)
        }
    }

}