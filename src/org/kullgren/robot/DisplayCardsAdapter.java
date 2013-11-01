package org.kullgren.robot;

import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class DisplayCardsAdapter extends BaseAdapter {
	private MainActivity mContext;
	private Hand mHand;
	
	public DisplayCardsAdapter(MainActivity mainActivity, Hand hand) {
		mContext = mainActivity;
		mHand = hand;
	}

	@Override
	public int getCount() {
		return mHand.numCards();
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

        imageView.setImageResource(mThumbIds[ mHand.getCard(position).getType().ordinal() ]);
        if (mHand.isCardSelected(position)) {
        	imageView.setColorFilter(Color.BLUE, Mode.LIGHTEN);
        } 
        else if (mHand.isCardInvalid(position)) {
        	imageView.setColorFilter(Color.BLACK, Mode.LIGHTEN);        	
        }
        else {
        	imageView.clearColorFilter();        	
        }
        return imageView;
	}

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.button_next_icon, R.drawable.button_previous_icon,
            R.drawable.button_reload_icon, R.drawable.button_close_icon,
            R.drawable.button_next_icon
    };
}
