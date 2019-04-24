package com.mygdx.DroppedGrinning;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.google.android.gms.ads.InterstitialAd;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
public class AndroidLauncher extends AndroidApplication implements SomeInterface {
    private InterstitialAd mInterstitialAd;
public void we(){
    runOnUiThread(new Runnable() {
        @Override
        public void run () {
            mInterstitialAd.loadAd(new AdRequest.Builder().build());}});}

    public void wal() {
        runOnUiThread(new Runnable() {
            @Override
            public void run () {
                if (mInterstitialAd.isLoaded()) {mInterstitialAd.show();}}});}

    public void walo() {
        runOnUiThread(new Runnable() {
            @Override
            public void run () {
                Toast.makeText(getContext(),"You Don't Have Enough Money",
                        Toast.LENGTH_SHORT).show();}

    });
}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1368824211967305/8306551152");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        RelativeLayout layout = new RelativeLayout(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        View gameView = initializeForView(new MyGdxGame(this), cfg);
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-1368824211967305/4750449523");
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        layout.addView(gameView);
        RelativeLayout.LayoutParams adParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        adParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        adParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        adParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

        layout.addView(adView, adParams);

        setContentView(layout);
    }}