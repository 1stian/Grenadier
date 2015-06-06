package util;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Stian on 07.06.2015.
 */
public class HashLists {

    static HashMap explode = new HashMap();

    public static void explodePut (String plr){
        if (!explode.containsKey(plr)) {
            explode.put(plr, "true");
        }else{
            explode.remove(plr);
        }
    }

    public static boolean checkMap(String plr){
        boolean player = false;
        if (explode.containsKey(plr)) {
            player = true;
        }else{
            player = false;
        }
        return player;
    }
}
