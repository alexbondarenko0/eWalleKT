package com.alexbondarenko.ewallekt.ui

import com.alexbondarenko.ewallekt.models.MainMenuItem

interface OnItemClickListener {
    fun onClick(menuItem: MainMenuItem?)
}