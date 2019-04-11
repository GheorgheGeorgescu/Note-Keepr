package com.example.notio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    // var FILE_NAME:String = "example.txt"
    // var FILE_NAME = findViewById<EditText>(R.id.file_text)
    var file = FILE_NAME.text.toString()

    //val fileName = findViewById<EditText>(R.id.file_text)
    // val fileName = findViewById<EditText>(R.id.edit_text)
    // val fileData = findViewById<EditText>(R.id.edit_text)

    var mEditText : EditText = findViewById(R.id.edit_text)//? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //mEditText = findViewById(R.id.edit_text)
        // var svb = findViewById<Button>(R.id.button_save)
        //  svb.setText()
    }

    fun save (v: View) {
        var text:String = mEditText.text.toString()
        this.openFileOutput(file, Context.MODE_PRIVATE).use {
            it.write(text.toByteArray())
        }

        // var fos:FileOutputStream? = null

        // try {
        //  fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE)
        //  fos.write(text.toByteArray())

        mEditText!!.text.clear()
        Toast.makeText(this, "Saved to " + filesDir + "/" + file, Toast.LENGTH_LONG).show()


        /*  } catch (e: FileNotFoundException) {
              e.printStackTrace()
          } catch (e: IOException) {
              e.printStackTrace()
          } finally {
              if (fos!= null) {
               try {
                   fos.close()
               } catch (e: IOException) {
                   e.printStackTrace()
               }
              }
          } */
    }

    fun load (v: View) {
        var fis: FileInputStream //? = null
        // try {
        fis = openFileInput(file)
        var isr:InputStreamReader = InputStreamReader(fis)
        var br:BufferedReader = BufferedReader(isr)
        var sb:StringBuilder = StringBuilder()
        var text: String? = null
        text = br.readLine()
        while(text != null) {
            sb.append(text).append("\n")
            text = br.readLine()
        }

        mEditText!!.setText(sb.toString())
        /* } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } finally {
            if (openFileInput(FILE_NAME) != null) { //fis instead of openFileInput(FILE_NAME)
                try {
                    openFileInput(FILE_NAME).close() // fis instead openFileInput(FILE_NAME)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        } */
    }
}
