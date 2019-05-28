package com.robosh;

import com.robosh.model.entity.Client;
import com.robosh.model.entity.Driver;
import com.robosh.model.entity.enums.Role;
import com.robosh.service.ClientService;
import com.robosh.service.DriverService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main{

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
         Map<Role, String> allowedPages = new HashMap<>();
        allowedPages.put(Role.UNKNOWN, Stream.of("/loginDriver", "/loginClient", "/registerClient",
                "/homePage", "/enterLogin").collect(Collectors.toSet()).toString());
        System.out.println(allowedPages.get(Role.UNKNOWN).contains("/loginDrier"));
    }

}