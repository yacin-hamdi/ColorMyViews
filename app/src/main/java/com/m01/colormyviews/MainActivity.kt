package com.m01.colormyviews

import android.R.color.black
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.m01.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)




        setListener()
    }

    private fun setListener(){
        binding.apply{
            val clickableViews: List<View> = listOf(boxOneId, boxTwoId, boxThreeId,
                                boxFourId, boxFiveId, constrainLayout, redButton, greenButton, buttonBlue)
            clickableViews.forEach { item ->
                item.setOnClickListener{
                    makeColored(it)
                }
            }
        }

    }

    private fun makeColored(view:View){
        when(view.id){
            R.id.box_one_id -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_id -> view.setBackgroundColor(Color.GRAY)
            R.id.box_three_id -> view.setBackgroundResource(android.R.color.black)
            R.id.box_four_id -> view.setBackgroundResource(android.R.color.holo_red_dark)
            R.id.box_five_id -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.red_button -> binding.boxThreeId.setBackgroundResource(R.color.red)
            R.id.green_button -> binding.boxFourId.setBackgroundResource(R.color.green)
            R.id.button_blue -> binding.boxFiveId.setBackgroundResource(R.color.blue)
            else -> view.setBackgroundResource(android.R.color.darker_gray)
        }
    }
}