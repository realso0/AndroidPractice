package com.example.user.part2_3;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lab3_3Activity extends AppCompatActivity implements View.OnClickListener {

    Button trueBtn;
    TextView targetTextView;
    Button falseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_3);

        //View 객체 획득(findViewById 함수 이용)
        trueBtn=(Button)findViewById(R.id.btn_visible_true);
        targetTextView=(TextView)findViewById(R.id.text_visible_target);
        falseBtn=(Button)findViewById(R.id.btn_visible_false);

        //버튼 이벤트 등록
        trueBtn.setOnClickListener(this);
        falseBtn.setOnClickListener(this);
    }

    //버튼 이벤트 콜백함수
    @Override
    public void onClick(View v) {
        if (v==trueBtn) {
            targetTextView.setVisibility(View.VISIBLE);
        } else if (v==falseBtn) {
            targetTextView.setVisibility(View.GONE);
        }
    }
}
