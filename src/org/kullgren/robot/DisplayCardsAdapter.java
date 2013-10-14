package org.kullgren.robot;

import java.util.ArrayList;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class DisplayCardsAdapter extends BaseAdapter {
	private MainActivity mContext;
	private ArrayList<Card> mCards;
	
	public DisplayCardsAdapter(MainActivity mainActivity, ArrayList<Card> cards) {
		mContext = mainActivity;
		mCards = cards;
	}

	@Override
	public int getCount() {
		return mCards.size();
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
            imageView.setLayoutParams(new GridView.LayoutParams(64, 64));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(1, 1, 1, 1);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[ mCards.get(position).getType().ordinal() ]);
        return imageView;
	}

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.button_next_icon, R.drawable.button_previous_icon,
            R.drawable.button_reload_icon, R.drawable.button_close_icon,
            R.drawable.button_next_icon
    };
}
