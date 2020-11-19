package name.yluo.SmartBioViewer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    public Window window;
    public Toolbar toolbar;
    public TextView tv_target;
    public TextView tv_mode;
    public Button btn_start;
    public TextView tv_state;
    public DrawerLayout mDrawerLayout;

//    static int r = 0x00;
//    static int g = 0xDA;
//    static int b = 0x29;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.backup:
                Toast.makeText(this, "You clicked backup!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                break;
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.viewGithub:
                Intent in = new Intent(Intent.ACTION_VIEW);
                in.setData(Uri.parse("https://github.com/thinkexist1989/SmartBioViewer"));
                startActivity(in);
                break;
            default:
        }
        return true;
//        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
//        return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv_target.setText(CustomInfo.target.toString());
        tv_mode.setText(CustomInfo.testMode.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        window = this.getWindow();
        //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //设置状态栏颜色
//        window.setStatusBarColor(Color.parseColor("#000000"));

        btn_start = (Button) findViewById(R.id.button_start);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv_target = (TextView) findViewById(R.id.textView_target);
        tv_target.setText(CustomInfo.target.toString());

        tv_mode = (TextView) findViewById(R.id.textView_mode);
        tv_mode.setText(CustomInfo.testMode.toString());

        tv_state = (TextView) findViewById(R.id.textView_state);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar  actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }

        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
//        navView.setCheckedItem(R.id.nav_target);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_mode:
                        Log.i(TAG, "mode selection");
                        Intent intent1 = new Intent(MainActivity.this, ModeActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_target:
                        Intent intent2 = new Intent(MainActivity.this, TargetActivity.class);
                        startActivity(intent2);
                        break;
                    default:
                }

                mDrawerLayout.closeDrawers();
                return true;
            }
        });

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                r = (int) ((float)i*0.001*218);
//                g = (int) ((float)(1000.0 - i)*0.001* 218);
                int i = (int) (Math.random()*1000);

                if(i >= 1000) i = 0;
                int color = CustomColor.getColor(i);
                Log.i(TAG, "r is: " + Color.red(color) + "  g is: " + Color.green(color));
//                window.setStatusBarColor(color);
//                toolbar.setBackgroundColor(color);

//                ((GradientDrawable) tv_mode.getBackground()).setColor(color);
//                ((GradientDrawable) tv_target.getBackground()).setColor(color);
//                ((GradientDrawable) tv_state.getBackground()).setColor(color);

                if(i <= 333)
                    tv_state.setText("NORMAL");
                else if(i > 333 && i < 666)
                    tv_state.setText("WARNING");
                else
                    tv_state.setText("ALERT");
//                toolbar.setBackgroundColor(Color.rgb(r, g ,b));


            }
        });
    }
}