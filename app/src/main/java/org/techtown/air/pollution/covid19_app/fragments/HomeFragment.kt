package org.techtown.air.pollution.covid19_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.techtown.air.pollution.covid19_app.data.Repository
import org.techtown.air.pollution.covid19_app.data.models.covid19domestic.Covid19MeasuredValue
import org.techtown.air.pollution.covid19_app.databinding.FragmentHomeBinding
import retrofit2.awaitResponse

class HomeFragment: Fragment() {

    private var _binding : FragmentHomeBinding? =null
    private val bindng get() = _binding!!

    private val scope = MainScope()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = bindng.root
        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews()
        fetchCovidData()
    }

    private fun bindViews() {
        bindng.refresh.setOnRefreshListener {
            fetchCovidData()
        }
    }

    private fun fetchCovidData() {
        scope.launch {
            bindng.errorDescriptionTextView.visibility = View.GONE
            try {
                val covid19MeasuredValue =
                    Repository.covidApi.getCovid().awaitResponse()
                if (covid19MeasuredValue.isSuccessful){
                   val data = covid19MeasuredValue.body()!!
                        displayCovidData(data)
                }

            }catch (exception : Exception){
               bindng.errorDescriptionTextView.visibility =View.VISIBLE
               bindng.homeFragement.alpha = 0F
            }finally {
                bindng.progresBar.visibility = View.GONE
                bindng.refresh.isRefreshing = false
            }
        }

    }

    private fun displayCovidData(covid19MeasuredValue: Covid19MeasuredValue) {
       bindng.homeFragement.animate()
            .alpha(1F)
            .start()

        bindng.totalCase.text = covid19MeasuredValue.totalCaseBefore


    }


    override fun onDestroy() {
        super.onDestroy()
        _binding =null
    }
}