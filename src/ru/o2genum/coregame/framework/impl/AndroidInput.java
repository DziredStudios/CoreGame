package ru.o2genum.coregame.framework.impl;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;

import ru.o2genum.coregame.framework.Input;

public class AndroidInput implements Input
{
	// OrientationHandler orientHandler;
	KeyboardHandler keyHandler;
	TouchHandler touchHandler;

	public AndroidInput(Context context, View view)
	{
		// orientHandler = new OrientationHandler(context);
		keyHandler = new KeyboardHandler(view);
		if(Integer.parseInt(VERSION.SDK) < 5)
			touchHandler = new SingleTouchHandler(view);
		else
			touchHandler = new MultiTouchHandler(view);
	}

	@Override
	public boolean isKeyPressed(int keyCode)
	{
		return keyHandler.isKeyPressed(keyCode);
	}

	@Override
	public float getTouchX()
	{
		return touchHandler.getTouchX();
	}

	@Override
	public float getTouchY()
	{
		return touchHandler.getTouchY();
	}

	@Override
	public boolean isTouched()
	{
		return touchHandler.isTouchDown();
	}

	@Override
	public float getAzimuth()
	{
		return 0.0F; // orientHandler.getAzimuth();
	}
}