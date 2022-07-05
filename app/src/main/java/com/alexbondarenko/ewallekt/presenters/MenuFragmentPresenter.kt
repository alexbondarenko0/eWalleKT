package com.alexbondarenko.ewallekt.presenters

import android.content.Context
import android.graphics.drawable.Drawable
import com.alexbondarenko.ewallekt.models.MainMenuItem
import com.alexbondarenko.ewallekt.models.MenuModel

class MenuFragmentPresenter(view: View, context: Context) {
    private val menuModel: MenuModel
    private val view: View

    init {
        menuModel = MenuModel.getInstance(context)!!
        this.view = view
    }

    fun updateCurrUserName(userName: String) {
        menuModel.currentUser.userName = userName
        view.updateUserNameTextView(menuModel.currentUser.userName)
    }

    fun updateCurrUserLocation(userLocation: String) {
        menuModel.currentUser.userLocation = userLocation
        view.updateUserLocationTextView(menuModel.currentUser.userLocation)
    }

    fun updateCurrUserAvatar(userAvatar: Drawable) {
        menuModel.currentUser.userAvatar = userAvatar
        view.updateUserAvatarImageView(menuModel.currentUser.userAvatar)
    }

    fun updateMenu(menu: ArrayList<MainMenuItem>) {
        menuModel.menu = menu
        view.updateMenuRecyclerView(menuModel.menu!!)
    }

    fun updateAppVersion(appVersion: String) {
        menuModel.appVersion = appVersion
        view.updateAppVersionTextView(menuModel.appVersion)
    }

    interface View {
        fun updateUserNameTextView(newUserName: String)
        fun updateUserLocationTextView(newUserLocation: String)
        fun updateUserAvatarImageView(newUserAvatar: Drawable)
        fun updateMenuRecyclerView(newMenu: ArrayList<MainMenuItem>)
        fun updateAppVersionTextView(newAppVersion: String)
    }

}
