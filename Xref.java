import java.io.*;
import java.util.Scanner;
/**
 * Write a description of class Xref here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Xref
{
    private ObjectBinaryTree tree = new ObjectBinaryTree();
    private PrintWriter pw;

    /**
     * Constructor for objects of class Xref
     */
    public Xref(PrintWriter pw)throws IOException
    {
        this.pw = pw;
    }

    public void getInfo() throws IOException
    {
        Scanner fileScan = new Scanner(new File("getty.txt"));
        Word derp = new Word(pw);
        Word foo = new Word(pw);
        Hash hash = new Hash(pw);
        int lineCount = 0;
        while(fileScan.hasNextLine())
        {
            lineCount++;
            String reader = fileScan.nextLine();
            String delims = "[ ,.-;]+";
            String [] tempArray = reader.split(delims);
            ObjectList [] hashTable = hash.getHashTable();
            System.out.println(lineCount + " " + reader);
            pw.println(lineCount + " " + reader);
            for(int n = 0; n < tempArray.length; n++)
            {
                int wordCount = n + 1;
                if(!hash.inHashTable(tempArray[n], hashTable))
                {
                    String tempString = tempArray[n];
                    tempString = tempString.toLowerCase();
                    ObjectList lineList = new ObjectList();
                    LinePosition lineObj = new LinePosition(lineCount, wordCount);
                    ObjectList linePosition = new ObjectList();
                    ObjectListNode listNode = new ObjectListNode();
                    listNode.setInfo(lineObj);
                    lineList.addLast(listNode);
                    foo = derp.loadObject(tempString, lineList);
                    linePosition.addLast(listNode);
                    tree.insertBSTDuplicate(foo);
                }
            }
        }
    }

    public void traverse()
    {
        ObjectTreeNode node = (ObjectTreeNode)tree.getRoot();
        tree.inTrav(node);
    }

    public void query()
    {
        Query query = new Query(pw);
        Scanner scanner = new Scanner(System.in);
        Scanner loop = new Scanner(System.in);
        int choice = 0;
        do
        {
            String input = "";
            System.out.println();
            pw.println();
            System.out.println("Please input the word you would like to search for.");
            pw.println("Please input the word you would like to search for.");
            input = scanner.nextLine();
            ObjectList temp = new ObjectList();
            Word derp = new Word(pw);
            Word foo = derp.loadObject(input,temp);
            query.search(tree, foo);
            System.out.println("Enter 1 to use the search function again or any other key to exit the program.");
            pw.println("Enter 1 to use the search function again or any other key to exit the program.");
            choice = loop.nextInt();
        }while(choice == 1);
    }
}
