package com.tocatapp.tocatapp.helpers;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import com.tocatapp.tocatapp.R;
import com.tocatapp.tocatapp.models.Instrument;
import com.tocatapp.tocatapp.models.Model;
import com.tocatapp.tocatapp.models.Musician;
import com.tocatapp.tocatapp.models.Style;


/**
 * Emulation of a data layer
 */
public class Data {

    private static final int MAX_MUSICIANS = 50;
    private static final int MAX_INSTRUMENTS = 6;
    private static final int MAX_STYLES = 6;

    private static ArrayList<Instrument> instrumentList;
    private static ArrayList<Style> styleList;
    private static ArrayList<Musician> musicianList;
    private static ArrayList<String> firstNames = new ArrayList<>();
    private static ArrayList<String> lastNames = new ArrayList<>();

    public static ArrayList<Instrument> getInstrumentList() {
        if(instrumentList == null) {
            instrumentList = new ArrayList<>();
            instrumentList.add(new Instrument(1, R.string.ta_instrument_guitar));
            instrumentList.add(new Instrument(2, R.string.ta_instrument_bass));
            instrumentList.add(new Instrument(3, R.string.ta_instrument_drums));
            instrumentList.add(new Instrument(4, R.string.ta_instrument_keyboards));
            instrumentList.add(new Instrument(5, R.string.ta_instrument_saxophone));
            instrumentList.add(new Instrument(6, R.string.ta_instrument_vocals));
        }

        return instrumentList;
    }

    public static ArrayList<Style> getStyleList() {
        if(styleList == null) {
            styleList = new ArrayList<>();
            styleList.add(new Style(1, R.string.ta_music_styles_rock));
            styleList.add(new Style(2, R.string.ta_music_styles_reggae));
            styleList.add(new Style(3, R.string.ta_music_styles_alternative));
            styleList.add(new Style(4, R.string.ta_music_styles_funk));
            styleList.add(new Style(5, R.string.ta_music_styles_pop));
            styleList.add(new Style(6, R.string.ta_music_styles_punk));
        }

        return styleList;
    }

    public static ArrayList<Musician> getMusicianList() {
        if(musicianList == null) {
            musicianList = new ArrayList<>();
            initFirstNames();
            initLastNames();
            for(int i=1; i<=MAX_MUSICIANS; i++) {
                musicianList.add(r.getMusician(i));
            }
        }

        return musicianList;
    }

    public static Musician getMusicianById(int id) {
        if(id >0 && id <= MAX_MUSICIANS) {
            return musicianList.get(id - 1);
        }

        return null;
    }

    public static Musician getMusicianByEmail(String email) {
        for(int i=0; i<MAX_MUSICIANS; i++) {
            if(musicianList.get(i).getEmail().equals(email)) {
                return musicianList.get(i);
            }
        }
        return null;
    }

    public static ArrayList<Musician> getMusiciansByStyle(Style style) {
        ArrayList<Musician> subset = new ArrayList<>();
        Musician m;
        ArrayList<Style> musicianStyles;
        for(int i=0; i<MAX_MUSICIANS; i++) {
            m = musicianList.get(i);
            musicianStyles = m.getStyles();
            for(int j=0; j<musicianStyles.size(); j++) {
                if(musicianStyles.get(j).getId() == style.getId()) {
                    subset.add(m);
                    break;
                }
            }
        }
        return subset;
    }

    public static ArrayList<Musician> getMusiciansByInstrument(Instrument instrument) {
        ArrayList<Musician> subset = new ArrayList<>();
        Musician m;
        ArrayList<Instrument> musicianInstruments;
        for(int i=0; i<MAX_MUSICIANS; i++) {
            m = musicianList.get(i);
            musicianInstruments = m.getInstruments();
            for(int j=0; j<musicianInstruments.size(); j++) {
                if(musicianInstruments.get(j).getId() == instrument.getId()) {
                    subset.add(m);
                    break;
                }
            }
        }
        return subset;
    }

    private static void initFirstNames() {
        firstNames.add("Janice");
        firstNames.add("Alfonso");
        firstNames.add("Betsy");
        firstNames.add("Claudia");
        firstNames.add("Dominic");
        firstNames.add("Joyce");
        firstNames.add("Claire");
        firstNames.add("Sheila");
        firstNames.add("Holly");
        firstNames.add("Rose");
        firstNames.add("Jake");
        firstNames.add("Cary");
        firstNames.add("Floyd");
        firstNames.add("Darnell");
        firstNames.add("Jonathan");
        firstNames.add("Susie");
        firstNames.add("Mamie");
        firstNames.add("Jack");
        firstNames.add("Louis");
        firstNames.add("Steven");
        firstNames.add("Judith");
        firstNames.add("Emma");
        firstNames.add("Dallas");
        firstNames.add("Phillip");
        firstNames.add("Leslie");
        firstNames.add("Tomas");
        firstNames.add("Marcos");
        firstNames.add("Blanca");
        firstNames.add("Sean");
        firstNames.add("Ashley");
        firstNames.add("Joanne");
        firstNames.add("Blake");
        firstNames.add("Lucy");
        firstNames.add("Harvey");
        firstNames.add("Earl");
        firstNames.add("Bethany");
        firstNames.add("Doreen");
        firstNames.add("Sidney");
        firstNames.add("Victoria");
        firstNames.add("Joanna");
        firstNames.add("Mable");
        firstNames.add("Clark");
        firstNames.add("Terri");
        firstNames.add("Elsa");
        firstNames.add("Ruben");
        firstNames.add("Terrance");
        firstNames.add("Gwen");
        firstNames.add("Dixie");
        firstNames.add("Dorothy");
        firstNames.add("Sadie");
    }

