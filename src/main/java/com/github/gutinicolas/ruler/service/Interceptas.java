package com.github.gutinicolas.ruler.service;

import org.springframework.data.util.Pair;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Future;

public abstract class Interceptas {

    public abstract String interceptaName();

    public static Set<Interceptas> requiredInterceptas() { return new HashSet<>(); }

    public static boolean isCriticalIntercepta() { return false; }

    public static boolean shouldApply() {
        return true;
    }

    public abstract <T> Future<Pair<ValidationStatusCode, T>> intercept();

    public abstract <T> void saveResults(T results);

    public abstract int timeout();
}

enum ValidationStatusCode {
    OK,
    DENIED,
    ERROR,
    NOT_FOUND
}