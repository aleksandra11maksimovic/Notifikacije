package elab3.com.notifikacijerad;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Build;

public class App extends Application {

    //Tutorijal: https://www.youtube.com/watch?v=tTbd1Mfi-Sk&t=126s


    //Pogledati AndroidManifest.xml, gde je dodata linija:
    //android:name=".App"


    public static final String CHANEL_1_ID="CHANEL_1";
    public static final String CHANEL_2_ID="CHANEL_2";
    @Override
    public void onCreate() {
        super.onCreate();

        kreirajKanale();
    }
    //Od verzije 8 (Oreo), za svaku notifikaciju postoji kanal.
    public void kreirajKanale(){

        //SDK_INT - target SDK ovog projekta, videti build.gradle(app)
        //VERSION_CODES - tu su sve verzije Androida (od 1 do 10)
        //VERSION_CODES.O - verzija Oreo (8)
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            // Pravljenje kanala za notifikaciju.
            NotificationChannel chanel1= new NotificationChannel(CHANEL_1_ID,"chanel1", NotificationManager.IMPORTANCE_HIGH);
            //setovanje parametara
            chanel1.enableLights(true);
            chanel1.setLightColor(Color.RED);
            chanel1.enableVibration(true);
            chanel1.setDescription("Ovo su neuspesno obavljene operacije nad bazom");

            NotificationChannel chanel2= new NotificationChannel(CHANEL_2_ID,"chanel2", NotificationManager.IMPORTANCE_LOW);

            chanel1.setDescription("Ovo su uspesno obavljene operacije nad bazom");

            NotificationManager manager= getSystemService(NotificationManager.class);
            manager.createNotificationChannel(chanel1);
            manager.createNotificationChannel(chanel2);
        }
    }
}
