package controller;

import sun.jvm.hotspot.bugspot.Main;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class test
{


    public static int docanArrange(String arr[],char before)
    {
        int x=0;
        int max=x;
        if(before == ' ')
        {


            for (int i=0 ;i< arr.length ;i ++)
            {
                x=1;
                String [] arrt =new String[arr.length-1];
                String temp= arr[0];
                arr[0]=arr[i];
                arr[i]= temp;
                System.arraycopy(arr,1,arrt,0,arrt.length);

                x+= docanArrange(arrt,arr[0].toCharArray()[arr[0].toCharArray().length]);
                if(x>max)
                    max=x;

            }

        }
        else{
            for (int i=0 ;i< arr.length ;i ++)
            {
                if(arr[0].toCharArray()[0]==(before)){
                    if(arr.length ==1)
                        return 1;
                    x=1;
                    String [] arrt =new String[arr.length-1];
                    String temp= arr[0];
                    arr[0]=arr[i];
                    arr[i]= temp;
                    System.arraycopy(arr,1,arrt,0,arrt.length);

                    x+= docanArrange(arrt,arr[0].toCharArray()[arr[0].toCharArray().length]);
                    if(x>max)
                        max=x;


                }
            }


        }
        return x;
    }
    //METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int canArrangeWords(String arr[])
    {
        // INSERT YOUR CODE HERE

        return arr.length == docanArrange(arr,' ')?1:-1;

    }
// METHOD SIGNATURE ENDS
    public static  void Main(String[] argvs)
    {
        String [] test={"ab","bc","cd","df"};
        System.out.print(canArrangeWords(test));
    }

// DO NOT IMPLEMENT THE main( ) METHOD
}