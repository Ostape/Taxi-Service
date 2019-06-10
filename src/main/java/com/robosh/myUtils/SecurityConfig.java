package com.robosh.myUtils;

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
        urlPatterns1.add("/makeOrder");
        urlPatterns1.add("/clientAccount");
        urlPatterns1.add("/logOut");
        urlPatterns1.add("/enterOrder");

        mapConfig.put(Role.CLIENT, urlPatterns1);

        // Configure For "Driver" Role.
        List<String> urlPatterns2 = new ArrayList<>();
        urlPatterns2.add("/showOrders");
        urlPatterns2.add("/driverAccount");
        urlPatterns2.add("/logOut");

        mapConfig.put(Role.DRIVER, urlPatterns2);
    }

    public static Set<Role> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(Role role) {
        return mapConfig.get(role);
    }
}
