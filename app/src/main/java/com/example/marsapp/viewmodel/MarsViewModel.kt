package com.example.marsapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.marsapp.MarsApi
import com.example.marsapp.api.MarsProperty
import retrofit2.Call

class MarsViewModel: ViewModel() {

    fun getMarsRealEstateProperties(): Call<List<MarsProperty>> {
        return MarsApi.retrofitService.getProperties()
    }
}

