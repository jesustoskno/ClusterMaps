package com.clustermaps.jtoscano.clustermaps.fragments;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.clustermaps.jtoscano.clustermaps.R;
import com.clustermaps.jtoscano.clustermaps.cluster.MiItem;
import com.clustermaps.jtoscano.clustermaps.interfaces.ISucursales;
import com.clustermaps.jtoscano.clustermaps.models.Sucursales;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;

import java.util.HashMap;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String BASE_URL = "http://farmaciasdelahorroapi.iainteractive.mx";
    private static String LOG_TAG;
    private HashMap<String, String> mOpciones = new HashMap<>();
    private ClusterManager<Sucursales> mClusterManager;
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .build();

        ISucursales sucursales = restAdapter.create(ISucursales.class);
        sucursales.getSucursales(new Callback<List<Sucursales>>() {
            @Override
            public void success(List<Sucursales> sucursales, Response response) {
                setMapMarkers(sucursales);
                Log.v(LOG_TAG, sucursales.toString());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.v(LOG_TAG, "Error, no paso el pishi");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                mClusterManager=new ClusterManager<Sucursales>(this, mMap);
                mClusterManager.setRenderer(new CustomRender<Sucursales>(this, mMap, mClusterManager));
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {


    }

    public void setMapMarkers(List<Sucursales> sucursales) {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(20.1212316, -101.1696363), 4));
        mClusterManager = new ClusterManager<Sucursales>(this, mMap);
        mMap.setOnCameraChangeListener(mClusterManager);

        for (Sucursales item : sucursales) {

            if ((item.getLatitud() != null) && (item.getLongitud() != null)) {
                LatLng position = new LatLng(Double.valueOf(item.getLatitud()), Double.valueOf(item.getLongitud()));
                double lat = position.latitude;
                double lng = position.longitude;
                Sucursales offsetItem = new Sucursales(lat, lng);
                mClusterManager.addItem(offsetItem);

            }
        }


    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;
    }

    class CustomRender<T extends ClusterItem> extends DefaultClusterRenderer<T>{

        public CustomRender(Context context, GoogleMap map, ClusterManager<T> clusterManager){
            super(context, map, clusterManager);
        }

        @Override
        protected boolean shouldRenderAsCluster(Cluster<T> cluster) {
            return cluster.getSize()>3;
        }
    }
}
