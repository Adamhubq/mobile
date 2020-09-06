package com.example.myapplication

import android.os.Build
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Error
import java.net.HttpURLConnection
import java.net.URL
import android.util.Log
import androidx.annotation.RequiresApi
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import java.io.OutputStream
import org.reactivestreams.Subscriber


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)


        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)




//        val test = "http://8f947002cc2e.ngrok.io/mobile-json"
//            .httpGet()
//            .response{request, response, result ->
//                when(result) {
//                    is Result.Failure -> {
//                        val ex = result.getException()
//                        Log.d("err -------------------", ex.toString())
//                    }
//                    is Result.Success -> {
//                        println(response)
//                        println(result)
//                        val data = result.toString()
//                        Log.d("err1 ------------------", data)
//                    }
//                }
//            }


        Log.d("tag", "2")


//        val url = URL("http://localhost:3000/hello")
//        val conn = url.openConnection() as HttpURLConnection
//        val sets = conn.getHeaderField("status")

//        val connection: HttpURLConnection = URL("http://localhost:3000/hello").openConnection() as HttpURLConnection
//        connection.setRequestMethod("GET")
//        connection.connect()
//
//        val magic = Volley
        // Create the stream



//        Log.d("ss ", sets)



//            inputStream.bufferedReader().use {
////                Log.d("tag", a)
//            }

//        connection.connect()
//            val stream = connection.inputStream
//            val inpStr = InputStreamReader(stream)
//            val br = BufferedReader(inpStr)
//            val line: String = br.readLine()
//            Log.d("HTTP-GET", line)
    }
}

