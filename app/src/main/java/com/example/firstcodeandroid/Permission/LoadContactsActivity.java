package com.example.firstcodeandroid.Permission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.firstcodeandroid.R;

import java.util.ArrayList;
import java.util.List;

public class LoadContactsActivity extends AppCompatActivity {


    ArrayAdapter<String> adapter2;
    List<String> list2 = new ArrayList<>();

    List<ContactUser> list = new ArrayList<>();
    ContactUserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_contacts);
        ListView list_contact = (ListView)findViewById(R.id.contact_list_view);
        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list2);
        list_contact.setAdapter(adapter2);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 3);
        }
        else {
            loadContact();
        }
//        ListView listView = (ListView)findViewById(R.id.contact_list_view);
//        adapter = new ContactUserAdapter(this, R.layout.contact_user_item, list);
//        listView.setAdapter(adapter);
//        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 3);
//        }
//        else {
//            loadContact();
//        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 3:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    loadContact();
                } else {
                    Toast.makeText(this, "permission denied", Toast.LENGTH_SHORT).show();
                }
        }
    }

    private void loadContact() {
        Cursor cur = null;
        try {
            cur = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
            if (cur != null) {
                while (cur.moveToNext()) {
                    String dispalyName = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String number = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    list2.add(dispalyName + "\n" + number);
                }
                adapter.refresh(list);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (cur != null) {
                cur.close();
            }
        }
    }
}
