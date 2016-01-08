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

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;

import java.util.List;

public class StrokedPolyline {

    private final Polyline fill;
    private final Polyline stroke;

    public StrokedPolyline(Polyline fill, Polyline stroke) {
        this.fill = fill;
        this.stroke = stroke;
    }

    public void remove() {
        fill.remove();
        stroke.remove();
    }

    public int getFillColor() {
        return fill.getColor();
    }

    public boolean isGeodesic() {
        return fill.isGeodesic();
    }

    public void setPoints(List<LatLng> points) {
        fill.setPoints(points);
        stroke.setPoints(points);
    }

    public String getId() {
        return fill.getId();
    }

    public void setWidth(float width) {
        fill.setWidth(width);
    }

    public float getWidth() {
        return stroke.getWidth();
    }

    public float getZIndex() {
        return fill.getZIndex();
    }

    public List<LatLng> getPoints() {
        return fill.getPoints();
    }

    public boolean isVisible() {
        return fill.isVisible();
    }

    public void setZIndex(float zIndex) {
        fill.setZIndex(zIndex);
        stroke.setZIndex(zIndex);
    }

    public void setFillColor(int color) {
        fill.setColor(color);
    }

    public void setVisible(boolean visible) {
        fill.setVisible(visible);
        stroke.setVisible(visible);
    }

    public void setGeodesic(boolean geodesic) {
        fill.setGeodesic(geodesic);
        stroke.setGeodesic(geodesic);
    }

    public void setStrokeColor(int color) {
        stroke.setColor(color);
    }

    public int getStrokeColor() {
        return stroke.getColor();
    }

    public void setStrokeWidth(float strokeWidth) {
        fill.setWidth((stroke.getWidth() - strokeWidth * 2));
    }

    public float getStrokeWidth() {
        return stroke.getWidth() - fill.getWidth() / 2;
    }
}
