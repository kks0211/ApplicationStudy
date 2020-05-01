package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitLibraryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_library)

        val retrofit = Retrofit.Builder()
                                .baseUrl("http://mellowcode.org/")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build()
        val service = retrofit.create(RetrofitService::class.java)

        //GET 요청
        service.getStudentsList().enqueue(object : Callback<ArrayList<PersonFromServer>>{
            //encque 대기중에 올려뒀는 것
            override fun onFailure(call: Call<ArrayList<PersonFromServer>>, t: Throwable) {
                Log.d("retrofitt", "ERROR")
                call.isCanceled
                call.isExecuted
                call.cancel()
            }

            override fun onResponse(
                call: Call<ArrayList<PersonFromServer>>,
                response: Response<ArrayList<PersonFromServer>>
            ) {
                if(response.isSuccessful){
                    val personList = response.body()
                    Log.d("retrofitt", "res1 : ${personList?.get(0)?.age}" )

                    val code = response.code()
                    Log.d("retrofitt", "code : $code")

                    val error =response.errorBody()
                    val header = response.headers()
                    Log.d("retrofitt", "code : $header")
                }
            }
        })

       /* // POST 요청 1
        val params = HashMap<String, Any>()
        params.put("name", "홍길")
        params.put("age", 30)
        params.put("intro", "안녕하세요")
        service.createStudent(params).enqueue(object : Callback<PersonFromServer>{
            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<PersonFromServer>,
                response: Response<PersonFromServer>
            ) {
               if(response.isSuccessful) {
                   val person = response.body()
                   Log.d("retrofitt", "name : ${person?.name}")
               }
            }
        })*/

        // POST 요청 2
        val person = PersonFromServer(name= "테스트", age= 34, intro = "테스트인트로")
        service.createStudentEasy(person).enqueue(object : Callback<PersonFromServer>{
            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
            }
            override fun onResponse(
                call: Call<PersonFromServer>,
                response: Response<PersonFromServer>
            ) {
                if(response.isSuccessful) {
                    val person = response.body()
                    Log.d("retrofitt", "name1 : ${person?.name}")
                }
            }
        })
    }
}
