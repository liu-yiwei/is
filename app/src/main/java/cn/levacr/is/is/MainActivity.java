package cn.levacr.is.is;

import android.animation.Animator;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.isnc.facesdk.SuperID;

import cn.levacr.is.is.local.LocalFragment;
import cn.levacr.is.is.pref.PrefFragment;
import cn.levacr.is.is.util.ActivityUtils;
import io.codetail.animation.ViewAnimationUtils;

public class MainActivity extends AppCompatActivity {


    private View mPrefView;
    private PrefFragment mPrefFragment;
    private android.app.FragmentManager mPrenFragmentManager;
    private android.support.v4.app.FragmentManager mFragmentManager;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actions_menu, menu);
        return true;
    }

    //actionbar 上的监听器
    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.setting:
                    turnToPrefrence();
                    break;
                case R.id.close:
                    turnToHome();
                    break;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //设置actionbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toobar);
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(onMenuItemClick);

        mPrefView = findViewById(R.id.pref);
        mFragmentManager =getSupportFragmentManager();
        mPrenFragmentManager = getFragmentManager();
        if(mPrefFragment == null)
            mPrefFragment = new PrefFragment();
        LocalFragment localFragment = new LocalFragment();
        ActivityUtils.UtilsV4.addFragmentToActivity(mFragmentManager, localFragment,R.id.main);

    }

    void turnToPrefrence (){
        ActivityUtils.UnitlsV3.addFragmentToActivity(mPrenFragmentManager, mPrefFragment,R.id.pref);
        mPrefView.setVisibility(View.VISIBLE);

        int cx =mPrefView.getHeight();
        int cy =100;
        int dx = Math.max(cx, mPrefView.getWidth() - cx);
        int dy = Math.max(cy, mPrefView.getHeight() - cy);
        float finalRadius = (float) Math.hypot(dx, dy);

        // Android native animator
        Animator animator =
                ViewAnimationUtils.createCircularReveal(mPrefView, cx, cy, 0, finalRadius);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.setDuration(500);
        animator.start();
    }
    void turnToHome(){

        int cx =mPrefView.getHeight();
        int cy =100;
        int dx = Math.max(cx, mPrefView.getWidth() - cx);
        int dy = Math.max(cy, mPrefView.getHeight() - cy);
        float finalRadius = (float) Math.hypot(dx, dy);

        Animator animator =
                ViewAnimationUtils.createCircularReveal(mPrefView, cx, cy, finalRadius, 0);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.setDuration(500);
        animator.start();
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mPrefView.setVisibility(View.INVISIBLE);
                ActivityUtils.UnitlsV3.removeFragmentFromActivity(mPrenFragmentManager, mPrefFragment);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });


    }
}
