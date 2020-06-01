/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.api.response.UserResponse;

import java.util.Map;



/**
 *
 * @author Dell
 */
public class AllUsersWithFullNameAndIdResponse {
    Map<Long,String> Users;

    public Map<Long, String> getUsers() {
        return Users;
    }

    public void setUsers(Map<Long, String> Users) {
        this.Users = Users;
    }
}
