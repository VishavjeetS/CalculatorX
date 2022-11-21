package com.example.calculatorx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var exp:TextView
    lateinit var finalnum:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        exp = findViewById(R.id.tvExpression)
        finalnum = findViewById(R.id.tvResult)
    }

    var dot=false
    var v = true
    fun numberevent(view: View) {
        if(v) {
            tvExpression.setText("")
        }
        var bclickvalue = exp.getText().toString()
        v =false
        val buSelect= view as TextView
        when(buSelect.id){
            b1.id -> {
                bclickvalue+="1"
            }
            b2.id -> {
                bclickvalue+="2"
            }
            b3.id -> {
                bclickvalue+="3"
            }
            b4.id -> {
                bclickvalue+="4"
            }
            b5.id -> {
                bclickvalue+="5"
            }
            b6.id -> {
                bclickvalue+="6"
            }
            b7.id -> {
                bclickvalue+="7"
            }
            b8.id -> {
                bclickvalue+="8"
            }
            b9.id -> {
                bclickvalue+="9"
            }
            b0.id -> {
                bclickvalue+="0"
            }
            bdot.id -> {
                if(dot){
                    bclickvalue+="."
                }
                dot = true
            }
        }
        exp.setText(bclickvalue)
    }

    fun clear(view: View) {
        tvExpression.setText(" ")
        tvResult.setText(" ")
    }

    fun back(view: View) {
        var str: String = tvExpression.getText().toString()
        if (str.length >= 1) {
            str = str.substring(0, str.length - 1)
            tvExpression.setText(str)
        }
        if (str.length < 1) {
            tvExpression.setText(" ")
        }
    }

    var op=""
    var oldNumber=""

    fun operator(view: View) {
        when(view.id)
        {
            R.id.into->
            {
                op="X"
                v=true
                Toast.makeText(this,"X",Toast.LENGTH_SHORT).show()
            }
            R.id.divide->
            {
                op="÷"
                v=true
                Toast.makeText(this,"/",Toast.LENGTH_SHORT).show()
            }
            R.id.minus->
            {
                op="-"
                v=true
                Toast.makeText(this,"-",Toast.LENGTH_SHORT).show()
            }
            R.id.plus->
            {
                op="+"
                v=true
                Toast.makeText(this,"+",Toast.LENGTH_SHORT).show()
            }
        }
        oldNumber=exp.getText().toString()
        v=true
        dot=false
    }

    fun equal(view: View) {
        var newnum = exp.getText().toString()
        var finaln:Double? = null
        if(!tvExpression.getText().toString().isEmpty()){
            when(op){
                "X" -> {
                    finaln = (oldNumber.toDouble()) * (newnum.toDouble())
                }
                "-" -> {
                    finaln = (oldNumber.toDouble()) - (newnum.toDouble())
                }
                "÷" -> {
                    finaln = (oldNumber.toDouble()) / (newnum.toDouble())
                }
                "+" -> {
                    finaln = (oldNumber.toDouble()) + (newnum.toDouble())
                }
            }
            var solution = finaln?.times(10.0)?.let { Math.round(it) }?.div(10.0)
            tvResult.setText(solution.toString())
            v = true
        }
        else if(op == "" && newnum==""){
            tvResult.setText(oldNumber)
        }
        else if(tvExpression.text==""){
            tvResult.setText(oldNumber)
        }
        else{
            tvResult.setText("")
        }
    }
}