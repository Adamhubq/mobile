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
import kotlinx.coroutines.Deferred
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.URL
import java.util.*
import kotlin.concurrent.schedule
import kotlin.reflect.typeOf
import kotlinx.coroutines.*
import kotlin.math.log
import kotlin.properties.Delegates

private const val CHAR_DATA_API = "https://chargen-api.herokuapp.com/"

private  fun <T> List<T>.rand() = shuffled().first()

//fun <T> CoroutineScope.async(): Deferred<String> {
//    return  async{
//        val apiData = URL(CHAR_DATA_API).readText()
//        apiData
//    }
//}

public suspend fun test(): String {
        val apiData = URL(CHAR_DATA_API).readText()
        println(apiData)
        return apiData
}

class MainActivity : AppCompatActivity(), View.OnClickListener {



    public lateinit var login: String

    public var _testInc by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val but = findViewById<Button>(R.id.buttonAutorized)
        but.setOnClickListener(this)

        println("adadasdasd")
    }

    override fun onClick(p0: View?) {


//        GlobalScope.launch{
//            test()
//        }

//        val flag = this.login

        lateinit var string: String
        if(this::login.isInitialized) {
            val st = findViewById<TextInputEditText>(R.id.loginInput)
            println(st)
            this.login = st.text.toString()
        } else {
            this._testInc = 12
        }
        println(this._testInc)
        println(this.login)
//        if (flag == "") {
//            val logins = findViewById<TextInputEditText>(R.id.loginInput)
//            println(logins.text)
//            this.login = logins.text as String
//        } else {
//            println(this.login)
//        }


/*
        val login = findViewById<TextInputEditText>(R.id.loginInput)
        val pass = findViewById<TextInputEditText>(R.id.passwordInput)
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
                            println(build.get("exp"))
                            println("del1")
                            val tim = Timer().schedule(4000){
                                println("del")
                            }
                        }
                    }
                }

        println(pass.text)
        println(login.text)
*/
//        val i = Intent(this, com.example.logistics.BaseMech::class.java)
//        startActivity(i)
    }
}