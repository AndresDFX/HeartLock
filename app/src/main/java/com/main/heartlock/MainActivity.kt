package com.main.heartlock

import android.annotation.SuppressLint

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.MotionEvent
import android.view.View
import com.main.heartlock.R

import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide();

        val buttonsNo = arrayOf(
            button_no_0,
            button_no_1,
            button_no_2,
            button_no_3,
            button_no_4,
            button_no_5
        )

        for ((index, button_no) in buttonsNo.withIndex()){
            button_no.visibility = View.INVISIBLE
            button_no.setOnTouchListener() { v, event ->
                if (event.action == MotionEvent.ACTION_DOWN){
//                    for(button in buttonsNo){
//                        button_no.visibility = View.INVISIBLE
//                    }
                    button_no.visibility = View.INVISIBLE
                    do{
                        val rand = (0..5).random()
                        if (rand != index){
                            buttonsNo[rand].visibility = View.VISIBLE
                        }
                    }while (rand == index)
                }

                v?.onTouchEvent(event) ?: true
            }
        }

        buttonsNo[5].visibility = View.VISIBLE

        button_yes.setOnClickListener{
            intent = Intent(applicationContext, YesActivity::class.java)
            startActivity(intent)
        }

    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
}
