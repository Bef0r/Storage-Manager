/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.managers.mappers;

import com.storage.managers.customClasses.CreateUserName;
import com.storage.api.response.UserResponse.AllUsersWithFullNameAndIdResponse;
import com.storage.repositories.entities.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Dell
 */
public class UsersMapper {

    public static AllUsersWithFullNameAndIdResponse mappedAllUserWithFullNameAndId(List<User> users) {
        AllUsersWithFullNameAndIdResponse getAllUsersWithFullNameAndIdResponse = new AllUsersWithFullNameAndIdResponse();
        Map<Long, String> response = new HashMap<>();

        users.forEach(user -> {
            response.put(user.getId(), CreateUserName.createUserName(user));
        });
        getAllUsersWithFullNameAndIdResponse.setUsers(response);
        return getAllUsersWithFullNameAndIdResponse;
    }
}
