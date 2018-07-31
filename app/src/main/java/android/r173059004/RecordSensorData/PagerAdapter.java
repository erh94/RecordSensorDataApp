package android.r173059004.RecordSensorData;

/**
 * Created by HS on 04-03-2018.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

//    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
//        super(fm);
//        this.mNumOfTabs = NumOfTabs;
//    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                LoginFragment tab1 = new LoginFragment();
                return tab1;
            case 1:
                SensorsFragment tab2 = new SensorsFragment();
                return tab2;

            case 2:
                RecordsFragment tab3 = new RecordsFragment();
                return tab3;


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

