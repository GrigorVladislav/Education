package com.example.lecture1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var count:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        left_Button.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                validateLeft()
                numRand()
                result()
            }
        })
        right_Button.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                validateRight()
                numRand()
                result()

            }
        })
    }

    override fun onResume() {
        super.onResume()
        numRand()
    }
    private fun result()
    {
        if (count==5)
        {
            count=0
            Toast.makeText(this,"You Won!!!",Toast.LENGTH_SHORT).show()

        }

    }

    private fun setResult()
    {
        if (count>=0)
        {
            textResult.text=count.toString()
        }

    }

    private fun validateLeft() {
        val leftBut:Int=left_Button.text.toString().toInt()
        val rightBut:Int=right_Button.text.toString().toInt()
        if (leftBut>rightBut)
        {
            count++
        }
        else if(leftBut==rightBut)
        {
        }
        else
        {
            if (count>0){
                count--
            }
        }

        setResult()
    }

    private fun validateRight() {
        val leftBut:Int=left_Button.text.toString().toInt()
        val rightBut:Int=right_Button.text.toString().toInt()
        if (leftBut<rightBut)
        {
            count++
        }
        else if(rightBut==leftBut)
        {

        }
        else
        {
            if (count>0){
                count--
            }
        }
        setResult()
    }

    fun numRand()
    {
        left_Button.text = (1..10).random().toString()
        right_Button.text = (1..10).random().toString()
    }
}
