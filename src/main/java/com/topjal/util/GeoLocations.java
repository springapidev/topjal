package com.topjal.util;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;
import org.springframework.data.jpa.domain.JpaSort;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

public class GeoLocations {
    private static DatabaseReader dbReader;

    public GeoLocations() throws IOException {

        File database = new File("classpath:GeoCountry.mmdb");
        if(!database.exists()){
            database.createNewFile();
            System.out.println("File created");
        }
        dbReader = new DatabaseReader.Builder(database).build();
    }

    public static GeoIP getLocation(String ip)
            throws IOException, GeoIp2Exception {
        InetAddress ipAddress = InetAddress.getByName(ip);
        CountryResponse response = dbReader.country(ipAddress);
          return new GeoIP(response.getCountry().getName());
    }


}
