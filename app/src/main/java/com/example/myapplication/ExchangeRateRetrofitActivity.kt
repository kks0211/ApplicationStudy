package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ExchangeRateRetrofitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exchange_rate_retrofit)

        val urlStr =
            ("https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=sf2uyxSqcV20fwhWfFOKTIXiNrN5GvZB"
                    + "&searchdate=20200518"
                    + "&data=AP01")


        val retrofit = Retrofit.Builder()
            .baseUrl(urlStr)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ExchangeRateService::class.java)

        //GET 요청
        service.getExchangeRateApi().enqueue(object : Callback<ArrayList<ExchangeRateServer>> {
            //encque 대기중에 올려뒀는 것
            override fun onFailure(call: Call<ArrayList<ExchangeRateServer>>, t: Throwable) {
                Log.d("retrofitt", "ERROR")
                call.isCanceled
                call.isExecuted
                call.cancel()
            }

            override fun onResponse(
                call: Call<ArrayList<ExchangeRateServer>>,
                response: Response<ArrayList<ExchangeRateServer>>
            ) {
                if(response.isSuccessful){
                    val exchangeList = response.body()
                    Log.d("retrofitt", "res1 : ${exchangeList?.get(0)?.result}" )

                    val code = response.code()
                    Log.d("retrofitt", "code : $code")

                    val error =response.errorBody()
                    val header = response.headers()
                    Log.d("retrofitt", "code : $header")
                }
            }
        })
    }
}
