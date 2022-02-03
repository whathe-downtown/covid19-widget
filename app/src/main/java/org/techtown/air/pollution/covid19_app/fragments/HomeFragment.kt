package org.techtown.air.pollution.covid19_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.techtown.air.pollution.covid19_app.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {

    private var mBinding : FragmentHomeBinding? =null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentHomeBinding.inflate(inflater, container , false)
        mBinding = binding

        return mBinding?.root

    }

    override fun onDestroy() {
        mBinding =null
        super.onDestroy()
    }
}