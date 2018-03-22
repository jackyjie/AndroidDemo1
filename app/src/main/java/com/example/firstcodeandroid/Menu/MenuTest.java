package com.example.firstcodeandroid.Menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.firstcodeandroid.R;

public class MenuTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_test);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "Click add", Toast.LENGTH_SHORT).show();
                break ;
            case R.id.remove_item:
                Toast.makeText(this, "Click remove", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
