package com.knowledgeflex.investfund.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.util.AttributeSet;

/**
 * Created by Vinoth on 7/17/2017.
 */

public class CustomCheckedTextView extends AppCompatCheckedTextView {

    public CustomCheckedTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }
    public CustomCheckedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }
    public CustomCheckedTextView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }
    public void setTypeface(Typeface tf, int style) {
        if(!this.isInEditMode()){
            Typeface boldTypeface = Typeface.createFromAsset(getContext().getAssets(), "arial_narrow.ttf");
                super.setTypeface(boldTypeface/*, -1*/);
        }

    }
}
