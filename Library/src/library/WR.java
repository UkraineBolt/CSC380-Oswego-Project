/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.*;
import java.nio.file.Paths;

/**
 *
 * @author alex
 */
public class WR {
    static String BD;
    static String C;
    static String A;
    
    WR(){
    String projectPath=Paths.get(".").toAbsolutePath().normalize().toString();
    String packagePath=projectPath+"\\Library\\src\\DataFilePackage";
    BD = packagePath+"\\bookData";
    C= packagePath+"\\Constants";
    A= packagePath+"\\Accounts";
    }
    
}