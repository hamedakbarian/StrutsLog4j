
package jndi;
import org.slf4j.*;

import java.util.Dictionary;
import java.util.Hashtable;

public class AppLogger {
    public static MDC Data; //dictionary for storing data for use in Log4j --thread specific {String:key, String:value}
    public Logger defaultLogger; //logger for every created AppLogger Object
    private static Dictionary<String,Marker> Markers = new Hashtable(); //dictionary for storing Markers for use in Log4j --shared among all objects {String:name, Marker:marker}
    
	//Constructor --initializes defaultLogger
    public AppLogger(String Name){
        defaultLogger = LoggerFactory.getLogger(Name);
    }
	//Creates a Marker and connects it to its parent and places it in the Markers dictionary for later use
    public static void createMarker(String Name, String parentMarkerName){
        if (parentMarkerName == null){
            Markers.put(Name, MarkerFactory.getMarker(Name));
            return;
        }
        Marker parentMarker = MarkerFactory.getMarker(Name);
        parentMarker.add(getMarker(parentMarkerName));
        Markers.put(Name, parentMarker);
    }
	//retrives marker from Markers dictionary based on name(ID)
	//returns Marker
    public static Marker getMarker(String Name){
        try{
            return Markers.get(Name);
        }catch(Exception e){}
        return null;
        }
    }
