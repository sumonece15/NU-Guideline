package com.sumon.nuguideline.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupExpandListener;

import com.sumon.nuguideline.R;
import com.sumon.nuguideline.activity.AdmissionActivity;
import com.sumon.nuguideline.activity.BrowserActivity;
import com.sumon.nuguideline.activity.CalculationDetailsActivity;
import com.sumon.nuguideline.activity.CalculatorActivity;
import com.sumon.nuguideline.activity.DeveloperActivity;
import com.sumon.nuguideline.activity.ResultHistoryActivity;
import com.sumon.nuguideline.activity.SyllabusActivity;
import com.sumon.nuguideline.adapter.ExpandableListAdapter;
import com.sumon.nuguideline.data.ExpandableListDataPump;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Fragment used for managing interactions for and presentation of a navigation drawer.
 * See the <a href="https://developer.android.com/design/patterns/navigation-drawer.html#Interaction">
 * design guidelines</a> for a complete explanation of the behaviors implemented here.
 */
public class NavigationDrawerFragment extends Fragment {

    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

    private NavigationDrawerCallbacks mCallbacks;

    private ActionBarDrawerToggle mDrawerToggle;

    private DrawerLayout mDrawerLayout;
    private ExpandableListView mDrawerListView;
    private View mFragmentContainerView;

    private int mCurrentSelectedPosition = 0;


