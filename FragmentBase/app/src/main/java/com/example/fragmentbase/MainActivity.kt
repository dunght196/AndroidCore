package com.example.fragmentbase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun AddA(view: View) {
        replaceFragmentBackStack("aaa", R.id.container, FragmentA())
    }

    fun AddB(view: View) {
        replaceFragmentBackStack("bbb", R.id.container, FragmentB())
    }

    fun AddC(view: View) {
        replaceFragmentBackStack("ccc", R.id.container, FragmentC())
    }

    fun Back(view: View) {
        onBackPressed()
    }

    fun RemoveA(view: View) {
    }

    fun RemoveB(view: View) {
    }

    fun RemoveC(view: View) {
        val fragmentManager = this.supportFragmentManager
        val transaction = supportFragmentManager.beginTransaction()
        val other = fragmentManager!!.findFragmentByTag("ccc")
        if (other != null) {
            transaction.show(other)
            transaction.commit()
        }
    }

    fun PopA(view: View) {
        val fragmentManager = this.supportFragmentManager
        val transaction = supportFragmentManager.beginTransaction()
        val other = fragmentManager!!.findFragmentByTag("ccc")
        if (other != null) {
            transaction.hide(other)
            transaction.commit()
        }
    }
}
