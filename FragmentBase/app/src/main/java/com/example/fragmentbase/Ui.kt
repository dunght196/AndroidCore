package com.example.fragmentbase

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.addFragment(
    tag: String, layoutId: Int, allowStateLoss: Boolean = false,
    newInstance: Fragment
) {
    val fragment = supportFragmentManager.findFragmentByTag(tag) ?: newInstance
    if (!fragment.isAdded) {
        val transaction = supportFragmentManager.beginTransaction()
            .add(layoutId, fragment, tag)
        if (allowStateLoss) {
            transaction.commitAllowingStateLoss()
        } else {
            transaction.commit()
        }
    }
}

fun AppCompatActivity.addFragmentBackStack(tag: String, layoutId: Int, newInstance: Fragment) {
    val fragment = supportFragmentManager.findFragmentByTag(tag) ?: newInstance
    if (!fragment.isAdded) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.enter_from_right, R.anim.exit_to_left,
                R.anim.enter_from_left, R.anim.exit_to_right
            )
            .add(layoutId, fragment, tag)
            .addToBackStack(tag)
            .commit()
    }
}

fun AppCompatActivity.addNewFragmentBackStack(tag: String, layoutId: Int, newInstance: Fragment) {
    val fragment = newInstance
    supportFragmentManager.beginTransaction()
        .setCustomAnimations(
            R.anim.enter_from_right, R.anim.exit_to_left,
            R.anim.enter_from_left, R.anim.exit_to_right
        )
        .add(layoutId, fragment, tag)
        .addToBackStack(tag)
        .commit()
}

fun AppCompatActivity.replaceFragmentBackStack(
    tag: String,
    layoutId: Int,
    newInstance: Fragment
) {
    val fragment = supportFragmentManager.findFragmentByTag(tag) ?: newInstance
    supportFragmentManager.beginTransaction()
        .setCustomAnimations(
            R.anim.enter_from_right, R.anim.exit_to_left,
            R.anim.enter_from_left, R.anim.exit_to_right
        )
        .replace(layoutId, fragment, tag)
        .addToBackStack(tag)
        .commit()
}

fun AppCompatActivity.replaceNewFragmentBackStack(
    tag: String,
    layoutId: Int,
    newInstance: Fragment
) {
    val fragment = newInstance
    supportFragmentManager.beginTransaction()
        .setCustomAnimations(
            R.anim.enter_from_right, R.anim.exit_to_left,
            R.anim.enter_from_left, R.anim.exit_to_right
        )
        .replace(layoutId, fragment, tag)
        .addToBackStack(tag)
        .commit()
}

fun AppCompatActivity.replaceFragmentBackStackBottomTop(
    tag: String,
    layoutId: Int,
    newInstance: () -> Fragment
) {
    val fragment = supportFragmentManager.findFragmentByTag(tag) ?: newInstance()
    supportFragmentManager.beginTransaction()
        .setCustomAnimations(
            R.anim.slide_up, 0
        )
        .replace(layoutId, fragment, tag)
        .addToBackStack(tag)
        .commit()
}

fun AppCompatActivity.replaceFragmentWithOutBackStack(
    tag: String,
    layoutId: Int,
    newInstance: () -> Fragment
) {
    val fragment = supportFragmentManager.findFragmentByTag(tag) ?: newInstance()
    if (fragment.isAdded) {
        return
    }
    supportFragmentManager.beginTransaction()
        /*.setCustomAnimations(
                R.anim.enter_from_right, R.anim.exit_to_left,
                R.anim.enter_from_left, R.anim.exit_to_right
        )*/
        .replace(layoutId, fragment, tag)
        .commit()
}

fun AppCompatActivity.replaceNewFragment(
    layoutId: Int,
    newInstance: () -> Fragment
) {
    val fragment = newInstance()
    supportFragmentManager.beginTransaction()
        /*.setCustomAnimations(
                R.anim.enter_from_right, R.anim.exit_to_left,
                R.anim.enter_from_left, R.anim.exit_to_right
        )*/
        .replace(layoutId, fragment)
        .commit()
}