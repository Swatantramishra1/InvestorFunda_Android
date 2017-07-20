package com.knowledgeflex.investfund.invest;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

	final int PAGE_COUNT = 4;
	// Tab Titles

	private String tabtitles[] = new String[] { "Our Top Mutual Funds", "Compare Funds", "Choose Your Fund",  "Corporate Fixed Deposits" };
	Context context;

	public ViewPagerAdapter(FragmentManager fm) {
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
			OurTopMutualFund our=new OurTopMutualFund();
			return our;
		case 1:
			CompareFund com = new CompareFund();
			return com;
		case 2:
			ChooseYourFund all=new ChooseYourFund();
			return all;
		case 3:
			CorporateFixedDesposits rec = new CorporateFixedDesposits();
			return rec;
		}
		return null;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return tabtitles[position];
	}


}
