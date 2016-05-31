package uk.co.breaktek.asosdemo.feature.home.productlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.breaktek.asosdemo.R;
import uk.co.breaktek.asosdemo.domain.model.ProductListing;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {
    public static final String TAG = ProductListAdapter.class.getSimpleName();
    private List<ProductListing> mDataset;
    private Set<Long> mFavouriteIds;
    private Context mContext;

    public ProductListAdapter(Context context) {
        mDataset = Collections.emptyList();
        this.mContext = context;
    }

    public void updateData(List<ProductListing> data) {
        Log.d(TAG, "updateData");
        mDataset = data;
        notifyDataSetChanged();
    }

    public void updateFavouriteIds(Set<Long> favouriteIds) {
        mFavouriteIds = favouriteIds;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_product_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ProductListing model = mDataset.get(position);
        holder.mPriceTextView.setText(model.currentPrice);
        boolean isFavourite = mFavouriteIds.contains(mDataset.get(position).productId);
        holder.mImageView.setSelected(isFavourite);

        String imageUrl = null;
        if (model.productImageUrl.size() > 0) {
            imageUrl = model.productImageUrl.get(0);
        }

//        if (imageUrl != null && !imageUrl.isEmpty()) {
        Picasso itemPicasso = Picasso.with(mContext);
        itemPicasso
                .load(imageUrl)
                .error(R.drawable.ic_asos_logo)
                .placeholder(R.drawable.ic_asos_logo)
                .fit()
                .centerCrop()
                .into(holder.mImageView);
//        }
    }

    public ProductListing getItem(int position) {
        return mDataset.get(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.recyclerview_item_product_list_textview_price)
        TextView mPriceTextView;

        @Bind(R.id.recyclerview_item_product_list_imageview)
        ImageView mImageView;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}