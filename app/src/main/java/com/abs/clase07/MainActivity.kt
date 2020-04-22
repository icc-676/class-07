package com.abs.clase07

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import java.io.File


class MainActivity : AppCompatActivity(), ProductFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.root_layout, ProductFragment.newInstance(), "productList")
                .commit()
        }
    }
    override fun onListFragmentInteraction(item: Product?) {
        if (item != null) {
            val file = File(this.filesDir, "cart.txt")
            file.createNewFile()
            file.appendText(item.name+"\n")
            //El archivo esta guardado en data/user/0/nombre del proyecto
            //cart.txt
        }
    }
}

data class Product(val name:String,val price:String,val url: String) {

}