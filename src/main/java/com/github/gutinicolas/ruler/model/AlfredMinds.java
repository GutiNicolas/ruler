package com.github.gutinicolas.ruler.model;

import java.util.*;

public class AlfredMinds {
    public Optional<User> user = Optional.empty();
    public List<UserHistoryRecord> userRecords = new ArrayList<>();
    public Map<String, Object> interceptasSafeBank = new HashMap<>();
    public Map<String, Object> additionalData = new HashMap<>();

    public AlfredMinds() {
    }

    public AlfredMinds withUser(User user) {
        this.user = Optional.of(user);
        return this;
    }

    public AlfredMinds withUserRecords(List<UserHistoryRecord> records) {
        this.userRecords = records;
        return this;
    }

    public void addInterceptasToSafeBank(String interceptasKey, Map<String, Object> value) {
        this.interceptasSafeBank.computeIfAbsent(interceptasKey, k -> value);
    }

    public void addAdditionalData(String dataKey, Map<String, Object> data) {
        this.additionalData.computeIfAbsent(dataKey, k -> data);
    }
}
