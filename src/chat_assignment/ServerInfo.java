/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_assignment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author dell
 */
public class ServerInfo {

    /**
     *
     */
    private static ParseRoute pr = ParseRoute.getInstance();
    public static String IP = "192.168.2.12";
    public static String getIP() throws UnknownHostException
    {
        return pr.getLocalIPAddress();
    }
   
     
    //public static String IP = ;
}
