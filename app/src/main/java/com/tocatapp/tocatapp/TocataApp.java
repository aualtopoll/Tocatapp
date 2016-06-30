package com.tocatapp.tocatapp;

import android.app.Application;

import com.tocatapp.tocatapp.models.Instrument;
import com.tocatapp.tocatapp.models.Style;

import java.util.ArrayList;

public class TocataApp extends Application {

    private static final ArrayList<Style> DATA_STYLES = new ArrayList<>();
    private static final ArrayList<Instrument> DATA_INSTRUMENTS = new ArrayList<>();

    public TocataApp() {
        super();

    }

    public static ArrayList<Style> getDataStyles() {
        return DATA_STYLES;
    }

    public static ArrayList<Instrument> getDataInstruments() {
        return DATA_INSTRUMENTS;
    }
}
