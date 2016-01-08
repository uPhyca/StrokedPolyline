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

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.List;

public class StrokedPolylineOptions implements Parcelable {

    private final PolylineOptions fill;
    private final PolylineOptions stroke;

    public StrokedPolylineOptions() {
        fill = new PolylineOptions();
        stroke = new PolylineOptions();
    }

    public StrokedPolylineOptions add(LatLng point) {
        fill.add(point);
        stroke.add(point);
        return this;
    }

    public StrokedPolylineOptions add(LatLng... points) {
        fill.add(points);
        stroke.add(points);
        return this;
    }

    public StrokedPolylineOptions addAll(Iterable<LatLng> points) {
        fill.addAll(points);
        stroke.addAll(points);
        return this;
    }

    public StrokedPolylineOptions width(float width) {
        float strokeWidth = getStrokeWidth();
        fill.width(width - strokeWidth * 2);
        stroke.width(width);
        return this;
    }

    public StrokedPolylineOptions fillColor(int color) {
        fill.color(color);
        return this;
    }

    public StrokedPolylineOptions zIndex(float zIndex) {
        fill.zIndex(zIndex);
        stroke.zIndex(zIndex);
        return this;
    }

    public StrokedPolylineOptions visible(boolean visible) {
        fill.visible(visible);
        stroke.visible(visible);
        return this;
    }

    public StrokedPolylineOptions geodesic(boolean geodesic) {
        fill.geodesic(geodesic);
        stroke.geodesic(geodesic);
        return this;
    }

    public List<LatLng> getPoints() {
        return fill.getPoints();
    }

    public float getWidth() {
        return stroke.getWidth();
    }

    public int getFillColor() {
        return fill.getColor();
    }

    public float getZIndex() {
        return fill.getZIndex();
    }

    public boolean isVisible() {
        return fill.isVisible();
    }

    public boolean isGeodesic() {
        return fill.isGeodesic();
    }

    public StrokedPolylineOptions strokeWidth(float strokeWidth) {
        fill.width(stroke.getWidth() - strokeWidth * 2);
        return this;
    }

    public float getStrokeWidth() {
        return stroke.getWidth() - fill.getWidth() / 2;
    }

    public StrokedPolylineOptions strokeColor(int color) {
        stroke.color(color);
        return this;
    }


    public int getStrokeColor() {
        return stroke.getColor();
    }

    public StrokedPolyline addPolylineTo(GoogleMap googleMap) {
        Polyline strokePolyline = googleMap.addPolyline(stroke);
        Polyline fillPolyline = googleMap.addPolyline(fill);
        return new StrokedPolyline(fillPolyline, strokePolyline);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.fill, flags);
        dest.writeParcelable(this.stroke, flags);
    }

    protected StrokedPolylineOptions(Parcel in) {
        this.fill = in.readParcelable(PolylineOptions.class.getClassLoader());
        this.stroke = in.readParcelable(PolylineOptions.class.getClassLoader());
    }

    public static final Creator<StrokedPolylineOptions> CREATOR = new Creator<StrokedPolylineOptions>() {
        public StrokedPolylineOptions createFromParcel(Parcel source) {
            return new StrokedPolylineOptions(source);
        }

        public StrokedPolylineOptions[] newArray(int size) {
            return new StrokedPolylineOptions[size];
        }
    };
}
