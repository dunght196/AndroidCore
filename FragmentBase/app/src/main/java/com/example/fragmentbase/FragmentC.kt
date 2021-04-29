package com.example.fragmentbase

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentC : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_layout_c, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("dz196", "onCreate C")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("dz196", "onViewCreated C")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("dz196", "onDestroyView C")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("dz196", "onDestroy C")
    }
}