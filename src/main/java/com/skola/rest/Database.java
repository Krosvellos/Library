package com.skola.rest;

import com.skola.rest.dto.Admindto;
import com.skola.rest.dto.Bookdto;
import com.skola.rest.dto.Categorydto;
import com.skola.rest.dto.Userdto;

import java.util.HashMap;
import java.util.UUID;

public class Database {

    public static HashMap<UUID, Userdto> userHashMap = new HashMap<>();

    public static HashMap<UUID, Admindto> adminHashMap = new HashMap<>();

    public static HashMap<UUID, Categorydto> categoryHashMap = new HashMap<>();

    public static HashMap<UUID, Bookdto> bookHashMap = new HashMap<>();


}
