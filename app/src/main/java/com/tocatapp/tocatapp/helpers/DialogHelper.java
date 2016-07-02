package com.tocatapp.tocatapp.helpers;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.tocatapp.tocatapp.R;

public class DialogHelper {

    public static void showAboutUs(AppCompatActivity context) {
        showSimpleOkDialog(context, R.string.ta_about, R.string.ta_about_text);
    }

    public static void showAboutUs(Activity context) {
        showSimpleOkDialog(context, R.string.ta_about, R.string.ta_about_text);
    }

    public static void showAuditionResult(Activity context, String musicianName) {
        showSimpleOkDialog(context, R.string.ta_audition, R.string.ta_auditionRequest);
    }

    private static void showSimpleOkDialog(Activity context, int title, int messageId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(messageId)
                .setTitle(title);
        builder.setPositiveButton(R.string.ta_back, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
