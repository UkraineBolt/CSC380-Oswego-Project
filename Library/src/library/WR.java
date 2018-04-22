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
    static String WL;
    static String E;
    static String CL;
    static String CE;
    static String LN;
    
    WR(){
    String projectPath=Paths.get(".").toAbsolutePath().normalize().toString();
    String packagePath=projectPath+"\\src\\DataFilePackage";
    BD = packagePath+"\\BookData.txt";
    C= packagePath+"\\Constants.txt";
    A= packagePath+"\\Accounts.txt";
    WL=packagePath+"\\WorkLogs.txt";
    E=packagePath+"\\Events.txt";
    CL=packagePath+"\\CompletedLogs.txt";
    CE=packagePath+"\\CompletedEvents.txt";
    LN=packagePath+"\\LibraryNumbers.txt";
    }
    
    public String returnCompletedLogsPath(){
        return CL;
    }
    public String returnLibraryNumberPath(){
        return LN;
    }
    public String returnCompletedEventsPath(){
        return CE;
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
    public String returnEventsPath(){
        return E;
    }
    public String returnWorkLogsPath(){
        return WL;
    }
}
