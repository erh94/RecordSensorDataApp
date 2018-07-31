package android.r173059004.RecordSensorData;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Toolbar custom_toolbar;
        custom_toolbar = (Toolbar) findViewById(R.id.common_actionbar);
        setSupportActionBar(custom_toolbar);
        custom_toolbar.setLogo(R.drawable.ic_iitb_logo);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Register"));
        tabLayout.addTab(tabLayout.newTab().setText("Sensors"));
        tabLayout.addTab(tabLayout.newTab().setText("Record"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.commonmenus,menu); //to infalte the menu layout to activity
        // first parameter is layout
        // second parameter is parent that is the menu

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem anyitem) {
//        int id = anyitem.getItemId();
//        if( id== R.id.about_menu)
//        {
//            Toast.makeText(this, "About menu is clicked",Toast.LENGTH_SHORT).show();
//            startActivity(new Intent(this, RegisterActivity.class));
//        }
        return super.onOptionsItemSelected(anyitem);
    }




//    private Toolbar custom_Toolbar;
//
//    @Override
//    public void setContentView(int layoutResID)
//    {
//        super.setContentView(layoutResID);
//        initializeToolbar(); // we are not setting the view of this activity
//    }


//    protected Toolbar initializeToolbar() {
//        if (custom_Toolbar == null) {
//            custom_Toolbar = (Toolbar) findViewById(R.id.common_actionbar);
//            custom_Toolbar.setTitle("");
//            custom_Toolbar.setLogo(R.drawable.ic_iitb_logo);
//

//            actionbar_spinner = (Spinner)findViewById(R.id.dropdown);
//            ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(BaseActivity.this,
//                    android.R.layout.simple_list_item_1,
//                    getResources().getStringArray(R.array.actionbar_dropdown_names));
//
//            myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            actionbar_spinner.setAdapter(myAdapter);
//
//            actionbar_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                @Override
//                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                    if (defaultSpinnerSelection) {
//                        defaultSpinnerSelection = false;
//                        return;
//                    }
//
//                    if (i==currentlySelected)
//                    {
////                        fromRecords=false;
//                        return;
//                    }
//
//                    final Intent intent;
//
//                    switch (i) {
//                        case 1:
//                            intent = new Intent(view.getContext(), RegisterActivity.class);
//                            startActivity(intent);
//                            break;
//                        case 2:
//                            intent = new Intent(view.getContext(), SensorsActivity.class);
//                            startActivity(intent);
//                            break;
//
//                    }
//                }
//
//                @Override
//                public void onNothingSelected(AdapterView<?> adapterView) {
//
//                }
//            });
//
//            setSupportActionBar(custom_Toolbar);
//        }
//
//        return custom_Toolbar;
//    }



}