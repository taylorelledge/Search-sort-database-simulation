import java.io.*;
/**
 * Class consisting of two methods which build a hash table and check to see if a value is in the hashtable that 
 * has been built.
 * 
 * @author Taylor Elledge 
 * @version 1.0
 */
public class Hash
{
    private int collisionCount;
    ObjectList [] hashTable = new ObjectList [37];
    PrintWriter pw;
    /**
     * Constructor for objects of class Hash
     */
    public Hash(PrintWriter pw)
    {
        this.pw = pw;
    }

    public int getCollisionCount()
    {
        return collisionCount;
    }

    /**
     * getHashTable() - function that constructs a hash table using a bucket approach to resolve collisions. After
     * hash table is constructed it is returned to calling method for use.
     * 
     * @param - none
     * @ return - ObjectList hashTable
     */
    public ObjectList [] getHashTable()
    {
        String [] omitWord = {"a", "after", "all", "and", "because", "every", "for", "from", "had", "have", "in",
                "is", "it", "its", "now", "of", "on", "so", "that", "the", "their", "there", "to",
                "was", "were", "which", "with"};
        collisionCount = 0;
        for(int i = 0; i < omitWord.length; i++)
        {
            int hashValue = 0;
            String tempString = omitWord[i];
            char [] charArray;
            charArray = tempString.toCharArray();
            int sum = 0;
            for(int n = 0; n < charArray.length; n++)
            {
                sum += charArray[n];
            }
            hashValue = sum % 37;
            ObjectListNode node = new ObjectListNode();
            Word temp = new Word(pw);
            temp.setWord(omitWord[i]);
            node.setInfo(temp);
            ObjectList foo = new ObjectList();
            if(hashTable[hashValue] != null)
            {
                collisionCount++;
                foo = hashTable[hashValue];
                foo.addLast(node);
                hashTable[hashValue] = foo;
            }
            else if(hashTable[hashValue] == null)
            {
                foo.addLast(node);
                hashTable[hashValue] = foo;
            }
        }
        return hashTable;
    }

    /**
     * printHasTable() - prints hashTable to user once it has been populated.
     */
    public void printHashTable()
    {
        for(int i = 0; i < hashTable.length; i++)
        {
            if(hashTable[i] == null)
            {
                System.out.println("[" + i + "] = null");
                pw.println("[" + i + "] = null");
            }
            else
            {
                ObjectList tempList = hashTable[i];
                ObjectListNode tempNode = (ObjectListNode)tempList.getFirstNode();
                System.out.print("[" + i + "] = ");
                pw.print("[" + i + "] = ");
                while(tempNode != null)
                {
                    Word foo = (Word)tempNode.getInfo();
                    String word = foo.getWord();
                    System.out.print(word + " ");
                    pw.print(word + " ");
                    tempNode = tempNode.getNext();
                }
                System.out.println();
                pw.println();
            }
        }
        Hash foo = new Hash(pw);
        int colCount = foo.getCollisionCount();
        System.out.println("Number of collisions: " + colCount);
        pw.println("Number of collisions: " + colCount);
        System.out.println("My hash function uses a lexicographic approach to find a number for each word, the word is then mapped \nto an array location via a %37 operation.");
        pw.println("My hash function uses a lexicographic approach to find a number for each word, the word is then mapped \nto an array location via a %37 operation.");
    }

    /**
     * inHashTable() - boolean function that determines whether String parameter arg is in the ObjectList 
     * parameter hash.
     * 
     * @param - String arg, ObjectList hash[]
     * @return - true if string is found in parameter hash, otherwise false.
     */
    public boolean inHashTable(String arg, ObjectList hash [])
    {
        char [] charArray = arg.toCharArray();
        ObjectList [] hashTable = hash;
        int sum = 0;
        for(int n = 0; n < charArray.length; n++)
        {
            sum += charArray[n];
        }
        int hashValue = sum % 37;
        ObjectList tempList = hashTable[hashValue];
        if(tempList == null)
        {
            return false;
        }
        ObjectListNode node = (ObjectListNode)tempList.getFirstNode();
        while(node != null)
        {
            Word temp = (Word)node.getInfo();
            String tempString  = temp.getWord();
            if(tempString.equals(arg))
            {
                return true;
            }
            else
            {
                node = node.getNext();
            }
        }
        return false;
    }
}

