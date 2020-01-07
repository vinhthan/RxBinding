package com.example.rxbindingreplacelivedata

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //EditText
        RxTextView.textChanges(edt).subscribe { it ->
            var str : String = edt.text.toString()
            //Toast.makeText(this, "$str", Toast.LENGTH_SHORT).show()
            txv.text = edt.text.toString()
        }

        //Buttun
        RxView.clicks(btn).subscribe {
            Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
            txv2.text = edt.text.toString()
        }

        //TextView
        RxView.clicks(txv).subscribe {
            txv.text = ""
            Toast.makeText(this, "clear", Toast.LENGTH_SHORT).show()
        }

    }
}
