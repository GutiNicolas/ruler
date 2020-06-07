package com.github.gutinicolas.ruler.utils;

import com.github.gutinicolas.ruler.model.graphQLUtilsModel.GraphMapEntry;
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

    public Map<String, Object> graphMapToImmutableMap(List<GraphMapEntry> graphMap) {
        return Map.ofEntries((Map.Entry<? extends String, ?>[]) graphMapToMap(graphMap)
                .entrySet()
                .stream()
                .filter(this::isValidImmutableEntry)
                .collect(Collectors.toSet())
                .toArray());
    }

    public List<GraphMapEntry> mapToGraphMap(Map<String, Object> map) {
        return map.entrySet()
                .stream()
                .map(GraphMapEntry::new)
                .collect(Collectors.toList());
    }

    public boolean isValidImmutableEntry(Map.Entry<String, Object> entry) {
        return StringUtils.isNotBlank((String) entry.getKey()) && entry.getValue() != null;
    }
}

