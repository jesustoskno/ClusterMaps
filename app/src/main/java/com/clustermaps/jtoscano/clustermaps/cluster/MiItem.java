package com.clustermaps.jtoscano.clustermaps.cluster;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

/**
 * Created by jtoscano on 22/10/2015.
 */
public class MiItem implements ClusterItem {
    private final LatLng mPosition;

    public MiItem(double lat, double lng){
        mPosition=new LatLng(lat, lng);
    }

    @Override
    public LatLng getPosition() {
        return mPosition;
    }
}
