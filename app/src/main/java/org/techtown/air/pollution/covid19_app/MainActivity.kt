package org.techtown.air.pollution.covid19_app



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

import kotlinx.coroutines.*
import org.techtown.air.pollution.covid19_app.data.Repository

import org.techtown.air.pollution.covid19_app.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host) as NavHostFragment

        //네비게이션 컨트롤러
        val naController = navHostFragment.navController

        //바텀 네비게이션 뷰 와 네비게이션을 묶어준다

        NavigationUI.setupWithNavController(binding.myBottomNav, naController)
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}