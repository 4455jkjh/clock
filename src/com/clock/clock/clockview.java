package com.clock.clock;
import android.view.*;
import android.content.*;
import android.graphics.*;
import android.util.*;
import android.os.*;
import android.content.res.*;

public class clockview extends View
{
	Paint p,pp,p1;
	String[] s;
	int c=0,d,background=0xffeeeeee;
	String str="0";
	String[] sss=new String[]{"0","0","0"};
	Canvas canvas;
	public clockview(Context c)
	{
		super(c);
	}
	public clockview(Context c, AttributeSet a)
	{
		super(c, a);
		TypedArray ta=c.obtainStyledAttributes(a, R.styleable.clockview1);
		speed = ta.getFloat(R.styleable.clockview1_speed, 1);
		over = ta.getBoolean(R.styleable.clockview1_over, true);
		background=ta.getColor(R.styleable.clockview1_background,0xffeeeeee);
	}
	float speed=1;
	boolean over=true;
	public clockview(Context c, AttributeSet a, int s)
	{
		super(c, a, s);
	}
	public clockview(Context c, String[] s)
	{
		super(c);
		this.s = s;
	}
	float b;
	int w,h,aaa,r;
	RectF rf1,rf2,rf3,rf4,rf5,rf6,rf7,rf8,rf9;
	float start=0,sj=1,end=start;
	boolean a=true,isMove=false;
	int hour=0,min=0,sec=0;
	float x,y,mTouchX,mTouchY;
	protected void onDraw(Canvas canvas)
	{
		// TODO: Implement this method
		this.canvas = canvas;
		sss = time.getsfm(new String[]{"0","0","0"});
		str = time.gettime("0");
		c = time.cc(0);
		super.onDraw(canvas);
		p = new Paint();
		pp = new Paint();
		d = c * 10;
		p1 = new Paint();
		p1.setColor(background);
		p.setAntiAlias(true);
		p1.setStyle(Paint.Style.FILL);
		p.setAntiAlias(true);
		p.setColor(Color.BLACK);
		w = getWidth();h = getHeight();
		if (w > h)
		{aaa = h;}
		else
		{aaa = w;}
		float s,x,z,y;
		s = h / 2 - r;
		x = h / 2 + r;
		z = w / 2 - r;
		y = w / 2 + r;
		b = (float)(Math.sqrt(3) / 2);
		r = (int)(aaa / 2 - 10 * b);
		canvas.drawColor(0xffeeeeee);
		p.setStyle(Paint.Style.STROKE);
		p.setStrokeWidth(3);
		rf1 = new RectF(z, s, y, x);
		rf2 = new RectF(z + 10 * b, s + 10 * b, y - 10 * b, x - 10 * b);
		rf6 = new RectF(w / 2 - 100 * b, h / 2 - 100 * b, w / 2 + 100 * b, h / 2 + 100 * b);
		rf3 = new RectF(z + 80 * b, 80 * b + s, y - 80 * b, x - 80 * b);
		rf7 = new RectF(w / 2 - 70 * b, h / 2 - 70 * b, w / 2 + 70 * b, h / 2 + 70 * b);
		rf4 = new RectF(z + 100 * b, 200 * b + s, y - 100 * b, x - 200 * b);
		rf8 = new RectF(w / 2 - 55 * b, h / 2 - 55 * b, w / 2 + 55 * b, h / 2 + 55 * b);
		rf5 = new RectF(w / 2 - r / 4, h / 2 + r / 4, w / 2 + r / 4, h / 2 + r / 2 + r / 4);
		canvas.drawCircle(w / 2, h / 2, r, p1);
		drawmiao(canvas);
		drawfen(canvas);
		drawshi(canvas);
		draw();
		p.setColor(0xff000000);
		p.setStyle(Paint.Style.STROKE);
		if (!over)end1 = 360;
		canvas.drawArc(rf1, start, end1, false, p);
		canvas.drawCircle(w / 2, h / 2 + r / 2, r / 4, p);
		p.setStyle(Paint.Style.FILL);
		p.setColor(Color.BLUE);
		canvas.drawCircle(w / 2, h / 2, 15 * b, p);//中间的点
		p.setTextSize(r / 8.5f);
		p.setColor(Color.DKGRAY);
		canvas.drawText("12", w / 2 - 15 * b, s + 70 * b, p);
		canvas.drawText(str, z + aaa / 9, s + r / 2 + 25 * b, p);
		end1 += speed;
		canvas.drawText(c + "", w / 2, h / 2 + r / 2, p);
		drawmmm(canvas);
		drawsec(canvas);
		drawmin(canvas);
		drawhour(canvas);
		draw();
		invalidate();
	}
	public void draw()
	{
		if (over)canvas.drawArc(rf1, end1, 361 - end1, true, p1);
	}
	float end1=0;
	private void drawmiao(Canvas cc)
	{
		p.setStyle(Paint.Style.STROKE);
		for (float st=0;st < 360;st += 6)
		{
			cc.drawArc(rf1, st, 0, true, p);
		}
		if (end1 > 360)
		{
			end1 = 360;
		}
		pp.setColor(Color.WHITE);
		pp.setStyle(Paint.Style.FILL);
		cc.drawCircle(w / 2, h / 2, r - 15 * b, p1);
	}
	private void drawfen(Canvas cc)
	{
		for (float f=0;f < 360;f += 30)
		{
			cc.drawArc(rf1, f, 0, true, p);
		}
		cc.drawCircle(w / 2, h / 2, r - 28 * b, p1);
	}
	private void drawshi(Canvas cc)
	{
		for (float f=0;f < 360;f += 90)
		{
			cc.drawArc(rf1, f, 0, true, p);
		}
		cc.drawCircle(w / 2, h / 2, r - 50 * b, p1);
	}
	float ss,ss1;
	public void drawmmm(Canvas cc)
	{
		float du=3.6f;
		float s=d * du + 270;
		if (s >= 360)
		{
			s = s - 360;
		}
		p.setColor(Color.RED);
		p.setStrokeWidth(2);
		p.setStyle(Paint.Style.STROKE);
		cc.drawArc(rf5, s, 0, true, p);
	}
	public void drawsec(Canvas cc)
	{//秒针
		sec = Integer.parseInt(sss[2]);
		float du=0.6f;
		ss = sec * 10 * du + c * du + 270;
		ss1 = sec * 10 * du + c * du + 90;
		if (ss >= 360)
		{
			ss = ss - 360;
		}
		if (ss1 > 360)
		{
			ss1 = ss1 - 360;
		}
		p.setColor(Color.BLUE);
		p.setStrokeWidth(3);
		p.setStyle(Paint.Style.STROKE);
		cc.drawArc(rf2, ss, 0, true, p);
		cc.drawArc(rf6, ss1, 0, true, p);
	}
	float z,zz;
	public void drawmin(Canvas c)
	{//分针
		p.setStrokeWidth(5);
		min = Integer.parseInt(sss[1]);
		if (sec == 0)
		{
			z = min * 60;
		}
		else if (sec < 60 && min == 1)
		{
			z = sec;
		}
		else if (sec < 60)
		{
			z = min * 60 + sec;
		}
		float du=0.1f;
		ss = z * du + 270;
		ss1 = z * du + 90;
		if (ss >= 360)
		{
			ss = ss - 360;
		}
		if (ss1 > 360)
		{
			ss1 = ss1 - 360;
		}
		c.drawArc(rf3, ss, 0, true, p);
		c.drawArc(rf7, ss1, 0, true, p);
	}
	public void drawhour(Canvas c)
	{//
		hour = Integer.parseInt(sss[0]);
		if (min == 0)
		{
			zz = hour * 60;
		}
		else if (hour == 1)
		{
			zz = min;
		}
		else
		{
			zz = hour * 60 + min;
		}
		float du=0.5f;
		ss = zz * du + 270;
		ss1 = zz * du + 90;
		p.setStrokeWidth(7);
		if (ss >= 360)
		{
			ss = ss - 360;
		}
		c.drawArc(rf4, ss, 0, true, p);
		c.drawArc(rf8, ss1, 0, true, p);
	}
	public void setTime(String a, String[]b, int c)
	{
		sss = b;
		str = a;
		this.c = c;
		invalidate();
	}
}
