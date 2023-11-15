package com.aepalher.medidordepresinarterial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.LineData

class TrendsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trends)

        val lineChart: LineChart = findViewById(R.id.lineChart)

        // Datos de ejemplo (reemplazar esto con datos del dispositivo)
        val medidasPresionArterial = listOf(
            PresionArterial(System.currentTimeMillis() - 20 * 86400000, 122f, 60f),
            PresionArterial(System.currentTimeMillis() - 19 * 86400000, 118f, 70f),
            PresionArterial(System.currentTimeMillis() - 18 * 86400000, 120f, 65f),
            PresionArterial(System.currentTimeMillis() - 17 * 86400000, 115f, 85f),
            PresionArterial(System.currentTimeMillis() - 16 * 86400000, 110f, 84f),
            PresionArterial(System.currentTimeMillis() - 15 * 86400000, 117f, 87f),
            PresionArterial(System.currentTimeMillis() - 14 * 86400000, 125f, 85f),
            PresionArterial(System.currentTimeMillis() - 13 * 86400000, 130f, 90f),
            PresionArterial(System.currentTimeMillis() - 12 * 86400000, 123f, 85f),
            PresionArterial(System.currentTimeMillis() - 11 * 86400000, 129f, 80f),
            PresionArterial(System.currentTimeMillis() - 10 * 86400000, 130f, 90f),
            PresionArterial(System.currentTimeMillis() - 9 * 86400000, 128f, 91f),
            PresionArterial(System.currentTimeMillis() - 8 * 86400000, 123f, 84f),
            PresionArterial(System.currentTimeMillis() - 7 * 86400000, 120f, 86f),
            PresionArterial(System.currentTimeMillis() - 6 * 86400000, 118f, 79f),
            PresionArterial(System.currentTimeMillis() - 5 * 86400000, 115f, 78f),
            PresionArterial(System.currentTimeMillis() - 4 * 86400000, 120f, 80f),
            PresionArterial(System.currentTimeMillis() - 3 * 86400000, 127f, 85f),
            PresionArterial(System.currentTimeMillis() - 2 * 86400000, 125f, 87f),
            PresionArterial(System.currentTimeMillis() - 86400000, 130f, 85f),
            PresionArterial(System.currentTimeMillis(), 128f, 88f)
        )

        // Configuración del conjunto de datos
        val entriesSistolica = mutableListOf<Entry>()
        val entriesDiastolica = mutableListOf<Entry>()

        medidasPresionArterial.forEachIndexed { index, medida ->
            entriesSistolica.add(Entry(index.toFloat(), medida.sistolica))
            entriesDiastolica.add(Entry(index.toFloat(), medida.diastolica))
        }

        val dataSetSistolica = LineDataSet(entriesSistolica, "Presión Sistólica")
        dataSetSistolica.color = Color.BLUE
        dataSetSistolica.valueTextColor = Color.BLACK

        val dataSetDiastolica = LineDataSet(entriesDiastolica, "Presión Diastólica")
        dataSetDiastolica.color = Color.RED
        dataSetDiastolica.valueTextColor = Color.BLACK

        // Configuración del gráfico
        val lineData = LineData(dataSetSistolica, dataSetDiastolica)
        lineChart.data = lineData

        // Configuración del eje X (fechas)
        val xAxis: XAxis = lineChart.xAxis
        xAxis.isEnabled = true // Desactivar las etiquetas del eje X
        xAxis.position = XAxis.XAxisPosition.BOTTOM

        // Actualizar el gráfico
        lineChart.invalidate()
    }
}