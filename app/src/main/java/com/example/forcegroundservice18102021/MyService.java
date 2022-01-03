package com.example.forcegroundservice18102021;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyService extends Service {

    String CHANNEL_ID = "mychannel";
    NotificationManager mNotificationManager;
    Notification mNotification;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("BBB", "OnCreate");
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotification = createNotification(this, "Khởi tạo lần đầu");
        mNotificationManager.notify(1, mNotification);
        startForeground(1, mNotification);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        Log.d("BBB","onStartCommand");
        mNotification = createNotification(this, "Xử lý");
        mNotificationManager.notify(1, mNotification);
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("BBB", "onDestroy");
    }

    private Notification createNotification(Context context, String message) {
        NotificationCompat.Builder notificationCompat = new NotificationCompat.Builder(context, CHANNEL_ID);
        notificationCompat.setContentTitle("Thông báo");
        notificationCompat.setContentText(message);
        notificationCompat.setShowWhen(true);
        notificationCompat.setSmallIcon(R.drawable.ic_launcher_background);
        return notificationCompat.build();
    }
}
