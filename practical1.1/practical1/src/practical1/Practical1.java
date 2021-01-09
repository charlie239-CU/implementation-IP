/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical1;

import java.util.Scanner;

/**
 *
 * @author vivek
 */
public class Practical1 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        boolean flag=false;
        System.out.println("enter the number of students");
        int size=scan.nextInt(),i; //taking number of students
        int id[]=new int[size];     //initializing array id of int type
        String name[]=new String[size];    //initializing array name of String type
        double score[]=new double[size];    //initializing array score of double type
        System.out.println("enter the id of the student");
        for(i=0;i<size;i++)
        {
            System.out.print("Student "+(i+1)+":");
            id[i]=scan.nextInt();           //inserting id to array
        }
        System.out.println("enter the name of the student");
        for(i=0;i<size;i++)
        {
            System.out.print("Student "+(i+1)+":");
            name[i]=scan.next();             //inserting name  to array
        }
        System.out.println("enter the score of the student");
        for(i=0;i<size;i++)
        {
            System.out.print("Student "+(i+1)+":");
            score[i]=scan.nextDouble();          //inserting id to array
        }
        System.out.println("enter the id to search");
        int search=scan.nextInt();              //search value
        
        for(i=0;i<size;i++)
        {
            if(search==id[i])                //if id found
            {
                System.out.println("====================");
                System.out.println("index:"+i);
                System.out.println("student id:"+search);
                System.out.println("student name:"+name[i]);
                System.out.println("student score:"+score[i]);
                flag=true;
            }
        }
        if(!flag)                           //if id not found
        {
           System.out.println("-1");
            System.out.println("student not found");
        }
      }
}

