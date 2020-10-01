/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seniorProject;

/**
 *
 * @author Trevor
 */
public class CaesareanEncryption {
 
    //this is the variable that represents the shift value the user chose 
    int shiftKey;
    //this is the variable that sends the text from the chosen file
    private String fileText;
    
    public CaesareanEncryption(){
        
    }
    
    public CaesareanEncryption(String fileContents) {
        fileText = fileContents;
    }
    
    public String cipherDescription(){
        String description;
        
        description = "The Caesarean Cipher was designed by the Roman Emperor"
                + " Caesar to communicate with his troops is battle securely."
                + " This was originally created to keep the contents of Caesar's"
                + " orders secret and secure to be hidden if they were ever"
                + " intercepted. This cipher functions off of a shift key that "
                + " is usually set to 3. The shift key values range from 1 to"
                + " 25 to shift the letters of the alphabet around. Each number"
                + " represents a specific letter that then becomes the first"
                + " letter in a new 'encrypted' alphabet.";
        
        return description;
    }
    
    public String caesareanEncryption(String text, int shift) {
        fileText = text;
        shiftKey = shift;
        String altered = "";
        
        //iterating over a string to create a new cyphered string
        
        for(int i = 0; i < fileText.length(); i++)
        {
            char ch = fileText.charAt(i);
            
            if(ch >= 97 && ch <= 122)
            {
                ch = (char)(ch + shiftKey);
                if(ch < 'a')
                {
                    ch = (char)(ch + 'z' - 'a' + 1);
                }
                altered += ch;
            }
            else if(ch >= 65 && ch <= 90)
            {
                ch = (char)(ch + shiftKey);
                if(ch < 'A')
                {
                    ch = (char)(ch + 'Z' - 'A' + 1);
                }
                altered += ch;
            }
            else
            {
                altered+= ch;
            }
        }
        return altered;
    }
    
    public String caesareanDecryption(String text, int shift) {
        fileText = text;
        shiftKey = shift;
        String decCae ="";
        
        //iterating over a string to create a new cyphered string
        
        for(int i = 0; i < fileText.length(); i++)
        {
            char ch = fileText.charAt(i);
            
            if(ch >= 97 && ch <= 122)
            {
                ch = (char)(ch - shiftKey);
                if(ch < 'a')
                {
                    ch = (char)(ch + 'z' - 'a' - 1);
                }
                decCae += ch;
            }
            else if(ch >= 65 && ch <= 90)
            {
                ch = (char)(ch - shiftKey);
                if(ch < 'A')
                {
                    ch = (char)(ch + 'Z' - 'A' - 1);
                }
                decCae += ch;
            }
            else
            {
                decCae += ch;
            }
        }
        return decCae;
    }

    public int getShiftKey() {
        return shiftKey;
    }

    public void setShiftKey(int shiftKey) {
        this.shiftKey = shiftKey;
    }
}