package com.tocatapp.tocatapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.tocatapp.tocatapp.R;
import com.tocatapp.tocatapp.helpers.DialogHelper;

import butterknife.OnClick;
import butterknife.Optional;

public abstract class BaseActivity extends AppCompatActivity {

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

    @OnClick(R.id.btnListMusicians)
    @Optional
    public void goToMusiciansList(View view) {
        Intent intent = new Intent(this, MusiciansList.class);
        startActivity(intent);
    }
}
