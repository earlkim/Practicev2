package com.example.practicetestv2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView tvHello;
	Button buttonHello;
	CheckBox cbHello;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvHello = (TextView) findViewById(R.id.tvHello);
		buttonHello = (Button) findViewById(R.id.button1);
		/*
		 * tvHello = (TextView) findViewById(R.id.tvHello);
		 * tvHello.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) {
		 * tvHello.setText("Clicked me"); // TODO Auto-generated method stub
		 * 
		 * } });
		 * 
		 * buttonHello = (Button) findViewById(R.id.button1);
		 * buttonHello.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) {
		 * buttonHello.setText("Clicked me"); // TODO Auto-generated method stub
		 * 
		 * } });
		 */

		// 1) 이벤트 처리자 생성
		View.OnClickListener mMyClick = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// 3) 이벤트 클릭시의 콜백 처리
				switch (v.getId()) {
				case R.id.tvHello:
					tvHello.setText("Clicked me");
					break;
				case R.id.button1:
					buttonHello.setText("Clicked me");
					break;
				}

			}
		};

		// 2) 이벤트 위임
		tvHello.setOnClickListener(mMyClick);
		buttonHello.setOnClickListener(mMyClick);
		
		//체크박스 이벤트 처리
		
		//체크박스가 체크되면 텍스트뷰의 내용을 checked로
		//체크박스가 해제되면 텍스트뷰의 내용을 unchecked로 바꾸시오.
		cbHello = (CheckBox) findViewById(R.id.cbHello);
		cbHello.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
					tvHello.setText("checked");
				}else{
					tvHello.setText("unchecked");
				}
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
