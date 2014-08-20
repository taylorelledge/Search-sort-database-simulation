import java.io.*;
/**
 * Write a description of class Query here.
 * 
 * @author Taylor Elledge 
 * @version 1.0
 */
public class Query
{
    private PrintWriter pw;
    /**
     * constructor for objects of class Query
     */
    public Query(PrintWriter pw)
    {
        this.pw = pw;
    }
    /**
     *  search() - takes as arguments a binary tree from the calling class and an object from the calling class.
     *  A search is performed and based on the state of the binary tree node returned one of two outputs are made.
     *  
     *  @param - ObjectBinaryTree tree, Word arg
     *  @return - none
     */
    public void search(ObjectBinaryTree tree, Word arg)
    {
        ObjectTreeNode treeNode = new ObjectTreeNode();
        ObjectListNode listNode = new ObjectListNode();
        treeNode = tree.searchBST(arg);
        if(treeNode == null)
        {
            System.out.println();
            pw.println();
            System.out.println("Invalid Input: The word is not in the file");
            pw.println("Invalid Input: The word is not in the file");
            System.out.println(); 
            pw.println();
        }
        else if(treeNode != null)
        {
            Word foo = (Word)treeNode.getInfo();
            String word = foo.getWord();
            int wordCount = foo.getCount();
            ObjectList lineRef = foo.getLineRef();
            listNode = (ObjectListNode)lineRef.getFirstNode();
            System.out.println("The word " + word + " occurs " + wordCount + " time(s) in this text file.");
            pw.println("The word " + word + " occurs " + wordCount + " time(s) in this text file.");
            System.out.println("Line number and position of word");
            pw.println("Line number and position of word");
            System.out.println("*****************************************");
            pw.println("*****************************************");
            while(listNode != null)
            {
                LinePosition temp = (LinePosition)listNode.getInfo();
                int tempLineCount = temp.getLineCount();
                int tempLinePos = temp.getLinePosition();
                System.out.println("Line: " + tempLineCount + " Line Position: " + tempLinePos);
                pw.println("Line: " + tempLineCount + " Line Position: " + tempLinePos);
                System.out.println();
                pw.println();
                System.out.println();
                pw.println();
                listNode = listNode.getNext();
            }
        }
    }
}
