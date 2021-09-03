package com.neppplus.colosseum20210903.utils

import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request

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
            
//            만들어진 요청 호출
            client.newCall(request)//request를 호출해주세요하는거
            
            
        }

    }

}