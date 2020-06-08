package com.github.gutinicolas.ruler.utils;

import java.io.Serializable;
import java.util.*;

public class PathObject implements Serializable {
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
