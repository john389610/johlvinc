

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author john vincent
 * Assignment 4
 * c202
 */
public class Assignment4 {
private MyLinkedList[] dictionary;
private long found;
private long notFound; 
private long compsFound;
private long compsNotFound;

    public Assignment4(){
    dictionary=new MyLinkedList[26];
    found=0;
    notFound=0;
    compsFound=0;
    compsNotFound=0;
    
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Assignment4 one=new Assignment4();
        for (int i = 0; i < 26; i++) {
            
        if (one.dictionary[i] == null) {
        one.dictionary[i] = new MyLinkedList<String>();
        }
        }
        one.populateDictionary("random_dictionary.txt");
        one.spellCheck("oliver.txt");
        System.out.println("Found: "+one.found);
        System.out.println("Not Found: "+one.notFound);
        System.out.printf("Average comparisons for word found: %.2f",(one.compsFound/(double)one.found));
        System.out.printf("\nAverage comparisons for word not found: %.2f",(one.compsNotFound/(double)one.notFound),"\n");
       }//main
 
    /**
     *
     * @param fName
     * populates dictionary an array of myLinkedList with strings from file fName
     */

        public void populateDictionary(String fName){
        File f=new File(fName);
        try{
            Scanner input = new Scanner(f);
           
            while (input.hasNext()){
                   String word = input.next();
                  word=word.toLowerCase();
                  this.dictionary[word.charAt(0)-97].add(word);
            }//while file
            
            input.close();
        }catch(IOException e){
            System.out.println("file reading failed");
        }//catch
        }//populateDictionary
        
    /**
     *
     * @param fName
     * compares words in file fName to words saved in 
     * dictionary array an array of myLinkedList
     * and updates counters:found,notFound,compsFound,compsNotFound=0;
     */
    public void spellCheck(String fName){
        int[] count=new int[1];
        File f=new File(fName);
        try{
            Scanner input = new Scanner(f);
            
            while (input.hasNext()){
                String rLine=input.nextLine();
                rLine=rLine.replaceAll("[^A-Za-z' ]", "");
                rLine=rLine.toLowerCase();
                Scanner line = new Scanner(rLine);
                
        while (line.hasNext()) {
            String word = line.next();          
                  count[0]=0;
                  //System.out.println(": "+word+":");
                  if(!word.isEmpty()){
                  if(word.charAt(0)>96 &&word.charAt(0)<123){
                  if(this.dictionary[word.charAt(0)-97].contains(count,word)){
                   found++;                        
                   compsFound+=count[0];
                  } else {notFound++;compsNotFound+=count[0];}
                  }}
        }//while line
            }//while file
            input.close();
        }catch(IOException e){
            System.out.println("file reading failed");
        }//catch
        }//spellCheck
        
}//class
