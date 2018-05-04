package com.example.user.androidlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//앱 클릭 시, 실행되는 액티비티 클래스(화면 구성을 주 목적으로 하는 클래스)
//액티비티 클래스는 Activity 를 상속받게 됨.(여기서는 Activity 의 서브 클래스인 AppCompatActivity 를 상속 받음)
public class MainActivity extends AppCompatActivity {

    //액티비티 클래스가 실행되면, 자동으로 onCreate 메서드가 호출됨.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //setContentView 가 화면 출력 함수
        //매개변수 R.layout.activity_main 은 res 의 하위 파일이므로, activity_main.xml 파일을 참조하기 위해, R.layout.activity_main 변수로 리소스를 식별함.
    }
}
