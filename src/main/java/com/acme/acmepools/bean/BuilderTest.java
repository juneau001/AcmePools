/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.acmepools.bean;

/**
 *
 * @author Juneau
 */
public class BuilderTest {
    public static void main(String[] args){
        Owner owner = Owner.builder().firstName("Josh")
                .lastName("Juneau")
                .address1("111 Java Lane")
                .city("DukeLand")
                .state("IL")
                .zip("10210")
                .phoneNumber("111-111-1111")
                .phoneNumber("222-222-2222")
                .build();
        System.out.println("Owner: " + owner.toString());
    }
}