    ArrayList<String> groupItem = new ArrayList<String>();
    ArrayList<Object> childItem = new ArrayList<Object>();

    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    public NavigationDrawerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Indicate that this fragment would like to influence the set of actions in the action bar.
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mDrawerListView = (ExpandableListView) inflater.inflate(
                R.layout.drawer_drawer, container, false);
        mDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
            }
        });

        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());


        mDrawerListView.setAdapter(new ExpandableListAdapter(getActivity(), expandableListTitle, expandableListDetail));

        mDrawerListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {

            }
        });


        mDrawerListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                boolean retVal = true;

                if (groupPosition == ExpandableListAdapter.ITEM1) {

                    Intent i = new Intent(getActivity(), AdmissionActivity.class);
                    startActivity(i);
                }
                else if (groupPosition == ExpandableListAdapter.ITEM2) {
                    retVal = false;
                } else if (groupPosition == ExpandableListAdapter.ITEM3) {
                    retVal = false;
                } else if (groupPosition == ExpandableListAdapter.ITEM4) {
                    // call some activity here

                    Intent i = new Intent(getActivity(), BrowserActivity.class);
                    i.putExtra("itemPosition", 10);
                    startActivity(i);


                } else if (groupPosition == ExpandableListAdapter.ITEM5) {
                    // call some activity here

                    Intent i = new Intent(getActivity(), BrowserActivity.class);
                    i.putExtra("itemPosition", 11);
                    startActivity(i);


                }
                else if (groupPosition == ExpandableListAdapter.ITEM6) {
                    // call some activity here

                    Intent i = new Intent(getActivity(), DeveloperActivity.class);
                    startActivity(i);


                }
                return retVal;
            }
        });

        mDrawerListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                if (groupPosition == ExpandableListAdapter.ITEM2) {
                    if (childPosition == ExpandableListAdapter.SUBITEM2_1) {

                       // call activity here
                        Intent i = new Intent(getActivity(), SyllabusActivity.class);
                        i.putExtra("deptName", "CSE");
                        startActivity(i);


                    }
                    else if (childPosition == ExpandableListAdapter.SUBITEM2_2) {

                       // call activity here

                        Intent i = new Intent(getActivity(), SyllabusActivity.class);
                        i.putExtra("deptName", "ECE");
                        startActivity(i);

                    }
                    else if (childPosition == ExpandableListAdapter.SUBITEM2_3) {

                        // call activity here
                        Intent i = new Intent(getActivity(), SyllabusActivity.class);
                        i.putExtra("deptName", "BBA");
                        startActivity(i);

                    }


                } else if (groupPosition == ExpandableListAdapter.ITEM3) {

                    if (childPosition == ExpandableListAdapter.SUBITEM3_1) {

                        // call activity here

                        Intent i = new Intent(getActivity(), CalculationDetailsActivity.class);
                        i.putExtra("calType", "calDetails");
                        startActivity(i);

                    }
                    else if (childPosition == ExpandableListAdapter.SUBITEM3_2) {

                        // call activity here

                        Intent i = new Intent(getActivity(), CalculatorActivity.class);
                        i.putExtra("calType", "calculator");
                        startActivity(i);
                    }
                    else if (childPosition == ExpandableListAdapter.SUBITEM3_3) {

                        // call activity here
                        Intent i = new Intent(getActivity(), ResultHistoryActivity.class);
                        i.putExtra("calType", "calHistory");
                        startActivity(i);

                    }



                }
                return true;
            }
        });

        mDrawerListView.setItemChecked(mCurrentSelectedPosition, true);

        View header= inflater.inflate(R.layout.drawer_header, null);
        mDrawerListView.addHeaderView(header);


        return mDrawerListView;
    }



    public boolean isDrawerOpen() {
        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(mFragmentContainerView);
    }

    /**
     * Users of this fragment must call this method to set up the navigation drawer interactions.
     *
     * @param fragmentId   The android:id of this fragment in its activity's layout.
     * @param drawerLayout The DrawerLayout containing this fragment's UI.
     */
    public void setUp(int fragmentId, DrawerLayout drawerLayout) {
        mFragmentContainerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;

        // set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        // set up the drawer's list view with items and click listener

        ActionBar actionBar = getActionBar();
       actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        // ActionBarDrawerToggle ties together the the proper interactions
        // between the navigation drawer and the action bar app icon.
        mDrawerToggle = new ActionBarDrawerToggle(
                getActivity(),                    /* host Activity */
                mDrawerLayout,                    /* DrawerLayout object */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
        ) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActionBar().setIcon(R.drawable.ic_drawer);
                getActionBar().setTitle("Home");
                if (!isAdded()) {
                    return;
                }

                getActivity().supportInvalidateOptionsMenu(); // calls onPrepareOptionsMenu()
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle("Main Menu");

                if (!isAdded()) {
                    return;
                }



                getActivity().supportInvalidateOptionsMenu(); // calls onPrepareOptionsMenu()
            }
        };


        // Defer code dependent on restoration of previous instance state.
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
        mDrawerLayout.openDrawer(mFragmentContainerView);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void selectItem(int position) {
        mCurrentSelectedPosition = position;
        if (mDrawerListView != null) {
            mDrawerListView.setItemChecked(position, true);
        }
        if (mDrawerLayout != null) {
            mDrawerLayout.closeDrawer(mFragmentContainerView);
        }
        if (mCallbacks != null) {
            mCallbacks.onNavigationDrawerItemSelected(position);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallbacks = (NavigationDrawerCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Forward the new configuration the drawer toggle component.
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // If the drawer is open, show the global app actions in the action bar. See also
        // showGlobalContextActionBar, which controls the top-left area of the action bar.
        if (mDrawerLayout != null && isDrawerOpen()) {
            inflater.inflate(R.menu.menu_main, menu);
            showGlobalContextActionBar();
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    /**
     * Per the navigation drawer design guidelines, updates the action bar to show the global app
     * 'context', rather than just what's in the current screen.
     */
    private void showGlobalContextActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);

    }

    private ActionBar getActionBar() {
        return ((AppCompatActivity) getActivity()).getSupportActionBar();
    }

    /**
     * Callbacks interface that all activities using this fragment must implement.
     */
    public static interface NavigationDrawerCallbacks {
        /**
         * Called when an item in the navigation drawer is selected.
         */
        void onNavigationDrawerItemSelected(int position);
    }
}
