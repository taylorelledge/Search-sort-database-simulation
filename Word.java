import java.io.*;
/**
 * Class Word contains all accessor and mutator functions necessary for major functionality of program. Also
 * contains overriden methods specified in TreeComparable interface tghat are used in Class ObjectBinaryTree.
 * 
 * @author Taylor Elledge 
 * @version 1.0
 */
public class Word implements Comparable, TreeComparable
{
    private String word;
    private int count = 1;
    private ObjectList lineRef = new ObjectList();
    PrintWriter pw;
    /**
     * constructor for objects of class Word.
     */
    public Word(PrintWriter pw)
    {
        this.pw  = pw;
    }

    /**
     * setWord() - changes value of member variable word in calling object of class Word.
     * 
     * @param - String inWord
     * @return - none
     */
    public void setWord(String inWord)
    {
        word  = inWord;
    }

    /**
     * getWord() - returns member variable word to calling class.
     * 
     * @param - none
     * @return - String word
     */
    public String getWord()
    {
        return word;
    }

    /**
     * getCount() - returns member variable count to calling class.
     * 
     * @param - none
     * @return - int count
     */
    public int getCount()
    {
        return count;
    }

    /**
     * getLineRef() - returns member variable lineRef to calling class.
     * 
     * @param - none
     * @return - ObjectList lineRef
     */
    public ObjectList getLineRef()
    {
        return lineRef;
    }

    /**
     * getLineRef() - changes value of member variable lineRef in calling object of class Word.
     * 
     * @param - none
     * @return - String word
     */
    public void setLineRef(ObjectList inLineRef)
    {
        lineRef = inLineRef;
    }

    /**
     * loadObject(String arg, ObjectList inLineRef) - loads word objects and returns them to calling class.
     * 
     * @param - String arg, ObjectList inLineRef
     */
    public Word loadObject(String arg, ObjectList inLineRef)
    {
        Word foo = new Word(pw);
        foo.setWord(arg);
        foo.setLineRef(inLineRef);
        return foo;
    }

    /**
     * compareTo(Object O) - returns int based on comparison of member variables word.
     * 
     * @param - Object O
     * @return - int
     */
    @Override public int compareTo(Object o)
    {
        Word node = (Word)o;
        return word.compareTo(node.getWord());
    }
    
    /**
     * operate(Object o) - used in ObjectBinaryTree to increment count of an occurence of a word and append a new
     * linked list node to the end  of the objects line position linked list.
     * 
     * @param - Object o
     * @return - none
     */
    public void operate(Object o)
    {
        Word node = (Word) o;
        this.count++;
        lineRef.addLast(node.getLineRef().getFirstNode());
    }
    
    /**
     * visit() - method used in ObjectBinaryTree to ouput the contents of a node when the node has been found 
     * as part of a search.
     * 
     * @param - none
     * @return - none
     */
    public void visit()
    {
        Word foo = new Word(pw);
        String tempWord = this.getWord();
        int tempCount = this.getCount();
        ObjectList wordList = this.getLineRef();
        ObjectListNode node = (ObjectListNode) wordList.getFirstNode();
        System.out.println("The word " + tempWord + " occurs " + tempCount + " time(s) in this text file.");
        pw.println("The word " + tempWord + " occurs " + tempCount + " time(s) in this text file.");
        System.out.println("Line number and position of word");
        pw.println("Line number and position of word");
        System.out.println("*****************************************");
        pw.println("*****************************************");
        while(node != null)
        {
            LinePosition temp = (LinePosition)node.getInfo();
            int tempLineCount = temp.getLineCount();
            int tempLinePos = temp.getLinePosition();
            System.out.println("Line: " + tempLineCount + " Line Position: " + tempLinePos);
            pw.println("Line: " + tempLineCount + " Line Position: " + tempLinePos);
            System.out.println();
            pw.println();
            System.out.println();
            pw.println();
            node = node.getNext();
        }
    }

}
