package com.github.gutinicolas.ruler.model;

import java.util.Set;
import java.util.UUID;

public class Permission {
    private String id;
    private String description;
    private Set<String> canAssignIfUserHas;
}

class PermissionGroup {
    private UUID id;
    private String groupName;
    private Set<Permission> groupPermissions;

}
