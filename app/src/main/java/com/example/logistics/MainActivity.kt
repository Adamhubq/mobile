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

public suspend fun test(): String {



    val pass = "\"password\":\"Rust123456\""
    val userName = "userName1111"
    val password = "password1111"



    val apiData = URL(BASE_URL_API + "api-token-auth/")
    val conn = apiData.openConnection() as HttpURLConnection
    conn.requestMethod = "POST"
    conn.setRequestProperty("Content-Type", "application/json; utf-8")
    conn.setRequestProperty("Accept", "application/json")
    conn.doOutput = true
    val jsonUnput = "{\"username\" : \"Rust\", \"password\" : \"Rust123456\"}"
    conn.connect()
    val paramsString: String = jsonUnput
    val wr = DataOutputStream(conn.outputStream)
    wr.writeBytes(paramsString)
    wr.flush()
    wr.close()


    try {
        val `in`: InputStream = BufferedInputStream(conn.inputStream)
        val reader = BufferedReader(InputStreamReader(`in`))
        val result = StringBuilder()
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            result.append(line)
        }
        Log.d("test", "result from server: $result")
    } catch (e: IOException) {
        e.printStackTrace()
    } finally {
        conn?.disconnect()
    }





//     (apiData.openConnection() as HttpURLConnection).run {
//         requestMethod = "POST"
//
////         setRequestProperty("Content-Length", pass)
////         getOutputStream().run{ write() }
//
//
////        setRequestProperty("password", "Rust123456")
//        inputStream.bufferedReader().let {
//            it.lines().forEach{
//                    line -> println(line)
//            }
//        }
//    }

    return ""

//        return (apiData.openConnection() as HttpURLConnection).run {
//            requestMethod = "POST"
//            setRequestProperty("username", "Rust")
//            setRequestProperty("password", "Rust123456")
//
////            = mapOf("username" to listOf("Rust"), "password" to listOf("Rust123456"))
//
////            Map<String, List<String>>
//
//            inputStream.bufferedReader().let {
//                it.lines().forEach{
//                    line -> println(line)
//                }
//            }
//
//            this.toString()
//        }
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
            test()
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