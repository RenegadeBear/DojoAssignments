import java.util.ArrayList;

public class Basic19 
{
    // print 1 to 255

    public void print1to255()
    {
        for(int i=1; i<256; i++)
        {
            System.out.println(i);
        }
    }

    // print odds 1 to 255

    public void printOdds1to255()
    {
        for(int i=1; i<256; i++)
        {
            if (i%2 != 0)
            {
                System.out.println(i);
            }
        }
    }

    // print ints and sums 1 to 255

    public void printIntsAndSums1To255()
    {
        int sum = 0;
        for (int i=1; i<256; i++)
        {
            sum += i;
            System.out.println(String.format("int: %d sum: %d", i, sum));
        }
    }

    // iterate and print list

    public void printList(ArrayList<Object> list)
    {
        for (Object item: list)
        {
            System.out.println(item);
        }
        // for (int i=0; i<list.size(); i++)
        // {
        //     System.out.println(list.get(i));
        // }
    }

    // printMax

    public void printMax(ArrayList<Object> list)
    {
        int max = (int) list.get(0);
        for (Object item: list)
        {
            int val = (int) item;
            if (val > max)
            {
                max = val;
            }
        }
        System.out.println(max);
    }

    // printAverage

    public void printAvg(ArrayList<Object> list)
    {
        Double sum = 0.0;
        for (Object item: list)
        {
            sum += (int) item;
        }
        System.out.println(sum / list.size());
    }    

    // array of odds 1 to 255

    public int[] oddsArray1to255()
    {
        int[] arr = new int[128];
        for(int i=0; i<128; i++)
        {
            arr[i] = 2*i + 1;
        }
        return arr;
    }

    // square values 

    public void squareArray(ArrayList<Object> list)
    {
        for (int i=0; i<list.size(); i++)
        {
            int val = (int) list.get(i);
            list.set(i, val*val);
        }
        System.out.println(list);
    }

    // count greater than y

    public void greaterThanY(ArrayList<Object> list, int y)
    {
        int count = 0;
        for (int i=0; i<list.size(); i++)
        {
            if ((int) list.get(i) > y)
            {
                count++;
            }
        }
        System.out.println(count);
    }

    // zero out negative values

    public void transformNegatives(ArrayList<Object> list)
    {
        for (int i=0; i<list.size(); i++)
        {
            if ((int) list.get(i) < 0)
            {
                list.set(i, 0);
            }       
        }
        System.out.println(list);
    }

    // min max and average

    // shift array values to left

    public void shiftArrayToLeft(ArrayList<Object> list)
    {
        int i=0;
        for (i=0; i<list.size()-1; i++)
        {
            list.set(i, list.get(i+1)); 
        }
        list.set(i, 0);
        System.out.println(list);
    }

    // swap negatives for string

    public void swapNegatives(ArrayList<Object> list, String str)
    {
        for (int i=0; i<list.size(); i++)
        {
            if ((int) list.get(i) < 0)
            {
                list.set(i, str);
            }       
        }
        System.out.println(list);
    }

    // sum values from 0 to N

    public void sumFrom0ToN(int n)
    {
        int sum = 0;
        for (int i=0; i<=n; i++)
        {
            sum += i;
        }
        System.out.println(sum);
        System.out.println(n*(n+1)/2);
    }

    // convert F to C

    public Double doohickyThing(Double fa)
    {
        return (fa-32)/9*5; 
    }

    // push front
    // reverse arrayList
    // string reverse
    // character count

    public static void main(String[] args)
    {
        System.out.println("Basic 19");
        Basic19 b19 = new Basic19();
        // b19.print1to255();
        // b19.printOdds1to255();
        // b19.printIntsAndSums1To255();
        ArrayList<Object> list1 = new ArrayList<Object>();
        list1.add(1);
        list1.add(-3);
        list1.add(4);
        list1.add(8);
        list1.add(-2);
        list1.add(0);
        list1.add(8);
        list1.add(0);
        list1.add(-1);
        list1.add(10);
        // b19.printList(list1);
        // b19.printMax(list1);
        // b19.printAvg(list1);
        // System.out.println(b19.oddsArray1to255());
        // b19.squareArray(list1);
        // b19.greaterThanY(list1, 7);
        // b19.transformNegatives(list1);
        // b19.shiftArrayToLeft(list1);
        // b19.swapNegatives(list1, "Dojo");
        b19.sumFrom0ToN(17);
        System.out.println(b19.doohickyThing(212.0));
    } 
} 