package com.tocatapp.tocatapp.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeApiServiceUtil;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.tocatapp.tocatapp.R;
import com.tocatapp.tocatapp.TocataApp;
import com.tocatapp.tocatapp.helpers.Data;
import com.tocatapp.tocatapp.helpers.DialogHelper;
import com.tocatapp.tocatapp.models.Model;
import com.tocatapp.tocatapp.models.Musician;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

public class MusicianProfile extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final int RECOVERY_REQUEST = 1;
    private Musician m;

    @BindView(R.id.profileMusicianName)
    TextView profileMusicianName;
    @BindView(R.id.profileInstruments)
    TextView profileInstruments;
    @BindView(R.id.profileStyles)
    TextView profileStyles;
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;
    @BindView(R.id.btnAudition)
    Button btnAudition;
    @BindView(R.id.youtubeView)
    YouTubePlayerView youtubeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musician_profile);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        m = Data.getMusicianById(extras.getInt("musicianId"));

        fillProfile(m);

        if(YouTubeApiServiceUtil.isYouTubeApiServiceAvailable(getApplicationContext()).equals(YouTubeInitializationResult.SUCCESS)) {
            youtubeView.initialize(TocataApp.YOUTUBE_API_KEY, this);
        }
    }

    private void fillProfile(Musician m) {
        Resources res = getResources();

        profileMusicianName.setText(m.getFullName());
        profileInstruments.setText(
                String.format(res.getString(R.string.ta_instrument_s),
                        getListAsString(m.getInstruments()))
        );
        profileStyles.setText(
                String.format(res.getString(R.string.ta_style_s),
                        getListAsString(m.getStyles()))
        );
    }

    private String getListAsString(ArrayList<? extends Model> modelList) {
        Resources res = getResources();

        String str = "";
        for (Model m : modelList) {
            str += (" " + res.getString(m.getName()));
        }

        return str;
    }

    @OnClick(R.id.btnAudition)
    public void audition() {
        DialogHelper.showAuditionResult(this, m.getFullName());
    }
    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
            player.cueVideo("2ZAGPI0aaHU");
        }
    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.ta_playerError), errorReason.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(TocataApp.YOUTUBE_API_KEY, this);
        }
    }

    protected Provider getYouTubePlayerProvider() {
        return youtubeView;
    }

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
