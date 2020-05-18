package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_realm.*

class RealmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        Realm.init(this@RealmActivity)
        val config : RealmConfiguration = RealmConfiguration
                                            .Builder()
                                            .deleteRealmIfMigrationNeeded()
                                            .build()

        Realm.setDefaultConfiguration(config)
        val realm = Realm.getDefaultInstance()

        btn_save.setOnClickListener {
            realm.executeTransaction{
                with(it.createObject(School::class.java)) {
                    this.name = "대학교"
                    this.location = "서울"
                }
            }
        }

        btn_load.setOnClickListener {
            realm.executeTransaction{
                val data = it.where(School::class.java).findFirst()
                Log.d("data=", "data : $data")
            }
        }

        btn_delete.setOnClickListener {
            realm.executeTransaction{
                //it.where(School::class.java).findAll().deleteAllFromRealm()
                it.where(School::class.java).findFirst().deleteFromRealm()
            }
        }

    }

}
