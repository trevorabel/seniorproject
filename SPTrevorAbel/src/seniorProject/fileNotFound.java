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
public class fileNotFound extends java.lang.Exception{
   fileNotFound(){
       super("File Error: Invalid File Location \n Please enter a valid file location.");
   }   
}
