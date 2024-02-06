package latihan.membuat.kuis1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
LinearLayout button1, button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (LinearLayout) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //catat di log
                Log.d("PROFIL", "Masuk ke profil");
                //pindah dari quizactivity ke pertemuan3activity
                Intent intent = new Intent(MainActivity.this, Profile.class);
                startActivity(intent);
            }
   });
        button2 = (LinearLayout) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //catat di log
                Log.d("TODO", "Masuk ke todo");
                //pindah dari quizactivity ke todoactivity
                Intent intent = new Intent(MainActivity.this, LatihanMembuatKomponen.class);
                startActivity(intent);
            }
   });

    }
}