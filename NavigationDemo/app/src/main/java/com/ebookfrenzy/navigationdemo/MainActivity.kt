package com.ebookfrenzy.navigationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.navigationdemo.ui.main.MainFragment
import android.net.Uri

class MainActivity : AppCompatActivity(),

    SecondFragment.OnFragmentInteractionListener{



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
      //  if (savedInstanceState == null) {
         //   supportFragmentManager.beginTransaction()
         //       .replace(R.id.container, MainFragment.newInstance())
        //        .commitNow()
        //}
    }
        override fun onFragmentInteraction(uri:Uri){
        }
    }
