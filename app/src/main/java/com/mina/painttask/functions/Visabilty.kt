package com.mina.painttask.functions

import android.view.View

fun showHide(view: View){
    view.visibility = if (view.visibility == View.VISIBLE){
        View.INVISIBLE
    } else{
        View.VISIBLE
    }
}