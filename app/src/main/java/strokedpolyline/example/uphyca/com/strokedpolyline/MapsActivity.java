/*
 * Copyright (C) 2016 uPhyca Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package strokedpolyline.example.uphyca.com.strokedpolyline;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;


public class MapsActivity extends FragmentActivity implements
        OnMapReadyCallback,
        GoogleMap.OnMapClickListener {

    private static final float POLYLINE_WIDTH_IN_PIXELS = 10;
    private static final float POLYLINE_STROKE_WIDTH_IN_PIXELS = 2;

    private GoogleMap googleMap;
    private StrokedPolyline polyline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setMapToolbarEnabled(false);

        googleMap.setOnMapClickListener(this);

        LatLng tokyo = new LatLng(35.689634, 139.692101);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tokyo, 10));
    }

    @Override
    public void onMapClick(LatLng latLng) {
        drawPolyline(latLng);
    }

    private void drawPolyline(LatLng latLng) {
        ensurePolyline();
        List<LatLng> points = polyline.getPoints();
        points.add(latLng);
        polyline.setPoints(points);
    }

    private void ensurePolyline() {
        if (polyline != null) {
            return;
        }

        int fillColor = ContextCompat.getColor(this, R.color.polylineFillColor);
        int strokeColor = ContextCompat.getColor(this, R.color.polylineStrokeColor);

        StrokedPolylineOptions polylineOptions = new StrokedPolylineOptions()
                .width(POLYLINE_WIDTH_IN_PIXELS)
                .fillColor(fillColor)
                .strokeColor(strokeColor)
                .strokeWidth(POLYLINE_STROKE_WIDTH_IN_PIXELS);
        polyline = polylineOptions.addPolylineTo(googleMap);
    }
}
