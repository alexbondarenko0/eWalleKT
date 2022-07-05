package com.alexbondarenko.ewallekt.models

import android.content.Context
import androidx.appcompat.content.res.AppCompatResources
import com.alexbondarenko.ewallekt.R

class HomeModel(
    var balance: String,
    var friends: ArrayList<Friend>,
    var services: ArrayList<Service>
) {
    companion object {
        private var instance: HomeModel? = null
        fun getInstance(context: Context): HomeModel {
            if (instance == null) {
                //TODO backend

                val balance: String = "20,600"

                val friends: ArrayList<Friend> = ArrayList()
                friends.add(Friend("Mike",
                        AppCompatResources.getDrawable(context, R.drawable.avatar_mike)!!
                    ))
                friends.add(Friend("Joseph",
                        AppCompatResources.getDrawable(context, R.drawable.avatar_joseph)!!
                    ))
                friends.add(Friend("Ashley",
                        AppCompatResources.getDrawable(context, R.drawable.avatar_ashley)!!
                    ))
                friends.add(Friend("Mike",
                        AppCompatResources.getDrawable(context, R.drawable.avatar_mike)!!
                    ))
                friends.add(Friend("Joseph",
                        AppCompatResources.getDrawable(context, R.drawable.avatar_joseph)!!
                    ))
                friends.add(Friend("Ashley",
                        AppCompatResources.getDrawable(context, R.drawable.avatar_ashley)!!
                    ))

                val services: ArrayList<Service> = ArrayList()
                services.add(Service("Send Money",
                        AppCompatResources.getDrawable(context, R.drawable.ico_send_money)!!
                    ))
                services.add(Service("Cashback Offer",
                        AppCompatResources.getDrawable(context, R.drawable.ico_cashback_offer)!!
                    ))
                services.add(Service("Receive Money",
                        AppCompatResources.getDrawable(context, R.drawable.ico_receive_money)!!
                    ))
                services.add(Service("Movie Tickets",
                        AppCompatResources.getDrawable(context, R.drawable.ico_movie_tickets)!!
                    ))
                services.add(Service("Mobile Prepaid",
                        AppCompatResources.getDrawable(context, R.drawable.ico_mobile_prepaid)!!
                    ))
                services.add(Service("Flight Tickets",
                        AppCompatResources.getDrawable(context, R.drawable.ico_flight_tickets)!!
                    ))
                services.add(Service("Electricity Bill",
                        AppCompatResources.getDrawable(context, R.drawable.ico_electricity_bill)!!
                    ))
                services.add(Service("More Option",
                        AppCompatResources.getDrawable(context, R.drawable.ico_more_option)!!
                    ))

                instance = HomeModel(balance, friends, services)
            }
            return instance as HomeModel
        }
    }
}