package com.example.user.part2_6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kkang
 * 깡샘의 안드로이드 프로그래밍 - 루비페이퍼
 * 위의 교제에 담겨져 있는 코드로 설명 및 활용 방법은 교제를 확인해 주세요.
 */

/**
 * 액티비티 클래스 자체를 이벤트핸들러로 만들기 위해 다음 두 개의 인터페이스를 클래스 선언 부분에 상속받고 인터페이스의 추상 함수를 재정의 해줌.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    TextView bellTextView;
    TextView labelTextVeiw;
    CheckBox repeatCheckView;
    CheckBox vibrateCheckView;
    Switch switchView;

    float initX;
    long initTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //View 객체 획득(findViewById 함수 이용)
        bellTextView = (TextView)findViewById(R.id.bell_name);
        labelTextVeiw=(TextView)findViewById(R.id.label);
        repeatCheckView=(CheckBox)findViewById(R.id.repeatCheck);
        vibrateCheckView=(CheckBox)findViewById(R.id.vibrate);
        switchView=(Switch)findViewById(R.id.onOff);

        //버튼 이벤트 등록
        bellTextView.setOnClickListener(this);
        labelTextVeiw.setOnClickListener(this);

        repeatCheckView.setOnCheckedChangeListener(this);
        vibrateCheckView.setOnCheckedChangeListener(this);
        switchView.setOnCheckedChangeListener(this);
    }

    /**
     * 각 이벤트의 콜백함수
     */

    //각 이벤트에 따라, 글을 보여주기 위한 메서드
    private void showToast(String message){
        Toast toast=Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    //클릭 이벤트 구현
    //토스트로 출력만 함.
    @Override
    public void onClick(View v) {
        if(v==bellTextView){
            showToast("bell text click event..");
        }else if(v==labelTextVeiw){
            showToast("label text click event...");
        }
    }

    //체크박스, 스위치 이벤트 구현
    //토스트로 출력만 함.
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(buttonView==repeatCheckView){
            showToast("repeat checkbox is "+isChecked);
        }else if(buttonView==vibrateCheckView){
            showToast("vibrate checkbox is "+isChecked);
        }else if(buttonView==switchView){
            showToast("switch is "+isChecked);
        }
    }

    //터치 이동 이벤트 구현(리턴 타입 boolean 이며, return 값이 정해져 있음)
    //여기서는 화면이 넘어가지 않고, 토스트로 출력하는 기능만 작성함.
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            initX=event.getRawX();
        }else if(event.getAction()== MotionEvent.ACTION_UP){
            float diffX=initX-event.getRawX();
            if(diffX>30){
                showToast("왼쪽으로 화면을 밀었습니다.");
            }else if(diffX < -30){
                showToast("오른쪽으로 화면을 밀었습니다.");
            }
        }
        return true;
    }

    //키 이벤트 구현(리턴 타입 boolean 이며, return 값이 정해져 있음)
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if(System.currentTimeMillis() - initTime > 3000){ //back button 을 누른지 3초가 지난거라면
                showToast("종료하려면 한번 더 누르세요.");
                initTime=System.currentTimeMillis(); //현재 시간 저장
            }else {
                finish(); //3초 이내에 back button 이 두번 눌린 경우, Activity 종료
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
