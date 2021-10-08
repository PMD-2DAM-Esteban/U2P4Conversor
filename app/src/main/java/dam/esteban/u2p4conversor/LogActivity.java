package dam.esteban.u2p4conversor;



import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class LogActivity extends AppCompatActivity {

    private final String DEBUG_TAG=("LogAndroid->"+this.getClass().getSimpleName());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(DEBUG_TAG,"onCreate");
        String eventName=(DEBUG_TAG+"onCreate");
        notify(eventName);



    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(DEBUG_TAG,"onPause");
        String eventName=(DEBUG_TAG+"onPause");
        notify(eventName);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(DEBUG_TAG,"onRestart");
        String eventName=(DEBUG_TAG+"onRestart");
        notify(eventName);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(DEBUG_TAG,"onResume");
        String eventName=(DEBUG_TAG+"onResum");
        notify(eventName);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(DEBUG_TAG,"onStart");
        String eventName=(DEBUG_TAG+"onStart");
        notify(eventName);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(DEBUG_TAG,"onStop");
        String eventName=(DEBUG_TAG+"onStop");
        notify(eventName);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()==true){
            Log.i(DEBUG_TAG,"El User FinalizaApp");
            String eventName=(DEBUG_TAG+"El User FinalizaApp");
            notify(eventName);
        }else{
            Log.i(DEBUG_TAG,"System FinalizaApp");
            String eventName=(DEBUG_TAG+"System FinalizaApp");
            notify(eventName);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(DEBUG_TAG,"onRestoreInstanceState");
        String eventName=(DEBUG_TAG+"onRestoreInstanceState");
        notify(eventName);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(DEBUG_TAG,"onSaveInstanceState");
        String eventName=(DEBUG_TAG+"onSaveInstanceState");
        notify(eventName);
    }


    private void notify(String eventName){

        String activivtyName= this.getClass().getSimpleName();

        String CHANNEL_ID= "My_LifeCyrcle";


        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            NotificationChannel notificationChannel= new NotificationChannel(CHANNEL_ID, "My Lifecycle", NotificationManager.IMPORTANCE_DEFAULT);

            notificationChannel.setDescription("Lifecycle events");
            notificationChannel.setShowBadge(true);


            NotificationManager notificationManager= getSystemService(NotificationManager.class);


            if (notificationManager!=null){
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }

        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(this);

        NotificationCompat.Builder notificationBuilder= new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle(eventName+ " "+ activivtyName)
                .setContentText(getPackageName())
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher);

        notificationManagerCompat.notify((int) System.currentTimeMillis(), notificationBuilder.build());

    }

}
