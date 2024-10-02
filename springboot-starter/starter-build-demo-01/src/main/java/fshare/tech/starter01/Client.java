package fshare.tech.starter01;

import java.util.Map;

/**
 * @author: yyj
 * @create: 2024-04-19 19:20
 * @description: TODO
 */

public class Client {

    Map<String, String> propertiesMap;

    public Client(Map<String, String> propertiesMap) {
        this.propertiesMap = propertiesMap;
    }

    public Map<String, String> getPropertiesMap() {
        return propertiesMap;
    }
}
