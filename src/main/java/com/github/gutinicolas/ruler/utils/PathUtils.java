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

class PathObject implements Serializable {
    Optional<Object> v;

    public PathObject(Optional<Object> o) {
        this.v = o;
    }

    public <T> Optional<T> convert(Class<T> c) {
        return this.v.isPresent() && c.isInstance(this.v.get()) ? (Optional<T>) this.v : Optional.empty();
    }

    public Optional<String> toStr() {
        return convert(String.class);
    }

    public Optional<Integer> toInteger() {
        return convert(Integer.class);
    }

    public Optional<Double> toDouble() {
        return convert(Double.class);
    }

    public Optional<Float> toFloat() {
        return convert(Float.class);
    }

    public Optional<Boolean> toBoolean() {
        return convert(Boolean.class);
    }

    public Optional<UUID> toUUID() {
        try{
            return Optional.of(UUID.fromString(this.toStr().orElse("")));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }

    public Map<String, Object> toMap() {
        return convert(Map.class).orElse(new HashMap());
    }

    public Map<String, Object> toImmutableMap() {
        return Map.ofEntries((Map.Entry[]) this.toMap().entrySet().toArray());
    }

    public <T> List<T> toList(Class<T> c) {
        List conv = convert(List.class).orElse(new ArrayList<T>());
        return conv.isEmpty() ? conv : c.isInstance(conv.get(0)) ? conv : new ArrayList<T>();
    }

    public <T> List<T> toImmutableList(Class<T> c) {
        return List.of((T[]) this.toList(c).toArray());
    }

    public <T> Set<T> toSet(Class<T> c) {
        return new HashSet<T>(this.toList(c));
    }

    public <T> Set<T> toImmutableSet(Class<T> c) {
        return Set.of((T[]) this.toList(c).toArray());
    }
}
