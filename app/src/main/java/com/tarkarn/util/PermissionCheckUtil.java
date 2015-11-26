package com.tarkarn.util;

import java.security.Permission;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.tarkarn.constant.Constant;

/**
 * PermisionCheck Util.
 * Over than Android OS Version 6.0.
 * @author tarkarn
 * 
 *    <!-- Dangerous Permission -->
    	<!-- Phone -->
	    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
	    <uses-permission android:name="android.permission.CALL_PHONE" />
	    <uses-permission android:name="android.permission.READ_CALL_LOG" />
		<uses-permission android:name="android.permission.WRITE_CALL_LOG" />
	
		<!-- Contact -->
	   	<uses-permission android:name="android.permission.READ_CONTACTS" />
		<uses-permission android:name="android.permission.WRITE_CONTACTS" />
	    <uses-permission android:name="android.permission.GET_ACCOUNTS" />
	    
	    <!-- SMS -->
	    <uses-permission android:name="android.permission.SEND_SMS"/>
	    <uses-permission android:name="android.permission.READ_SMS" />
	    
	    <!-- Storage -->
    	<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <!-- Dangerous Permission End -->
 *
 */
public class PermissionCheckUtil {

	private static final String TAG = PermissionCheckUtil.class.getSimpleName();
	
	
	public static void permissionCheck(Activity act, final int PERMISSION_CODE){

		// SDK Version..
		final int SDK_VERSION = Build.VERSION.SDK_INT;
		Log.d(TAG, " ttTest SDK_VERSION = " + SDK_VERSION);
		
		// Check Android Version. (Over than OS 6.0)
		if(SDK_VERSION >= Build.VERSION_CODES.M){

			// Setting Permission Name.
			String permissionName = setPermissionType(PERMISSION_CODE);
			Log.d(TAG, " ttTest permissionName value [" + permissionName +"] permissionCode ["+PERMISSION_CODE+"]");

			// Permission 을 해제해 놓은 경우
			if(ContextCompat.checkSelfPermission(act, permissionName) != PackageManager.PERMISSION_GRANTED) {
				Log.d(TAG, " ttTest checkSelfPermission "+permissionName+" is not PERMISSION_GRANTED ");

				ActivityCompat.requestPermissions(act, new String[]{permissionName}, PERMISSION_CODE);

				/*
				// 권한 설정을 어플 내에서 한번 설정한 이후 어픙을 실행 한 경우 처리를 어떻게 할 것인지.
				if(ActivityCompat.shouldShowRequestPermissionRationale(act, permissionName)){
					Log.d(TAG, " ttTest shouldShowRequestPermissionRationale " + permissionName);
					ActivityCompat.requestPermissions(act, new String[]{permissionName}, PERMISSION_CODE);

				// 최초 어플 실행 시 권한 설정을 하지 않은 경우.
				} else {
					
					// Request는 해당 Method를 호출한 Activity 로 Callback이 감.
					Log.d(TAG, " ttTest requestPermissions "+ permissionName);
					ActivityCompat.requestPermissions(act, new String[]{permissionName}, PERMISSION_CODE);
				}
				*/
			}
		}
		
	}

	private static String setPermissionType(int permissionCode){
		String result = "";

		switch (permissionCode){
			case Constant.PERMISSION_CALENDAR: result = Manifest.permission.READ_CALENDAR; break;
			case Constant.PERMISSION_CAMERA: result = Manifest.permission.CAMERA; break;
			case Constant.PERMISSION_CONTACT: result = Manifest.permission.READ_CONTACTS; break;
			case Constant.PERMISSION_LOCATION: result = Manifest.permission.ACCESS_FINE_LOCATION; break;
			case Constant.PERMISSION_MICROPHONE: result = Manifest.permission.RECORD_AUDIO; break;
			case Constant.PERMISSION_PHONE: result = Manifest.permission.READ_PHONE_STATE; break;
			case Constant.PERMISSION_SENSORS: result = Manifest.permission.BODY_SENSORS; break;
			case Constant.PERMISSION_SMS: result = Manifest.permission.SEND_SMS; break;
			case Constant.PERMISSION_STORAGE: result = Manifest.permission.READ_EXTERNAL_STORAGE; break;
		}

		return result;
	}
}
