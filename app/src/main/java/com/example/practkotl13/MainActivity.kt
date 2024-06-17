package com.example.practkotl13

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imageView: ImageView = findViewById(R.id.imageView)
        val textView: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.button)
        val popupMenu = androidx.appcompat.widget.PopupMenu(this, imageView)
        popupMenu.inflate(R.id.popupmenu)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId){
                R.id.menu1 -> {
                    textView.text = "Нажат пункт PopupMenu1"
                    true
                }
                R.id.menu2 -> {
                    textView.text = "Нажат пункт PopupMenu2"
                    true
                }
                R.id.menu3 -> {
                    textView.text = "Нажат пункт PopupMenu3"
                    true
                }
                else -> false
            }
        }
        imageView.setOnClickListener{
            popupMenu.show()
        }
    }
}