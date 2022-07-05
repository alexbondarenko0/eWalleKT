package com.alexbondarenko.ewallekt.models

import android.content.Context
import androidx.appcompat.content.res.AppCompatResources
import com.alexbondarenko.ewallekt.R

class MenuModel private constructor(
    var currentUser: CurrentUser,
    menu: ArrayList<MainMenuItem>,
    appVersion: String
) {
    var menu: ArrayList<MainMenuItem>?
    var appVersion: String

    init {
        this.menu = menu
        this.appVersion = appVersion
    }

    fun menuButtonClicked(clickedItem: MainMenuItem?) {
        if (menu != null) {
            for (i in menu!!.indices) {
                menu!![i].isChecked = menu!![i] == clickedItem
            }
        }
    }

    companion object {
        private var instance: MenuModel? = null
        fun getInstance(context: Context?): MenuModel? {
            if (instance == null) {
                //TODO backend

                val currentUser = CurrentUser(
                    "Carol Black",
                    "Seattle,Washington",
                    AppCompatResources.getDrawable(context!!, R.drawable.avatar_carol)!!
                )

                val menu = ArrayList<MainMenuItem>()
                menu.add(MainMenuItem("Home", true, "home"))
                menu.add(MainMenuItem("Profile", false, "profile"))
                menu.add(MainMenuItem("Accounts", false, "accounts"))
                menu.add(MainMenuItem("Stats", false, "stats"))
                menu.add(MainMenuItem("Settings", false, "settings"))
                menu.add(MainMenuItem("Help", false, "help"))

                val appVersion = "2.0.1"

                instance = MenuModel(currentUser, menu, appVersion)
            }
            return instance
        }
    }

}