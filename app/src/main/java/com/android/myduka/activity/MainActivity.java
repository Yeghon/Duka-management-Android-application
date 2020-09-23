package com.android.myduka.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.android.myduka.adapter.MyDukaAdapter;
import com.android.myduka.fragments.MyDukaMainFragment;
import com.android.myduka.fragments.MySupppliersFragment;
import com.android.myduka.fragments.NewsFragment;
import com.android.myduka.model.MyDukaProducts;
import com.android.myduka.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private Toolbar toolbar;
    private TabLayout tabLayout;

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MyDukaMainFragment(), "ONE");
        adapter.addFragment(new MySupppliersFragment(), "TWO");
//        adapter.addFragment(new NewsFragment(), "TWO");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mList = new ArrayList<>();
        private final List<String> mTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int i) {
            return mList.get(i);
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mList.add(fragment);
            mTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);
        }
    }
}
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        RecyclerView rv = findViewById(R.id.recycler_view);
//
//        FloatingActionButton fb = findViewById(R.id.productAddNewProduct);
//        fb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Wanna add a new product?", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        MyDukaProducts sugar = new MyDukaProducts("Sugar", "Ksh. 112 / Kg", "34%");
//        MyDukaProducts salt = new MyDukaProducts("Salt", "Ksh. 30 / Kg", "65%");
//        MyDukaProducts oil = new MyDukaProducts("Oil", "Ksh. 156 / ltr", "87%");
//        MyDukaProducts teaLeaves = new MyDukaProducts("Tea Leaves", "Ksh. 200 / Kg", "34.4%");
//        MyDukaProducts flour = new MyDukaProducts("Flour", "Ksh. 126 / Kg", "12.5%");
//        MyDukaProducts soap = new MyDukaProducts("Soap", "Ksh. 150 / Kg", "98%");
//
//        ArrayList<MyDukaProducts> myDukaProductsList = new ArrayList<>();
////        Collections.emptyList();
////        List<>();
//        myDukaProductsList.add(sugar);
//        myDukaProductsList.add(salt);
//        myDukaProductsList.add(oil);
//        myDukaProductsList.add(teaLeaves);
//        myDukaProductsList.add(flour);
//        myDukaProductsList.add(soap);
//
//        MyDukaAdapter ca = new MyDukaAdapter(myDukaProductsList);
//        rv.setAdapter(ca);
//
//        LinearLayoutManager llm = new LinearLayoutManager(this);
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
//        rv.setLayoutManager(llm);
//    }
//
//
//
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
////        int id = item.getItemId();
//        switch(item.getItemId())
//        {
//            case R.id.search_product:
//                new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
//                        .setTitleText(".. coming soon ...")
//                        .setContentText("Search is coming soon!")
//                        .show();
//
//                break;
//            case R.id.inbox:
//                break;
//            case R.id.help:
//                break;
//            case R.id.logout:
//                break;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}
