package org.kullgren.robot;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class DisplayBoardAdapter extends BaseAdapter {
    private MainActivity mContext;
    private Board mBoard;

    public DisplayBoardAdapter(MainActivity mainActivity, Board board) {
        mContext = mainActivity;
        mBoard = board;
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
        if (convertView == null) { // if it's not recycled, initialize some
                                   // attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(24, 24));
            imageView.setPadding(0, 0, 0, 0);
        } else {
            imageView = (ImageView) convertView;
        }

        Resources r = mContext.getResources();
        int numLayers = mBoard.get(position).getNumBlockedDirections() + 1 + mBoard.get(position).numRobotsPresent();
        int currentLayer = 0;
        Drawable[] layers = new Drawable[numLayers];
        if (mBoard.get(position).isHole()) {
            layers[0] = r.getDrawable(mThumbIds[3]);
        } else {
            layers[0] = r.getDrawable(mThumbIds[0]);
        }
        ++currentLayer;

        if (mBoard.get(position).isBlocked(Direction.Up)) {
            layers[currentLayer] = r.getDrawable(mThumbIds[1]);
            ++currentLayer;
        }

        if (mBoard.get(position).isBlocked(Direction.Down)) {
            layers[currentLayer] = r.getDrawable(mThumbIds[1]);
            ++currentLayer;
        }

        if (mBoard.get(position).isBlocked(Direction.Left)) {
            layers[currentLayer] = r.getDrawable(mThumbIds[2]);
            ++currentLayer;
        }

        if (mBoard.get(position).isBlocked(Direction.Right)) {
            layers[currentLayer] = r.getDrawable(mThumbIds[2]);
            ++currentLayer;
        }
        
        Robot myRobot = mBoard.get(position).getRobot();
        if (myRobot != null) {
            layers[currentLayer] = r.getDrawable(mThumbIds[4]);
            ++currentLayer;            
        }

        LayerDrawable layerDrawable = new LayerDrawable(layers);
        int hight = layerDrawable.getIntrinsicHeight();
        layerDrawable.setLayerInset(0, 0, 0, 0, 0);

        currentLayer = 1;
        if (mBoard.get(position).isBlocked(Direction.Up)) {
            layerDrawable.setLayerInset(currentLayer, 0, 0, 0, hight * 9 / 10);
            ++currentLayer;
        }

        if (mBoard.get(position).isBlocked(Direction.Down)) {
            layerDrawable.setLayerInset(currentLayer, 0, hight * 9 / 10, 0, 0);
            ++currentLayer;
        }

        if (mBoard.get(position).isBlocked(Direction.Left)) {
            layerDrawable.setLayerInset(currentLayer, 0, 0, hight * 9 / 10, 0);
            ++currentLayer;
        }

        if (mBoard.get(position).isBlocked(Direction.Right)) {
            layerDrawable.setLayerInset(currentLayer, hight * 9 / 10, 0, 0, 0);
            ++currentLayer;
        }

        imageView.setImageDrawable(layerDrawable);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = { R.drawable.open_space,
            R.drawable.blocked_ns, R.drawable.blocked_ew, R.drawable.sink, R.drawable.robot };
}
