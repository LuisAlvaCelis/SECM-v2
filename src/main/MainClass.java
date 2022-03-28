package main;

import files.FileClass;
import mvc.controller.ControllerMain;

public class MainClass {
    
    public static void main(String[] args) throws Exception{
        if(FileClass.getInstance().createFile()){
            ControllerMain.getInstance();
        }
    }
}
