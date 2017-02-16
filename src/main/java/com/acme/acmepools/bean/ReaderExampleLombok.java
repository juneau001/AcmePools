/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.acmepools.bean;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import lombok.Cleanup;
import lombok.SneakyThrows;

/**
 *
 * @author Juneau
 */
public class ReaderExampleLombok {

    @SneakyThrows({FileNotFoundException.class, IOException.class})
    public static void main(String args[]) {
        @Cleanup
        FileInputStream fis = null;
        @Cleanup
        BufferedReader reader = null;
        fis = new FileInputStream(
                "/path-to-file/upload.log");
        reader = new BufferedReader(
                new InputStreamReader(fis));

        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }
    }
}
