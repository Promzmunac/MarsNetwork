package com.example.marsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marsapp.api.MarsJson
import com.example.marsapp.api.MarsProperty
import com.example.marsapp.databinding.ActivityMarsMainBinding
import com.example.marsapp.viewmodel.MarsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarsMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMarsMainBinding
    private lateinit var marsViewModel: MarsViewModel
    //private lateinit var marsData: emptyList<MarsProperty>
    private lateinit var adapter: AdapterMars


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = AdapterMars(this)
        marsViewModel = ViewModelProvider(this)[MarsViewModel::class.java]

        binding = ActivityMarsMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // marsData = emptyList<MarsProperty>()
        binding.rvRecyclerView.adapter = adapter
        binding.rvRecyclerView.layoutManager = LinearLayoutManager(this)

        marsViewModel.getMarsRealEstateProperties().enqueue(
            object : Callback<List<MarsProperty>> {
                override fun onResponse(
                    call: Call<List<MarsProperty>>,
                    response: Response<List<MarsProperty>>
                ) {
                    //displaying the image on the imageView
                    response.body()?.let { adapter.setData(it) }

                    /*
                     //check the body of the response
                     val body = response.body()
                     if( body == null) {
                     Log.w(TAG, "Didnt recieve vqlid response")
                        return
                     }
                     marsData.addAll(body.marsData)
                     adapter.notifyDatasetChanged
                     */
                }

                override fun onFailure(call: Call<List<MarsProperty>>, t: Throwable) {
                    Log.d("ERROR", "${t.message}")
                }
            }
        )
    }
}