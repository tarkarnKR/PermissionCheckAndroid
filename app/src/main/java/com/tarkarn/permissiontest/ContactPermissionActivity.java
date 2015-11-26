package com.tarkarn.permissiontest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.tarkarn.constant.Constant;
import com.tarkarn.util.PermissionCheckUtil;

public class ContactPermissionActivity extends AppCompatActivity {

    private final String TAG = ContactPermissionActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_permission);

        PermissionCheckUtil.permissionCheck(ContactPermissionActivity.this, Constant.PERMISSION_CONTACT);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Log.d(TAG, " ttTest onRequestPermissionsResult requestCode[" + requestCode + "]permissions[" + permissions[0] + "]grantResults[" + grantResults[0] + "]");

        if(Constant.PERMISSION_CONTACT == requestCode){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getApplicationContext(), " onRequestPermissionsResult " + Manifest.permission_group.CONTACTS + " GRANTED. ", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(getApplicationContext(), " onRequestPermissionsResult "+ Manifest.permission_group.CONTACTS +" DENIED.\n[Setting > Apps > PermissionTest > Permissions] Turn On Permission ",Toast.LENGTH_SHORT).show();
                finish();
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
