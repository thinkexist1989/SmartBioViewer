package name.yluo.SmartBioViewer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;

public class TargetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        CardView cardView1 = (CardView) findViewById(R.id.target_1);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomInfo.target = CustomInfo.Target.IFH8;
                finish();
            }
        });

        CardView cardView2 = (CardView) findViewById(R.id.target_2);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomInfo.target = CustomInfo.Target.IL6;
                finish();
            }
        });

        CardView cardView3 = (CardView) findViewById(R.id.target_3);
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomInfo.target = CustomInfo.Target.TNFALPHA;
                finish();
            }
        });

        CardView cardView4 = (CardView) findViewById(R.id.target_4);
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomInfo.target = CustomInfo.Target.TNFBETA;
                finish();
            }
        });
    }
}