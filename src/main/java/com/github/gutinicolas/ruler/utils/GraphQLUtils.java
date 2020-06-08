package com.github.gutinicolas.ruler.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.gutinicolas.ruler.model.graphQLUtilsModel.GraphMapEntry;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GraphQLUtils {

    Logger logger = LoggerFactory.getLogger(GraphQLUtils.class);

    @Autowired
    ObjectMapper objectMapper;

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

    public List<GraphMapEntry> toRecursiveJSON(List<GraphMapEntry> mapEntries) {
        return mapEntries.stream().map(this::toJSON).collect(Collectors.toList());
    }

    private GraphMapEntry toJSON(GraphMapEntry graphMapEntry) {
        try {
            if (graphMapEntry.value instanceof Collection || graphMapEntry.value instanceof Map<?, ?>) {
                graphMapEntry.value = objectMapper.writeValueAsString(graphMapEntry.value);
            }
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage(), e);
        }
        return graphMapEntry;
    }
}

