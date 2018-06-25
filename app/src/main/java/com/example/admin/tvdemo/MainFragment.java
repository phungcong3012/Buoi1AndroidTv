package com.example.admin.tvdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v4.widget.ListViewAutoScrollHelper;

public class MainFragment extends BrowseFragment {

  private ArrayObjectAdapter mRowsAdapter;

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    updateUI();
    loadRows();
  }

  private void updateUI() {
    setTitle("Hello Android TV!");
    setHeadersState(HEADERS_ENABLED);
    setHeadersTransitionOnBackEnabled(true);
    setBrandColor(getResources().getColor(R.color.colorBlue));
    setSearchAffordanceColor(getResources().getColor(R.color.colorGreen));
  }

  private void loadRows() {
    mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
    /* CardPresenter */

    HeaderItem headerItemPicasso = new HeaderItem(1, "Picasso");
    CardViewPresenter cardViewPresenterPicasso = new CardViewPresenter();
    ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(cardViewPresenterPicasso);
    arrayObjectAdapter.add(new Movie("DuanVH", "Android", "http://i.9mobi.vn/cf/images/2015/03/nkk/nhung-hinh-anh-dep-3.jpg"));
    arrayObjectAdapter.add(new Movie("CongPV", "Android", "http://i.9mobi.vn/cf/images/2015/03/nkk/nhung-hinh-anh-dep-3.jpg"));
    arrayObjectAdapter.add(new Movie("ChiNBH", "Android", "http://i.9mobi.vn/cf/images/2015/03/nkk/nhung-hinh-anh-dep-3.jpg"));
    arrayObjectAdapter.add(new Movie("DungNB", "Android", "http://i.9mobi.vn/cf/images/2015/03/nkk/nhung-hinh-anh-dep-3.jpg"));
    arrayObjectAdapter.add(new Movie("GiangDD", "Android", "http://i.9mobi.vn/cf/images/2015/03/nkk/nhung-hinh-anh-dep-3.jpg"));
    arrayObjectAdapter.add(new Movie("DatTT", "IOS", "http://i.9mobi.vn/cf/images/2015/03/nkk/nhung-hinh-anh-dep-3.jpg"));
    mRowsAdapter.add(new ListRow(headerItemPicasso, arrayObjectAdapter));

    HeaderItem headerItem = new HeaderItem(2, "Ahihi");
    CardViewPresenter cardViewPresenter = new CardViewPresenter();
    ArrayObjectAdapter arrayObjectAdapter1 = new ArrayObjectAdapter(cardViewPresenter);
    arrayObjectAdapter1.add(new Movie("Duan", "Android", R.drawable.hoa_cuc));
    arrayObjectAdapter1.add(new Movie("CHi", "Android", R.drawable.hoa_cuc));
    arrayObjectAdapter1.add(new Movie("Cong", "Android", R.drawable.hoa_cuc));
    arrayObjectAdapter1.add(new Movie("Giang", "Android", R.drawable.hoa_cuc));
    mRowsAdapter.add(new ListRow(headerItem, arrayObjectAdapter1));

    setAdapter(mRowsAdapter);

  }
}
