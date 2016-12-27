package com.demo.app.androidsdkdemo;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.growingio.android.sdk.collection.GrowingIO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";


    private SparseArray<Class> ACTIVITIES = new SparseArray<>(6);

    {
        ACTIVITIES.put(R.id.list_demo, ListActivity.class);
        ACTIVITIES.put(R.id.webview_demo, SystemWebActivity.class);
        ACTIVITIES.put(R.id.x5webview_demo, X5WebViewActivity.class);
        ACTIVITIES.put(R.id.vp_fragment_demo, ViewPagerFragmentActivity.class);
        ACTIVITIES.put(R.id.tab_fragment_demo, TabActivity.class);
        ACTIVITIES.put(R.id.tab_fragment_demo2, Tab2Activity.class);
        ACTIVITIES.put(R.id.list_demo2, ListActivity2.class);
        ACTIVITIES.put(R.id.tablayout_vp_fragment, TabLayoutFragmentActivity.class);
    }

    private BannerClickListener mBannerListener = new BannerClickListener() {
        @Override
        public void onClick(int position) {
            String url = BLOG_POSTS.get(position % BLOG_POSTS.size());
            Log.i(TAG, "onClick: open " + url);
            Intent openUrl = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(openUrl);
        }
    };

    private ArrayList<String> BANNER_IMAGES = new ArrayList<>();

    {
        BANNER_IMAGES.add("https://assets.growingio.com/blog/storage/image/9067f093995d17e1d1edc8ee5d90c67b.jpeg");
        BANNER_IMAGES.add("https://assets.growingio.com/blog/storage/image/76c5cbbffd3e804ef2db9801fed25a25.jpeg");
        BANNER_IMAGES.add("https://assets.growingio.com/blog/storage/image/5c059eabde75b6708f63eb8352eeef12.jpeg");
        BANNER_IMAGES.add("https://assets.growingio.com/blog/storage/image/eb47c4e4ac22e888684b089074aa1bc0.jpeg");
        BANNER_IMAGES.add("https://assets.growingio.com/blog/storage/image/b2e0b25df0da8d9563b031e66a7e9e96.jpeg");
        BANNER_IMAGES.add("https://assets.growingio.com/blog/storage/image/e6116a8955d615ff4385cc90e481e6a0.jpeg");
        BANNER_IMAGES.add("https://assets.growingio.com/blog/storage/image/73cdce8e5dadde8474f58b3d859c8775.jpeg");
    }

    private ArrayList<String> BLOG_POSTS = new ArrayList<>();

    {
        BLOG_POSTS.add("https://blog.growingio.com/posts/activity_2");
        BLOG_POSTS.add("https://blog.growingio.com/posts/hu-lian-wang-chuang-ye-gong-si-yong-hu-zeng-zhang-shi-zhan-mi-ji");
        BLOG_POSTS.add("https://blog.growingio.com/posts/funcation_1");
        BLOG_POSTS.add("https://blog.growingio.com/posts/esoterica_3");
        BLOG_POSTS.add("https://blog.growingio.com/posts/esoterica_2");
        BLOG_POSTS.add("https://blog.growingio.com/posts/customer_2");
        BLOG_POSTS.add("https://blog.growingio.com/posts/esoterica_1");
    }

    private SparseArray<String> URLS = new SparseArray<>(5);

    {
        URLS.put(R.id.nav_documents, "https://help.growingio.com/SDK/Android.html");
        URLS.put(R.id.nav_source_code, "https://github.com/GrowingIOSamples/android-sdk-demo");
        URLS.put(R.id.nav_website, "https://www.growigio.com");
        URLS.put(R.id.nav_free_try, "https://www.growingio.com/signup");
        URLS.put(R.id.nav_job, "https://www.growingio.com/joinus");
    }

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent start = new Intent(MainActivity.this, ACTIVITIES.get(v.getId()));
            startActivity(start);
        }
    };

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        GrowingIO.getInstance().trackEditText((EditText) findViewById(R.id.editText));
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = ((MyApplication) getApplication()).mCurrentLocation;
                if (TextUtils.isEmpty(location)) {
                    location = "GrowingIO";
                }
                Snackbar.make(view, location, Snackbar.LENGTH_LONG)
                        .setAction("Click me", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i(TAG, "Snackbar action onClick: " + v);
                            }
                        }).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        assert drawer != null;
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        for (int i = 0; i < ACTIVITIES.size(); i++) {
            findViewById(ACTIVITIES.keyAt(i)).setOnClickListener(mClickListener);
        }
        initBanner();
    }

    private void initBanner() {

        final RecyclerView banner = (RecyclerView) findViewById(R.id.main_banner);
        assert banner != null;
        banner.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new BannerItemHolder(new ImageView(MainActivity.this), mBannerListener);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                Glide.with(MainActivity.this).load(BANNER_IMAGES.get(position % BANNER_IMAGES.size())).into((ImageView) holder.itemView);
            }

            @Override
            public int getItemCount() {
                return Integer.MAX_VALUE;
            }
        });
        banner.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        banner.scrollToPosition(Integer.MAX_VALUE / 2);
        GrowingIO.trackBanner(banner, BLOG_POSTS);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            Toast.makeText(this, "退出应用", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent openURL = new Intent(Intent.ACTION_VIEW, Uri.parse(URLS.get(id)));
        startActivity(openURL);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        assert drawer != null;
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private static class BannerItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        BannerClickListener listener;

        BannerItemHolder(ImageView itemView, BannerClickListener listener) {
            super(itemView);
            this.listener = listener;
            itemView.setOnClickListener(this);
            itemView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            itemView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }

        @Override
        public void onClick(View v) {
            listener.onClick(getAdapterPosition());
        }
    }

    interface BannerClickListener {
        void onClick(int position);
    }
}
