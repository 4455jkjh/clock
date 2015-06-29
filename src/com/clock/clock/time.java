package com.clock.clock;

import android.os.*;
import java.text.*;
import java.util.*;

public class time extends Thread
{
	boolean run=true;
	static  boolean ready=false;
	SimpleDateFormat formatter;
	public time(){
		formatter=new SimpleDateFormat ("yyyy年MM月dd日 ccc HH:mm:ss");
	}
	@Override
	public void run()
	{
		// TODO: Implement this method
		do{
			try
			{
				Thread.sleep(1);
				Date curDate=new Date(System.currentTimeMillis());//获取当前时间     
				str=formatter.format(curDate);   
				str1=str.split(" ");
				long ss=curDate.getTime();
				long ss1s=(int)(ss%1000);
				d=(int)(ss1s/10);
				c=(int)(ss1s/100);
				//c=(int)(ss1s/1000)*1;
				sss=str1[2].split(":");
				ready=true;
			}
			catch (InterruptedException e)
			{}
		}while(run);
	}
	
	@Override
	public void stop(boolean b)
	{
		// TODO: Implement this method
		run=false;
		ready=false;
	}
	static String str;
	static String[] str1,sss;
	static int c,d;
	public static String[] getsfm(String[] s){
		if(ready)return sss;
		return s;
	}
	public static String gettime(String s){
		if(ready)return str;
		return s;
	}
	public static int cc(int i){
		if(ready)return c;
		return i;
	}
}
