package com.knowledgeflex.investfund.tax;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class SaveTaxAdapter extends FragmentStatePagerAdapter {

    final int PAGE_COUNT = 2;
    // Tab Titles

    private String tabtitles[] = new String[] { "Customized tax saving portfolio", "ELSS TAX SAVINGS SIP" };
    Context context;

    public SaveTaxAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                CustomizedTaxSavings rec = new CustomizedTaxSavings();
                return rec;
            case 1:
                ElssTaxSavings all=new ElssTaxSavings();
                return all;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }


}
