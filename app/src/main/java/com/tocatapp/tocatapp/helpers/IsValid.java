package com.tocatapp.tocatapp.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsValid {

    private static boolean find(String value, String patternString) {
        Pattern pat = Pattern.compile(patternString);
        Matcher matcher = pat.matcher(value);
        return matcher.find();
    }

    public static boolean name(String name) {
        return find(name, "^[A-Za-záéíóúñÁÉÍÓÚÑ \\-']+$");
    }

    public static boolean email(String email) {
        return find(email, "^(.+)@(.+)$");
    }

    public static boolean password(String password) {
        return find(password, "[\\d\\w]{4,10}");
    }
}
