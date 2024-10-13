package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    // Оголошення глобальних зміних
    lateinit var enterCoal: EditText
    lateinit var enterMasut: EditText
    lateinit var enterGas: EditText
    lateinit var button: Button
    var GasDensity = 0.273

    lateinit var finalkCoal: TextView
    lateinit var finalECoal: TextView
    lateinit var finalkMasut: TextView
    lateinit var finalEMasut: TextView
    lateinit var finalkGas: TextView
    lateinit var finalEGas: TextView
    lateinit var backButton: Button

    lateinit var notCT0: TextView
    lateinit var notCT1: TextView
    lateinit var notCT2: TextView
    lateinit var notCT3: TextView
    lateinit var notCT4: TextView
    lateinit var notCT5: TextView
    lateinit var notCT6: TextView
    lateinit var notCT7: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Отримуємо посилання на поля введення
        enterCoal = findViewById(R.id.field1)
        enterMasut = findViewById(R.id.field2)
        enterGas = findViewById(R.id.field3)

        // Отримуємо посилання на поля виведення
        finalkCoal = findViewById(R.id.changeText1)
        finalECoal = findViewById(R.id.changeText4)
        finalkMasut = findViewById(R.id.changeText2)
        finalEMasut = findViewById(R.id.changeText5)
        finalkGas = findViewById(R.id.changeText3)
        finalEGas = findViewById(R.id.changeText6)

        // Отримуємо посилання на кнопки
        button= findViewById(R.id.button)
        backButton = findViewById(R.id.backButton)

        // Отримуємо посилання на текстові поля
        notCT0 = findViewById(R.id.textView)
        notCT1 = findViewById(R.id.notChangeText1)
        notCT2 = findViewById(R.id.notChangeText2)
        notCT3 = findViewById(R.id.notChangeText3)
        notCT4 = findViewById(R.id.textView2)
        notCT5 = findViewById(R.id.notChangeText4)
        notCT6 = findViewById(R.id.notChangeText5)
        notCT7 = findViewById(R.id.notChangeText6)

        // Обробка кнопки "Розрахувати"
        button.setOnClickListener{
            showResultWind()
            showResult(calculateResult())
        }
        // Обробка кнопки "Назад"
        backButton.setOnClickListener{
            showInput()
        }
    }

    // Функція для виконання розрахунків
    fun calculateResult(): Map<String, Any>{

            val BCoal = enterCoal.text.toString().toDouble()
            val BMasut = enterMasut.text.toString().toDouble()
            val BGas = enterGas.text.toString().toDouble() * GasDensity

            // Коефіцієнт емісії та валовий викид для вугілля
            val kCoal = "%.2f".format(10.0.pow(6).toInt()/20.47*0.8*25.2/(100-1.5)*(1-0.985))
            val ECoal = "%.2f".format(10.0.pow(-6)*kCoal.toDouble()*20.47*BCoal)
            // Коефіцієнт емісії та валовий викид для мазуту
            val kMasut = "%.2f".format(10.0.pow(6).toInt()/39.48*1*0.15/(100-0)*(1-0.985))
            val EMasut = "%.2f".format(10.0.pow(-6)*kMasut.toDouble()*39.48*BMasut)
            // Коефіцієнт емісії та валовий викид для природнього газу
            val kGas = "%.2f".format(10.0.pow(6).toInt()/33.08*0*0/(100-0)*(1-0.985))
            val EGas = "%.2f".format(10.0.pow(-6)*kGas.toDouble()*33.08*BGas)

            // Повертаємо результати обчислень
            return mapOf(
                    "finalkCoal" to kCoal,
                    "finalECoal" to ECoal,
                    "finalkMasut" to kMasut,
                    "finalEMasut" to EMasut,
                    "finalkGas" to kGas,
                    "finalEGas" to EGas,
                )
    }

    // Виведення результатів
    fun showResult(results: Map<String, Any>) {
        val kCoal = results["finalkCoal"].toString()
        val ECoal = results["finalECoal"].toString()
        val kMasut = results["finalkMasut"].toString()
        val EMasut = results["finalEMasut"].toString()
        val kGas = results["finalkGas"].toString()
        val EGas = results["finalEGas"].toString()

        finalkCoal.text = kCoal + " г/ГДж"
        finalECoal.text = ECoal + " т"
        finalkMasut.text = kMasut + " г/ГДж"
        finalEMasut.text = EMasut + " т"
        finalkGas.text = kGas + " г/ГДж"
        finalEGas.text = EGas + " т"
    }

    fun showResultWind() {
        notCT0.visibility = View.GONE
        enterCoal.visibility = View.GONE
        enterMasut.visibility = View.GONE
        enterGas.visibility = View.GONE
        button.visibility = View.GONE

        finalkCoal.visibility = View.VISIBLE
        finalECoal.visibility = View.VISIBLE
        finalkMasut.visibility = View.VISIBLE
        finalEMasut.visibility = View.VISIBLE
        finalkGas.visibility = View.VISIBLE
        finalEGas.visibility = View.VISIBLE
        backButton.visibility = View.VISIBLE
        notCT1.visibility = View.VISIBLE
        notCT2.visibility = View.VISIBLE
        notCT3.visibility = View.VISIBLE
        notCT4.visibility = View.VISIBLE
        notCT5.visibility = View.VISIBLE
        notCT6.visibility = View.VISIBLE
        notCT7.visibility = View.VISIBLE
    }

    fun showInput () {
        notCT4.visibility = View.GONE
        finalkCoal.visibility = View.GONE
        finalECoal.visibility = View.GONE
        finalkMasut.visibility = View.GONE
        finalEMasut.visibility = View.GONE
        finalkGas.visibility = View.GONE
        finalEGas.visibility = View.GONE
        backButton.visibility = View.GONE
        notCT1.visibility = View.GONE
        notCT2.visibility = View.GONE
        notCT3.visibility = View.GONE
        notCT5.visibility = View.GONE
        notCT6.visibility = View.GONE
        notCT7.visibility = View.GONE

        notCT0.visibility = View.VISIBLE
        enterCoal.visibility = View.VISIBLE
        enterMasut.visibility = View.VISIBLE
        enterGas.visibility = View.VISIBLE
        button.visibility = View.VISIBLE
    }
}