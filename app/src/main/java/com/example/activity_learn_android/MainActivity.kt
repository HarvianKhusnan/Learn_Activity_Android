package com.example.activity_learn_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView
    /*
    Kode diatas meruapakan kode untuk memanipulasi konten view atau mudahnya
    untuk variable yang akan di isi oleh object-object yang ada di xml
     */

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // onCreate mudahnya adalah main() jika dalam pemrograman biasa
        // Disini onCreate akan mengatur semua proses inisialisasi pada xml dan akan dijalankan
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // kode ini berfungsi untuk menampikkan tampilan yang sudah disusun di xml

        edtWidth= findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)
        /*
        kode diatas merupakan kode yang ditunjukan untuk mengisi variable yang sudah
        di assign sebelumnya dan di isi oleh object-object yang terdapat di xml berdasarkan
        id yang sudah di set di xml.
         */

        btnCalculate.setOnClickListener(this) //setOnClickListener berfungsi untuk memberi interaksi ketika tombol diklik
        //keyword This memiliki yang merujuk pada activity saat ini.

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_calculate) {
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()
            /*
            Kode diatas berfungsi untuk mengambil inputan yang terdapat pada editText dan
            trim digunakan untuk menghiraukan spasi jika ada inputan yang menggunakan spasi
             */

            var isEmptyFields = false

            if (inputWidth.isEmpty()) {
                isEmptyFields = true
                edtWidth.error = "Field tidak bisa kosong"
            }

            if(inputHeight.isEmpty()) {
                isEmptyFields = true
                edtHeight.error = "Field tidak boleh kosong"
            }
            if(inputLength.isEmpty()) {
                isEmptyFields = true
                edtLength.error = "Field ini tidak boleh kosong"
            }
            if (!isEmptyFields) {
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tvResult.text = volume.toString()
            }

        }
    }
}