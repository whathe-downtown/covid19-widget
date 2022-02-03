package org.techtown.air.pollution.covid19_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.techtown.air.pollution.covid19_app.databinding.FragmentFriendsBinding
import org.techtown.air.pollution.covid19_app.databinding.FragmentHomeBinding

class FriendsFragment: Fragment() {

    private var mBinding : FragmentFriendsBinding? =null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentFriendsBinding.inflate(inflater, container , false)
        mBinding = binding

        return mBinding?.root

    }

    override fun onDestroy() {
        mBinding =null
        super.onDestroy()
    }
}