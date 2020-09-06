package com.example.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.github.kittinunf.fuel.httpGet
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.plugins.RxJavaPlugins


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


//        val objectRx = Observable.create(subscriber -> {
//
//        })

//        val test = "http://8f947002cc2e.ngrok.io/mobile-json"
//            .httpGet().subscribe()

//            .response{request, response, result ->
//                when(result) {
//                    is Result.Failure -> {
//                        val ex = result.getException()
//                        Log.d("err -------------------", ex.toString())
//                    }
//                    is Result.Success -> {
//
//                        val write = response.body().toStream()
//                        write.read()
////                        val str = (response is String)
////                        println(result)
////                        println(bod.length)
//                        println(write)
////                        println(response)
//                    }
//                }
//            }


        return root
    }
}