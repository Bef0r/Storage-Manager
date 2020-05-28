/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.controllers;

import com.storage.controllers.exceptions.customException;
import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.storage.repositories.BlueprintRepository;
import com.storage.repositories.LocationRepository;
import com.storage.repositories.PermissionRepository;
import com.storage.repositories.RoleRepository;
import com.storage.repositories.UserRepository;
import com.storage.repositories.WorkpieceRepository;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("rest/test")
public class TestController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BlueprintRepository blueprintRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private WorkpieceRepository workpieceRepository;

    @GetMapping(path = "/")
    public String test() throws IOException {
        File file = new ClassPathResource("t.json").getFile();
        String test = new String(Files.readAllBytes(file.toPath()));
        ObjectMapper objectMapper = new ObjectMapper();
        List<customException> test2 = Arrays.asList(objectMapper.readValue(test, customException[].class));
        String z = test2.stream().filter(t-> t.getERROR_CODE()==1000).map(mapper->mapper.getEN()).collect(Collectors.joining());
        return z.toString();
    }
}
