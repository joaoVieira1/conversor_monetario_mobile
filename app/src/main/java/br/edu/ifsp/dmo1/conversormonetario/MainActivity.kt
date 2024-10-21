package br.edu.ifsp.dmo1.conversormonetario

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private val DOLLAR = 5.50
    private lateinit var inputEditText: EditText
    private lateinit var toDollarButton: Button
    private lateinit var toRealButton: Button
    private lateinit var outputTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findById();
        configClickListener()
    }

    private fun findById(){
        inputEditText = findViewById(R.id.edittext_value)
        toDollarButton = findViewById(R.id.button_convert_to_dollar)
        toRealButton = findViewById(R.id.button_convert_to_real)
        outputTextView = findViewById(R.id.textview_output)
    }

    private fun configClickListener(){
        toDollarButton.setOnClickListener(this)
        toRealButton.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(view == toDollarButton){
            dollarConversion()
        }else if(view == toRealButton){
            realConversion()
        }
    }

    private fun getValue(): Double{
        var value = try{
            inputEditText.text.toString().toDouble()
        }catch (e: NumberFormatException){
            0.0
        }
        return value
    }

    private fun dollarConversion(){
        var value = getValue()
        value = value / DOLLAR

        outputTextView.text = "U$ $value"
    }

    private fun realConversion(){
        var value = getValue()
        value = value * DOLLAR

        outputTextView.text = "R$ $value"
    }

}