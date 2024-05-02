package com.neppplus.myfirstandroidapp_geine

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class RegistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_main)

        val cancelBtn = findViewById<TextView>(R.id.cancelBtn)
        cancelBtn.setOnClickListener {
            Toast.makeText(this, "로그인 화면으로 이동합니다.", Toast.LENGTH_SHORT).show()
            // MainActivity로 돌아가기 위한 Intent 생성
            val intent = Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            startActivity(intent)
        }
    }
}