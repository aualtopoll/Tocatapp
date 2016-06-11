package com.tocatapp.tocatapp.helpers;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by atoledo on 6/11/16.
 */
public class FormElement extends AppCompatActivity {

    public static String getStringValue(AppCompatActivity context, int id) {
        EditText field = (EditText) context.findViewById(id);
        if(field != null) {
            return field.getText().toString();
        }
        return "";
    }

    public static void setStringValue(AppCompatActivity context, int id, String value) {
        EditText field = (EditText) context.findViewById(id);
        if(field != null) {
            field.setText(value);
        }
    }
}
