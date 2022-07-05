package com.alexbondarenko.ewallekt.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alexbondarenko.ewallekt.R
import com.alexbondarenko.ewallekt.models.MainMenuItem

class MenuAdapter(
    context: Context?,
    mainMenuItems: List<MainMenuItem>,
    listener: OnItemClickListener
) :
    RecyclerView.Adapter<MenuAdapter.ViewHolder>() {
    private val inflater: LayoutInflater
    private val mainMenuItems: List<MainMenuItem>
    private val listener: OnItemClickListener

    init {
        inflater = LayoutInflater.from(context)
        this.mainMenuItems = mainMenuItems
        this.listener = listener
    }

    companion object {
        private const val TYPE_CHECKED = 1
        private const val TYPE_UNCHECKED = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View
        if (viewType == TYPE_UNCHECKED)
            view = inflater.inflate(R.layout.menu_item, parent, false)
        else
            view = inflater.inflate(R.layout.menu_item_checked, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mainMenuItem: MainMenuItem = mainMenuItems[position]
        holder.tvName.text = mainMenuItem.itemName
        holder.itemView.setOnClickListener {
            listener.onClick(mainMenuItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (mainMenuItems[position].isChecked) TYPE_CHECKED else TYPE_UNCHECKED
    }

    override fun getItemCount(): Int {
        return mainMenuItems.size
    }

    class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView

        init {
            tvName = itemView.findViewById(R.id.mi_menu_name)
        }
    }

}