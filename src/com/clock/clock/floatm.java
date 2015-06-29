package com.clock.clock;
import android.app.Service;
import android.os.*;
import android.content.*;
import android.view.*;
import android.graphics.*;
import android.util.*;
import android.view.View.*;
public class floatm extends Service implements View.OnTouchListener
{
	class bi extends Binder
	{
		floatm get()
		{
			return floatm.this;
		}
		void ss(ser sw)
		{
			s = sw;
		}
	}
	bi b=new bi();
	@Override
	public IBinder onBind(Intent p1)
	{
		// TODO: Implement this method
		return b;
	}

	@Override
	public void onCreate()
	{
		// TODO: Implement this method
		super.onCreate();
		createView();
	}
	boolean show=false;
	public void add()
	{
		// TODO: Implement this method
		if (!show)
		{
			windowManager.addView(view, wl);
			show = true;
			return;
		}
		windowManager.removeView(view);
		show = false;
	}
	@Override
	public void onDestroy()
	{
		// TODO: Implement this method
		super.onDestroy();
	}
	ser s;
	View view;
	WindowManager windowManager;
	WindowManager.LayoutParams wl;
	private void createView()
	{
		//view= new clockview(getApplicationContext());
		LayoutInflater li=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
		view = li.inflate(R.layout.mm, null);
		view.setOnTouchListener(this);
		windowManager = (WindowManager) view.getContext().getApplicationContext()
			.getSystemService(Context.WINDOW_SERVICE);
		// 设置LayoutParams(全局变量）相关参数
		wl = new WindowManager.LayoutParams();

		wl.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
		wl.format = PixelFormat.RGBA_8888;
		wl.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
		wl.gravity = Gravity.LEFT | Gravity.TOP;
		wl.x = 0;wl.y = 0;
		wl.width = 400;//WindowManager.LayoutParams.WRAP_CONTENT;
		wl.height = 400;//WindowManager.LayoutParams.WRAP_CONTENT;
		ser.yes();
		// 显示myFloatVie
	}
	private float x,y,mTouchX,mTouchY;
	private boolean isMove=false;
	@Override
	public boolean onTouch(View v, MotionEvent event)
	{
		// 获取到状态栏的高度
		Rect frame = new Rect();
		view.getWindowVisibleDisplayFrame(frame);
		int statusBarHeight = frame.top;

		System.out.println("statusBarHeight:" + statusBarHeight);
		// 获取相对屏幕的坐标，即以屏幕左上角为原点
		x = event.getRawX();
		y = event.getRawY() - statusBarHeight; // statusBarHeight是系统状态栏的高度
		Log.i("tag", "currX" + x + "====currY" + y);

		int screenWidth = getResources().getDisplayMetrics().widthPixels;
		switch (event.getAction())
		{
			case MotionEvent.ACTION_DOWN: // 捕获手指触摸按下动作
				// 获取相对View的坐标，即以此View左上角为原点
				mTouchX = event.getX();
				mTouchY = event.getY();
				isMove = false;
				Log.i("tag", "startX" + mTouchX + "====startY" + mTouchY);
				break;

			case MotionEvent.ACTION_MOVE: // 捕获手指触摸移动动作
				if (x > 5 && (screenWidth - x) > 5)
				{
					isMove = true;
					updateViewPosition();
				}
				break;
			case MotionEvent.ACTION_UP: // 捕获手指触摸离开动作
				if (isMove)
				{
					isMove = false;
				}
				else
				{
					Click();
					isMove = false;
				}
				mTouchX = mTouchY = 0;
				break;
		}
		return true;
	}
	private void updateViewPosition()
	{
		// 更新浮动窗口位置参数
		wl.x = (int) (x - mTouchX);
		wl.y = (int) (y - mTouchY);
		windowManager.updateViewLayout(view, wl); // 刷新显示
	}

	@Override
	public void Click()
	{
		// TODO: Implement this method
		Intent ii=new Intent();
		ii.setClass(this, clock.class);
		ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(ii);
	}

	@Override
	public void onClick(View p1)
	{
		// TODO: Implement this method
		Click();
	}


}
