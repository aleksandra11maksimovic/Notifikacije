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


    public static final String CHANNEL_1_ID="CHANNEL_1";
    public static final String CHANNEL_2_ID="CHANNEL_2";
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
            NotificationChannel channel1= new NotificationChannel(CHANNEL_1_ID,"channel1", NotificationManager.IMPORTANCE_HIGH);
            //setovanje parametara
            channel1.enableLights(true);
            channel1.setLightColor(Color.RED);
            channel1.enableVibration(true);
            channel1.setDescription("Uspesno");

            NotificationChannel channel2= new NotificationChannel(CHANNEL_2_ID,"channel2", NotificationManager.IMPORTANCE_LOW);

            channel2.setDescription("Neuspesno");

            NotificationManager manager= getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
        }
    }
}
