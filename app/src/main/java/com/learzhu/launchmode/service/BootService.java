package com.learzhu.launchmode.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.learzhu.launchmode.SingleTaskActivity;

public class BootService extends Service {
    public BootService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        return super.onStartCommand(intent, flags, startId);
        Intent intent1 = new Intent(BootService.this, SingleTaskActivity.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent1.putExtra("Service", "AAAAAAAAAAAAAa");
        BootService.this.startActivity(intent1);
        return START_STICKY;
    }
}
