package org.kullgren.robot;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements
        ActionBar.OnNavigationListener {

    /**
     * The serialization (saved instance state) Bundle key representing the
     * current dropdown position.
     */
    private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
    private int selectedItem = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Hand hand = new Hand();
        hand.generateRandomCards(5);

        Board board = new Board(20, 20);
        board.createRandomBoard();

        RobotHandler handler = new RobotHandler(board);
        
        Robot robot = new Robot();
        handler.addRobot(robot, 9, 19);
        
        GridView boardView = (GridView) findViewById(R.id.Board);
        boardView.setAdapter(new DisplayBoardAdapter(this, board));

        GridView handView = (GridView) findViewById(R.id.Hand);
        final BaseAdapter handAdapter = new DisplayCardsAdapter(this, hand);
        handView.setAdapter(handAdapter);

        handView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                    int position, long id) {
                hand.selectCard(position);
                if (selectedItem == position) {
                    selectedItem = -1;
                } else {
                    selectedItem = position;
                }
                handAdapter.notifyDataSetChanged();
            }
        });

        GridView controlView = (GridView) findViewById(R.id.Control);
        controlView.setAdapter(new DisplayControlAdapter(this));

        controlView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                    int position, long id) {
                if (position == 3) {
                    // execute moves
                } else if (selectedItem != -1) {
                    switch (position) {
                    case 0:
                        // Move selected item right
                        hand.moveSelectedCardsRight();
                        break;
                    case 1:
                        // Move selected item left
                        hand.moveSelectedCardsLeft();
                        break;
                    case 2:
                        // Throw away cards.
                        hand.invalidateCard();
                        break;
                    default:
                        break;
                    }
                    handAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore the previously serialized current dropdown position.
        if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
            getActionBar().setSelectedNavigationItem(
                    savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Serialize the current dropdown position.
        outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
                .getSelectedNavigationIndex());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(int position, long id) {
        // When the given dropdown item is selected, show its contents in the
        // container view.
        Fragment fragment = new DummySectionFragment();
        Bundle args = new Bundle();
        args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
        fragment.setArguments(args);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment).commit();
        return true;
    }

    /**
     * A dummy fragment representing a section of the app, but that simply
     * displays dummy text.
     */
    public static class DummySectionFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        public static final String ARG_SECTION_NUMBER = "section_number";

        public DummySectionFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main_dummy,
                    container, false);
            TextView dummyTextView = (TextView) rootView
                    .findViewById(R.id.section_label);
            dummyTextView.setText(Integer.toString(getArguments().getInt(
                    ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

}
