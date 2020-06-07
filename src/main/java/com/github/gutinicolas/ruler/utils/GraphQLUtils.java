package com.github.gutinicolas.ruler.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GraphQLUtils {
    public Map<String, Object> graphMapToMap(List<GraphMapEntry> graphMap) {
        Map<String, Object> map = new HashMap<>();
        graphMap.stream().filter(GraphMapEntry::isValidEntry).collect(Collectors.toList()).forEach(graphMapEntry -> {
            map.put(graphMapEntry.key, graphMapEntry.value);
        });
        return map;
    }

}

class GraphMapEntry {
    String key;
    Object value;

    public GraphMapEntry(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean isValidEntry() {
        return StringUtils.isNotBlank(key) && value != null;
    }
}
