package com.example.admin.tvdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v17.leanback.widget.ImageCardView;
import android.support.v17.leanback.widget.Presenter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.channels.Channels;

public class CardViewPresenter extends Presenter {

  private static final String TAG = CardViewPresenter.class.getSimpleName();

  private static Context mContext;
  private static int CARD_WIDTH = 313;
  private static int CARD_HEIGHT = 176;


  static class ViewHolder extends Presenter.ViewHolder {

    private Movie movie;
    private ImageCardView imageCardView;
    private Drawable drawable;
    private PicassoImageCardViewTarget mImageCardViewTarget;


    public ViewHolder(View view) {
      super(view);
      imageCardView = (ImageCardView) view;
      mImageCardViewTarget = new PicassoImageCardViewTarget(imageCardView);
      drawable = mContext.getResources().getDrawable(R.drawable.lb_card_shadow_focused);
    }

    protected void updateCardViewImage(URI uri) {
      Picasso.with(mContext)
          .load(uri.toString())
          .resize(Utils.convertDpToPixel(mContext, CARD_WIDTH),
              Utils.convertDpToPixel(mContext, CARD_HEIGHT))
          .error(drawable)
          .into(mImageCardViewTarget);
    }

    public Movie getMovie() {
      return movie;
    }

    public void setMovie(Movie movie) {
      this.movie = movie;
    }

    public ImageCardView getImageCardView() {
      return imageCardView;
    }

    public void setImageCardView(ImageCardView imageCardView) {
      this.imageCardView = imageCardView;
    }

    public Drawable getDrawable() {
      return drawable;
    }

    public void setDrawable(Drawable drawable) {
      this.drawable = drawable;
    }


  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent) {
    mContext = parent.getContext();

    ImageCardView cardView = new ImageCardView(mContext);
    cardView.setFocusable(true);
    cardView.setFocusableInTouchMode(true);
    cardView.setBackgroundColor(mContext.getResources().getColor(R.color.colorWhite));
    return new ViewHolder(cardView);
  }

  @Override
  public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {

    Movie movie = (Movie) item;
    ((ViewHolder) viewHolder).setMovie(movie);

    ((ViewHolder) viewHolder).imageCardView.setTitleText(movie.getTitle());
    ((ViewHolder) viewHolder).imageCardView.setContentText(movie.getStudio());
    ((ViewHolder) viewHolder).imageCardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT);

    if (movie.getUrl() != null) {
      ((ViewHolder) viewHolder).updateCardViewImage(movie.getImageURI());
    } else
      ((ViewHolder) viewHolder).imageCardView.setMainImage(mContext.getResources().getDrawable(movie.getImage()));

  }

  @Override
  public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {

  }


  public static class PicassoImageCardViewTarget implements Target {

    private ImageCardView imageCardView;

    public PicassoImageCardViewTarget(ImageCardView imageCardView) {
      this.imageCardView = imageCardView;
    }

    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
      Drawable drawable = (BitmapDrawable) new BitmapDrawable(mContext.getResources(), bitmap);
      imageCardView.setMainImage(drawable);
    }

    @Override
    public void onBitmapFailed(Drawable errorDrawable) {
      imageCardView.setMainImage(errorDrawable);
    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {

    }
  }
}
