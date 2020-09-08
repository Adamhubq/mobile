package com.example.logistics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.base_mech.view.*
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*
import kotlin.reflect.typeOf


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val but = findViewById<Button>(R.id.buttonAutorized)
        but.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {

        val login = findViewById<TextInputEditText>(R.id.loginInput)
        val pass = findViewById<TextInputEditText>(R.id.passwordInput)

//        http://192.168.9.47:4333/admin/login/?next=/admin/



        val urlRequest ="http://192.168.9.47:4333/api-token-auth/"
        var parameters = listOf(Pair("username", "Rust"), Pair("password", "Rust123456"))
        urlRequest.httpPost(parameters)
                .response { request, response, result ->
                    when(result) {
                        is Result.Failure -> {
                            println("result")
                            println(result)
                        }
                        is Result.Success -> {
                            val _writeStreamBody: InputStream = response.body().toStream()
                            val bufferedString = BufferedReader(InputStreamReader(_writeStreamBody)).readText()
                            val responseObjectToken = com.beust.klaxon.Parser().parse(StringBuilder(bufferedString)) as JsonObject
                            val header = String(Base64.getDecoder().decode((responseObjectToken.get("token") as String).split(".")[1]))
                            val build = com.beust.klaxon.Parser().parse(StringBuilder(header)) as JsonObject


                        }
                    }
                }

        println(pass.text)
        println(login.text)

//        val i = Intent(this, com.example.logistics.BaseMech::class.java)
//        startActivity(i)
    }
}