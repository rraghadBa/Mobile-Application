package com.example.ch12;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
public class MainActivity extends AppCompatActivity {
    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Attach the SectionsPagerAdapter to the ViewPager
        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        //Attach the FragmentPagerAdapter to the ViewPager.
        pager.setAdapter(pagerAdapter);

        //Attach the ViewPager to the TabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        //This links the ViewPager to the TabLayout.
        tabLayout.setupWithViewPager(pager);

    }

    /*    @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the app bar.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            MenuItem menuItem = menu.findItem(R.id.action_share);
            shareActionProvider =
                    (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
            setShareActionIntent("Want to join me for pizza?");
            return super.onCreateOptionsMenu(menu);
        }*/
    private void setShareActionIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }

    //   @Override
    // public boolean onOptionsItemSelected(MenuItem item) {
    //   switch (item.getItemId()) {
    //case R.id.action_create_order:
    //    Intent intent = new Intent(this, OrderActivity.class);
    //   startActivity(intent);
    //    return true;
    // default:
    //         return super.onOptionsItemSelected(item);
    // }
    // }
    //The FragmentPagerAdapter passes information to the ViewPager.
    private class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        //Say how many pages the ViewPager should contain.
        public int getCount() {
            return 4;
        }

        @Override
        //Specify which fragment should appear on each page.
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new TopFragment();
                case 1:
                    return new PizzaFragment();
                case 2:
                    return new PastaFragment();
                case 3:
                    return new StoresFragment();
            }
            return null;
        }

        //This method adds the text to the tabs.
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Home";
                case 1:
                    return getResources().getText(R.string.pizza_tab);
                case 2:
                    return getResources().getText(R.string.pasta_tab);
                case 3:
                    return getResources().getText(R.string.store_tab);
            }
            return null;
        }
    }
}


