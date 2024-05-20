package com.bextdev.pngloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.HVArrangement;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import com.google.appinventor.components.runtime.util.MediaUtil;

import java.io.IOException;

public class PNGLoader extends AndroidNonvisibleComponent {
  private final Context context;
  private ImageView imageView;

  public PNGLoader(ComponentContainer container) {
    super(container.$form());
    this.context = container.$context();
  }

  @SimpleFunction
  public void LoadPngImage(HVArrangement layout, String pngFilePath) {
    if (pngFilePath.endsWith(".png")) {
      View view = layout.getView();
      imageView = new ImageView(this.context);
      try {
        BitmapDrawable drawable = MediaUtil.getBitmapDrawable(form, pngFilePath);
        Bitmap pngFile = drawable.getBitmap();
        imageView.setImageBitmap(pngFile);
        FrameLayout frameLayout = (FrameLayout) view;
        frameLayout.addView(imageView);
      } catch (IOException e) {
        e.printStackTrace();
        Error("Error loading PNG image: " + e.getMessage());
      }
    } else {
      Error("Please only use .png files!");
    }
  }

  @SimpleEvent
  public void Error(String error) {
    EventDispatcher.dispatchEvent(this, "Error", error);
  }
}