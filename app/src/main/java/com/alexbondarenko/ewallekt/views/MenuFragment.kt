package com.alexbondarenko.ewallekt.views

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alexbondarenko.ewallekt.R
import com.alexbondarenko.ewallekt.models.MainMenuItem
import com.alexbondarenko.ewallekt.models.MenuModel
import com.alexbondarenko.ewallekt.presenters.MenuFragmentPresenter
import com.alexbondarenko.ewallekt.ui.MenuAdapter
import com.alexbondarenko.ewallekt.ui.OnItemClickListener
import com.mikhaellopez.circularimageview.CircularImageView


class MenuFragment(
    private val onCloseMenuButtonClick: View.OnClickListener,
    private val onLogoutButtonClick: View.OnClickListener
) :
    Fragment(R.layout.fragment_menu), MenuFragmentPresenter.View {

    private var closeMenuButton: ImageView? = null
    private var logoutImageView: ImageView? = null
    private var recyclerViewMenu: RecyclerView? = null
    private var userAvatarImageView: CircularImageView? = null
    private var userNameTextView: TextView? = null
    private var userLocationTextView: TextView? = null
    private var appVersionTextView: TextView? = null
    private var logoutButton: TextView? = null
    private var presenter: MenuFragmentPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_menu, container, false)

        closeMenuButton = view.findViewById(R.id.fm_close_menu)
        recyclerViewMenu = view.findViewById(R.id.fm_recycler_view_menu)
        userAvatarImageView = view.findViewById(R.id.fm_user_avatar)
        userNameTextView = view.findViewById(R.id.fm_user_name_textview)
        userLocationTextView = view.findViewById(R.id.fm_user_location_textview)
        appVersionTextView = view.findViewById(R.id.fm_version_textview)
        logoutImageView = view.findViewById(R.id.fm_logout_imageview)
        logoutButton = view.findViewById(R.id.fm_logout_label)

        closeMenuButton?.setOnClickListener(onCloseMenuButtonClick)
        logoutImageView?.setOnClickListener(onLogoutButtonClick)
        logoutButton?.setOnClickListener(onLogoutButtonClick)

        presenter = context?.let { MenuFragmentPresenter(this, it) }
        val menuModel: MenuModel? = context?.let { MenuModel.getInstance(it) }

        if (menuModel != null) {
            presenter?.updateCurrUserLocation(menuModel.currentUser.userLocation)
            presenter?.updateCurrUserName(menuModel.currentUser.userName)
            presenter?.updateCurrUserAvatar(menuModel.currentUser.userAvatar)
            menuModel.menu?.let { presenter?.updateMenu(it) }
            presenter?.updateAppVersion(menuModel.appVersion)
        }

        return view
    }


    private fun initMenuList(menu: List<MainMenuItem>) {
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerViewMenu!!.layoutManager = layoutManager

        val adapter = (context as OnItemClickListener?)?.let { MenuAdapter(context, menu, it) }
        recyclerViewMenu!!.adapter = adapter
    }

    override fun updateUserNameTextView(newUserName: String) {
        userNameTextView?.text = newUserName
    }

    override fun updateUserLocationTextView(newUserLocation: String) {
        userLocationTextView?.text = newUserLocation
    }

    override fun updateUserAvatarImageView(newUserAvatar: Drawable) {
        userAvatarImageView?.setImageDrawable(newUserAvatar)
    }

    override fun updateMenuRecyclerView(newMenu: ArrayList<MainMenuItem>) {
        initMenuList(newMenu)
    }

    override fun updateAppVersionTextView(newAppVersion: String) {
        appVersionTextView?.text = newAppVersion
    }


}