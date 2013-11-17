package com.example.practicetestv2.ui;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class TimerThread extends Thread {
	int mInt;
	public boolean mIsRunning;
	private Handler mHandler;
	
	//핸들러를 넘겨받는 생성자 생성
	public TimerThread (Handler handler){
		mHandler = handler;
	}

	@Override
	public void run() {
		mIsRunning = true;
		while (mIsRunning) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			mInt++;
			// tvTimer.setText(String.valueOf(mInt));
			Log.d("kmw", "mInt : " + mInt);
			
			//UI 쓰레드에게 갱신된 값을 넘겨주기
			//Message 객체에 mInt값을 담는다.
			Message msg = mHandler.obtainMessage();
			msg.what = 0;
			msg.arg1 = mInt;
			mHandler.sendMessage(msg);

		}
	}

}
