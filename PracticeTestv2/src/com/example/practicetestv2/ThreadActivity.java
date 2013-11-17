package com.example.practicetestv2;

import com.example.practicetestv2.ui.TimerThread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ThreadActivity extends Activity {
    Button btnStart;
	static TextView tvTimer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thread);

		tvTimer = (TextView) findViewById(R.id.tvTimer);
		tvTimer.setText("0");


		
		//To Do : 시작 버튼 누르면 타이머가 동작하도록 수정
		btnStart = (Button) findViewById(R.id.btnStart);
		btnStart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TimerThread mTimerThread = new TimerThread(mHandler);
				mTimerThread.setDaemon(true); //메인이 종료하면 같이 종료
				mTimerThread.start();
				
				
			}
		});
		
		//To Do : 종료 버튼 누르면 타이머가 종료하도록 수정
		Button btnStop = (Button) findViewById(R.id.btnStop);
		btnStop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
	//			mTimer
				
			}
		});
		
		
		
		

	}

	public static Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// Message 객체에서 변수를 가져와서 UI 갱신
			switch (msg.what) {
			case 0:
				int temp = msg.arg1;
				tvTimer.setText(String.valueOf(temp));
				break;
			default:
				break;
			}

		}

	};

}
