package com.paypal.unittesingdemo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ViewsActivity : AppCompatActivity() {

    lateinit var continueButton: Button
    lateinit var nameEditText: EditText
    lateinit var msgText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_views)

        continueButton = findViewById(R.id.continueB)
        nameEditText = findViewById(R.id.nameE)
        msgText = findViewById(R.id.msgT)

        continueButton.setOnClickListener {
            val name = nameEditText.text.toString()
            msgText.setText("Welcome $name")
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}