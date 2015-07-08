/*
 * @author Shivanand Darur
 * @version 1.0
 */
package com.holmusk.foodsearch.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.LinearLayout;

import com.holmusk.foodsearch.GlobalValues;
import com.holmusk.foodsearch.R;
import com.holmusk.foodsearch.adapters.PortionsAdapter;
import com.holmusk.foodsearch.adapters.SuggestionAdapter;
import com.holmusk.foodsearch.model.FoodItem;

public class HomeActivity extends Activity implements OnChildClickListener,
        OnItemClickListener {

    public static final String PORTION = "portion";
    SuggestionAdapter suggestionAdapter;
    ExpandableListView mElvPortions;
    AutoCompleteTextView mAcFoodSuggestions;
    String value = "";
    Drawable mClearButton;
    LinearLayout mLlPortionsSection;
    FoodItem selectedFoodItem;
    private GlobalValues globalValues;

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mAcFoodSuggestions = (AutoCompleteTextView) findViewById(R.id.activity_home_ac_food_items);
        mLlPortionsSection = (LinearLayout) findViewById(R.id.activity_home_ll_portions_section);
        suggestionAdapter = new SuggestionAdapter(this, mAcFoodSuggestions
                .getText().toString());
        mAcFoodSuggestions.setAdapter(suggestionAdapter);

        mAcFoodSuggestions.setText(value);
        mClearButton = getResources().getDrawable(
                android.R.drawable.presence_offline);
        mClearButton.setBounds(0, 0, mClearButton.getIntrinsicWidth(),
                mClearButton.getIntrinsicHeight());
        mAcFoodSuggestions.setCompoundDrawables(null, null,
                value.equals("") ? null : mClearButton, null);
        mAcFoodSuggestions
                .setOnTouchListener(new SuggestionItemtouchListener());
        mAcFoodSuggestions.addTextChangedListener(new SuggestionTextWatcher());
        mAcFoodSuggestions.setOnItemClickListener(HomeActivity.this);

        mElvPortions = (ExpandableListView) findViewById(R.id.activity_home_elv_portions);
        globalValues = (GlobalValues) getApplication();
        selectedFoodItem = globalValues.getSelectedFoodItem();

        if (selectedFoodItem != null) {
            PortionsAdapter portionsAdapter = new PortionsAdapter(
                    getApplicationContext(), selectedFoodItem.getPortions());
            mElvPortions.setAdapter(portionsAdapter);
        }
        mElvPortions.setOnChildClickListener(HomeActivity.this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        selectedFoodItem = suggestionAdapter.getFoodItem(position);
        if (selectedFoodItem != null) {
            mLlPortionsSection.setVisibility(View.VISIBLE);
            globalValues.setSelectedFoodItem(selectedFoodItem);
            PortionsAdapter portionsAdapter = new PortionsAdapter(
                    getApplicationContext(), selectedFoodItem.getPortions());
            mElvPortions.setAdapter(portionsAdapter);
        }
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v,
                                int groupPosition, int childPosition, long id) {
        if (childPosition != 0) {
            Intent intent = new Intent(getApplicationContext(),
                    FoodDetailsActivity.class);
            intent.putExtra(PORTION, childPosition);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
        }
        return false;
    }

    class SuggestionItemtouchListener implements OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (mAcFoodSuggestions.getCompoundDrawables()[2] == null) {
                return false;
            }
            if (event.getAction() != MotionEvent.ACTION_UP) {
                return false;
            }
            if (event.getX() > mAcFoodSuggestions.getWidth()
                    - mAcFoodSuggestions.getPaddingRight()
                    - mClearButton.getIntrinsicWidth()) {
                mAcFoodSuggestions.setText("");
                mAcFoodSuggestions.setCompoundDrawables(null, null, null, null);
            }
            return false;
        }
    }

    class SuggestionTextWatcher implements TextWatcher {
        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            String enteredText = mAcFoodSuggestions.getText().toString();
            if (enteredText == null || enteredText.isEmpty()) {
                mAcFoodSuggestions.setCompoundDrawables(null, null, null, null);
                mLlPortionsSection.setVisibility(View.INVISIBLE);

            } else {
                mAcFoodSuggestions.setCompoundDrawables(null, null,
                        mClearButton, null);
            }
        }

        @Override
        public void afterTextChanged(Editable arg0) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
        }
    }
}
