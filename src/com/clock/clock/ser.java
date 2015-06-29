package com.clock.clock;
import android.content.*;
import android.os.*;

public class ser implements ServiceConnection
{
	floatm f;
	@Override
	public void onServiceConnected(ComponentName p1, IBinder p2)
	{
		// TODO: Implement this method
		f = ((floatm.bi)p2).get();
	}
	static boolean b;
	@Override
	public void onServiceDisconnected(ComponentName p1)
	{
		// TODO: Implement this method
		if (f.show)
		{
			f.add();
		}
	}
	public static void yes()
	{
		b = true;
	}
}
