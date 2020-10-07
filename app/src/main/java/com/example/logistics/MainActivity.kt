package com.example.logistics

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import kotlin.properties.Delegates

//private const val CHAR_DATA_API = "https://chargen-api.herokuapp.com/"

private const val BASE_URL_API = "http://192.168.9.47:4555/"

private  fun <T> List<T>.rand() = shuffled().first()

//fun <T> CoroutineScope.async(): Deferred<String> {
//    return  async{
//        val apiData = URL(CHAR_DATA_API).readText()
//        apiData
//    }
//}

public suspend fun autorized(login: String, password: String): String {
    val requestParams = mapOf<String, String>("username" to "Rust", "password" to "Rust123456")
    val route = "api-token-auth/"
    GlobalScope.launch {
        postRequest(requestParams, route)
    }
    return ""
}

public suspend fun postRequest(mapRequstParams: Map<String, out String>, router: String): String {



    val apiDataCorut = URL(BASE_URL_API + router)
    var jsonUnput = "{"
    lateinit var _response: String
    _response = ""
    var incrmenet = mapRequstParams.count() + 1

    var arrayKey = mapRequstParams.keys.let {
//        while (incrmenet < 0) {
//            println(incrmenet)
//            incrmenet--
//            it.elementAt(incrmenet)
//        }
        it. { line -> mapRequstParams.get(line) }
//        println(it.elementAt(0))
//        jsonUnput += """"${it}" : "${mapRequstParams.get(it)}","""
    }
    println(arrayKey)

    return ""



//    map {
//        println(it)
//        jsonUnput += """"${it.key}" : "${it.value}","""
//    }

    jsonUnput += "}"

    val connetion = (apiDataCorut.openConnection() as HttpURLConnection).apply{
        requestMethod = "POST"
        setRequestProperty("Content-Type", "application/json; utf-8")
        setRequestProperty("Accept", "application/json")
        doOutput = true
        connect()
    }

    (connetion.let { DataOutputStream(it.outputStream) } as DataOutputStream)
        .run {
            writeBytes(jsonUnput)
            flush()
            close()
        }

    connetion.run {
        inputStream.bufferedReader().let {
            it.lines().forEach { line ->
                println(_response)
            }
        }
    }
    return _response

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


        GlobalScope.launch{
            autorized("Rust", "Rust123456")
        }

//        val flag = this.login

        lateinit var string: String
        if(this::login.isInitialized) {
            val st = findViewById<TextInputEditText>(R.id.loginInput)
            println(st)
            this.login = st.text.toString()
        } else {
            this._testInc = 12
        }
//        println(this._testInc)
//        println(this.login)
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