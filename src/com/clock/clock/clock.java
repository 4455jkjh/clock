package com.clock.clock;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.lang.reflect.*;
public class clock extends Activity
{
	static String[] str1,sss;
	static String str;
	static int c,d,xz=0;
	Intent in;
	Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		//	requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
		//		 WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		/*Class<? extends Window> c =getWindow().getClass();
		 try{
		 int tni=0;
		 Class<?> cc=Class.forName("android.view.MiuiWindowManager$LayoutParams");
		 Field f=cc.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
		 tni=f.getInt(cc);
		 Method m=c .getMethod("setExtraFlags",int.class,int.class);
		 m.invoke(getWindow(),true?tni:0,tni);

		 }
		 catch (Exception e)
		 {}*/
		//timee=new time();
		//timee.start();
		setContentView(R.layout.main);
		res = new ser();
		in = new Intent();
		in.setClass(clock.this, floatm.class);
		bindService(in, res, 1);
		app ppa=(app)getApplication();
		time t=ppa.t;
		clockview cv=(clockview)findViewById(R.id.mainccc1);
		//t.setOnTimeChangedListener(new a(cv)
		b = (Button)findViewById(R.id.switch1);
	}
	ser res;
	public void c(View v)
	{
		switch (v.getId())
		{
			case R.id.switch1:
				if (res.f.show)
				{

					b.setText("打开悬浮窗");
				}
				else
				{

					b.setText("关闭悬浮窗");
				}
				res.f.add();
				break;
			case R.id.finish:
				finish();
				break;
			case R.id.exit:
				stop();
				System.exit(0);
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		// TODO: Implement this method
		if (keyCode == 4)
		{
			stop();
			System.exit(0);
		}
		return false;
	}
	private void stop()
	{
		if (res.f.show)
			res.f.add();
		unbindService(res);
		stopService(in);
	}

	@Override
	protected void onDestroy()
	{
		// TODO: Implement this method
		super.onDestroy();

	}

}
