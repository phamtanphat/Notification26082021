package com.example.notification26082021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.graphics.BitmapFactory;
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
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"CHANNEL_ID");
                builder.setSmallIcon(android.R.drawable.ic_dialog_email);
                builder.setShowWhen(true);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),android.R.drawable.ic_dialog_email));
                builder.setContentTitle("Thông báo");
                builder.setContentText("Ứng dụng có phiên bản cập nhật mới!!");

            }
        });
    }
}