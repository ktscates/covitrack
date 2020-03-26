package rw.awesomity.covi_tracker;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    //preference file name
    private static final String FILE_NAME = "file_lang";
    // preference key
    private static final String KEY_LANG = "key_lang";

    TextView bring;
    TextView family;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLanguage();
        setContentView(R.layout.activity_main);
        bring = (TextView) findViewById(R.id.bring);
        start = (Button) findViewById(R.id.start);

    }

    //use this method to save language
    private void saveLanguage(String lang) {
        SharedPreferences preferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_LANG, lang);
        editor.apply();
        recreate();
    }

    private void loadLanguage() {
        //use this method to load language,
        Locale locale = new Locale(getLangCode());
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }

    private String getLangCode() {
        SharedPreferences preferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        // save english as the default
        String langCode = preferences.getString(KEY_LANG, "en");
        return langCode;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_english:
                saveLanguage("en");
                break;
            case R.id.action_french:
                saveLanguage("fr");
                break;
            case R.id.action_kinyarwanda:
                saveLanguage("rw");
                break;
        }
        return true;
    }
}
