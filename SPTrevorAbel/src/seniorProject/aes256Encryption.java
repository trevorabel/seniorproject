/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seniorProject;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import static javax.crypto.Cipher.SECRET_KEY;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author Trevor
 */
public class aes256Encryption {
 
    //global varriables for entire class
    String passedFileContents;    
    //global varriables for encryption here
    
    //global varriables for decryption here
    
    //blank constructor here
    public aes256Encryption()
    {
        
    }
    
    /*method to pass through the string from the chosen text file for 
      encryption and decryption of the file
    */
    public aes256Encryption(String str)
    {
        passedFileContents = str;
    }
    
    //AES256 Encryption here
    public String aesEncrypt(String fileContents, SecretKeySpec genedKey, IvParameterSpec IV) 
            throws NoSuchAlgorithmException, NoSuchPaddingException, 
            InvalidKeySpecException, InvalidKeyException, 
            InvalidAlgorithmParameterException, IllegalBlockSizeException, 
            BadPaddingException
    {
        Cipher AESCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        AESCipher.init(Cipher.ENCRYPT_MODE, genedKey, IV);
        
        String encrypted = Base64.getEncoder().encodeToString(AESCipher.doFinal(fileContents.getBytes(StandardCharsets.UTF_8)));
        
        return encrypted;
    }
    
    //AES256 Decryption here
    public String aesDecrypt(String fileContents, SecretKeySpec genedKey, IvParameterSpec IV)
            throws NoSuchAlgorithmException, NoSuchPaddingException, 
            InvalidKeySpecException, InvalidKeyException, 
            InvalidAlgorithmParameterException, IllegalBlockSizeException, 
            BadPaddingException
    {
        Cipher AESCipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        AESCipher.init(Cipher.DECRYPT_MODE, genedKey, IV);
        
        return new String(AESCipher.doFinal(Base64.getDecoder().decode(fileContents)));
    }
    
    //potentially make method to generate secret key/ salted IV for encryption
    public SecretKeySpec genSecretKey (String key, String salt) 
            throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        /*
            PBKDF2WithHmacSHA256 breaks down as "PBKDF2With" "HmacSHA256"
        
            PBKDF2With is a Password Based Key Derivation algorithm part of
                PKCS v5.2
            HmacSHA256 specifies what algorithm flavor is to be used for the 
                generating of the key for the encryption
        */
        SecretKeyFactory SKey = 
                SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec SKeySpec = 
                new PBEKeySpec(key.toCharArray(), salt.getBytes(), 65536, 256);
        SecretKey halfWay = SKey.generateSecret(SKeySpec);
        SecretKeySpec finalizedKey = 
                new SecretKeySpec(halfWay.getEncoded(), "AES");
        
        return finalizedKey;
    }
    
    //generate the 16-byte IV for AES256 Encryption via Random Num Gen
    public byte[] genIV ()
    {
        byte IVArray[] = new byte [16];
        //using the random number generator generate a 16-byte length int array
        //to be passed for encryption and decryption
        Random ranGen = new Random();
        
        ranGen.nextBytes(IVArray);
        
        //check statement to ensure that the array was filled
        //System.out.println("Added to array");
        
        return IVArray;
    }
}
