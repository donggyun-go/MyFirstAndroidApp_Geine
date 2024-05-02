package com.neppplus.myfirstandroidapp_geine

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // 뷰에 대한 인셋 적용
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 로그인 버튼, 아이디 필드, 패스워드 필드를 찾고 클릭 리스너 설정
        val loginButton = findViewById<Button>(R.id.login)
        val idEditText = findViewById<EditText>(R.id.idEdt)
        val passwordEditText = findViewById<EditText>(R.id.passwordEdt)

        loginButton.setOnClickListener {
            val inputId = idEditText.text.toString()
            val inputPwd = passwordEditText.text.toString()
            // 로그인 로직 실행
            if(inputId == "admin@test.com" && inputPwd == "qwer") {
                Toast.makeText(this, "관리자입니다.", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
        }
        // 회원가입 TextView 찾기 및 클릭 리스너 설정
        val signupTextView = findViewById<TextView>(R.id.signupText)
        signupTextView.setOnClickListener {
            Toast.makeText(this, "회원가입 화면으로 이동합니다.", Toast.LENGTH_SHORT).show()
            // Intent로 다른 Activity 시작
            val intent = Intent(this, RegistActivity::class.java)
            startActivity(intent)
        }
    }
}
