package com.nepinepi984.yuichi_develop.myapplication;

import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

import org.osmdroid.api.IMapView;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.constants.OpenStreetMapTileProviderConstants;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.util.ListPointL;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlay;
import org.osmdroid.views.overlay.Overlay;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LocationListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

//    org.osmdroid.tileprovider.constants.OpenStreetMapTileProviderConstants.setUserAgentValue(BuildConfig.APPLICATION_ID);
    Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);

    MapView map = (MapView) findViewById(R.id.map);
    map.setTileSource(TileSourceFactory.MAPNIK);
    map.setBuiltInZoomControls(true);
    map.setMultiTouchControls(true);
    int lat = (int)(34.39720742251445 * 1E6);   // 十日市町の緯度
    int lng = (int)(132.44787690249098 * 1E6);  // 十日市町の経度
    GeoPoint point = new GeoPoint(lat, lng);
    map.getController().setCenter(point);
    map.getController().animateTo(point);
    map.getController().setZoom(19.5);
    map.invalidate();
  }

  @Override
  public void onLocationChanged(Location location) {
    int lat = (int) (location.getLatitude() * 1E6);
    int lng = (int) (location.getLongitude() * 1E6);

    lat = (int)(34.39720742251445 * 1E6);
    lng = (int)(132.44787690249098 * 1E6);
    GeoPoint point = new GeoPoint(lat, lng);

    MapView map = (MapView) findViewById(R.id.map);
    map.getController().setCenter(point);
    map.getController().animateTo(point);

    final List<OverlayItem> overlayList = new ArrayList<>();
    overlayList.add(new OverlayItem("aaa", "aaa", new GeoPoint(34.39720742251445, 132.44787690249098)));

    final ItemizedIconOverlay<OverlayItem> iconOverlay = new ItemizedIconOverlay<>(
      MainActivity.this,
        overlayList,
        null
    );
    map.getOverlays().add(iconOverlay);
    map.invalidate();
  }

  @Override
  public void onStatusChanged(String s, int i, Bundle bundle) {

  }

  @Override
  public void onProviderEnabled(String s) {

  }

  @Override
  public void onProviderDisabled(String s) {

  }

}
