package com.efhem.moviegalore.feature.movie.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.*
import android.widget.FrameLayout
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.efhem.moviegalore.feature.movie.R
import com.google.android.material.snackbar.Snackbar

fun Context.getImage(@DrawableRes id: Int): Drawable? {
    return ContextCompat.getDrawable(this, id)
}

fun Context.getColorResId(@ColorRes id: Int): Int {
    return ContextCompat.getColor(this, id)
}

fun Context.getResDrawable(@DrawableRes id: Int): Drawable? {
    return ContextCompat.getDrawable(this, id)
}

fun ViewGroup.inflate(layout: Int): View {
    val layoutInflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    return layoutInflater.inflate(layout, this, false)
}

fun Fragment.showSnackbar(
    snackbarText: String,
    timeLength: Int = 5000,
    actionButtonText: String? = null,
    action: View.OnClickListener? = null
) {
    activity?.let {
        val snack = Snackbar.make(it.findViewById(android.R.id.content), snackbarText, timeLength)
        if (actionButtonText != null) snack.setAction(actionButtonText, action)
        snack.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
        snack.setBackgroundTint(ContextCompat.getColor(requireContext(), R.color.black))
        snack.setActionTextColor(ContextCompat.getColor(requireContext(), R.color.white))
        val view = snack.view
        val params = view.layoutParams as FrameLayout.LayoutParams
        params.gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
        view.layoutParams = params
        snack.show()
    }
}


inline fun RecyclerView.onReachBottom(
    crossinline action: () -> Unit
){
    this.addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (!recyclerView.canScrollHorizontally(1)) {
                action()
            }
        }
    })
}
