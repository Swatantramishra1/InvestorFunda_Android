package com.knowledgeflex.investfund;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.knowledgeflex.investfund.fragment.BankDetails;
import com.knowledgeflex.investfund.fragment.DepositoryDetail;
import com.knowledgeflex.investfund.fragment.NomineeFragment;
import com.knowledgeflex.investfund.fragment.ProfileEditFragment;
import com.knowledgeflex.investfund.fragment.UploadDocument;

public class Portfolio extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private OnFragmentInteractionListener callback;
   // private Context mContext;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    private String tabtitles[] = new String[] { "Edit Profile", "Bank Details", "Nominee Details", "Depository Details", "Upload Document" };


    final int PAGE_COUNT = 8;
    // Tab Titles


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Context context);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private Fragment portfolioFragments;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    ProfileEditFragment about = new ProfileEditFragment();
                    return about;
                case 1:
                    BankDetails educate=new BankDetails();
                    return educate;
                case 2:
                    NomineeFragment project=new NomineeFragment();
                    return project;
                case 3:
                    DepositoryDetail detail = new DepositoryDetail();
                    return detail;
                case 4:
                    UploadDocument exp = new UploadDocument();
                    return exp;
            }
            return null;/*  case GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE:
                    this.portfolioFragments = new ProfileEditFragment();
                    break;
                case ValueAnimator.RESTART *//*1*//*:
                    this.portfolioFragments = new BankDetails();
                    break;
                case ValueAnimator.REVERSE *//*2*//*:
                    this.portfolioFragments = new NomineeFragment();
                    break;
                case ConnectionResult.SERVICE_DISABLED *//*3*//*:
                    this.portfolioFragments = new UploadDocument();
                    break;
                default:
                    this.portfolioFragments = new BankDetails();*/
           /* return this.portfolioFragments;*/
        }

        public int getCount() {
            return 5;
        }

        public CharSequence getPageTitle(int position) {
            return tabtitles[position];
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        //mContext = this;
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(this);
        ((TabLayout) findViewById(R.id.tabs)).setupWithViewPager(mViewPager);
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.i("Page Scrolled", "Page Scrolled");
    }

    public void onPageSelected(int position) {
        Log.i("Page Selected", "Page Selected");
        try {
        switch (position) {
           case 0:
                callback = (ProfileEditFragment) getSupportFragmentManager().findFragmentById(R.id.container);
                callback.onFragmentInteraction(this);
                return;
            case 1:
                callback = (BankDetails) getSupportFragmentManager().findFragmentById(R.id.container);
                callback.onFragmentInteraction(this);
                return;
            case 2:
                callback = (NomineeFragment) getSupportFragmentManager().findFragmentById(R.id.container);
                callback.onFragmentInteraction(this);
                return;
            case 3:
                callback = (UploadDocument) getSupportFragmentManager().findFragmentById(R.id.container);
                callback.onFragmentInteraction(this);
                return;
            default:
                return;
        }
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

    }

    public void onPageScrollStateChanged(int state) {
        Log.i("Page ScrollState", "Page ScrollState");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            return true;
        }
        if (item.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
