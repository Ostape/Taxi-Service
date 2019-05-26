package com.robosh;

import com.robosh.model.entity.Client;
import com.robosh.model.entity.Driver;
import com.robosh.service.ClientService;
import com.robosh.service.DriverService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Main{

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("me", "Orest");
        map.put("he", "Nazar");
        System.out.println(map.get("fsd"));
    }

}