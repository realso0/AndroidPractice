package com.example.user.part2_3;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class Lab3_4Activity extends AppCompatActivity {

    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_4);

        //Custom Font 적용
        TextView textView=(TextView)findViewById(R.id.fontView);
        Typeface typeface=Typeface.createFromAsset(getAssets(), "xmas.ttf");
        textView.setTypeface(typeface);

        //CheckBox 이벤트 프로그램
        //View 객체 획득(findViewById 함수 이용)
        checkBox=(CheckBox)findViewById(R.id.checkbox);
        //버튼 이벤트 등록과 동시에 콜백함수로 이벤트 구현
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    checkBox.setText("is Checked");
                } else {
                    checkBox.setText("is unChecked");
                }
            }
        });
    }
}
