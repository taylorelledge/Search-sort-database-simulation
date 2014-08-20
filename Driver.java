import java.util.Scanner;
import java.io.*;
/**
 * Taylor Elledge 007686183
 * 
 * Binary Tree Lab
 */
public class Driver
{
    public static void main(String [] args)throws IOException
    {
        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
        Xref foo = new Xref(pw);
        Hash hash = new Hash(pw);
        hash.getHashTable();
        hash.printHashTable();
        foo.getInfo();
        foo.traverse();
        foo.query();
        pw.flush();
        pw.close();
    }
}
