/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seniorProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Base64;
import java.util.Base64.Decoder;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Trevor
 */
public class desEncryption {
    
    private static Cipher encryptCipher;
    
    private static Cipher decryptCipher;
    
    //This is the string read in from the file.
    private String fileContent;
    
    //This is the selected encryption method.
    private String selectedEnc = "DES";
    
    //This is the specified padding to use.
    private String padding = "DES/ECB/PKCS5Padding";
    
    //The encrypted string in semi-readable text.
    protected String encString;
    
    //The decrypted string in readable text.
    protected String decString;
    
    //Create the cipher which is used to incorporate the padding.
    protected Cipher dCipher;
    
    //The byte array of the encrypted text.
    protected byte[] encText;
    
    //Create the secret key, used for security purposes.
    protected SecretKey sKey;
    
    //Byte array of the decrypted text.
    public byte[] decText;
    
    //Get the string from the file.
    public desEncryption(String fileInput){
        fileContent = fileInput;
    }
    
    //Returns the information about the encryption algorithm.
    public String desEncryption(){
        String description = "The Data Encryption Standard (DES) is a " +
                              "symmetric-key algorithm for the encryption of " +
                              "electronic data. The DES algorithm was " + 
                              "created in the early 1970s at IBM.";
        return description;
    }
    
    //Encrypt the string from the file.
    public void DESEncrypt(InputStream is, OutputStream os) throws IOException{
        //Execute this code, watching for any errors.
        try{
        //Create a KeyGenerator, dependent on the encryption type.    
        KeyGenerator keyGen = KeyGenerator.getInstance(selectedEnc);
        
        //Generate the SecretKey, which is used for encryption.
        sKey = keyGen.generateKey();
          
        //Initialize the cipher and tell the cipher what padding to use.
        encryptCipher = Cipher.getInstance(padding);
        
        //Initialize the cipher for encryption mode, using the secret key.
        encryptCipher.init(Cipher.ENCRYPT_MODE, sKey);
        
        os = new CipherOutputStream(os, encryptCipher);
        writeData(is, os);
    }
    //Catch any of the specified errors, if they occur.
    catch(InvalidKeyException | NoSuchAlgorithmException |
                               NoSuchPaddingException e){
        //Print out the error.
        System.err.println(e);
    }   
   }

    public void DESDecrypt(InputStream is, OutputStream os) throws IOException{        
        try{
         
        decryptCipher = Cipher.getInstance(padding);    
            
         //Initialize decryption
        decryptCipher.init(Cipher.DECRYPT_MODE, sKey);
        
        is = new CipherInputStream(is, decryptCipher);
        writeData(is, os);
        }
        //Catch any errors if they occur.
        catch(InvalidKeyException | NoSuchAlgorithmException | 
                NoSuchPaddingException e){
            //Print out the error.
            System.err.println(e);
        }
    }
    
    private static void writeData(InputStream is, OutputStream os)
                                                    throws IOException{
        byte[] buffer = new byte[1024];
        int numberRead = 0;
        
        while((numberRead = is.read(buffer)) >= 0){
            os.write(buffer, 0, numberRead);
        }
        os.close();
        is.close();
    }
    
    
    public static String desFileCreator(){
        boolean Real = false;
        String newFPath = "";
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
                    dir = new File("C:\\Users\\Trevor\\Desktop\\SPTests\\DESEncryption"+iter);
                    if(!dir.exists())
                    {
                        dir.mkdir();
                        dirPath = dir.toString();
                        System.out.println("Put dir path into a string.");
                        Real = true;
                        System.out.println("Set real to true.");
                        
                        //Print out to a new file below
//                        Date date = new Date();
//                        long time = date.getTime();
//                        Timestamp ts = new Timestamp(time);
                        File encrypted = new 
                            File(dirPath+"\\DESEncrypted.txt");
                        
                        String encryptString = encrypted.toString();
                        return encryptString;
                    }
                    System.out.println("Start New Cycle.");
                }  
            }
            else
            {
                System.out.println("Folder now exists.");
                
                //Print out to a new file below
//                Date date = new Date();
//                long time = date.getTime();
//                Timestamp ts = new Timestamp(time);
                String fullPath = "DESEnrypted.txt";
                
                newFPath = dir+fullPath;
                break;
            } 
        }
        System.out.println("Made it out.");
        return newFPath;
    }       
    
    public static String desFileCreatorDec(){
        boolean Real = false;
        String newFPath = "";
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
                    dir = new File("C:\\Users\\Trevor\\Desktop\\SPTests\\DESDecryption"+iter);
                    if(!dir.exists())
                    {
                        dir.mkdir();
                        dirPath = dir.toString();
                        System.out.println("Put dir path into a string.");
                        Real = true;
                        System.out.println("Set real to true.");
                        
                        //Print out to a new file below
//                        Date date = new Date();
//                        long time = date.getTime();
//                        Timestamp ts = new Timestamp(time);
                        File encrypted = new 
                            File(dirPath+"\\DESDecrypted.txt");
                        
                        String encryptString = encrypted.toString();
                        return encryptString;
                    }
                    System.out.println("Start New Cycle.");
                }  
            }
            else
            {
                System.out.println("Folder now exists.");
                
                //Print out to a new file below
//                Date date = new Date();
//                long time = date.getTime();
//                Timestamp ts = new Timestamp(time);
                String fullPath = "DESDerypted.txt";
                
                newFPath = dir+fullPath;
                break;
            } 
        }
        System.out.println("Made it out.");
        return newFPath;
    }       
}
