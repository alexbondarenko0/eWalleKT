package com.alexbondarenko.ewallekt.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.alexbondarenko.ewallekt.R

class LoginFragment(private val onClickListener: View.OnClickListener) :
    Fragment(R.layout.fragment_login) {

    private var createAccButton: TextView? = null
    private var signInButton: CardView? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_login, container, false)

        createAccButton = view.findViewById(R.id.fl_create_acc_button)
        signInButton = view.findViewById(R.id.fl_sign_in_button)

        createAccButton?.setOnClickListener(onClickListener)
        signInButton?.setOnClickListener(onClickListener)

        return view
    }
}