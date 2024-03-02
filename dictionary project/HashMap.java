/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class HashNode{
    String key;
    String value;
    HashNode next;
    
    HashNode(String key, String value){
        this.key= key;
        this.value=value;
        this.next=null;
    }
}
public class HashMap<K,V>{
    int size = 2000000;
    Object[] array;
    
    HashMap( ){
        array = new Object[size];
    }
    public int hashFunction(String key){
        int hash=0 ;
        for (char c : key.toCharArray()){
            hash+=c;
        }
        return hash%size;
    }
    public void put(String key,String value){
        int index = hashFunction(key);
        if(array[index]==null){
                array[index]=new HashNode(key,value);
        }
        else{
            HashNode currentNode= (HashNode) array[index];
            while(currentNode.next!=null){
                currentNode=currentNode.next;
            }
            currentNode.next= new HashNode(key,value);
        }
    }
    public Object get(String key){
        int index = hashFunction(key);
        HashNode currentNode = (HashNode) array [index];
        while ( currentNode.next!=null){
            if(currentNode.key.equals(key)){
                return currentNode.value;
            }
            currentNode=currentNode.next;
        }
        return null;
    }
        public void remove(String key) {
        int index = hashFunction(key);
        HashNode currentNode = (HashNode) array[index];
        HashNode prevNode = null;

        while (currentNode != null && !currentNode.key.equals(key)) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode != null) {
            if (prevNode == null) {
                array[index] = currentNode.next;
            } else {
                prevNode.next = currentNode.next;
            }
        }
    }
         public void printDictionary() {
        for (int i = 0; i < array.length; i++) {
            HashNode currentNode = (HashNode) array[i];
            while (currentNode != null) {
                System.out.println("key : " + currentNode.key + " value : " + currentNode.value);
                currentNode = currentNode.next;
            }
        }
      }
public boolean containsKey(String key) {
    int index = hashFunction(key);
    HashNode currentNode = (HashNode) array[index];

    while (currentNode != null) {
        if (currentNode.key.equals(key)) {
            return true; 
        }
        currentNode = currentNode.next;
    }

    return false;
}

}

