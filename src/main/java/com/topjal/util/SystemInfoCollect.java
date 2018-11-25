package com.topjal.util;


import java.net.InetAddress;
import java.net.NetworkInterface;

public class SystemInfoCollect {
    

    /**
     * Method for get System Name
     *
     * @return Host name
     */
    public static String getSystemName() {
        try {
            InetAddress inetaddress = InetAddress.getLocalHost(); //Get LocalHost refrence
            String name = inetaddress.getHostName();   //Get Host Name
            return name;   //return Host Name
        } catch (Exception E) {
            E.printStackTrace();  //print Exception StackTrace
            return null;
        }
    }

    /**
     * method to get Host IP
     *
     * @return Host IP Address
     */
    public static String getIPAddress() {
        try {
            InetAddress inetaddress = InetAddress.getLocalHost();  //Get LocalHost refrence
            String ip = inetaddress.getHostAddress();  // Get Host IP Address
            return ip;   // return IP Address
        } catch (Exception E) {
            E.printStackTrace();  //print Exception StackTrace
            return null;
        }

    }

    /**
     * method to get Host Mac Address
     *
     * @return Mac Address
     */
    public static String getMAC() {
        try {
            InetAddress inetaddress = InetAddress.getLocalHost(); //Get LocalHost refrence

            //get Network interface Refrence by InetAddress Refrence
            NetworkInterface network = NetworkInterface.getByInetAddress(inetaddress);
            byte[] macArray = network.getHardwareAddress();  //get Harware address Array
            StringBuilder str = new StringBuilder();

            // Convert Array to String 
            for (int i = 0; i < macArray.length; i++) {
                str.append(String.format("%02X%s", macArray[i], (i < macArray.length - 1) ? "-" : ""));
            }
            String macAddress = str.toString();

            return macAddress; //return MAc Address
        } catch (Exception E) {
            E.printStackTrace();  //print Exception StackTrace
            return null;
        }
    }
}
