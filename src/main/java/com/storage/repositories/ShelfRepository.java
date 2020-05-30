/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.repositories;

import com.storage.repositories.entities.Shelf;
import org.springframework.data.repository.CrudRepository;

public interface ShelfRepository extends CrudRepository<Shelf, Long> {
    
}
