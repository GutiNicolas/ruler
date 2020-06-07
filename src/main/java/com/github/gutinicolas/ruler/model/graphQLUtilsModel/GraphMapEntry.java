package com.github.gutinicolas.ruler.model.graphQLUtilsModel;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class GraphMapEntry {
    public String key;
    public Object value;

    public GraphMapEntry(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public GraphMapEntry(Map.Entry<String, Object> entry) {
        this.key = entry.getKey();
        this.value = entry.getValue();
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
        return StringUtils.isNotBlank(key);
    }
}
