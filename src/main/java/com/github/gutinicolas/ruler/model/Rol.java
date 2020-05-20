package com.github.gutinicolas.ruler.model;

import java.util.Set;
import java.util.UUID;

public class Rol {
    private UUID id;
    private String name;
    private Set<RolPermission> permissions;
    private int permissionLevel;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<RolPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<RolPermission> permissions) {
        this.permissions = permissions;
    }

    public int getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(int permissionLevel) {
        this.permissionLevel = permissionLevel;
    }
}
