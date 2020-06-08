package com.github.gutinicolas.ruler.utils;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PathUtils {

    private final static Pattern INDEX = Pattern.compile("^\\\\[(\\\\d+)\\\\]$");

    public static PathObject path(Map<String, Object> container, String fullPath) {
        String[] paths = fullPath.split("\\.");
        PathObject result = new PathObject(Optional.of(container));
        try {
            for (String path : paths) {
                result.v = Optional.of(extractValue(result.v, path));
            }
            return result;
        } catch (IllegalArgumentException e) {
            result.v = Optional.empty();
            return result;
        }
    }

    private static Object extractValue(Optional<Object> optContainer, String index) {
        if (!optContainer.isPresent() || optContainer.get() == null) {
            throw new IllegalArgumentException();
        }
        Object container = optContainer.get();
        Matcher m = INDEX.matcher(index);
        if (m.matches()) {
            int i = Integer.parseInt(m.group(1));
            if (container instanceof Object[]) {
                return ((Object[]) container)[i];
            }
            if (container instanceof List<?>) {
                return ((List<?>) container).get(i);
            }
            throw new IllegalArgumentException("An array or a list was expected, none of them was provided.");
        }
        if (container instanceof Map<?, ?>) {
            return ((Map<?, ?>) container).get(index);
        }
        throw new IllegalArgumentException();
    }
}

