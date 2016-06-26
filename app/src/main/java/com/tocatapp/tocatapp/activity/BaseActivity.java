package com.tocatapp.tocatapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.tocatapp.tocatapp.R;
import com.tocatapp.tocatapp.helpers.DialogHelper;

public class BaseActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_about) {
            DialogHelper.showAboutUs(this);
        }
        if(item.getItemId() == R.id.action_close) {
            this.finish();
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
}
