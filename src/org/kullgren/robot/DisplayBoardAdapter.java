package org.kullgren.robot;

import java.util.ArrayList;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class DisplayBoardAdapter extends BaseAdapter{
	private MainActivity mContext;
	private ArrayList<BoardPosition> mBoardPosition;
	
	public DisplayBoardAdapter(MainActivity mainActivity, ArrayList<BoardPosition> boardPosition) {
		mContext = mainActivity;
		mBoardPosition = boardPosition;
	}

	@Override
	public int getCount() {
		return 400;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(24, 24));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0, 0, 0, 0);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[mBoardPosition.get(position).getBlockedDirection().ordinal()]);
        return imageView;
	}

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.open_space, R.drawable.blocked_up,
            R.drawable.blocked_right, R.drawable.blocked_down, R.drawable.blocked_left
    };
}
