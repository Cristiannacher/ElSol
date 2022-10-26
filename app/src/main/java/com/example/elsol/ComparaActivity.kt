package com.example.elsol

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ComparaActivity : AppCompatActivity() {
 override fun onCreate(savedInstanceState: Bundle?){
     super.onCreate(savedInstanceState)
     setContentView(R.layout.activity_compara)

     val planetas = arrayListOf<Planeta>()
     planetas.add(Planeta("Mercury","0,382","0,387","5400"))
     planetas.add(Planeta("Venus","0,949","0,723","5250"))
     planetas.add(Planeta("Tierra","1","1","5520"))
     planetas.add(Planeta("Marte","0,53","1,542","3960"))
     planetas.add(Planeta("Jupiter","11,2","5,203","1350"))
     planetas.add(Planeta("Saturno","9,41","9,539","700"))
     planetas.add(Planeta("Urano","3,38","19,81","1200"))
     planetas.add(Planeta("Neptuno","3,81","30,07","1500"))
     planetas.add(Planeta("Pluton","???","39,44","5?"))

     val nombresPlanetas = arrayListOf("Mercury","Venus","Tierra","Marte","Jupiter","Saturno","Urano","Neptuno","Pluton")
     val lista_planetas1 = findViewById(R.id.autoCompleteTextView1) as AutoCompleteTextView
     val lista_planetas2 = findViewById(R.id.autoCompleteTextView2) as AutoCompleteTextView
     val adaptador = ArrayAdapter<String> (this, android.R.layout.simple_dropdown_item_1line, nombresPlanetas)
     lista_planetas1.setAdapter(adaptador)
     lista_planetas1.threshold = 1
     lista_planetas2.setAdapter(adaptador)
     lista_planetas2.threshold = 1

     val diametro1: TextView = findViewById(R.id.textViewDiametro1)
     val distancia1: TextView = findViewById(R.id.textViewDistancia1)
     val densidad1: TextView = findViewById(R.id.textViewDensidad1)
     val diametro2: TextView = findViewById(R.id.textViewDiametro2)
     val distancia2: TextView = findViewById(R.id.textViewDistancia2)
     val densidad2: TextView = findViewById(R.id.textViewDensidad2)

     lista_planetas1.setOnItemClickListener { adapterView, view, i, l ->
         val planeta = adapterView.getItemAtPosition(i)
         val indice = nombresPlanetas.indexOf(planeta)
         diametro1.setText(planetas.get(indice).diametro)
         distancia1.setText(planetas.get(indice).distanciaSol)
         densidad1.setText(planetas.get(indice).densidad)
     }
     lista_planetas2.setOnItemClickListener { adapterView, view, i, l ->
         val planeta = adapterView.getItemAtPosition(i)
         val indice = nombresPlanetas.indexOf(planeta)
         diametro2.setText(planetas.get(indice).diametro)
         distancia2.setText(planetas.get(indice).distanciaSol)
         densidad2.setText(planetas.get(indice).densidad)
     }





 }
}
