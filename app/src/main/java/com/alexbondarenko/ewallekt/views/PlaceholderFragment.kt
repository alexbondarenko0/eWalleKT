package com.alexbondarenko.ewallekt.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.alexbondarenko.ewallekt.R

class PlaceholderFragment(var textOnCenter: String, var onClickListener: View.OnClickListener) :
    Fragment(R.layout.fragment_placeholder) {

    var textView: TextView? = null
    var menuButton: ImageView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_placeholder, container, false)

        textView = view.findViewById(R.id.fp_textView)
        menuButton = view.findViewById(R.id.fp_menu_button)

        menuButton?.setOnClickListener(onClickListener)
        textView?.text = textOnCenter

        return view
    }

}