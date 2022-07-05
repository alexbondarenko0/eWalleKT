package com.alexbondarenko.ewallekt.ui

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.alexbondarenko.ewallekt.R
import com.alexbondarenko.ewallekt.models.Service

class ServiceAdapter(context: Context?, services: List<Service>) :
    RecyclerView.Adapter<ServiceAdapter.ViewHolder>() {

    private val inflater: LayoutInflater
    private val services: List<Service>

    init {
        inflater = LayoutInflater.from(context)
        this.services = services
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = inflater.inflate(R.layout.service_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val service: Service = services[position]
        holder.tvName.text = service.serviceName
        holder.ivImage.setImageDrawable(service.serviceAvatar)
    }

    override fun getItemCount(): Int {
        return services.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView
        val ivImage: ImageView

        init {
            tvName = itemView.findViewById(R.id.service_name)
            ivImage = itemView.findViewById(R.id.service_image)
        }
    }


}