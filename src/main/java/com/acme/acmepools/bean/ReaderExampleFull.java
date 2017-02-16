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

/**
 *
 * @author Juneau
 */
public class ReaderExampleFull {
    public static void main(String args[]) {
     
        FileInputStream fis = null;
        BufferedReader reader = null;
      
        try {
            fis = new FileInputStream(
                    "/path-to-file/myfile.txt");
            reader = new BufferedReader(
                    new InputStreamReader(fis));
       
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                line = reader.readLine();
            }           
          
        } catch (FileNotFoundException ex) {
            // Log exception
        } catch (IOException ex) {
            // Log exception
          
        } finally {
            try {
                if(reader != null)
                    reader.close();
                if(fis != null)
                    fis.close();
            } catch (IOException ex) {
                // Log exception
            }
        }
    }
}


