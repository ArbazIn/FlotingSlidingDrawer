package com.tech.flotingnavigation;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.tech.flotingnavigation.Adapter.LeftMenuAdapter;
import com.tech.flotingnavigation.Fregment.TestFragment;
import com.tech.flotingnavigation.Listeners.RecyclerItemClickListener;
import com.tech.flotingnavigation.Model.MenuMain;
import com.tech.flotingnavigation.Utils.ElasticDrawer;
import com.tech.flotingnavigation.Utils.FlowingDrawer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TestFragment.OnFragmentInteractionListener {
    private FlowingDrawer drawerlayout;
    private RecyclerView rvMenu;
    private ArrayList<MenuMain> menuMainArrayList;
    LeftMenuAdapter leftMenuAdapter;
    MenuMain menuMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerlayout = (FlowingDrawer) findViewById(R.id.drawerlayout);
        drawerlayout.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        rvMenu = (RecyclerView) findViewById(R.id.rvMenu);
        rvMenu.setLayoutManager(layoutManager);
        setupToolbar();
        menuMainArrayList = new ArrayList<>();
        menuMainArrayList.add(new MenuMain("Testing Data"));
        menuMainArrayList.add(new MenuMain("Testing Data"));
        menuMainArrayList.add(new MenuMain("Testing Data"));
        menuMainArrayList.add(new MenuMain("Testing Data"));
        menuMainArrayList.add(new MenuMain("Testing Data"));
        menuMainArrayList.add(new MenuMain("Testing Data"));
        menuMainArrayList.add(new MenuMain("Testing Data"));
        menuMainArrayList.add(new MenuMain("Testing Data"));
        menuMainArrayList.add(new MenuMain("Testing Data"));
        menuMainArrayList.add(new MenuMain("Testing Data"));
        leftMenuAdapter = new LeftMenuAdapter(menuMainArrayList, this);
        rvMenu.setAdapter(leftMenuAdapter);

        rvMenu.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                menuMain = menuMainArrayList.get(position);
                try {

                    if (menuMain.getItemName().equalsIgnoreCase("Testing Data")) {
                        changeFragment(new TestFragment());
                        drawerlayout = (FlowingDrawer) findViewById(R.id.drawerlayout);
                        drawerlayout.closeMenu();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }));
    }

    void changeFragment(Fragment fragment) {
        try {
            String backStateName = fragment.getClass().getName();
            String fragmentTag = backStateName;

            FragmentManager manager = getSupportFragmentManager();
            boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);


            if (!fragmentPopped && manager.findFragmentByTag(fragmentTag) == null) {
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                fragmentTransaction.replace(R.id.test_container, fragment, fragmentTag);
                fragmentTransaction.addToBackStack(backStateName);
                fragmentTransaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerlayout.toggleMenu();
            }
        });
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
