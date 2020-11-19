package name.yluo.SmartBioViewer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
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
                CustomInfo.target = CustomInfo.Target.IFN_gama;
                Intent intent = new Intent(TargetActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        CardView cardView2 = (CardView) findViewById(R.id.target_2);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomInfo.target = CustomInfo.Target.TNF_alpha;
                Intent intent = new Intent(TargetActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        CardView cardView3 = (CardView) findViewById(R.id.target_3);
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomInfo.target = CustomInfo.Target.IL_6;
                Intent intent = new Intent(TargetActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}