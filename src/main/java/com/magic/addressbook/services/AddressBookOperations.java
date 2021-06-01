package com.magic.addressbook.services;

import com.magic.addressbook.controller.*;
import com.magic.addressbook.entity.*;

import java.awt.peer.ListPeer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBookOperations implements IAddressBookOperations {
    HashMap<String, List<PersonInfo>> addressBook = new HashMap<>();

    @Override
    public void createAddressBook(String bookName) {

            addressBook.put(bookName, new ArrayList<>());
    }

    @Override
    public void openAddressBook(String bookName) {
        ContactOperations contact_operations = new ContactOperations();
        contact_operations.contactOperation(addressBook.get(bookName));
    }

    @Override
    public void showAddressBook() {
        for (Map.Entry mapValue :  addressBook.entrySet()){
            String key = (String)mapValue.getKey();
            System.out.println(key);
        }
    }

    @Override
    public void searchPersonByCity(String city) {
        int count = 0;
        for (Map.Entry mapValue : addressBook.entrySet()){
            String key = (String)mapValue.getKey();
            List<PersonInfo> personInfos = addressBook.get(key);
            for (PersonInfo personInfo : personInfos){
                if (personInfo.getCity().equalsIgnoreCase(city)){
                    System.out.println(personInfo);
                    count++;
                }
            }
        }
        System.out.println("Number of Person from " + city + ": " + count);
    }

    @Override
    public void searchPersonByState(String state) {
        int count = 0;
        for (Map.Entry mapValue : addressBook.entrySet()){
            String key = (String)mapValue.getKey();
            List<PersonInfo> personInfos = addressBook.get(key);
            for (PersonInfo personInfo : personInfos){
                if (personInfo.getState().equalsIgnoreCase(state)){
                    System.out.println(personInfo);
                    count++;
                }
            }
        }
        System.out.println("Number of Person from " + state + ": " + count);
    }
}
