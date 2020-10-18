package name.yluo.SmartBioViewer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;

public class ModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        CardView cardView1 = (CardView) findViewById(R.id.mode_1);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomInfo.testMode = CustomInfo.TestMode.SALIVA;
                finish();
            }
        });

        CardView cardView2 = (CardView) findViewById(R.id.mode_2);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomInfo.testMode = CustomInfo.TestMode.URINE;
                finish();
            }
        });
    }
}