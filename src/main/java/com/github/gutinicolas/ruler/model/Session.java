package com.github.gutinicolas.ruler.model;


import java.io.Serializable;
import java.util.*;

public class Session implements Serializable {

    private UUID id;
    private SessionResult result;
    private Set<String> permissions;
    private Float expirationDate;
    private SessionIdentity user_identity;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SessionResult getResult() {
        return result;
    }

    public void setResult(SessionResult result) {
        this.result = result;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

    public Float getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Float expirationDate) {
        this.expirationDate = expirationDate;
    }

    public SessionIdentity getUser_identity() {
        return user_identity;
    }

    public void setUser_identity(SessionIdentity user_identity) {
        this.user_identity = user_identity;
    }
}

class SessionBreakdown implements Serializable {
    private UUID id;
    private UUID session_id;
    private List<UserFlowEvents> events;
    private Float start_time;
    private Float end_time;
    private Float duration;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getSession_id() {
        return session_id;
    }

    public void setSession_id(UUID session_id) {
        this.session_id = session_id;
    }

    public List<UserFlowEvents> getEvents() {
        return events;
    }

    public void setEvents(List<UserFlowEvents> events) {
        this.events = events;
    }

    public Float getStart_time() {
        return start_time;
    }

    public void setStart_time(Float start_time) {
        this.start_time = start_time;
    }

    public Float getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Float end_time) {
        this.end_time = end_time;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }
}

class UserFlowEvents implements Serializable {
    private UUID id;
    private Float time;
    private FlowEventType type;
    private Map<String, Object> entity;
    private Optional<String> external_action_type;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Float getTime() {
        return time;
    }

    public void setTime(Float time) {
        this.time = time;
    }

    public FlowEventType getType() {
        return type;
    }

    public void setType(FlowEventType type) {
        this.type = type;
    }

    public Map<String, Object> getEntity() {
        return entity;
    }

    public void setEntity(Map<String, Object> entity) {
        this.entity = entity;
    }

    public Optional<String> getExternal_action_type() {
        return external_action_type;
    }

    public void setExternal_action_type(Optional<String> external_action_type) {
        this.external_action_type = external_action_type;
    }
}

enum FlowEventType {
    LOGIN,
    LOGOUT,
    REGISTER,
    UPDATE_PROFILE,
    RESET_PASSWORD,
    UNKNOWN_ACTION,
    EXTERNAL_ACTION
}

enum SessionResult {
    OK,
    DENIED,
    BANNED_USER,
    TIMEOUT,
    NO_USER
}

class SessionIdentity {
    private String username;
    private String email;
    private Float last_seen_date;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getLast_seen_date() {
        return last_seen_date;
    }

    public void setLast_seen_date(Float last_seen_date) {
        this.last_seen_date = last_seen_date;
    }
}
