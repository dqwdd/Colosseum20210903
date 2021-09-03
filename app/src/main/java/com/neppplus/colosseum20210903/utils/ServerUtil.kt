package com.neppplus.colosseum20210903.utils

import android.util.Log
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ServerUtil {

//    단순 기능 수행이란? == 서버에 요청을 날리고 -> 응답을 화면에 전달
//    이 짓은 어떤 객체가 하던 요청/응답 처리만 잘 되면 그만임
//    이런 함수를 만든다? -> 뭐로 만드는게 낫다? -> static 함수들로 활용. ServerUtil 기능() 코드 작성 가능

    companion object {

//        이 안에 만드는 변수 / 함수는 전부 static처럼 동작함

//        호스트 주소를 애초에 변수로 저장해두자(가져다 쓰기 편하게 - ServerUtil안에서만)
        private val HOST_URL = "http://52.180.52.26"


//        로그인 기능 실행 함수

        fun postRequestSignIn( id : String, pw: String ) {
            
//            1. 어디로(url) 갈 것인가?   HOST_URL + Endpoint
            
            val urlString = "${HOST_URL}/user"
            
//            2. 어떤 데이터를 가지고 갈 것인가? (파라미터)
            val formData = FormBody.Builder()
                .add("email", id)
                .add("password", pw)
                .build()
        
        
        //    3. 어떤 방식으로 접근할 것인가? Request에 같이 적어주자
        //    모두 모아서 하나의 Request 정보로 만들어주자
            
            val request = Request.Builder()
                .url(urlString)
                .post(formData)//짐을 넣을거면 여기다 넣어라
                .build()
            
//            만들어진 request를 실제로 호출해야함
//            요청을 한다 -> 클라이언트의 역할 -> 앱이 클라이언트로 동작해야함
            
            val client = OkHttpClient()
            
//            만들어진 요청 호출 -> 응답이 왔을 때 분석 / UI 반영
//            호출을 하면 -> 서버가 데이터 처리...-> 응답 받아서 처리 (처리할 코드를 등록)
            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {

//                    실패? 서버 연결 자체를 실패. 응답이 돌아오지 않은 경우에
//                    ex) 비번 틀려서 로그인 실패 : 응답은 돌아왔는데 그 내용이 실패( 응답 O )
//                    인터넷 끊김, 서버 접속 불가 등. 실패 O

                }

                override fun onResponse(call: Call, response: Response) {

//                    어떤 내용이든, 응답이 돌아온 경우(로그인 성공, 실패 모두 응답)
//                    응답에 포함된 데이터들 중 -> 본문을 보자

                    val bodyString = response.body!!.string()//자동완성때 보니까 body에 ?있어서 !! 붙임
//                    본문을 그냥 String으로 찍어보면 -> 한글이 깨져보임
//                    JSONObject 형태로 변환해서 -> 다시 String으로 바꿔보면 한글이 보임
                    val jsonObj = JSONObject(bodyString)

                    Log.d("서버 응답 본문", jsonObj.toString())



                }


            })
        //request를 호출해주세요하는거
            //enqueue()==호출을 하고 돌아올 때 할 일
            
            
        }

    }

}