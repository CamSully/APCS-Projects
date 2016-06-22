/**
 * Lockable is an interface that can create a locking functionality for any class- in this case the Coin class.
 * 
 * @author Cameron Sullivan 
 * @version 2015.12.27
 */
public interface Lockable
{
    // Declare four methods to be used in the coin class.
    void setKey(int key) throws Exception;
    
    void lock(int key) throws Exception;
    
    void unlock(int key);
    
    boolean locked();
    
}
