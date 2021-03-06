package com.efortshub.holyquran.utils;

import com.efortshub.holyquran.models.TranslatedFontSettings;

/**
 * Created by H. Bappi on  12:52 PM 9/27/21.
 * Contact email:
 * contact@efortshub.com
 * bappi@efortshub.com
 * contact.efortshub@gmail.com
 * Copyright (c) 2021 eFortsHub . All rights reserved.
 **/
public class HbConst {
    public static final String KEY_IS_SYSTEM_ALLOCATED_DOWNLOAD_PATH = "is_system_allocated";
    public static final String KEY_IS_CUSTOM_DOCUMENT_DOWNLOAD_URI = "document_path_uri";
    public static final String KEY_TABLE_NAME_DOWNLOAD_QUE = "d_que";
    //FETCHING NATIVE VARIABLE HERE INCLUDING API AND OFFLINE URL

    static {
        System.loadLibrary("native-lib");
    }

    public static native String getOnlineBaseJsonUrl();


    public static native String getOfflineHbjImlaei();
    public static native String getOfflineHbjIndopak();
    public static native String getOfflineHbjUthmani();
    public static native String getOfflineHbjTranslations();
    public static native String getOfflineHbjTrEn20();
    public static native String getOfflineHbjTrBn162();



    //DEFAULT ARABIC FONT INITIALIZATION


  static String gunnah = "إِنَّهَا عَلَيْهِم مُّؤْصَدَةٌ ";
  static String ikhfa = "تَرْمِيهِم بِحِجَارَةٍ مِّن سِجِّيلٍ";
 // static String idhgham = " الَّذِي أَطْعَمَهُم مِّن جُوعٍ وَآمَنَهُم مِّنْ خَوْفٍ";
 // static String idhghamwithoutgunnah = "وَلَمْ يَكُن لَّهُ كُفُوًا أَحَدٌ";
  static String iqlab = "كَذَّبَتْ ثَمُودُ وَعَادٌۢ بِالْقَارِعَةِ";
 // static String qalqala = "لَمْ يَلِدْ وَلَمْ يُولَدْ";

  public static final String DEFAULT_COLOR_CODED_TEXT = gunnah + " " + ikhfa   + " " + iqlab;
  //public static final String DEFAULT_COLOR_CODED_TEXT = gunnah + " " + ikhfa + " " + idhgham + " " + idhghamwithoutgunnah + " " + iqlab + " " + qalqala;
  public static final int DEFAULT_ARABIC_FONT_SIZE = 14;
    public static final String DEFAULT_ARABIC_FONT = "othmani";
    public static final String DEFAULT_ARABIC_SCRIPT = "Imlaei";
    public static final String DEFAULT_ARABIC_FONT_STYLE = "normal";
    public static final String DEFAULT_ARABIC_PRIMARY_TRANSLATION_LANGUAGE_ID = "20";
    public static final String DEFAULT_ARABIC_PRIMARY_TRANSLATION_NAME = "Saheeh International";
    public static final String DEFAULT_ARABIC_PRIMARY_TRANSLATION_LANGUAGE_NAME = "English";
    public static final String DEFAULT_ARABIC_SECONDARY_TRANSLATION_LANGUAGE_ID = "162";
    public static final String DEFAULT_ARABIC_SECONDARY_TRANSLATION_NAME = "Bayaan Foundation";
    public static final String DEFAULT_ARABIC_SECONDARY_TRANSLATION_LANGUAGE_NAME = "Bangla";
    public static final boolean DEFAULT_QURAN_TRANSLATION_VISIBILITY_SECONDARY = true;
    public static final boolean DEFAULT_QURAN_TRANSLATION_VISIBILITY_PRIMARY = true;








    public static final String OFFLINE_HBJ_IMLAEI = getOfflineHbjImlaei();
    public static final String OFFLINE_HBJ_INDOPAK = getOfflineHbjIndopak();
    public static final String OFFLINE_HBJ_UTHMANI = getOfflineHbjUthmani();
    public static final String OFFLINE_HBJ_TRANSLATIONS = getOfflineHbjTranslations();
    public static final String OFFLINE_HBJ_TR_EN = getOfflineHbjTrEn20();
    public static final String OFFLINE_HBJ_TR_BN= getOfflineHbjTrBn162();
    public static final String ONLINE_JSON_TRANSLATION_URL = getOnlineBaseJsonUrl()+"translations/%s.json";
    public static final String ONLINE_JSON_RECITATION_URL = getOnlineBaseJsonUrl()+"recitations/%s.json";




    public static final int REQUEST_CODE_SELECT_DOWNLOAD_PATH = 91;
    public static final int REQUEST_CODE_SELECT_STORAGE_PERMISSION = 92;

    //DEFAULT KEY USED IN APP TO VALIDATE OF FIND CONTENT
    public static final String KEY_SHARED_PREF_KEY = "sp";
    public static final String KEY_THEME = "theme";
    public static final String KEY_ARABIC_SCRIPT = "arb_script";
    public static final String KEY_ARABIC_FONT = "arb_font";
    public static final String KEY_ARABIC_FONT_SIZE = "arb_font_size";
    public static final String KEY_ARABIC_FONT_STYLE = "arb_font_style";
    public static final String KEY_TRANSLATION_FONT = "trs_font";
    public static final String KEY_TRANSLATION_FONT_SIZE = "trs_font_size";
    public static final String KEY_TRANSLATION_FONT_STYLE = "trs_font_style";
    public static final String KEY_REQUIRED_OPEN_SETTINGS = "restart_required";
    public static final String KEY_QURAN_PRIMARY_TRANSLATION_LANGUAGE_ID = "pri_quran_trns_id ";
    public static final String KEY_QURAN_PRIMARY_TRANSLATION_NAME = "pri_quran_trns_name";
    public static final String KEY_QURAN_PRIMARY_TRANSLATION_LANGUAGE_NAME = "pri_quran_trns_lang_name";
    public static final String KEY_QURAN_SECONDARY_TRANSLATION_LANGUAGE_ID = "sec_quran_trns_id ";
    public static final String KEY_QURAN_SECONDARY_TRANSLATION_NAME = "sec_quran_trns_name";
    public static final String KEY_QURAN_SECONDARY_TRANSLATION_LANGUAGE_NAME = "sec_quran_trns_lang_name";
    public static final String KEY_TRANSLATION_VISIBILITY_SECONDARY = "trns_vsb_sc";
    public static final String KEY_TRANSLATION_VISIBILITY_PRIMARY = "trns_vsb_pr";
    public static final String KEY_DOWNLOAD_DIR_MAIN_PATH = "HolyQuran";
    public static final String KEY_DOCUMENT_FILE_PATH_SEPARATOR = "%2F";
    public static final String KEY_SHOW_TAJWEED = "tajweed_check";








}
