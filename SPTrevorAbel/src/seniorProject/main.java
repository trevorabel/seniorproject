/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seniorProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;
import static seniorProject.desEncryption.desFileCreator;
import static seniorProject.desEncryption.desFileCreatorDec;

/**
 *
 * @author Trevor
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
            throws FileNotFoundException, UnsupportedEncodingException, IOException
    {
        
        start();
       
//        //Creates a new folder if the previous one is already created
//        //limitation to 100 files
//        boolean Real = false;
//        int i = 1;
//        File dir = new File("C:\\Users\\Trevor\\Desktop\\SPTests\\test"+i);
//        dir.mkdir();
//        while(!Real)
//        {
//           if(dir.exists())
//            {
//                System.out.println("Folder already exists.");
//                for(int iter = 1; iter < 100; iter++)
//                {
//                    System.out.println("Added one to the iterator.");
//                    dir = new File("C:\\Users\\Trevor\\Desktop\\SPTests\\test"+iter);
//                    if(!dir.exists())
//                    {
//                        dir.mkdir();
//                        Real = true;
//                        System.out.println("Set real to true.");
//                        break;
//                    }
//                    System.out.println("Start New Cycle.");
//                }
//                
//                
//            }
//            else
//            {
//                System.out.println("Folder now exists.");
//                Real = true;
//            } 
//        }
//        
//        System.out.println("Made it out.");
    }
    
    public static void start()
            throws FileNotFoundException, UnsupportedEncodingException, IOException
    {
        
        //banner strings with project information
        String banner1 = "====================================================";
        String banner2 = "----------------------------------------------------";
        String banner3 = "--------------- Senior Project: Text ---------------";
        String banner4 = "---------------    File Encryptor    ---------------";
        String banner5 = "---------------    By: Trevor Abel   ---------------";
        
        System.out.println(banner1);
        System.out.println(banner1);
        System.out.println(banner1);
        System.out.println(banner2);
        System.out.println(banner3);
        System.out.println(banner4);
        System.out.println(banner5);
        System.out.println(banner2);
        System.out.println(banner1);
        System.out.println(banner1);
        System.out.println(banner1);
        
        System.out.println();
        System.out.println();
        System.out.println();
        
        //press enter to begin the program
        String start = "                Press Enter to begin.";
        System.out.println(start);
        
        Scanner keyboard1 = new Scanner(System.in);
        keyboard1.nextLine();
        
        selection();
    }
    
    public static void selection()
            throws FileNotFoundException, UnsupportedEncodingException, IOException
    {
        String banner1 = "====================================================";
        String banner2 = "----------------------------------------------------";
        Scanner choice1Selection = new Scanner(System.in);
        
        //selection for what they would like to do first
        System.out.println(banner2);
        System.out.println(banner1);
        String choice1 = "Please enter the number of which option you would "
                + "like to do first:";
        
        String select1 = "1) Encrypt (For DES and AES256 this will also decrypt"
                + " after encrypting and entering the new file location)";
        String select2 = "2) Decrypt (Only works for Caesarean Method due to"
                + " the limitations of instances for DES and AES256)";
        String select3 = "3) Exit";
        
        System.out.println();
        System.out.println();
        System.out.println(choice1);
        
        System.out.println();
        System.out.println();
        System.out.println(select1);
        System.out.println(select2);
        System.out.println(select3);
        
        
        switch(choice1Selection.nextInt())
        {
            case 1:
            {
                encrypt();
            }
            case 2:
            {
                decrypt();
            }
            case 3:
            {
                System.exit(0);
            }
        }
    }
    
    public static void encrypt() 
            throws FileNotFoundException, UnsupportedEncodingException, IOException
    {
        //user selects file and it is checked to make sure it exists
        
        String verifiedPath = "";
        String filePath;
        boolean validPath = false;
        File file;
        
        String getFilePath = "Please enter the file path for the file "
                + "you wish to encrypt:";
        System.out.println(getFilePath);
        Scanner enteredPath = new Scanner(System.in);
        filePath = enteredPath.nextLine();
        
        /*
        while loop will loop until the path entered by the user comes back
        as a file that actually exists on the users computer
        */
        while(!validPath)
        {
            try
            {
                file = new File(filePath);
                if(file.exists())
                {
                    System.out.println("File Found at: " + file.getPath());
                    validPath = true;
                    verifiedPath = file.getPath();
                }
                else{
                    throw new fileNotFound();
                }
            }
            
            /*
            catching this error allows for the while loop to let the user
            enter in more paths to have more chances without closing and
            reopening the program
            */
            catch(fileNotFound e)
            {
                System.out.println(e.getMessage());
                Scanner retryPath = new Scanner(System.in);
                filePath = retryPath.nextLine();
            }
        }
        //only used for the encryption using the Caesarean method
        String extractedContents = bufferedReader(verifiedPath);
        
        //Main start section where the user selects the method of encryption
        String selectMethod = "Please enter the number of the encryption "
                + "method you would like to use from above:";
        String method1 = "1) Caesarean";
        String method2 = "2) DES";
        String method3 = "3) Triple DES";
        
        System.out.println();
        System.out.println();
        System.out.println(method1);
        System.out.println(method2);
        System.out.println(method3);
        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        
        System.out.println(selectMethod);
        Scanner methodChoice = new Scanner(System.in);
        
        switch(methodChoice.nextInt())
        {
            case 1:
            {
                caesarEnc(extractedContents);
                selection();
                break;
            }
            case 2:
            {
                //Call DES Encryption Method here
                //after call back to selection method
                //desEncrypt(new FileInputStream(verifiedPath));
                
                //create instance of des
                String fileContent = "";
                desEncryption des = new desEncryption(fileContent);
                
                //encryption here
                des.DESEncrypt(new FileInputStream(verifiedPath), new FileOutputStream(desFileCreator()));
                
                //enter new file path here
                String verifiedPathDec = "";
                String filePathDec;
                boolean validPathDec = false;
                File fileDec;
        
                System.out.println(getFilePath);
                Scanner enteredPathDec = new Scanner(System.in);
                filePathDec = enteredPathDec.nextLine();
        
                /*
                while loop will loop until the path entered by the user comes back
                as a file that actually exists on the users computer
                */
                while(!validPathDec)
                {
                    try
                    {
                        fileDec = new File(filePathDec);
                        if(fileDec.exists())
                        {
                            System.out.println("File Found at: " + fileDec.getPath());
                            validPathDec = true;
                            verifiedPathDec = fileDec.getPath();
                        }
                        else
                        {
                            throw new fileNotFound();
                        }
                    }
            
                /*
                catching this error allows for the while loop to let the user
                enter in more paths to have more chances without closing and
                reopening the program
                */
                    catch(fileNotFound e)
                    {
                        System.out.println(e.getMessage());
                        Scanner retryPath = new Scanner(System.in);
                        filePathDec = retryPath.nextLine();
                    }
                }
                
                //decryption with new file path
                des.DESDecrypt(new FileInputStream(verifiedPathDec), new FileOutputStream(desFileCreatorDec()));
                
                selection();
                break;
            }
            case 3:
            {
                //Call Triple DES Encryption Method here
                //after call back to selection method
                break;
            }
        }
    }
    
    public static void decrypt()
            throws FileNotFoundException, UnsupportedEncodingException, IOException
    {
        //user selects file and it is checked to make sure it exists
        
        String verifiedPath = "";
        String filePath;
        boolean validPath = false;
        File file;
        
        String getFilePath = "Please enter the file path for the file "
                + "you wish to decrypt:";
        System.out.println(getFilePath);
        Scanner enteredPath = new Scanner(System.in);
        filePath = enteredPath.nextLine();
        
        /*
        while loop will loop until the path entered by the user comes back
        as a file that actually exists on the users computer
        */
        while(!validPath)
        {
            try
            {
                file = new File(filePath);
                if(file.exists())
                {
                    System.out.println("File Found at: " + file.getPath());
                    validPath = true;
                    verifiedPath = file.getPath();
                }
                else{
                    throw new fileNotFound();
                }
            }
            
            /*
            catching this error allows for the while loop to let the user
            enter in more paths to have more chances without closing and
            reopening the program
            */
            catch(fileNotFound e)
            {
                System.out.println(e.getMessage());
                Scanner retryPath = new Scanner(System.in);
                filePath = retryPath.nextLine();
            }
        }
        String extractedContents = bufferedReader(verifiedPath);
        
        
        
        //Main start section where the user selects the method of encryption
        Scanner methodChoice = new Scanner(System.in);
        String selectMethod = "Please enter the number of the decryption method "
                + "you would like to use down below:";
        String method1 = "1) Caesarean";
        String method2 = "2) DES";
        String method3 = "3) Triple DES";
        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        
        System.out.println(selectMethod);
        
        System.out.println();
        System.out.println();
        System.out.println(method1);
        System.out.println(method2);
        System.out.println(method3);
        
        switch(methodChoice.nextInt())
        {
            case 1:
            {
                caesarDec(extractedContents);
                selection();
                break;
            }
//            case 2:
//            {
//                desDecrypt(new FileInputStream(verifiedPath));
//                selection();
//                break;
//            }
//            case 3:
//            {
//                //Call Triple DES Decryption Method here
//                //after call back to selection method
//                break;
//            }
        }
    }
    
    public static void caesarEnc(String fileContent) 
            throws FileNotFoundException, UnsupportedEncodingException
    {
        int shift;
        Scanner shiftKey = new Scanner(System.in);
        String encryptedText = "";
        CaesareanEncryption caeEnc = new CaesareanEncryption();
        
        System.out.print("Please enter a value (1 - 26) for the shift key "
                + "for the Caesarean cipher:");
        shift = shiftKey.nextInt();
        
        encryptedText = 
                caeEnc.caesareanEncryption(fileContent, shift);
        
        System.out.println(encryptedText);
        
        // 08/20 fixed caesarean encryption issues
        
        //Create a new folder
        //Creates a new folder if the previous one is already created
        //limitation to 100 files
        boolean Real = false;
        String dirPath = "";
        File dir = new File("C:\\Users\\Trevor\\Desktop\\SPTests");
        dir.mkdir();
        while(!Real)
        {
           if(dir.exists())
            {
                System.out.println("Folder already exists.");
                for(int iter = 1; iter < 100; iter++)
                {
                    System.out.println("Added one to the iterator.");
                    dir = new File("C:\\Users\\Trevor\\Desktop\\SPTests\\CaesarEncryption"+iter);
                    if(!dir.exists())
                    {
                        dir.mkdir();
                        dirPath = dir.toString();
                        System.out.println("Put dir path into a string.");
                        Real = true;
                        System.out.println("Set real to true.");
                        
                        //Print out to a new file below
                        Date date = new Date();
                        long time = date.getTime();
                        Timestamp ts = new Timestamp(time);
                        PrintWriter encryptedOut;
                        File encrypted = new 
                            File(dirPath+"\\caesarEncrypted.txt");
        
                        encryptedOut = new PrintWriter(encrypted, "UTF-8");
                        encryptedOut.println(encryptedText);
                        encryptedOut.println();
                        encryptedOut.println();
                        encryptedOut.println(ts);
                        encryptedOut.close();
                        
                        break;
                    }
                    System.out.println("Start New Cycle.");
                }  
            }
            else
            {
                System.out.println("Folder now exists.");
                
                //Print out to a new file below
                Date date = new Date();
                long time = date.getTime();
                Timestamp ts = new Timestamp(time);
                PrintWriter encryptedOut;
                String fullPath = "caesarEncrypted.txt";
        
                encryptedOut = new PrintWriter(fullPath, "UTF-8");
                encryptedOut.println(encryptedText);
                encryptedOut.println();
                encryptedOut.println();
                encryptedOut.println(ts);
                encryptedOut.close();
                
                Real = true;
            } 
        }
        System.out.println("Made it out.");
        
//        //Print out to a new file below
//        Date date = new Date();
//        long time = date.getTime();
//        Timestamp ts = new Timestamp(time);
//        PrintWriter encryptedOut;
//        String fullPath = "caesarEncrypted.txt";
//        
//        encryptedOut = new PrintWriter(fullPath, "UTF-8");
//        encryptedOut.println(encryptedText);
//        encryptedOut.println();
//        encryptedOut.println();
//        encryptedOut.println("Created on: " + ts);
//        encryptedOut.close();
    }
    
    public static void caesarDec(String fileContent)
            throws FileNotFoundException, UnsupportedEncodingException
    {
        int shift;
        Scanner shiftKey = new Scanner(System.in);
        String decryptedText = "";
        CaesareanEncryption caeDec = new CaesareanEncryption();
        
        System.out.print("Please enter the value you used for the shift key "
                + "for the Caesarean encryption:");
        shift = shiftKey.nextInt();
        
        decryptedText = 
                caeDec.caesareanDecryption(fileContent, shift);
        
        System.out.println(decryptedText);
        
        //Create a new folder
        //Creates a new folder if the previous one is already created
        //limitation to 100 files
        boolean Real = false;
        String dirPath = "";
        File dir = new File("C:\\Users\\Trevor\\Desktop\\SPTests");
        dir.mkdir();
        while(!Real)
        {
           if(dir.exists())
            {
                System.out.println("Folder already exists.");
                for(int iter = 1; iter < 100; iter++)
                {
                    System.out.println("Added one to the iterator.");
                    dir = new File("C:\\Users\\Trevor\\Desktop\\SPTests\\CaesarDecryption"+iter);
                    if(!dir.exists())
                    {
                        dir.mkdir();
                        dirPath = dir.toString();
                        System.out.println("Put dir path into a string.");
                        Real = true;
                        System.out.println("Set real to true.");
                        
                        //Print out to a new file below
                        Date date = new Date();
                        long time = date.getTime();
                        Timestamp ts = new Timestamp(time);
                        PrintWriter decryptedOut;
                        File encrypted = new 
                            File(dirPath+"\\caesarDecrypted.txt");
        
                        decryptedOut = new PrintWriter(encrypted, "UTF-8");
                        decryptedOut.println(decryptedText);
                        decryptedOut.println();
                        decryptedOut.println();
                        decryptedOut.println(ts);
                        decryptedOut.close();
                        
                        break;
                    }
                    System.out.println("Start New Cycle.");
                }  
            }
            else
            {
                System.out.println("Folder now exists.");
                
                //Print out to a new file below
                Date date = new Date();
                long time = date.getTime();
                Timestamp ts = new Timestamp(time);
                PrintWriter decryptedOut;
                String fullPath = "caesarDecrypted.txt";
        
                decryptedOut = new PrintWriter(fullPath, "UTF-8");
                decryptedOut.println(decryptedText);
                decryptedOut.println();
                decryptedOut.println();
                decryptedOut.println(ts);
                decryptedOut.close();
                
                Real = true;
            } 
        }
        System.out.println("Made it out.");
    }
    
    //1st attempt at a complete cycle for DES Encryption and Decryption
//    public static void desEncrypt(FileInputStream vPath)
//            throws FileNotFoundException, IOException
//    {
//        String fileContent = "";
//        desEncryption des = new desEncryption(fileContent);
//        
//        des.DESEncrypt(vPath, new FileOutputStream(desFileCreator()));
//    }
//    
//    public static void desDecrypt(FileInputStream vPath)
//            throws FileNotFoundException, IOException
//    {
//        String fileContent = "";
//        desEncryption des = new desEncryption(fileContent);
//        
//        des.DESDecrypt(vPath, new FileOutputStream(desFileCreator()));
//    }
    
    public static String bufferedReader(String fileP){
        StringBuilder fileContent = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileP))){
            String currLine;
            while((currLine = reader.readLine()) != null){
                fileContent.append(currLine).append("\n");
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return fileContent.toString();
    }
}