    private static void initLastNames() {
        lastNames.add("Page");
        lastNames.add("Chapman");
        lastNames.add("Padilla");
        lastNames.add("Davidson");
        lastNames.add("Stone");
        lastNames.add("Young");
        lastNames.add("Fleming");
        lastNames.add("Neal");
        lastNames.add("Jordan");
        lastNames.add("Ward");
        lastNames.add("Byrd");
        lastNames.add("Foster");
        lastNames.add("Walters");
        lastNames.add("Franklin");
        lastNames.add("Goodwin");
        lastNames.add("Harrison");
        lastNames.add("Matthews");
        lastNames.add("Valdez");
        lastNames.add("Boone");
        lastNames.add("Colon");
        lastNames.add("Griffith");
        lastNames.add("Reese");
        lastNames.add("Guzman");
        lastNames.add("Beck");
        lastNames.add("Erickson");
        lastNames.add("Brady");
        lastNames.add("Patrick");
        lastNames.add("Santos");
        lastNames.add("Bryant");
        lastNames.add("Cross");
        lastNames.add("Lopez");
        lastNames.add("Frank");
        lastNames.add("Roberts");
        lastNames.add("Boyd");
        lastNames.add("Wright");
        lastNames.add("Morgan");
        lastNames.add("Hogan");
        lastNames.add("Santiago");
        lastNames.add("Ferguson");
        lastNames.add("Austin");
        lastNames.add("Horton");
        lastNames.add("Mcguire");
        lastNames.add("Kelly");
        lastNames.add("Robbins");
        lastNames.add("Drake");
        lastNames.add("Summers");
        lastNames.add("Hubbard");
        lastNames.add("Cruz");
        lastNames.add("Alexander");
        lastNames.add("Lowe");
    }

    /**
     * Random generator inner class
     */
    public static class r extends Data{

        private static int curFn = 0;

        public static Musician getMusician(int id) {
            Musician musician = new Musician();
            musician.setId(id);
            musician.setFirstName(fn());
            musician.setLastName(ln());
            musician.setPassword("1234");
            musician.setEmail(em(musician.getFirstName(), musician.getLastName()));
            musician.setInstruments((ArrayList<Instrument>) in());
            musician.setStyles((ArrayList<Style>) st());
            musician.setBandMembersId(new ArrayList<Integer>());

            return musician;
        }

        public static String getN(ArrayList<String> collection) {
            if(curFn == Data.MAX_MUSICIANS) {
                curFn = 0;
            }
            return collection.get(curFn++);
        }

        public static String fn() {
            return getN(Data.firstNames);
        }

        public static String ln() {
            return getN(Data.lastNames);
        }

        public static String em(String fname, String lname) {
            return fname.toLowerCase()
                    + lname
                    + "@gmail.com";
        }

        public static ArrayList<? extends Model> st() {
            ArrayList<? extends Model> list = getStyleList();
            return getRandomStyleInstrument(list, MAX_STYLES);
        }

        public static ArrayList<? extends Model> in() {
            ArrayList<? extends Model> list = getInstrumentList();
            return getRandomStyleInstrument(list, MAX_INSTRUMENTS);
        }

//        public static ArrayList<Style> st() {
//            ArrayList<Style> all = getStyleList();
//            ArrayList<Style> styles = new ArrayList<>();
//            Random r = new Random();
//            int maxStyles = r.nextInt(MAX_STYLES - 3) + 1;
//            ArrayList<Integer> uniques = new ArrayList<>();
//            for(int i=0; i<maxStyles; i++) {
//                int randomStyleIndex = r.nextInt(MAX_STYLES);
//                if(!uniques.contains(randomStyleIndex)) {
//                    uniques.add(randomStyleIndex);
//                    styles.add(all.get(randomStyleIndex));
//                }
//            }
//            return styles;
//        }

        private static ArrayList<Model> getRandomStyleInstrument(ArrayList<? extends Model> collection, int MAX) {
            ArrayList<Model> styleInstrument = new ArrayList<>();
            Random r = new Random();
            int maxElements = r.nextInt(MAX - 3) + 1;
            ArrayList<Integer> uniques = new ArrayList<>();
            for(int i=0; i<maxElements; i++) {
                int randomStyleInstrumentIndex = r.nextInt(MAX);
                if(!uniques.contains(randomStyleInstrumentIndex)) {
                    uniques.add(randomStyleInstrumentIndex);
                    styleInstrument.add(collection.get(randomStyleInstrumentIndex));
                }
            }
            return styleInstrument;

        }
    }
}
