package org.techtown.air.pollution.covid19_app



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

import kotlinx.coroutines.*

import org.techtown.air.pollution.covid19_app.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val scope = MainScope()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        bindViews()
        //네이게이션들을 담은 호스트
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host) as NavHostFragment

        //네비게이션 컨트롤러
        val naController = navHostFragment.navController

        //바텀 네비게이션 뷰 와 네비게이션을 묶어준다

        NavigationUI.setupWithNavController(binding.myBottomNav, naController)
    }

    private fun bindViews() {
//        binding.refresh.setOnRefreshListener {
//            fetchAirQualityData()
//        }
    }


    companion object {
        private const val REQUEST_ACCESS_LOCATION_PERMISSIONS = 100
    }







    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}