/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.controllers.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @author Dell
 */
public class LanguageAndDescriptionSelector {

    private static final String EXCEPTON_FILE_NAME = "exceptionsDescribe.json";

    public static String languageAndDescriptionSelector(String language, int errorCode) {
        try {
            String exceptionsJsonFrom = openFileAndPutString(EXCEPTON_FILE_NAME);
            ObjectMapper objectMapper = new ObjectMapper();
            List<customException> exceptions = Arrays.asList(objectMapper.readValue(exceptionsJsonFrom, customException[].class));
            return languageSelect(exceptions, language, errorCode);
        } catch (Exception e) {
            //LOGGER
            return "INTERNAL_SERVER_ERROR";
        }
    }

    public static String openFileAndPutString(String fileName) throws IOException {
        File file = new ClassPathResource(fileName).getFile();
        return new String(Files.readAllBytes(file.toPath()));
    }

    private static String languageSelect(List<customException> exceptions, String language, int errorCode) {
        switch (language) {
            case "HU":
                return exceptions.stream().filter(exception -> exception.getERROR_CODE() == errorCode).map(mapper -> mapper.getHU()).collect(Collectors.joining());
            case "DE":
                return exceptions.stream().filter(exception -> exception.getERROR_CODE() == errorCode).map(mapper -> mapper.getDE()).collect(Collectors.joining());
            default:
                return exceptions.stream().filter(exception -> exception.getERROR_CODE() == errorCode).map(mapper -> mapper.getEN()).collect(Collectors.joining());
        }
    }
}
