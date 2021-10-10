package com.example.activitylifecycletask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

     var shownView = 0
    private lateinit var view : TextView



    companion object {
        const val TAG = "mainActivity"
        const val KEYVIEW = " shown result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate called")

//        if (savedInstanceState != null){
//            view.text = savedInstanceState.getString(KEYVIEW)
//        }

        val btnAdd : Button = findViewById(R.id.addBtn)
        view = findViewById(R.id.view)
        val btnSubtract : Button = findViewById(R.id.subtractBtn)
        val btnClear : Button = findViewById(R.id.clearBtn)


        fun addValue (){
            shownView++
            view.text= shownView.toString()
        }
        btnAdd.setOnClickListener {
            addValue()
            btnClear.visibility = View.VISIBLE
        }



        fun subtractValue(){
            shownView--
            view.text = shownView.toString()
        }
        btnSubtract.setOnClickListener {
            subtractValue()
            btnClear.visibility = View.VISIBLE
        }



        btnClear.setOnClickListener {
            view.text = null
            btnClear.visibility = View.INVISIBLE
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop Called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEYVIEW, view.text.toString())

        Log.d(TAG, "onSaveInstance Called")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstance called")
        view.text = savedInstanceState.getString(KEYVIEW)

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart Called")
    }
}