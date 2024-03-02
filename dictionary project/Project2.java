/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project2;

/**
 *
 * @author SILA
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Project2 {

 public static void main(String[] args)  {
         HashMap<String,String> dictionary = new HashMap<>();
       
        
       while(true){
        int opt;
           System.out.println("❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀❀");
        System.out.println("Welcome the dictionary !");
        System.out.println("1 - Load a dictionary");
        System.out.println("2 - Print the dictionary");
        System.out.println("3 - Search for an entry in this dictionary");
        System.out.println("4 - Insert a word to the dictionary");
        System.out.println("5 - Delete a word from the dictionary in constant time");
        System.out.println("6 - Given a random text file, do a spell check in linear time ");
        System.out.println("7 - Exit");
        Scanner option = new Scanner (System.in);
        opt=option.nextInt();
        if(opt==1){
        
       try{
           String filePath = "C:/Users/SILA/OneDrive - isik.edu.tr/Masaüstü/dict.txt";
       
           Scanner s = new Scanner (new File (filePath));
           
           while (s.hasNext()){
               String word=s.next();
               dictionary.put(word,word);
               
           }
           s.close();
       }
       catch (FileNotFoundException e){
           System.out.println("File can not found!");
       }
            System.out.println("Loaded!!");
            continue;
        }
        else if(opt==2){
           dictionary.printDictionary();
                continue;
        }
           
        
        else if(opt==3){
            System.out.println("Enter the word you want to search : ...");
      Scanner searchScanner = new Scanner(System.in);
      String userWord= searchScanner.next();
       if (dictionary.containsKey(userWord)){
     System.out.println("Word found : " + userWord);
         }
        else{
     System.out.println("Word can not found !!!");
   }
       continue;
        }
        else if (opt==4){
            System.out.println("Enter the word you want to add: ...");
            Scanner insert = new Scanner(System.in);
            String ins=insert.next();
            if (dictionary.containsKey(ins)){
     System.out.println("This word already in the dictionary");
         }
        else{
       dictionary.put(ins, ins);
                System.out.println("Word added to dictionary!");
   }
          continue;
        }
        else if (opt==5){
            System.out.println("Enter the word you want to delete: ...");
            Scanner delete = new Scanner(System.in);
            String del=delete.next();
            if (dictionary.containsKey(del)){
     dictionary.remove(del);
                System.out.println("Word deleted from dictionary!");
         }
        else{
                System.out.println("This word is not in the diictionary");
   }
          continue;
        }
    else if (opt==6) {
    
    String userFilePath = "C:/Users/SILA/OneDrive - isik.edu.tr/Masaüstü/dict - Kopya.txt";
   File usersFile = new File(userFilePath);
      if (!usersFile.exists()) {
    System.out.println("File does not exist!");
      }
     try{
         Scanner  userTxtScanner= new Scanner (usersFile);
         while(userTxtScanner.hasNext()){
             String w = userTxtScanner.next();
             if(!dictionary.containsKey(w)){
                 System.out.println("error word : " + w);
             }
         }
     }
         catch(FileNotFoundException e){
                 System.out.println("reading file error!!!");
                 }
    continue;
     
  }
    else if (opt==7){
            System.out.println("Bye bye (◕‿◕)");
            break;
        }
        else{
            System.out.println("Unvalid option!");
            continue;
        }
       
        
}
    }
}