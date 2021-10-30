package com.example.notification26082021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.notification26082021.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.buttonOpenNotifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity.class);

                TaskStackBuilder stackBuilder = TaskStackBuilder.create(MainActivity.this);
                stackBuilder.addNextIntentWithParentStack(intent);

                PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "CHANNEL_ID");
                builder.setSmallIcon(android.R.drawable.ic_dialog_email);
                builder.setShowWhen(true);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_dialog_email));
                builder.setContentTitle("Thông báo");
                builder.setContentText("Ứng dụng có phiên bản cập nhật mới!!");
                builder.setContentIntent(pendingIntent);

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel notificationChannel = new NotificationChannel("CHANNEL_ID", "CHANNEL", NotificationManager.IMPORTANCE_DEFAULT);
                    notificationManager.createNotificationChannel(notificationChannel);
                }

                notificationManager.notify(1, builder.build());
            }
        });
    }
}