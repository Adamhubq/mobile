package com.example.myapplication.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Klaxon
import com.beust.klaxon.Parser
import com.example.myapplication.R
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })


//        val objectRx = Observable.just("pidor").subscribe{data -> println(data)}

//        val objectRT = Observable.create<String>{
//            emitter ->
//            "http://8f947002cc2e.ngrok.io/mobile-json"
//                .httpGet().responseString { request, response, result ->  when(result) {
//                    is Result.Success -> {
//                        response.body().toStream()
//
//                    }
//                } }
//        }

        "http://8f947002cc2e.ngrok.io/mobile-json"
            .httpGet()
            .response{request, response, result ->
                when(result) {
                    is Result.Failure -> {
//                        val ex = result.getException()
                        Log.d("err -------------------", "")
                    }
                    is Result.Success -> {

                        println("1223")
                        val write: InputStream = response.body().toStream()
                        val br = InputStreamReader(write)
                        val str = BufferedReader(br).readText()
                        val parsed = Parser().parse(StringBuilder(str))as JsonArray<JsonObject>
                        var i = 0
                        parsed.forEach{ el ->
                            Log.d("tar", el.string("name") as String)
//                            var st =
                        }
                        println(i)
//                        val bra1 = Klaxon().parseArray<Array<Any>>(InputStreamReader(write))
//                        println(bra1)
                    }
                }
            }


//        val parser: Parser = Parser.default()
//        val stringBuilder: StringBuilder = StringBuilder("{\"name\":\"Cedric Beust\", \"age\":23}")
//        val json = (parser.parse(stringBuilder) as JsonObject)
//        println(json)





        return root
    }
}