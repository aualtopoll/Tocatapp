package com.tocatapp.tocatapp.helpers;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.tocatapp.tocatapp.R;

public class DialogHelper {

    public static void showBadFieldHelper(AppCompatActivity context, int messageId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(messageId)
                .setTitle(R.string.ta_bad_field);
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
