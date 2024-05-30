package api.utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class ReadPropertyFiles {

    private static Properties props;
    private static Map<String, String> conf = new HashMap<>();




    static {
        try {
            props = readProperties();
            for(Map.Entry prop : props.entrySet()){
                if (System.getProperties().stringPropertyNames().contains(prop.getKey().toString())){
                    props.setProperty(prop.getKey().toString(),System.getProperty(prop.getKey().toString()));
                }
            }
            props.forEach((key, value) -> conf.put(String.valueOf(key).trim(), String.valueOf(value).trim()));
        }catch(Exception e){
            throw new RuntimeException("The properties files can't be read");

        }

    }
    public static String getProperty(String key){
        String value = null;
        if(Objects.nonNull(conf.get(key))){
            value = conf.get(key);

        }else {
            throw new RuntimeException("The property is not in the default property file" );
        }
        return value;
    }

    private static Properties readProperties(){
        props = new Properties();
        try (InputStream input = new FileInputStream("src/test/resources/default.properties")){
            props.load(input);
        }catch(Exception e){
            throw new RuntimeException("Unable to read the property file " + "default.properties" );
            //  log.error("Unable to read the property file {}", DEFAULT_PROPERTIES, e);
        }
        return props;
    }



}
