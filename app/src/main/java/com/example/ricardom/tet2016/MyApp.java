package com.example.ricardom.tet2016;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.example.ricardom.tet2016.receivers.BeaconReceiver;

import java.util.List;
import java.util.UUID;

/**
 * Created by RicardoM on 06/12/2016.
 */

public class MyApp extends Application {


    private BeaconManager beaconManager;
    String num;

    @Override
    public void onCreate() {
        super.onCreate();

        beaconManager = new BeaconManager(getApplicationContext());
        beaconManager.setMonitoringListener(new BeaconManager.MonitoringListener() {
            @Override
            public void onEnteredRegion(Region region, List<Beacon> list) {
                for (int i=0;i<list.size();i++) {

                    Intent intent = new Intent(BeaconReceiver.ACTION_BEACON);


                    intent.putExtra(BeaconReceiver.EXTRA_MAJOR, list.get(i).getMajor());
                    intent.putExtra(BeaconReceiver.EXTRA_MINOR, list.get(i).getMinor());

                    showNotification("Un pabellon detectado", "Pabellon dectectado");

                    sendBroadcast(intent);
                }
            }
            @Override
            public void onExitedRegion(Region region) {
                // could add an "exit" notification too if you want (-:

            }
        });

        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                beaconManager.startMonitoring(new Region(
                        "monitored region",UUID.fromString("f7826da6-4fa2-4e98-8024-bc5b71e0893e"), null, null));
            }
        });
    }

    public void showNotification(String title, String message) {
        Intent notifyIntent = new Intent(this, MapsEvent.class);
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivities(this, 0,
                new Intent[]{notifyIntent}, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_alert)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .build();
        notification.defaults |= Notification.DEFAULT_SOUND;
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }



}
