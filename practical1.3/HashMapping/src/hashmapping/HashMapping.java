/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashmapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author vivek
 */
public class HashMapping {

    HashMap<String,Long>contactList=new HashMap<String,Long>();
    public static void main(String[] args) {
       Scanner scan=new Scanner(System.in);
       HashMapping hm=new HashMapping();
       char ch='n';
       int op=0;
       
       while(ch=='n')
       {
           System.out.println("");
           System.out.println("1.Add Contact \n2.Search Key \n3.Search Value \n4.List \n5.Exit");
            op=scan.nextInt();
           switch(op)
           {
               case 1:
                       System.out.print("Enter name:");
                       String name=scan.next();
                       System.out.print("Enter phone:");
                       long phone=scan.nextLong();
                       hm.addContact(name, phone);
                       System.out.println("contact added!");
                   break;
               case 2:
                        System.out.print("Enter key to be searched:");
                        String key=scan.next();
                        if(hm.searchKey(key))
                            System.out.println("key is present");
                        else
                            System.out.println("key is not present");
                   break;
               case 3:
                            System.out.print("Enter value to be searched:");
                              long value=scan.nextLong();
                            if(hm.searchValue(value))
                                System.out.println("value is present");
                            else
                                System.out.println("value is not present");
                   break;
               case 4: 
                        System.out.println("Contact List");
                        hm.list();
                   break;
               case 5:  ch='y';
                   break;
               default:
                   System.out.println("choose from above options");
           }
       }
       
    }
    
    //adding contact
    public void addContact(String name,Long phone)
    {
        contactList.put(name, phone);
    }
    
    //searching key
    public boolean searchKey(String key)
    {
        boolean flag=false;
        if(contactList.get(key)!=null)
            flag=true;
        
        return flag;
    }
    
    //searching value
    public boolean searchValue(Long value)
    {
         boolean flag=false;
        List<Long> values = new ArrayList<>(contactList.values());
        for(int i=0;i<values.size();i++)
        {
            
            if(Objects.equals(values.get(i), value))
            {
                flag=true;
                break;
            }
        }
        
        return flag;
    }
    
    //all key-value pairs
     public void list()
    {
        for(Map.Entry m:contactList.entrySet()){    
           System.out.println(m.getKey()+" "+m.getValue());    
          }  
    }
}
