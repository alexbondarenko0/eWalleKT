package com.alexbondarenko.ewallekt.views

import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.fragment.app.FragmentActivity
import com.alexbondarenko.ewallekt.R
import com.alexbondarenko.ewallekt.models.MainMenuItem
import com.alexbondarenko.ewallekt.models.MenuModel
import com.alexbondarenko.ewallekt.ui.OnItemClickListener

class MainActivity : FragmentActivity(), OnItemClickListener {

    private var motionLayout: MotionLayout? = null
    private var contentView: CardView? = null

    private var menuFragment: MenuFragment? = null
    private var homeFragment: HomeFragment? = null
    private var placeholderFragment: PlaceholderFragment? = null
    private var loginFragment: LoginFragment? = null

    private var isMenuOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contentView = findViewById(R.id.am_fragment_container)
        motionLayout = findViewById(R.id.am_motion_layout)

        isMenuOpen = false
        loginFragmentAdd()

        addCustomTransitionListener()

    }

    private fun addCustomTransitionListener() {
        val transitionListener: MotionLayout.TransitionListener = object : TransitionAdapter() {
            override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
                if (!isMenuOpen) {
                    menuFragmentRemove()
                } else contentView?.radius = 100f
            }

            override fun onTransitionStarted(motionLayout: MotionLayout, startId: Int, endId: Int) {
                if (isMenuOpen) {
                    menuFragmentAdd()
                } else contentView?.radius = 0f
            }
        }
        motionLayout?.addTransitionListener(transitionListener)
    }

    private fun menuClose() {
        isMenuOpen = false
        motionLayout!!.transitionToStart()
    }

    private fun menuOpen() {
        isMenuOpen = true
        motionLayout!!.transitionToEnd()
    }

    private fun menuFragmentAdd() {
        menuFragment = MenuFragment({ menuClose() }) {
            loginFragmentAdd()
            menuClose()
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.am_menu_fragment, menuFragment!!, null)
            .commit()
    }

    private fun menuFragmentRemove() {
        supportFragmentManager.beginTransaction()
            .remove(menuFragment!!)
            .commit()
    }

    private fun homeFragmentAdd() {
        homeFragment = HomeFragment { menuOpen() }
        supportFragmentManager.beginTransaction()
            .replace(R.id.am_fragment_container, homeFragment!!, null)
            .commit()
    }

    private fun placeholderFragmentAdd(message: String) {
        placeholderFragment = PlaceholderFragment(
            message
        ) { menuOpen() }
        supportFragmentManager.beginTransaction()
            .replace(R.id.am_fragment_container, placeholderFragment!!, null)
            .commit()
    }

    private fun loginFragmentAdd() {
        loginFragment = LoginFragment { homeFragmentAdd() }
        supportFragmentManager.beginTransaction()
            .replace(R.id.am_fragment_container, loginFragment!!, null)
            .commit()
    }

    override fun onClick(menuItem: MainMenuItem?) {
        MenuModel.getInstance(baseContext)?.menuButtonClicked(menuItem)
        menuFragmentAdd()
        when (menuItem?.itemID) {
            "home" -> homeFragmentAdd()
            "profile" -> placeholderFragmentAdd("There will be a Profile fragment")
            "accounts" -> placeholderFragmentAdd("There will be a Accounts fragment")
            "stats" -> placeholderFragmentAdd("There will be a Stats fragment")
            "settings" -> placeholderFragmentAdd("There will be a Settings fragment")
            "help" -> placeholderFragmentAdd("There will be a Help fragment")
        }
        menuClose()
    }

}