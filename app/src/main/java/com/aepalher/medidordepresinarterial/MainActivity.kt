package com.aepalher.medidordepresinarterial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRead = findViewById<Button>(R.id.button38)
        btnRead.setOnClickListener{
            val intent = Intent(this, ReadingActivity::class.java)
            startActivity(intent)
        }

        val btnTrends = findViewById<Button>(R.id.button39)
        btnTrends.setOnClickListener{
            val intent = Intent(this, TrendsActivity::class.java)
            startActivity(intent)
        }

        val btnBT = findViewById<Button>(R.id.button40)
        btnBT.setOnClickListener{
            val intent = Intent(this, BluetoothActivity::class.java)
            startActivity(intent)
        }

        val btnRec = findViewById<Button>(R.id.button41)
        btnRec.setOnClickListener{
            val intent = Intent(this, RecommendationsActivity::class.java)
            startActivity(intent)
        }

        val btnConfig = findViewById<Button>(R.id.button42)
        btnConfig.setOnClickListener{
            val intent = Intent(this, ConfigActivity::class.java)
            startActivity(intent)
        }
    }
}