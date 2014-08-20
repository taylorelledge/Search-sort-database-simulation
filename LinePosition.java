
/**
 * Class LinePosition used to create objects that keep track of line number and position in regard to words in the 
 * text file being read in.
 * 
 * @author Taylor Elledge 
 * @version 1.0
 */
public class LinePosition
{
    private int lineCount;
    private int linePosition;

    /**
     * Constructor for objects of class LinePosition
     */
    public LinePosition(int inLineCount, int inLinePosition)
    {
       lineCount = inLineCount;
       linePosition = inLinePosition;
    }
    /**
     * getLineCount() - returns member variable lineCount to calling class.
     * 
     * @param - none
     * @return - int lineCount
     */
    public int getLineCount()
    {
        return lineCount;
    }
    /**
     * getLineCount() - returns member variable linePosition to calling class.
     * 
     * @param - none
     * @return - int linePosition
     */
    public int getLinePosition()
    {
        return linePosition;
    }
}
