package com.clock.clock;

import android.app.Application;
import android.view.WindowManager;
import android.content.*;

/**
 * 
 * @author <a href="mailto:kris@krislq.com">Kris.lee</a>
 * @website www.krislq.com
 * @date Nov 29, 2012
 * @version 1.0.0
 * 
 */
public class app extends Application
{
	private WindowManager.LayoutParams windowParams = new WindowManager.LayoutParams();

	public WindowManager.LayoutParams getWindowParams()
	{
		return windowParams;
	}
	public time t;

	@Override
	public void onCreate()
	{
		// TODO: Implement this method
		super.onCreate();
		t = new time();
		t.start();
	}

}

