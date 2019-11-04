package com.ebc.ipnapplication.utils.extension

import com.ebc.ipnapplication.R


/**
 * Created by Mohamed Adel on 18/01/18.
 */
internal fun androidx.fragment.app.FragmentManager.removeFragment(
    tag: String,
    slideIn: Int = R.anim.slide_left,
    slideOut: Int = R.anim.slide_right
) {
    this.beginTransaction()
        .disallowAddToBackStack()
        .setCustomAnimations(slideIn, slideOut)
        .remove(this.findFragmentByTag(tag)!!)
        .commitNow()
}

internal fun androidx.fragment.app.FragmentManager.addFragment(
    containerViewId: Int,
    fragment: androidx.fragment.app.Fragment,
    tag: String,
    slideIn: Int = R.anim.slide_left,
    slideOut: Int = R.anim.slide_right
) {
    this.beginTransaction().disallowAddToBackStack()
        .setCustomAnimations(slideIn, slideOut)
        .add(containerViewId, fragment, tag)
        .commit()
}
