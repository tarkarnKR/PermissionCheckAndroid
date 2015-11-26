package com.tarkarn.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tarkarn.permissiontest.CalendarPermissionActivity;
import com.tarkarn.permissiontest.CameraPermissionActivity;
import com.tarkarn.permissiontest.ContactPermissionActivity;
import com.tarkarn.permissiontest.LocationPermissionActivity;
import com.tarkarn.permissiontest.MicrophonePermissionActivity;
import com.tarkarn.permissiontest.PhonePermissionActivity;
import com.tarkarn.permissiontest.R;
import com.tarkarn.permissiontest.SensorPermissionActivity;
import com.tarkarn.permissiontest.SmsPermissionActivity;
import com.tarkarn.permissiontest.StoragePermissionActivity;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button btnCalendar, btnCamera, btnContact, btnLocation, btnMicrophone, btnPhone, btnSensors, btnSms, btnStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setItem();
        setListener();
    }

    private void setItem(){
        btnCalendar = (Button) findViewById(R.id.btn_permission_calendar);
        btnCamera = (Button) findViewById(R.id.btn_permission_camera);
        btnContact = (Button) findViewById(R.id.btn_permission_contact);
        btnLocation = (Button) findViewById(R.id.btn_permission_location);
        btnMicrophone = (Button) findViewById(R.id.btn_permission_microphone);
        btnPhone = (Button) findViewById(R.id.btn_permission_phone);
        btnSensors = (Button) findViewById(R.id.btn_permission_sensors);
        btnSms = (Button) findViewById(R.id.btn_permission_sms);
        btnStorage = (Button) findViewById(R.id.btn_permission_storage);
    }

    private void setListener(){
        btnCalendar.setOnClickListener(this);
        btnCamera.setOnClickListener(this);
        btnContact.setOnClickListener(this);
        btnLocation.setOnClickListener(this);
        btnMicrophone.setOnClickListener(this);
        btnPhone.setOnClickListener(this);
        btnSensors.setOnClickListener(this);
        btnSms.setOnClickListener(this);
        btnStorage.setOnClickListener(this);
    }

    private void startNextActivity(Class cls){
        Intent intent = new Intent(MainActivity.this, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = null;

        switch (id){
            case R.id.btn_permission_calendar :
                startNextActivity(CalendarPermissionActivity.class);
                break;

            case R.id.btn_permission_camera :
                startNextActivity(CameraPermissionActivity.class);
                break;

            case R.id.btn_permission_contact :
                startNextActivity(ContactPermissionActivity.class);
                break;

            case R.id.btn_permission_location :
                startNextActivity(LocationPermissionActivity.class);
                break;

            case R.id.btn_permission_microphone :
                startNextActivity(MicrophonePermissionActivity.class);
                break;

            case R.id.btn_permission_phone :
                startNextActivity(PhonePermissionActivity.class);
                break;

            case R.id.btn_permission_sensors :
                startNextActivity(SensorPermissionActivity.class);
                break;

            case R.id.btn_permission_sms :
                startNextActivity(SmsPermissionActivity.class);
                break;

            case R.id.btn_permission_storage :
                startNextActivity(StoragePermissionActivity.class);
                break;
        }
    }
}
