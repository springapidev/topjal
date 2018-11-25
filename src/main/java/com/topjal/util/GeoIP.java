package com.topjal.util;

public class GeoIP {
    private String ipAddress;
    private String countrtyNamme;

    public GeoIP(String countrtyNamme) {
        this.countrtyNamme = countrtyNamme;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getCountrtyNamme() {
        return countrtyNamme;
    }

    public void setCountrtyNamme(String countrtyNamme) {
        this.countrtyNamme = countrtyNamme;
    }

    @Override
    public String toString() {
        return "GeoIP{" +
                "ipAddress='" + ipAddress + '\'' +
                ", countrtyNamme='" + countrtyNamme + '\'' +
                '}';
    }
}
