package com.sumon.nuguideline.adapter;

import java.util.HashMap;
import java.util.List;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.sumon.nuguideline.view.FontManager;
import com.sumon.nuguideline.R;


public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> expandableListTitle;
    private HashMap<String, List<String>> expandableListDetail;

    public static int ITEM1 = 0;
    public static int ITEM2 = 1;
    public static int ITEM3 = 2;
    public static int ITEM4 = 3;
    public static int ITEM5 = 4;


    public static int SUBITEM3_1 = 0;
    public static int SUBITEM3_2 = 1;
    public static int SUBITEM3_3 = 2;


    public static int SUBITEM2_1 = 0;
    public static int SUBITEM2_2 = 1;
    public static int SUBITEM2_3 = 2;




    public ExpandableListAdapter(Context context, List<String> expandableListTitle,
                                 HashMap<String, List<String>> expandableListDetail) {
        this.context = context;
        this.expandableListTitle = expandableListTitle;
        this.expandableListDetail = expandableListDetail;


    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                .get(expandedListPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final String expandedListText = (String) getChild(listPosition, expandedListPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }

        TextView expandedListTextView = (TextView) convertView
                .findViewById(R.id.expandedListItem);

        TextView sublistTitleTextIconView = convertView.findViewById(R.id.tvlistTitleIcon);
        sublistTitleTextIconView.setTypeface(null, Typeface.NORMAL);
        sublistTitleTextIconView.setTypeface(FontManager.getTypeface(context, FontManager.FONTAWESOME));
        if (listPosition == SUBITEM2_1)
            sublistTitleTextIconView.setText(context.getResources().getString(R.string.fa_cse));
        else if (listPosition == SUBITEM2_2)
            sublistTitleTextIconView.setText(context.getResources().getString(R.string.fa_ece));
        else if (listPosition == SUBITEM2_3)
            sublistTitleTextIconView.setText(context.getResources().getString(R.string.fa_bba));

        else if (listPosition == SUBITEM3_1)
            sublistTitleTextIconView.setText(context.getResources().getString(R.string.fa_calculator_details));
        else if (listPosition == SUBITEM3_2)
            sublistTitleTextIconView.setText(context.getResources().getString(R.string.fa_calculator));
        else if (listPosition == SUBITEM3_3)
            sublistTitleTextIconView.setText(context.getResources().getString(R.string.fa_calculator_history));

        expandedListTextView.setText(expandedListText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                .size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.expandableListTitle.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return this.expandableListTitle.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String listTitle = (String) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }
        TextView listTitleTextView = (TextView) convertView
                .findViewById(R.id.listTitle);
        listTitleTextView.setTypeface(null, Typeface.NORMAL);
        listTitleTextView.setText(listTitle);


        TextView listTitleTextArrowView = (TextView) convertView
                .findViewById(R.id.listTitleArrow);
        listTitleTextArrowView.setTypeface(null, Typeface.NORMAL);
        listTitleTextArrowView.setTypeface(FontManager.getTypeface(context, FontManager.FONTAWESOME));

        // set icons for menu items
        TextView listTitleTextIconView = (TextView) convertView
                .findViewById(R.id.listTitleIcon);
        listTitleTextIconView.setTypeface(null, Typeface.NORMAL);
        listTitleTextIconView.setTypeface(FontManager.getTypeface(context, FontManager.FONTAWESOME));
        if (listPosition == ITEM1)
            listTitleTextIconView.setText(context.getResources().getString(R.string.fa_admission));
        else if (listPosition == ITEM2)
            listTitleTextIconView.setText(context.getResources().getString(R.string.fa_book));
        else if (listPosition == ITEM3)
            listTitleTextIconView.setText(context.getResources().getString(R.string.fa_cgpa));
        else if (listPosition == ITEM4)
            listTitleTextIconView.setText(context.getResources().getString(R.string.fa_form));
        else if (listPosition == ITEM5)
            listTitleTextIconView.setText(context.getResources().getString(R.string.fa_notice));

        // set arrow icons for relevant items
        if (listPosition == ITEM2 || listPosition == ITEM3) {
            if (!isExpanded)
                listTitleTextArrowView.setText(context.getResources().getString(R.string.fa_chevron_right));
            else
                listTitleTextArrowView.setText(context.getResources().getString(R.string.fa_chevron_down));
        } else {
            listTitleTextArrowView.setText("");

        }
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }

}
