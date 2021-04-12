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
import java.lang.reflect.Array;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import static seniorProject.desEncryption.desFileCreator;
import static seniorProject.desEncryption.desFileCreatorDec;

/**
 *
 * @author Trevor
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.io.UnsupportedEncodingException
     * @throws java.security.NoSuchAlgorithmException
     * @throws java.security.spec.InvalidKeySpecException
     * @throws javax.crypto.NoSuchPaddingException
     * @throws java.security.InvalidKeyException
     * @throws java.security.InvalidAlgorithmParameterException
     * @throws javax.crypto.IllegalBlockSizeException
     * @throws javax.crypto.BadPaddingException
     */
    public static void main(String[] args) 
            throws FileNotFoundException, UnsupportedEncodingException, 
            IOException, NoSuchAlgorithmException, InvalidKeySpecException, 
            NoSuchPaddingException, InvalidKeyException, 
            InvalidAlgorithmParameterException, IllegalBlockSizeException, 
            BadPaddingException
            
    {
        start();
//-----------------------------------------------------------------------------        
//-----------------------------------------------------------------------------
        //testing that the encryption works with pre-set data before 
        //implementing with input requests and file creation
        //Confirmed successful encryption 03/10/21
//
//        aes256Encryption test = new aes256Encryption();
//        
//        String testContents = "test file";
//        String key = "test Key";
//        String salt = "asdfghjkl";
//        
//        System.out.println("Starting encryption now");
//        
//        String enc = test.aesEncrypt(testContents, key, salt);
//        
//        System.out.println("Encryption finished");
//        System.out.println(enc);
//        
//-----------------------------------------------------------------------------        
//-----------------------------------------------------------------------------

        //Testing the creation of the IV Array for AES 256 Encryption
        //Confirmed sucessful key generation 03/10/21
//        
//        aes256Encryption test = new aes256Encryption();
//        
//        System.out.println("Generating IV now.");
//        
//        byte IV[] = test.genIV();
//        
//        System.out.println("IV Generated.");
//        
//        System.out.println(Arrays.toString(IV));
//        
//-----------------------------------------------------------------------------        
//-----------------------------------------------------------------------------

        //Testing the creation of the key for AES256 Encryption
        //Confirmed successful key generation 03/10/21
//        
//        System.out.println("Generating key now please wait.");
//        
//        aes256Encryption test = new aes256Encryption();
//        
//        String prt = test.genSecretKey("test key", "asdfhjkl").toString();
//
//        System.out.println("The reference to your generated key is: " + prt);
//        
//        System.out.println("Key Generated.");
//        
//-----------------------------------------------------------------------------        
//-----------------------------------------------------------------------------
        
        //Creates a new folder if the previous one is already created
        //limitation to 100 files
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

//-----------------------------------------------------------------------------        
//-----------------------------------------------------------------------------
    }
    
    public static void start()
            throws FileNotFoundException, UnsupportedEncodingException, 
            IOException, NoSuchAlgorithmException, NoSuchPaddingException, 
            InvalidKeySpecException, InvalidKeyException, 
            InvalidAlgorithmParameterException, IllegalBlockSizeException, 
            BadPaddingException
    {        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        
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
            throws FileNotFoundException, UnsupportedEncodingException, 
            IOException, NoSuchAlgorithmException, NoSuchPaddingException, 
            InvalidKeySpecException, InvalidKeyException, 
            InvalidAlgorithmParameterException, IllegalBlockSizeException, 
            BadPaddingException
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
            throws FileNotFoundException, UnsupportedEncodingException, 
            IOException, NoSuchAlgorithmException, NoSuchPaddingException, 
            InvalidKeySpecException, InvalidKeyException, 
            InvalidAlgorithmParameterException, IllegalBlockSizeException, 
            BadPaddingException
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
        String method3 = "3) AES256";
        
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
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                
                //warning that DES will encrypt and decrypt at the same time
                String banner1des = "====================================================";
                String banner2des = "----------------------------------------------------";
                String banner3des = "------- This method will encrypt and decrypt -------";
                String banner4des = "------- at the same time if you are ok with  -------";
                String banner5des = "------- this please press enter to continue. -------";
                String banner6des = "---------- Otherwise restart the program. ----------";
                System.out.println(banner1des);
                System.out.println(banner1des);
                System.out.println(banner1des);
                System.out.println(banner2des);
                System.out.println(banner2des);
                System.out.println(banner3des);
                System.out.println(banner4des);
                System.out.println(banner5des);
                System.out.println(banner6des);
                System.out.println(banner2des);
                System.out.println(banner2des);
                System.out.println(banner1des);
                System.out.println(banner1des);
                System.out.println(banner1des);
                
                Scanner desAcknowledgment = new Scanner(System.in);
                desAcknowledgment.nextLine();
                
                //Call DES Encryption Method here
                //after call back to selection method
                //desEncrypt(new FileInputStream(verifiedPath));
                
                //create instance of des
                String fileContent = "";
                desEncryption des = new desEncryption(fileContent);
                
                //encryption here
                des.DESEncrypt(new FileInputStream(verifiedPath), 
                        new FileOutputStream(desFileCreator()));
                
                
                System.out.println("Starting Decryption Now.");
                
                
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
                            System.out.println
                                ("File Found at: " + fileDec.getPath());
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
                des.DESDecrypt(new FileInputStream(verifiedPathDec), 
                        new FileOutputStream(desFileCreatorDec()));
                
                selection();
                break;
            }
            case 3:
            {               
                //warning that AES256 will encrypt and decrypt at the same time
                String banner1aes = "====================================================";
                String banner2aes = "----------------------------------------------------";
                String banner3aes = "------- This method will encrypt and decrypt -------";
                String banner4aes = "------- at the same time if you are ok with  -------";
                String banner5aes = "------- this please press enter to continue. -------";
                String banner6aes = "---------- Otherwise restart the program. ----------";
                System.out.println(banner1aes);
                System.out.println(banner1aes);
                System.out.println(banner1aes);
                System.out.println(banner2aes);
                System.out.println(banner2aes);
                System.out.println(banner3aes);
                System.out.println(banner4aes);
                System.out.println(banner5aes);
                System.out.println(banner6aes);
                System.out.println(banner2aes);
                System.out.println(banner2aes);
                System.out.println(banner1aes);
                System.out.println(banner1aes);
                System.out.println(banner1aes);
                
                Scanner aesAcknowledgment = new Scanner(System.in);
                aesAcknowledgment.nextLine();
                
                //global declaration of aes256 class
                aes256Encryption aes = new aes256Encryption();
                
                //create IV for one instance
                byte[] aesIVTemp = aes.genIV();
                IvParameterSpec aesIV = new IvParameterSpec(aesIVTemp);

                //Call AES256 Encryption method here
                //aesEnc(extractedContents);
                //get key from user
                System.out.print("Please enter a phrase to be your key: ");
                Scanner sKeyScanner = new Scanner(System.in);
                String userKey = sKeyScanner.nextLine();
                
                //get salt from user
                System.out.print("Please enter a phrase to be your salt: ");
                Scanner saltScanner = new Scanner(System.in);
                String userSalt = saltScanner.nextLine();
                
                SecretKeySpec sKey = aes.genSecretKey(userKey, userSalt);
        
                String aesEnc = aes.aesEncrypt(extractedContents, sKey, aesIV);
                
                aesEncFileCreator(aesEnc);
                
                System.out.println("========================================");
                System.out.println("========================================");
                
                //Call for encrypted file here
                String verifiedPathAESDec = "";
                String filePathAESDec;
                boolean validPathAESDec = false;
                File fileAESDec;
                
                String getFilePathAESDec = "Please enter the file path for the"
                        + " file you wish to decrypt:";
                System.out.println(getFilePathAESDec);
                Scanner enteredPathAESDec = new Scanner(System.in);
                filePathAESDec = enteredPathAESDec.nextLine();
                
                /*
                while loop will loop until the path entered by the user comes 
                back as a valid file
                */
                while(!validPathAESDec)
                {
                    try
                    {
                        fileAESDec = new File(filePathAESDec);
                        if(fileAESDec.exists())
                        {
                            System.out.println("File Found at: " 
                                    + fileAESDec.getPath());
                            validPathAESDec = true;
                            verifiedPathAESDec = fileAESDec.getPath();
                        }
                        else
                        {
                            throw new fileNotFound();
                        }
                    }
                    catch(fileNotFound e)
                    {
                        System.out.println(e.getMessage());
                        Scanner retryPathAESDec = new Scanner(System.in);
                        filePathAESDec = retryPathAESDec.nextLine();
                    }
                }
                
                String extractedContentsAESDec = bufferedReader(verifiedPath);
                
                String cutContents = extractedContentsAESDec.replaceAll(" ","");
                String cut2 = cutContents.replaceAll("\\R","");
               
                //Call AES256 Decryption method here
                //aesDec(extractedContents);
                //get key from user
        
                System.out.print("Please enter your key from encrypting: ");
                Scanner sKeyScannerDec = new Scanner(System.in);
                String userKeyDec = sKeyScannerDec.nextLine();
                
                //get salt from user
                System.out.print("Please enter your salt from encrypting: ");
                Scanner saltScannerDec = new Scanner(System.in);
                String userSaltDec = saltScannerDec.nextLine();

                //verifies users key and salt since sending them would create
                //a new secret key
                if(passVerif(userKey, userSalt, userKeyDec, userSaltDec) == true)
                {
                    String aesDec = aes.aesDecrypt(cut2, sKey, aesIV);
                    
                    aesDecFileCreator(aesDec);
                }
                //after call back to selection method
                selection();
                break;
            }
        }
    }
    
    public static void decrypt()
            throws FileNotFoundException, UnsupportedEncodingException, 
            IOException, NoSuchAlgorithmException, NoSuchPaddingException, 
            InvalidKeySpecException, InvalidKeyException, 
            InvalidAlgorithmParameterException, IllegalBlockSizeException, 
            BadPaddingException
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
        String method3 = "3) AES256";
        
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
// 1st attempt at creating a multiuse separated encryption and 
//decryption for DES and AES256 didnt work as intended
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
    
    public static void aesEncFileCreator(String encContents) 
            throws  FileNotFoundException, UnsupportedEncodingException
    {
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
                    dir = new File("C:\\Users\\Trevor\\Desktop\\SPTests\\AES256Encryption"+iter);
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
                            File(dirPath+"\\AES256Encrypted.txt");
        
                        encryptedOut = new PrintWriter(encrypted, "UTF-8");
                        encryptedOut.println(encContents);
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
                String fullPath = "AES256Encrypted.txt";
        
                encryptedOut = new PrintWriter(fullPath, "UTF-8");
                encryptedOut.println(encContents);
                encryptedOut.println();
                encryptedOut.println();
                encryptedOut.println(ts);
                encryptedOut.close();
                
                Real = true;
            } 
        }
    }
    
    public static void aesDecFileCreator(String decContents) 
            throws FileNotFoundException, UnsupportedEncodingException
    {
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
                    dir = new File("C:\\Users\\Trevor\\Desktop\\SPTests\\AES256Decryption"+iter);
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
                            File(dirPath+"\\AES256Decrypted.txt");
        
                        encryptedOut = new PrintWriter(encrypted, "UTF-8");
                        encryptedOut.println(decContents);
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
                String fullPath = "AES256Decrypted.txt";
        
                encryptedOut = new PrintWriter(fullPath, "UTF-8");
                encryptedOut.println(decContents);
                encryptedOut.println();
                encryptedOut.println();
                encryptedOut.println(ts);
                encryptedOut.close();
                
                Real = true;
            } 
        }
    }
    
    public static boolean passVerif(String baseKey, String baseSalt, String guessedKey, String guessedSalt)
    {
        boolean retVal = false;
        
        if(guessedKey.equals(baseKey))
        {
            System.out.println("----- Checking Key Now -----");
            System.out.println();
            try
            {
                TimeUnit.SECONDS.sleep(15);
            }
            catch(InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
            String str = "       Key is correct";
            System.out.println(str);
            System.out.println();
            
            //this will only check the salt if the key is the same
            if(guessedSalt.equals(baseSalt)) 
            {
                System.out.println("----- Checking Salt Now -----");
                System.out.println();
                try
                {
                    TimeUnit.SECONDS.sleep(8);
                }
                catch(InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                }
                String str1 = "       Salt is correct";
                System.out.println(str1);
                System.out.println();
                
                retVal = true;
            }
        }
        else
        {
            System.out.println("----- Checking Key Now -----");
            System.out.println();
            try
            {
                TimeUnit.SECONDS.sleep(5);
            }
            catch(InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
            
            System.out.println("----- Checking Salt Now -----");
            System.out.println();
            try
            {
                TimeUnit.SECONDS.sleep(5);
            }
            catch(InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
            retVal = false;
        }
        return retVal;
    }
    
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

