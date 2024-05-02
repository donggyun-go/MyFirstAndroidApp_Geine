package com.neppplus.myfirstandroidapp_geine

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var dbHelper: SQLiteHelper  // 데이터베이스 헬퍼 객체 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        dbHelper = SQLiteHelper(this)  // SQLiteHelper 인스턴스화

        // 로그인 버튼, 아이디 필드, 패스워드 필드를 찾고 클릭 리스너 설정
        val loginButton = findViewById<Button>(R.id.login)
        val idEditText = findViewById<EditText>(R.id.idEdt)
        val passwordEditText = findViewById<EditText>(R.id.passwordEdt)

        loginButton.setOnClickListener {
            val inputId = idEditText.text.toString().trim()
            val inputPwd = passwordEditText.text.toString().trim()
            // 데이터베이스를 통해 로그인 로직 실행
            if (dbHelper.checkUser(inputId, inputPwd)) {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
        }

        // 회원가입 TextView 클릭 리스너 설정
        val signupTextView = findViewById<TextView>(R.id.signupText)
        signupTextView.setOnClickListener {
            Toast.makeText(this, "회원가입 화면으로 이동합니다.", Toast.LENGTH_SHORT).show()
            // 회원가입 화면으로 이동하기 위한 Intent 생성
            val intent = Intent(this, RegistActivity::class.java)
            startActivity(intent)
        }
    }
}
