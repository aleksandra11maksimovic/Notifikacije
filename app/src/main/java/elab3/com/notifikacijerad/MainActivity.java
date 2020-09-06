package elab3.com.notifikacijerad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText etNaslov, etTekst;
    String velikiTekst= "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially";
    NotificationManagerCompat notificationManagerCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNaslov= findViewById(R.id.etNaslov);
        etTekst= findViewById(R.id.etPoruka);
        notificationManagerCompat= NotificationManagerCompat.from(this);
    }

    public void posaljiNaPrvi(View view) {

        String naslov= etNaslov.getText().toString();
        String poruka= etTekst.getText().toString();

        //Kreiranje notifikacije
        Notification notification = new NotificationCompat.Builder(this, App.CHANNEL_1_ID)
                .setContentTitle(naslov)
                .setContentText(poruka)
                //Stil BigText
                // .setStyle( new NotificationCompat.BigTextStyle().bigText(velikiTekst).setBigContentTitle("Dugacak tekst").setSummaryText("Ovo je summaryText"))
                .setSmallIcon(R.drawable.googleg_disabled_color_18)
                .build();
        //Prikaz notifikacije koriscenjem NotificationManagerCompat-a
        //Svaku notifikaciju odredjuje id. Ukoliko nakon ovog prikazemo notifikaciju sa istim id-jem, zamenice staru notifikaciju
        notificationManagerCompat.notify(1, notification);
    }
    public void posaljiNaDrugi(View view) {
        //Kastovanje slike u objekat Bitmap klase da bismo mogli da je prosledimo u BigPictureStyle().bigPicture(slika)
        //Bitmap slika= BitmapFactory.decodeResource(getResources(),R.drawable.slika);
        String naslov= etNaslov.getText().toString();
        String poruka= etTekst.getText().toString();
        Notification notification = new NotificationCompat.Builder(this, App.CHANNEL_2_ID)
                .setContentTitle(naslov)
                //Stil bigPicture
                //.setStyle( new NotificationCompat.BigPictureStyle().bigPicture(slika))
                //Stil Inbox
                //.setStyle(new NotificationCompat.InboxStyle().addLine("Prva linija").addLine("Druga linija").addLine("Treca linija"))
                .setContentText(poruka)
                .setSmallIcon(R.drawable.greska)
                .build();
        notificationManagerCompat.notify(2, notification);


        /* Grupne notifikacije. Moramo imati summaryNotifikaciju koja ce spojiti sve Notifikacije sa istim nazivom grupe u jednu

            Notification notification= new NotificationCompat.Builder(this, App.CHANNEL_2)
        .setContentTitle(title)
        .setContentText(message)
        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(picture))
        .setSmallIcon(R.drawable.done)
        .setColor(Color.BLUE)
        .setGroup("Grupa 1")
        .build();
            Notification notification2= new NotificationCompat.Builder(this, App.CHANNEL_2)
        .setContentTitle(title)
        .setContentText("DRUGA PORUKA")
        .setSmallIcon(R.drawable.done)
        .setColor(Color.BLUE)
        .setGroup("Grupa 1")
        .build();
            Notification summaryNotification= new NotificationCompat.Builder(this, App.CHANNEL_2)
        .setContentTitle(title)
        .setContentText("Prikazi notifikacije")
        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(picture))
        .setSmallIcon(R.drawable.done)
        .setColor(Color.BLUE)
        .setGroup("Grupa 1")
        .setGroupSummary(true)
        .build();
            notificationManagerCompat.notify(2, notification);
            notificationManagerCompat.notify(3, notification2);
            notificationManagerCompat.notify(4, summaryNot);





         */

    }


}
