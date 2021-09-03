package com.neppplus.colosseum20210903

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.colosseum20210903.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        signInBtn.setOnClickListener {
//            입력한 아이디/비번을 변수로 저장
            val inputId = emailEdt.text.toString()
            val inputPw = passwordEdt.text.toString()



//            서버에 이 데이터가 회원이 맞는지 확인 요청 => 로그인 시도

            ServerUtil.postRequestSignIn(inputId, inputPw)



        }

    }

    override fun setValues() {
    }
}