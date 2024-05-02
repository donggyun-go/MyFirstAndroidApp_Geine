package com.neppplus.myfirstandroidapp_geine

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistActivity : AppCompatActivity() {
    private lateinit var dbHelper: SQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_main)

        // DBHelper 인스턴스 생성
        dbHelper = SQLiteHelper(this)

        // 사용자 입력 필드 찾기
        val idEditText = findViewById<EditText>(R.id.idEdt)
        val passwordEditText = findViewById<EditText>(R.id.passwordEdt)
        val nicknameEditText = findViewById<EditText>(R.id.nicknameEdt) // ID 확인 필요
        val genderRadioGroup = findViewById<RadioGroup>(R.id.genderRadioGroup) // 레이아웃에 추가해야 함

        // 등록 버튼 이벤트 처리
        val registerButton = findViewById<Button>(R.id.commit)
        registerButton.setOnClickListener {
            val id = idEditText.text.toString()
            val password = passwordEditText.text.toString()
            val nickname = nicknameEditText.text.toString()
            val selectedGenderId = genderRadioGroup.checkedRadioButtonId
            val gender = findViewById<RadioButton>(selectedGenderId).text.toString()

            // 입력값을 데이터베이스에 저장
            val success = dbHelper.insertUser(id, password, nickname, gender)
            if (success) {
                Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "회원가입 실패", Toast.LENGTH_SHORT).show()
            }
        }

        // 취소 버튼 이벤트 처리
        val cancelButton = findViewById<Button>(R.id.cancelBtn)
        cancelButton.setOnClickListener {
            Toast.makeText(this, "로그인 화면으로 이동합니다.", Toast.LENGTH_SHORT).show()
            finish() // 현재 액티비티 종료
        }
    }
}
