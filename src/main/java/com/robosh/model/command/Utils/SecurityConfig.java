package com.robosh.model.command.Utils;

import com.robosh.model.entity.enums.Role;

import java.util.*;

public class SecurityConfig {
    private static final Map<Role, List<String>> mapConfig = new HashMap<>();

    static {
        init();
    }

    private static void init() {

        // Configure For "Client" Role.
        List<String> urlPatterns1 = new ArrayList<>();

        //todo make url patterns
        urlPatterns1.add("/makeOrder");
        urlPatterns1.add("/clientAccount");

        mapConfig.put(Role.CLIENT, urlPatterns1);

        // Configure For "Driver" Role.
        List<String> urlPatterns2 = new ArrayList<>();

        ///urlPatterns2.add("/userInfo");
        urlPatterns2.add("/driverAccount");

        mapConfig.put(Role.DRIVER, urlPatterns2);
    }

    public static Set<Role> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(Role role) {
        return mapConfig.get(role);
    }
}
