package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Payload {



    public  static String GetTeamInfo()  {
        String jsonAsString=null;
        try {
       return  jsonAsString = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "\\src\\test\\java\\util\\payLoad.json")));
        }
        catch (Exception e)
        {
            System.out.println("file not found.");
            e.printStackTrace();
        }
        return jsonAsString;
    }
}
