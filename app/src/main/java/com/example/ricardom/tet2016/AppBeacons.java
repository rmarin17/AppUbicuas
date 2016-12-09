package com.example.ricardom.tet2016;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.example.ricardom.tet2016.receivers.BeaconReceiver;

import java.util.List;
import java.util.UUID;

/**
 * Created by RicardoM on 19/11/2016.
 */

public class AppBeacons extends Application implements BeaconManager.MonitoringListener{

    static final UUID BEACON_UUID = UUID.fromString("f7826da6-4fa2-4e98-8024-bc5b71e0893e");
    static final int MAJOR = 703;
    static final int MINOR = 45750;

    BeaconManager manager;
    Region region;

    String pabellon;

    @Override
    public void onCreate() {
        super.onCreate();

        region = new Region("beacons", BEACON_UUID, null,null);
        manager =  new BeaconManager(getApplicationContext());
        manager.connect(new BeaconManager.ServiceReadyCallback(){

            @Override
            public void onServiceReady() {
                manager.startRanging(region);
                manager.setRangingListener(new BeaconManager.RangingListener(){

                    @Override
                    public void onBeaconsDiscovered(Region region, List<Beacon> list) {

                        for (int i=0;i<list.size();i++) {
                            //Enviar un mensaje en BROADCAST
                            Intent intent = new Intent(BeaconReceiver.ACTION_BEACON);

                            intent.putExtra(BeaconReceiver.EXTRA_MAJOR, list.get(i).getMajor());
                            intent.putExtra(BeaconReceiver.EXTRA_MINOR, list.get(i).getMinor());

                            sendBroadcast(intent);
                            //Crear notificación

                            showNotification("Pabellon Cercano","Se detecto un pabellon cercano");

                        }

                    }
                });
            }
        });

    }

    @Override
    public void onEnteredRegion(Region region, List<Beacon> list) {



    }

    public void showNotification(String title, String message) {
        Intent notifyIntent = new Intent(this, MapsEvent.class);
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivities(this, 0,
                new Intent[]{notifyIntent}, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_prox)
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

    @Override
    public void onExitedRegion(Region region) {

    }
}
