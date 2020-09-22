package net.berrygames.bungee.utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

public class IPUtils {

    public static String getIP(){
        String systemipaddress = "";
        try
        {
            URL url_name = new URL("http://bot.whatismyipaddress.com");
            BufferedReader sc = new BufferedReader(new InputStreamReader(url_name.openStream()));
            systemipaddress = sc.readLine().trim();
            if (!(systemipaddress.length() > 0))
            {
                try
                {
                    InetAddress localhost = InetAddress.getLocalHost();
                    systemipaddress = (localhost.getHostAddress()).trim();
                }
                catch(Exception e1)
                {
                    systemipaddress = "localhost";
                }
            }
        }
        catch (Exception e2)
        {
            systemipaddress = "localhost";
        }
        return systemipaddress;
    }

}