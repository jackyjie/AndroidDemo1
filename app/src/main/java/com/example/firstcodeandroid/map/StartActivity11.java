package com.example.firstcodeandroid.map;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

//import com.baidu.location.BDAbstractLocationListener;
//import com.baidu.location.BDLocation;
//import com.baidu.location.BDLocationListener;
//import com.baidu.location.LocationClient;
//import com.baidu.location.LocationClientOption;
//import com.baidu.mapapi.SDKInitializer;
//import com.baidu.mapapi.map.MapView;
import com.example.firstcodeandroid.R;

import java.util.ArrayList;
import java.util.List;

public class StartActivity11 extends AppCompatActivity {
//
//    private LocationClient client ;
//    private TextView text;
//    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        SDKInitializer.initialize(this);
//        client = new LocationClient(this);
//        client.registerLocationListener(new MyLocationListener());
//        setContentView(R.layout.activity_start11);
//        mapView = (MapView)findViewById(R.id.bmapview);
//        text = (TextView)findViewById(R.id.location);
        List<String> permissionList = new ArrayList<>();
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if(!permissionList.isEmpty()){
            String[] permissions = permissionList.toArray(new String[permissionList.size()] );
            ActivityCompat.requestPermissions(this, permissions, 1);
        }
        else {
            requestLocation();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        mapView.onPause();
    }

    private void requestLocation(){
//        initLocation();
//        client.start(); // 定位 一次
    }

    private void initLocation(){
//        LocationClientOption option = new LocationClientOption();
////        option.setLocationMode(LocationClientOption.LocationMode.Device_Sensors);
//        option.setScanSpan(5000);
//        option.setIsNeedAddress(true); // 地址
//        client.setLocOption(option);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        client.stop();
//        mapView.onDestroy();
    }

//    public class MyLocationListener extends BDAbstractLocationListener{
//
//        @Override
//        public void onReceiveLocation(BDLocation bdLocation) {
//            StringBuilder currnentPosition = new StringBuilder();
//            currnentPosition.append("纬度：").append(bdLocation.getLatitude()).append("\n");
//            currnentPosition.append("经度：").append(bdLocation.getLongitude()).append("\n");
//            currnentPosition.append("国家：").append(bdLocation.getCountry()).append("\n");
//            currnentPosition.append("省：").append(bdLocation.getProvince()).append("\n");
//            currnentPosition.append("市：").append(bdLocation.getCity()).append("\n");
//            currnentPosition.append("区：").append(bdLocation.getDistrict()).append("\n");
//            currnentPosition.append("街道：").append(bdLocation.getStreet()).append("\n");
//            currnentPosition.append("定位方式：");
//            if(bdLocation.getLocType() == BDLocation.TypeGpsLocation){
//                currnentPosition.append("GPS");
//            }
//            else if(bdLocation.getLocType() == BDLocation.TypeNetWorkLocation){
//                currnentPosition.append("网络");
//            }
//            text.setText(currnentPosition);
//        }
//    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length > 0 ){
                    for(int result :grantResults){
                        if(result != PackageManager.PERMISSION_GRANTED){
                            Toast.makeText(this, "必须统一所有权限才可以使用本程序", Toast.LENGTH_SHORT).show();
                            finish();
                            return ;
                        }
                    }
                    requestLocation();
                }
                else {
                    Toast.makeText(this, "发生未知错误", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
        }
    }
}
