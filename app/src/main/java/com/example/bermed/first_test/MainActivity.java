package com.example.bermed.first_test;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.RemoteViews;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public TextView tv ;
    public Button b1 ;


    public MainActivity main;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = this;

        tv = (TextView) findViewById(R.id.myText);
        tv.setText(" hi evry one how are you ! ");

        b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sendNotification(v);
            }

        });


    }

    public void sendNotification(View view) {

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

        //Create the intent that’ll fire when the user taps the notification//

        RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.notification_small);
        contentView.setTextViewText(R.id.not_text1, "Custom notification");

        Intent intent = new Intent(main, MainActivity.class);
                //new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.androidauthority.com/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);


        mBuilder.setContentIntent(pendingIntent);

        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentTitle("My notification");
        mBuilder.setContentText("Hello World!");
        mBuilder.addAction(R.mipmap.ic_launcher, "BUTTON 1", pendingIntent);
        mBuilder.addAction(R.mipmap.ic_launcher, "BUTTON 2", pendingIntent);
        mBuilder.addAction(R.mipmap.ic_launcher, "BUTTON 3", pendingIntent);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(main.NOTIFICATION_SERVICE);
        mNotificationManager.notify(001, mBuilder.build());
    }

}
