package com.neppplus.colosseum20210903

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.neppplus.colosseum20210903.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

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

//            서버 로그인 시도 => 서버에 다녀오면 어떡할건지? 대응 가이드북 변수 첨부 (인터페이스 객체)

            ServerUtil.postRequestSignIn(inputId, inputPw, object : ServerUtil.JsonResponseHandler {
                override fun onResponse(jsonObj: JSONObject) {

//                    서버가 보내준 jsonObj를 가지고 처리하는 코드 작성 영역

                    Log.d("화면에서 받은 JSON", jsonObj.toString())


                }

            })



        }

    }

    override fun setValues() {
    }
}