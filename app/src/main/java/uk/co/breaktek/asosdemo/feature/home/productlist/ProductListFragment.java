package uk.co.breaktek.asosdemo.feature.home.productlist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.breaktek.asosdemo.R;
import uk.co.breaktek.asosdemo.di.base.DaggerActivity;
import uk.co.breaktek.asosdemo.di.component.activity.HomeComponent;
import uk.co.breaktek.asosdemo.di.component.fragment.FragmentComponent;
import uk.co.breaktek.asosdemo.di.component.fragment.ProductListComponent;
import uk.co.breaktek.asosdemo.di.module.fragment.ProductListModule;
import uk.co.breaktek.asosdemo.domain.model.ProductListing;
import uk.co.breaktek.asosdemo.mvp.FragmentPresenter;
import uk.co.breaktek.asosdemo.mvp.base.MvpFragment;
import uk.co.breaktek.asosdemo.user.ProductFavouritesManager;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class ProductListFragment extends MvpFragment implements ProductListView, ProductListTouchListener.ProductListClickListener {
    private static final String ARG_KEY_CATEGORY_ID = "categoryId";
    private static final int RECYCLER_VIEW_GRID_SPAN = 2;

    @Bind(R.id.fragment_product_list_recyclerview)
    RecyclerView mRecyclerView;

    @Bind(R.id.fragment_product_list_textview_header)
    TextView mHeaderTextView;

    @Inject
    ProductListPresenter mPresenter;

    private ProductListAdapter mAdapter;

    public static ProductListFragment newInstance(@NonNull String categoryId) {
        Log.d(TAG, "newInstance");
        ProductListFragment fragment = new ProductListFragment();

        Bundle args = new Bundle();
        args.putString(ARG_KEY_CATEGORY_ID, categoryId);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_product_list, container, false);
        ButterKnife.bind(this, rootView);
        configureRecyclerView();
        String categoryId = getArguments().getString(ARG_KEY_CATEGORY_ID);
        mPresenter.initialize(categoryId);
        return rootView;
    }

    private void configureRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), RECYCLER_VIEW_GRID_SPAN));
        mAdapter = new ProductListAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new ProductListTouchListener(getContext(), this));
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected FragmentComponent setupComponent() {
        ProductListComponent component = ((HomeComponent) ((DaggerActivity) getActivity()).getActivityComponent())
                .with(new ProductListModule(this));
        component.inject(this);
        return component;
    }

    @Override
    protected FragmentPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void bindPresenter() {
        mPresenter.bind(this);
    }

    @Override
    public void setHeaderText(@NonNull String headerText) {
        mHeaderTextView.setText(headerText);
    }

    @Override
    public void setProductList(@NonNull List<ProductListing> productList) {
        mAdapter.updateData(productList);
    }

    public void setFavouriteIds(@NonNull Set<Long> favouriteIds) {
        mAdapter.updateFavouriteIds(favouriteIds);
    }

    @Override
    public void onProductItemClick(int position) {
        mPresenter.onProductListingSelected(mAdapter.getItem(position));
    }
}
