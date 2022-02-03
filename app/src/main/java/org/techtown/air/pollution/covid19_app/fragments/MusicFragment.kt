package org.techtown.air.pollution.covid19_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.techtown.air.pollution.covid19_app.databinding.FragmentHomeBinding
import org.techtown.air.pollution.covid19_app.databinding.FragmentMusicBinding

class MusicFragment: Fragment() {

    private var mBinding : FragmentMusicBinding? =null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentMusicBinding.inflate(inflater, container , false)
        mBinding = binding

        return mBinding?.root

    }

    override fun onDestroy() {
        mBinding =null
        super.onDestroy()
    }
}