package my_examples;

import java.util.Collections;

/**
 * Created by root on 14.12.15.
 */
public class Pusir
{
    public static void main(String[] args)
    {
       String[] strings = {"киев", "нью-Йорк", "амстердам", "вена", "мельбурн"};
        int[] ar = {1,8,3,7,5,2,4,6};
        ar = insertSort(ar);
        for (int i = 0; i < ar.length; i++)
        {
            System.out.print(ar[i] + " ");
        }

        



    }

    public static int[] insertSort(int[] array){
        int[] ar = array;
        for (int i = 1; i < ar.length; i++)
        {
            int currentElement = ar[i];
            int prevIndex = i - 1;
                while (prevIndex >= 0 && ar[prevIndex] > currentElement){
                    ar[prevIndex + 1] = ar[prevIndex];
                    ar[prevIndex] = currentElement;
                    prevIndex--;
                }

        }
        return ar;
    }

    public static int[] intSotr(int[] array){
        int[] ar = array;
        for (int i = 0; i < ar.length; i++)
        {
            for (int j = 0; j < ar.length-i-1; j++)
            {
                if (ar[j]>ar[j+1]){
                    int t = ar[j];
                    ar[j] = ar[j+1];
                    ar[j+1] = t;
                }
            }
        }
        return ar;
    }

    public static char[] charSort(char[] array){
        char[] ar = array;
        for (int i = 0; i < ar.length; i++)
        {
            for (int j = 0; j < ar.length-i-1; j++)
            {
                if (ar[j]>ar[j+1]){
                    char ch = ar[j];
                    ar[j] = ar[j+1];
                    ar[j+1] = ch;
                }
            }
        }
        return ar;
    }


}
