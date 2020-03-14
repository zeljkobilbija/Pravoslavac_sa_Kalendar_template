package com.interfacemockup.kalendar.fcm;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.interfacemockup.kalendar.R;
import com.interfacemockup.kalendar.SplashScreen;

public class FirebaseMessageReceiver extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if (remoteMessage.getData().size() > 0){
            showNotification(remoteMessage.getData().get("title"), remoteMessage.getData().get("message"));
        }

        if (remoteMessage.getNotification() != null){
            showNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
        }
    }


            private RemoteViews getCustomDesign(String title, String message){
                    RemoteViews remoteViews = new RemoteViews(getApplicationContext().getPackageName(), R.layout.notification );
                    remoteViews.setTextViewText(R.id.idTitle, title);
                    remoteViews.setTextViewText(R.id.idMessage, message);
                    remoteViews.setImageViewResource(R.id.idMessageIcon,R.drawable.jesus);
                    return remoteViews;
    }

    public void showNotification(String title, String message){

                    Intent intent = new Intent(this, SplashScreen.class);
                    String channel_id = "web_app_channel";
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    Context context;
                    PendingIntent pendingIntetnt = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
                    Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channel_id)
                            .setSmallIcon(R.drawable.jesus)
                            .setSound(uri)
                            .setAutoCancel(true)
                            .setVibrate(new long[]{1000,1000,1000,1000})
                            .setOnlyAlertOnce(false)
                            .setContentIntent(pendingIntetnt);

                    if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN){
                        builder = builder.setContent(getCustomDesign(title,message));
                    }else {
                        builder = builder.setContentTitle(title)
                                .setContentText(message)
                                .setSmallIcon(R.drawable.jesus);
                    }

                    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                    if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                        CharSequence name;
                        NotificationChannel notificationChannel = new NotificationChannel(channel_id, "web_app",NotificationManager.IMPORTANCE_HIGH );
                        notificationChannel.setSound(uri, null);
                        assert notificationManager != null;
                        notificationManager.createNotificationChannel(notificationChannel);
                    }

        assert notificationManager != null;
        notificationManager.notify(0,builder.build());


    }
}
