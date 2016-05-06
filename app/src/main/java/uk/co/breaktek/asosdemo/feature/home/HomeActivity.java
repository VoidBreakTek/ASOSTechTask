package uk.co.breaktek.asosdemo.feature.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.breaktek.asosdemo.ASOSDemoApplication;
import uk.co.breaktek.asosdemo.R;
import uk.co.breaktek.asosdemo.di.base.MvpActivity;
import uk.co.breaktek.asosdemo.di.component.activity.ActivityComponent;
import uk.co.breaktek.asosdemo.di.component.activity.HomeComponent;
import uk.co.breaktek.asosdemo.di.module.activity.HomeModule;
import uk.co.breaktek.asosdemo.domain.model.Categories;
import uk.co.breaktek.asosdemo.domain.model.CategoryListing;
import uk.co.breaktek.asosdemo.mvp.ActivityPresenter;

public class HomeActivity extends MvpActivity
        implements NavigationView.OnNavigationItemSelectedListener, HomeView {

    @Inject
    HomePresenter mPresenter;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawer;

    @Bind(R.id.nav_view)
    NavigationView mNavigationView;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    TextView mShowWomenTextView;
    TextView mShowMenTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPresenter.bind(this);
        mPresenter.initialize();

        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(toggle);
        toggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);
        addNavigationViewHeaderClickListeners();
    }

    private void addNavigationViewHeaderClickListeners() {
        mShowWomenTextView = (TextView) mNavigationView.getHeaderView(0).findViewById(R.id.navigation_drawer_header_shop_women_button);
        mShowMenTextView = (TextView) mNavigationView.getHeaderView(0).findViewById(R.id.navigation_drawer_header_shop_men_button);

        mShowWomenTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onClickNavBarWomensTab();
            }
        });

        mShowMenTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onClickNavBarMensTab();
            }
        });
    }

    @Override
    protected ActivityComponent setupActivityComponent() {
        HomeComponent component = ASOSDemoApplication.get(this)
                .getAppComponent()
                .with(new HomeModule(this));

        component.inject(this);
        return component;
    }

    @Override
    protected ActivityPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the ic_menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void setMenuCategories(@NonNull Categories categories) {
        mNavigationView.getMenu().clear();

        Iterator<CategoryListing> iterator = categories.getCategoryListings().getIterator();
        while (iterator.hasNext()) {
            CategoryListing listing = iterator.next();
            mNavigationView.getMenu().add(listing.getCategoryName()).setIcon(R.drawable.ic_menu_send);
        }
    }
}
