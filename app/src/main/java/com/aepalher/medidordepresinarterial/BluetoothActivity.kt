package com.aepalher.medidordepresinarterial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.view.View
import android.widget.Button

class BluetoothActivity : AppCompatActivity() {

    private var bluetoothAdapter: BluetoothAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dispbt)

        // Obtén la instancia del adaptador Bluetooth
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()

        // Referencia a los botones en el diseño
        val btnEnableBluetooth: Button = findViewById(R.id.btnEnableBluetooth)
        val btnDisableBluetooth: Button = findViewById(R.id.btnDisableBluetooth)

        // Configura el evento de clic para activar el Bluetooth
        btnEnableBluetooth.setOnClickListener {
            enableBluetooth()
        }

        // Configura el evento de clic para desactivar el Bluetooth
        btnDisableBluetooth.setOnClickListener {
            disableBluetooth()
        }
    }
    private fun enableBluetooth() {
        if (bluetoothAdapter != null && !bluetoothAdapter!!.isEnabled) {
            // Si el Bluetooth no está habilitado, solicita habilitarlo
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivity(enableBtIntent)
        }
    }

    private fun disableBluetooth() {
        if (bluetoothAdapter != null && bluetoothAdapter!!.isEnabled) {
            // Si el Bluetooth está habilitado, deshabilítalo
            bluetoothAdapter!!.disable()
        }
    }
}