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

        final Board board = new Board(20, 20);
        board.createRandomBoard();

        Robot robot = new Robot();
        board.addRobot(robot, 9, 19);
        
        GridView boardView = (GridView) findViewById(R.id.Board);
        final BaseAdapter boardAdapter = new DisplayBoardAdapter(this, board);
        boardView.setAdapter(boardAdapter);

        GridView handView = (GridView) findViewById(R.id.Hand);
        final BaseAdapter handAdapter = new DisplayCardsAdapter(this, hand);
        handView.setAdapter(handAdapter);

        handView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                    int position, long id) {
                hand.selectCard(position);
                handAdapter.notifyDataSetChanged();
            }
        });

        GridView controlView = (GridView) findViewById(R.id.Control);
        controlView.setAdapter(new DisplayControlAdapter(this));

        controlView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                    int position, long id) {
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
                case 3:
                    // execute moves
                    hand.execute(board);
                    boardAdapter.notifyDataSetChanged();
                    break;
                default:
                    break;
                }
                handAdapter.notifyDataSetChanged();
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

        return true;
    }

}
