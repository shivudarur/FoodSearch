/*
 * @author Shivanand Darur
 * @version 1.0
 */
package com.holmusk.foodsearch.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.holmusk.foodsearch.R;
import com.holmusk.foodsearch.model.Portion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PortionsAdapter extends BaseExpandableListAdapter {

    private Context context;
    private final List<Portion> portions;
    private HashMap<String, List<String>> listDataChild;

    public PortionsAdapter(Context context, List<Portion> portions) {
        this.context = context;
        this.portions = portions;
        listDataChild = new HashMap<String, List<String>>();
        for (Portion portion : portions) {
            List<String> subPortions = new ArrayList<String>();
            subPortions.add("Unhandled");
            subPortions.add("Important");
            subPortions.add("Extra");
            listDataChild.put(portion.getName(), subPortions);
        }
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this.listDataChild.get(
                this.portions.get(groupPosition).getName()).get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.sub_portion, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.sub_portion_name);

        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 3;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.portions.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.portions.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = ((Portion) getGroup(groupPosition)).getName();
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.portion, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.portion_tv_title);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}