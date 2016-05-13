package uk.co.breaktek.asosdemo.feature.home.productlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class ProductListTouchListener extends RecyclerView.SimpleOnItemTouchListener {
    ProductListClickListener mListener;
    GestureDetector mSingleTapGestureDetector;

    public ProductListTouchListener(Context context, ProductListClickListener clickListener) {
        mListener = clickListener;
        mSingleTapGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View touchedView = rv.findChildViewUnder(e.getX(), e.getY());
        if (touchedView != null && mListener != null && mSingleTapGestureDetector.onTouchEvent(e)) {
            mListener.onProductItemClick(rv.getChildAdapterPosition(touchedView));
            return true;
        }
        return false;
    }

    public interface ProductListClickListener {
        void onProductItemClick(int position);
    }
}
