package com.aepalher.medidordepresinarterial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Date
import android.os.Handler
import java.util.Locale

class ReadingActivity : AppCompatActivity() {
    private val handler = Handler()
    private lateinit var textViewFechaHora: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reading)
        textViewFechaHora = findViewById<TextView>(R.id.textView6)
        handler.post(updateTimeRunnable)
    }

    private val updateTimeRunnable = object : Runnable {
        override fun run() {
            val formatoFechaHora = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
            val fechaHoraActual = Date()
            val fechaHoraFormateada = formatoFechaHora.format(fechaHoraActual)

            textViewFechaHora.text = "Fecha y Hora Actual: $fechaHoraFormateada"

            handler.postDelayed(this, 1000)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(updateTimeRunnable)
    }
}