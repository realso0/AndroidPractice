package com.example.user.part2_4;

import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

public class FrameLayout_2Activity extends AppCompatActivity implements View.OnClickListener {

    Button trueBtn;
    TextView targetTextView;
    Button falseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout_2);

        //탭버튼과 버튼에 따른 화면을 TabSpec클래스로 결합하여 추가하는 방식, 즉, TabSpec안에 버튼과 본문이 결합되어 있어서 버튼을 누르면 해당 버튼과 결합된 본문이 나오는 구조.
        //전체 TabHost에 탭 버튼 3개 있는 화면을 구성할 것임.(각 TabSpec 에는 버튼인 Indicator와 본문인 TabContent가 결합된 구조)
        TabHost host=(TabHost)findViewById(R.id.host); //host객체를 TabHost 타입으로 가져옴.
        host.setup(); //setup 메소드 내부에서, android.R.id.tabs, android.R.id.tabcontent로 이미 정해져 있는 내장 id를 인식하게 됨.

        //각 TabSpec을 만들 때 매개변수의 문자열은 각 TabSpec의 식별자 문자열
        TabHost.TabSpec spec=host.newTabSpec("tab1");
        //tab button 구성
        spec.setIndicator(null, ResourcesCompat.getDrawable(
                getResources(), R.drawable.tab_icon1, null));
        //tab 본문 구성
        spec.setContent(R.id.tab_content1);
        host.addTab(spec);

        spec=host.newTabSpec("tab2");
        spec.setIndicator(null, ResourcesCompat.getDrawable(
                getResources(), R.drawable.tab_icon2, null));
        spec.setContent(R.id.tab_content2);
        host.addTab(spec);

        spec=host.newTabSpec("tab3");
        spec.setIndicator(null, ResourcesCompat.getDrawable(
                getResources(), R.drawable.tab_icon3, null));
        spec.setContent(R.id.tab_content3);
        host.addTab(spec);

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
