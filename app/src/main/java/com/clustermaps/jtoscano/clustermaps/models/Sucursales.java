package com.clustermaps.jtoscano.clustermaps.models;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.ClusterManager;

/**
 * Created by jtoscano on 22/10/2015.
 */
public class Sucursales implements ClusterItem{

    private final LatLng mPosition;

    public Sucursales(double lat, double lng){
        mPosition=new LatLng(lat, lng);
    }

    @Override
    public LatLng getPosition() {
        return mPosition;
    }

    @SerializedName("SERVICIO_COD_APP")
    private String servicioCodApp;

    @SerializedName("SERVICIO_APP")
    private String servicioaPP;

    @SerializedName("FILIAL_CODE")
    private String filianCode;

    @SerializedName("SUCURSAL")
    private String sucursal;

    @SerializedName("CALLE")
    private String calle;

    @SerializedName("NUM_EXT")
    private String numExt;

    @SerializedName("NUM_INT")
    private String numInt;

    @SerializedName("COLONIA")
    private String colonia;

    @SerializedName("CIUDAD")
    private String ciudad;

    @SerializedName("CODIGO_POSTAL")
    private String codigoPostal;

    @SerializedName("MUNICIPIO")
    private String municipio;

    @SerializedName("ESTADO")
    private String estado;

    @SerializedName("TELEFONO")
    private String telefono;

    @SerializedName("EMAIL")
    private String email;

    @SerializedName("LATITUD")
    private String latitud;

    @SerializedName("LONGITUD")
    private String longitud;

    @SerializedName("JORNADA_24HRS")
    private String jornada24Hrs;

    @SerializedName("HORA_APERTURA_FARMACIA")
    private String horaAperturaFarmacia;

    @SerializedName("HORA_CIERRE_FARMACIA")
    private String horaCierreFarmacia;

    @SerializedName("SERVICIO_DOMICILIO")
    private String servicioDomicilio;

    @SerializedName("HORA_APERTURA_SERV_DOM")
    private String horaAperturaServDom;

    @SerializedName("HORA_CIERRE_SERV_DOM")
    private String horaCierreServDom;

    @SerializedName("SERVICIO_SOM")
    private String servicioSom;

    @SerializedName("HORA_APERTURA_SOM")
    private String horaAperturaSom;

    @SerializedName("HORA_CIERRE_SOM")
    private String horaCierreSom;

    @SerializedName("ERROR")
    private String error;

    @SerializedName("MSG_ERROR")
    private String msgError;

    public String getServicioCodApp() {
        return servicioCodApp;
    }

    public String getServicioaPP() {
        return servicioaPP;
    }

    public String getFilianCode() {
        return filianCode;
    }

    public String getSucursal() {
        return sucursal;
    }

    public String getCalle() {
        return calle;
    }

    public String getNumExt() {
        return numExt;
    }

    public String getNumInt() {
        return numInt;
    }

    public String getColonia() {
        return colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getEstado() {
        return estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getLatitud() {
        return latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public String getJornada24Hrs() {
        return jornada24Hrs;
    }

    public String getHoraAperturaFarmacia() {
        return horaAperturaFarmacia;
    }

    public String getHoraCierreFarmacia() {
        return horaCierreFarmacia;
    }

    public String getServicioDomicilio() {
        return servicioDomicilio;
    }

    public String getHoraAperturaServDom() {
        return horaAperturaServDom;
    }

    public String getHoraCierreServDom() {
        return horaCierreServDom;
    }

    public String getServicioSom() {
        return servicioSom;
    }

    public String getHoraAperturaSom() {
        return horaAperturaSom;
    }

    public String getHoraCierreSom() {
        return horaCierreSom;
    }

    public String getError() {
        return error;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setServicioCodApp(String servicioCodApp) {
        this.servicioCodApp = servicioCodApp;
    }

    public void setServicioaPP(String servicioaPP) {
        this.servicioaPP = servicioaPP;
    }

    public void setFilianCode(String filianCode) {
        this.filianCode = filianCode;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumExt(String numExt) {
        this.numExt = numExt;
    }

    public void setNumInt(String numInt) {
        this.numInt = numInt;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public void setJornada24Hrs(String jornada24Hrs) {
        this.jornada24Hrs = jornada24Hrs;
    }

    public void setHoraAperturaFarmacia(String horaAperturaFarmacia) {
        this.horaAperturaFarmacia = horaAperturaFarmacia;
    }

    public void setHoraCierreFarmacia(String horaCierreFarmacia) {
        this.horaCierreFarmacia = horaCierreFarmacia;
    }

    public void setServicioDomicilio(String servicioDomicilio) {
        this.servicioDomicilio = servicioDomicilio;
    }

    public void setHoraAperturaServDom(String horaAperturaServDom) {
        this.horaAperturaServDom = horaAperturaServDom;
    }
}
