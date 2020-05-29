/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.controllers.exceptions.exceptionConstans;

/**
 *
 * @author Dell
 */
public interface ExceptionConstans {
    public static final int EXCEPTION_FILE_NOT_FOUND =800;
    public static final String EXCEPTION_FILE_NOT_FOUND_DESC= "Exception file not found";
    public static final String DEFAULT_EXCEPTON_MESSAGE ="Something went wrong, try again later";
    public static final int ROLE_DOES_NOT_EXISTS = 1000;
    public static final int ROLE_NAME_EXISTS = 1001;
    public static final int INTERNAL_SERVER_ERROR_ROLE_UPDATE = 1002;
    public static final int ROLE_UPDATE_CREATE_ERROR = 1003;
    public static final int ROLE_UPDATE_DELETE_ERROR = 1004;
}
