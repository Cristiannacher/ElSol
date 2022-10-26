package com.example.elsol

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = ArrayList<Sol>()
        items.add(Sol(R.drawable.corona_solar,R.string.corona_solar))
        items.add(Sol(R.drawable.erupcionsolar,R.string.erupcion_solar))
        items.add(Sol(R.drawable.espiculas,R.string.espiculas))
        items.add(Sol(R.drawable.filamentos,R.string.filamentos))
        items.add(Sol(R.drawable.magnetosfera,R.string.magnetosfera))
        items.add(Sol(R.drawable.manchasolar,R.string.mancha_Solar))


        val recView = findViewById<RecyclerView>(R.id.recyclerView)
        recView.setHasFixedSize(true)

        val adaptador = Sol_Adapter(items)
        recView.adapter = adaptador
        recView.layoutManager = GridLayoutManager(this,2)

        adaptador.onClick = {

        }

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId.equals(R.id.compara)) {
            val i = Intent(this, ComparaActivity::class.java)
            startActivity(i)
        }
        return true
    }

}