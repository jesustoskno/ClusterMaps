package com.clustermaps.jtoscano.clustermaps.interfaces;

import com.clustermaps.jtoscano.clustermaps.models.Sucursales;

import java.util.List;
import java.util.Map;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.QueryMap;


/**
 * Created by jtoscano on 22/10/2015.
 */
public interface ISucursales {
    @GET("/api/v1/Sucursal/Servicios")
    void getSucursales(Callback<List<Sucursales>> callback);
}
