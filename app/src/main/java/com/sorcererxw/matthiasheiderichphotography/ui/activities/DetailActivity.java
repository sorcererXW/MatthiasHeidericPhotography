package com.sorcererxw.matthiasheiderichphotography.ui.activities;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.sorcererxw.matthiasheiderichphotography.MHApp;
import com.sorcererxw.matthiasheiderichphotography.ui.views.TypefaceSnackbar;
import com.sorcererxw.matthiasheiderichphotography.ui.views.TypefaceToolbar;
import com.sorcererxw.matthiasheiderichphotography.util.DialogUtil;
import com.sorcererxw.matthiasheiderichphotography.util.ResourceUtil;
import com.sorcererxw.matthiasheiderichphotography.util.StringUtil;
import com.sorcererxw.matthiasheidericphotography.BuildConfig;
import com.sorcererxw.matthiasheidericphotography.R;
import com.tbruyelle.rxpermissions.RxPermissions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import uk.co.senab.photoview.PhotoView;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class DetailActivity extends AppCompatActivity {
    @BindView(R.id.coordinatorLayout_detail)
    CoordinatorLayout mCoordinatorLayout;
    @BindView(R.id.toolbar_detail)
    TypefaceToolbar mToolbar;
    @BindView(R.id.imageView_detail)
    PhotoView mImageView;
    @BindView(R.id.fab_detail)
    FloatingActionMenu mFAB;
    @BindView(R.id.fab_detail_apply)
    FloatingActionButton mApplyFAB;
    @BindView(R.id.fab_detail_save)
    FloatingActionButton mSaveFAB;

    @OnClick(R.id.fab_detail_apply)
    void clickApply() {
        setWallpapers();
    }

    @OnLongClick(R.id.fab_detail_apply)
    boolean longClickApply() {
        setWallpapersMore();
        return true;
    }

    @OnClick(R.id.fab_detail_save)
    void clickSave() {
        saveToLocal();
    }

    @OnLongClick(R.id.fab_detail_save)
    boolean longClickSave() {
        return true;
    }

    private String mLink;
    private Uri mUri = null;

    private RxPermissions mRxPermissions;

    private MaterialDialog mProgressDialog;

    private Snackbar.Callback mSnackbarCallback = new Snackbar.Callback() {
        @Override
        public void onDismissed(Snackbar snackbar, int event) {
            super.onDismissed(snackbar, event);
            mFAB.animate().translationY(0).setDuration(200).start();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        mLink = getIntent().getStringExtra("link");
        initImage();
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mFAB.hideMenuButton(false);

        mRxPermissions = RxPermissions.getInstance(this);
    }

    private void initImage() {
        mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (MHApp.getInstance().getTmpDrawable() != null) {
            mImageView.setImageDrawable(MHApp.getInstance().getTmpDrawable());
            setupFAB();
        } else {
            Observable.just(mLink + "?format=1000w")
                    .map(new Func1<String, Drawable>() {
                        @Override
                        public Drawable call(String s) {
                            try {
                                return Glide.with(DetailActivity.this)
                                        .load(s)
                                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                                        .into(-1, -1)
                                        .get();
                            } catch (InterruptedException | ExecutionException e) {
                                e.printStackTrace();
                            }
                            return null;
                        }
                    })
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<Drawable>() {
                        @Override
                        public void call(Drawable drawable) {
                            if (drawable != null) {
                                mImageView.setImageDrawable(drawable);
                                setupFAB();
                            } else {
                                finish();
                            }
                        }
                    });
        }
    }

    private Observable<Boolean> requestPermission() {
        return mRxPermissions.request(WRITE_EXTERNAL_STORAGE)
                .map(new Func1<Boolean, Boolean>() {
                    @Override
                    public Boolean call(Boolean aBoolean) {
                        if (!aBoolean) {
                            TypefaceSnackbar.make(mCoordinatorLayout, "No permission :(",
                                    Snackbar.LENGTH_LONG)
                                    .setCallback(mSnackbarCallback).show();
                        }
                        return aBoolean;
                    }
                });
    }

    private Observable<Uri> download() {
        return Observable.just(mLink).map(new Func1<String, Bitmap>() {
            @Override
            public Bitmap call(String s) {
                try {
                    return Glide.with(DetailActivity.this)
                            .load(mLink)
                            .asBitmap()
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .into(-1, -1)
                            .get();
                } catch (InterruptedException | ExecutionException e) {
                    if (BuildConfig.DEBUG) {
                        e.printStackTrace();
                    }
                    try {
                        return Glide.with(DetailActivity.this)
                                .load(mLink)
                                .asBitmap()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(-1, -1)
                                .get();
                    } catch (InterruptedException | ExecutionException e1) {
                        if (BuildConfig.DEBUG) {
                            e1.printStackTrace();
                        }
                    }
                }
                return null;
            }
        }).subscribeOn(Schedulers.io()).map(new Func1<Bitmap, Uri>() {
            @Override
            public Uri call(Bitmap bitmap) {
                if (bitmap == null) {
                    return null;
                }
                Uri uri = null;
                FileOutputStream out = null;
                try {
                    File path = Environment.getExternalStoragePublicDirectory(
                            Environment.DIRECTORY_PICTURES);
                    File dir = new File(path, "/Matthisa Heideric");
                    if (dir.exists()) {
                        dir.renameTo(new File(path, "/Matthisa Heiderich"));
                    }
                    dir = new File(path, "/Matthisa Heiderich");
                    if (!dir.exists()) {
                        dir.mkdir();
                    }
                    final File file = new File(path, "/Matthisa Heiderich/"
                            + StringUtil.getFileNameFromLinkWithoutExtension(mLink)
                            + ".png");
                    if (file.exists()) {
                        uri = Uri.fromFile(file);
                    } else {
                        out = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                        uri = Uri.fromFile(file);
                    }
                } catch (Exception e) {
                    if (BuildConfig.DEBUG) {
                        e.printStackTrace();
                    }
                } finally {
                    try {
                        if (out != null) {
                            out.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return uri;
            }
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<Uri, Uri>() {
                    @Override
                    public Uri call(Uri uri) {
                        mUri = uri;
                        return uri;
                    }
                });
    }

    private void saveToLocal() {
        mRxPermissions.request(WRITE_EXTERNAL_STORAGE).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                if (!aBoolean) {
                    return;
                }
                String progressText = "Saving To Local...";
                if (mUri == null) {
                    showDialog(progressText);
                    download().subscribe(new Action1<Uri>() {
                        @Override
                        public void call(final Uri uri) {
                            dismissDialog();
                            if (uri != null) {
                                TypefaceSnackbar.make(mCoordinatorLayout, "Success",
                                        Snackbar.LENGTH_LONG)
                                        .setAction("Open", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                openOuterPhotoViewer(uri);
                                            }
                                        })
                                        .setActionTextColor(
                                                ResourceUtil.getColor(DetailActivity.this,
                                                        R.color.white))
                                        .setCallback(mSnackbarCallback)
                                        .show();
                            } else {
                                TypefaceSnackbar.make(mCoordinatorLayout, "Fail",
                                        Snackbar.LENGTH_LONG)
                                        .setCallback(mSnackbarCallback).show();
                            }
                        }
                    });
                } else {
                    TypefaceSnackbar
                            .make(mCoordinatorLayout, "Existed", Snackbar.LENGTH_LONG)
                            .setAction("Open", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    openOuterPhotoViewer(mUri);
                                }
                            })
                            .setActionTextColor(ResourceUtil
                                    .getColor(DetailActivity.this, R.color.white))
                            .setCallback(mSnackbarCallback)
                            .show();
                }
            }
        });

    }

    private void setWallpapers() {
        mRxPermissions.request(WRITE_EXTERNAL_STORAGE)
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        if (!aBoolean) {
                            return;
                        }
                        String progressText = "Setting wallpaper...";

                        if (mUri == null) {
                            showDialog(progressText);
                            download().subscribe(new Action1<Uri>() {
                                @Override
                                public void call(Uri uri) {
                                    setWallpapers();
                                }
                            });
                        } else {
                            Observable.just(mUri).map(new Func1<Uri, Boolean>() {
                                @Override
                                public Boolean call(Uri uri) {
                                    try {
                                        WallpaperManager wallpaperManager
                                                = WallpaperManager
                                                .getInstance(getApplicationContext());
                                        wallpaperManager.setWallpaperOffsets(
                                                getWindow().getDecorView().getRootView()
                                                        .getWindowToken(), 1, 1);
                                        wallpaperManager.setStream(
                                                new FileInputStream(new File(mUri.getPath())));
                                        return true;
                                    } catch (IOException e) {
                                        if (BuildConfig.DEBUG) {
                                            e.printStackTrace();
                                        }
                                    }
                                    return false;
                                }

//                @Override
//                public Boolean call(Bitmap bitmap) {
//                    try {
//                        WallpaperManager wallpaperManager
//                                = WallpaperManager.getInstance(getApplicationContext());
//                        wallpaperManager.setWallpaperOffsets(
//                                getWindow().getDecorView().getRootView().getWindowToken(), 1, 1);
//                        wallpaperManager.setBitmap(mRawBitmap);
//                        return true;
//                    } catch (IOException e) {
//                        if (BuildConfig.DEBUG) {
//                            e.printStackTrace();
//                        }
//                    }
//                    return false;
//                }
                            })
                                    .subscribeOn(Schedulers.newThread())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(new Action1<Boolean>() {
                                        @Override
                                        public void call(Boolean aBoolean) {
                                            if (aBoolean) {
                                                TypefaceSnackbar
                                                        .make(mCoordinatorLayout, "Success",
                                                                Snackbar.LENGTH_LONG)
                                                        .setCallback(mSnackbarCallback)
                                                        .show();
                                            } else {
                                                TypefaceSnackbar
                                                        .make(mCoordinatorLayout, "Fail",
                                                                Snackbar.LENGTH_LONG)
                                                        .setCallback(mSnackbarCallback)
                                                        .show();
                                            }
                                            dismissDialog();
                                        }
                                    });
                        }
                    }
                });

    }

    private void setWallpapersMore() {
        requestPermission().subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                if (!aBoolean) {
                    return;
                }
                String progressText = "Preparing...";

                if (mUri == null) {
                    showDialog(progressText);
                    download().subscribe(new Action1<Uri>() {
                        @Override
                        public void call(Uri uri) {
                            dismissDialog();
                            setWallpapersMore();
                        }
                    });
                } else {
                    Intent intent = new Intent(Intent.ACTION_ATTACH_DATA);
                    intent.addCategory(Intent.CATEGORY_DEFAULT);
                    intent.setDataAndType(mUri, "image/*");
                    intent.putExtra("mimeType", "image/*");
                    startActivity(Intent.createChooser(intent, "Set as:"));
                }
            }
        });
    }

    private void showDialog(String s) {
        if (mProgressDialog == null) {
            mProgressDialog = DialogUtil.getProgressDialog(this, s);
        } else if (mProgressDialog.isShowing()) {
            return;
        } else {
            if (mProgressDialog.getCustomView() != null) {
                ((TextView) mProgressDialog.getCustomView()
                        .findViewById(R.id.textView_progress_message)).setText(s);
            }
        }
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    private void dismissDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            super.onBackPressed();
        }
        return false;
    }

    private void setupFAB() {
        Observable.just(mLink + "?format=1000w").map(new Func1<String, Palette.Swatch>() {
            @Override
            public Palette.Swatch call(String s) {
                Bitmap bitmap = null;
                try {
                    bitmap = Glide.with(DetailActivity.this)
                            .load(s)
                            .asBitmap()
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .into(-1, -1)
                            .get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
                if (bitmap != null) {
                    Palette palette = Palette.from(bitmap).generate();
                    Palette.Swatch[] swatches = new Palette.Swatch[]{
                            palette.getMutedSwatch(),
                            palette.getLightMutedSwatch(),
                            palette.getDarkMutedSwatch(),
                            palette.getVibrantSwatch(),
                            palette.getLightVibrantSwatch(),
                            palette.getDarkVibrantSwatch(),
                    };
                    for (Palette.Swatch sc : swatches) {
                        if (sc != null) {
                            return sc;
                        }
                    }
                    return null;
                }
                return null;
            }
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Palette.Swatch>() {
                    @Override
                    public void call(Palette.Swatch swatch) {
                        int color = ResourceUtil.getColor(DetailActivity.this, R.color.accent);
                        if (swatch != null) {
                            color = swatch.getRgb();
                        }
                        mFAB.setMenuButtonColorNormal(color);
                        mFAB.setMenuButtonColorPressed(color);
                        mApplyFAB.setColorNormal(color);
                        mApplyFAB.setColorPressed(color);
                        mSaveFAB.setColorNormal(color);
                        mSaveFAB.setColorPressed(color);

                        mFAB.showMenuButton(true);
                    }
                });
    }

    private void openOuterPhotoViewer(Uri uri) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            File file = new File(uri.getPath());
            Intent intent = new Intent();
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(this,
                    "com.sorcererxw.matthiasheiderichphotography.fileProvider",
                    file);
            intent.setDataAndType(contentUri, "image/*");
            intent.setAction(Intent.ACTION_VIEW);
            startActivity(intent);
        } else {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setDataAndType(uri, "image/*");
            startActivity(intent);
        }
    }
}