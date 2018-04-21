/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;


import java.nio.file.Paths;

/**
 *
 * @author alex
 */
public class WR {
    static String BD;
    static String C;
    static String A;
    static String L;
    
    WR(){
    String projectPath=Paths.get(".").toAbsolutePath().normalize().toString();
    String packagePath=projectPath+"\\Library\\src\\DataFilePackage";
    BD = packagePath+"\\bookData.txt";
    C= packagePath+"\\Constants.txt";
    A= packagePath+"\\Accounts.txt";
    L=projectPath+"\\Library\\src\\LogPackages";
    }
    
    public String returnBookDataPath(){
        return BD;
    }
    public String returnConstantsPath(){
        return C;
    }
    public String returnAccountsPath(){
        return A;
    }
    public String returnLogFolderPath(){
        return L;
    }
    
}
