package com.example.class_2_13_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    // the name of the file you'll be saving to
    var  my_file = "MySharedFile"
    lateinit var saved_var: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saved_var = findViewById(R.id.etStuff1)


    }

    override fun onResume() {
        super.onResume()
        // opens up the shared prefeneces file
        val SP = getSharedPreferences(my_file, MODE_PRIVATE)
        // sets key1 to the string saved with the key "name"
        val key1 = SP.getString("name","")


        saved_var.setText(key1)

    }

    override fun onPause() {
        super.onPause()
        val SP = getSharedPreferences(my_file, MODE_PRIVATE)

        // opens the file for editting
        val myEdit = SP.edit()
        // adds the key value pair
        myEdit.putString("name", saved_var!!.text.toString())
        // saves what you just did
        myEdit.commit()

    }
}