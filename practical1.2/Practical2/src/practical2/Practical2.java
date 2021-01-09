/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical2;

import java.util.Scanner;

/**
 *
 * @author vivek
 */
public class Practical2{

public static void main(String[] args) {
Scanner s = new Scanner(System.in);
System.out.print("Enter no. of elements in array:"); 
int n = s.nextInt();
int a[] = new int[n]; 
System.out.println("Enter the elements:"); 
for(int i = 0; i < n; i++)
{
a[i] = s.nextInt();

}


int sum = 0,gap=0;
for(int i=0;i<a.length;i++)
{ 
    if(a[i]==6)
    {
        for(int j=a.length-1;j>=i;j--)
            { 
                 if(a[j]==7)
                  break;
                  gap+= a[j];
            }
       break;
    }
    sum=sum+a[i];
}
System.out.println(gap+sum);
}
}

