/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.managers.customClasses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class OperationsOfTwoLists {

    public static <E> List<E> getListsUnio(List<E> listA, List<E> listB) {
        List<E> union = new ArrayList(listA);
        union.addAll(listB);
        List<E> intersection = new ArrayList(listA);
        intersection.retainAll(listB);
        return intersection;
    }
    
    public static <E> List<E> getADifferenceB(List<E> listA, List<E> listB){
        List<E> listTemp = new LinkedList<>(listA);
        listTemp.removeAll(listB);
        return listTemp;
    }
}
