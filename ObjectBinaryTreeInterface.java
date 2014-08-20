
/**
 * Write a description of interface ObjectBinaryTreeInterface here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ObjectBinaryTreeInterface
{
   public void setLeftChild(ObjectTreeNode parent, ObjectTreeNode r);
   public void setRightChild(ObjectTreeNode parent, ObjectTreeNode r);
   public void insertBST(Object o);
   public void insertBSTDuplicate(Object o);
   public ObjectTreeNode searchBST(Object o);
   public void preTrav(ObjectTreeNode tree);
   public void inTrav(ObjectTreeNode tree);
   public void postTrav(ObjectTreeNode tree);
   public void delete(Object o);
   
}
