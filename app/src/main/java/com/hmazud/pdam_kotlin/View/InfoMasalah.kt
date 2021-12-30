package com.hmazud.pdam_kotlin.View

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.hmazud.pdam_kotlin.Adapter.MasalahAdapter
import com.hmazud.pdam_kotlin.Local.SharePref
import com.hmazud.pdam_kotlin.Model.MasalahResponse
import com.hmazud.pdam_kotlin.NetworkService.ApiInterface
import com.hmazud.pdam_kotlin.NetworkService.RetrofitInstance
import com.hmazud.pdam_kotlin.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InfoMasalah : AppCompatActivity() {

    var apiInterface: ApiInterface? = null
    private var recyclerView: RecyclerView? = null
    private var adapter: RecyclerView.Adapter<*>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    var mainActivity: InfoMasalah? = null

    var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_masalah)

        title = "Informasi Gangguan Air"

        recyclerView = findViewById(R.id.rvMasalah)
        layoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = layoutManager
        apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)

        mainActivity = this
        context = this

        getMasalah()

    }

    private fun getMasalah() {
        Log.e("TAG_DATA_MASALAH0", "onResponse: ")

        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        retIn.getMasalahResponse().enqueue(object : Callback<MasalahResponse>{
            override fun onResponse(
                call: Call<MasalahResponse>,
                response: Response<MasalahResponse>
            ) {
                Log.e("TAG_DATA_MASALAH1", "onResponse: "+response.body())
                val masalahDataList: List<MasalahResponse.MasalahModel?> = response.body()?.masalahDataList!!
                adapter = MasalahAdapter(masalahDataList)
                recyclerView!!.adapter = adapter
            }

            override fun onFailure(call: Call<MasalahResponse>, t: Throwable) {
                Log.e("TAG_DATA_MASALAH2", "onResponse: ")
            }

        })
    }
    
}
