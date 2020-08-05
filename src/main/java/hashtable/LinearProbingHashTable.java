package hashtable;





public class LinearProbingHashTable
{
    private int currentSize, maxSize;
    private String[] keys;
    private String[] vals;

    /** Constructor **/
    public LinearProbingHashTable(int capacity)
    {
        currentSize = 0;
        maxSize = capacity;
        keys = new String[maxSize];

    }

    public void makeEmpty()
    {
        currentSize = 0;
        keys = new String[maxSize];

    }

    /** Function to get size of hash table **/
    public int Size()
    {
        return keys.length;
    }

    /** Function to check if hash table is full **/
    public boolean isFull()
    {
        return currentSize == maxSize;
    }

    /** Function to check if hash table is empty **/
    public boolean isEmpty()
    {
        return Size() == 0;
    }

    /** Fucntion to check if hash table contains a key **/
    public boolean contains(String key)
    {
        return get(key) !=  null;
    }

    /** Functiont to get hash code of a given key **/
    private int hash(String key)
    {
        return key.hashCode() % maxSize;
    }
    /** Function for Loading factor **/
    public double LoadFactor(){
        double ld=currentSize/keys.length;
        return ld;
    }
    public boolean add (String str)
    {double p=LoadFactor();
        if(p>=0.75)
        {String [] temp=new String [keys.length*2];
            for(int i=0;i<keys.length;i++)
            {temp[i]=keys[i];
            }
            keys=temp;
            maxSize=keys.length;
        }
        int tmp = hash(str);
        int i = tmp;
        do
        {
            if (keys[i] == null)
            {
                keys[i] = str;

                currentSize++;
                return true;
            }
            if (keys[i].equals(str))
            {

                return true;
            }
            i = (i + 1) % maxSize;
        } while (i != tmp);
        return false;
    }


    /** Function to get value for a given key **/
    public String get(String key)
    {
        int i = hash(key);
        while (keys[i] != null)
        {
            if (keys[i].equals(key))
                return keys[i];
            i = (i + 1) % maxSize;
        }
        return null;
    }
    public boolean delete (String str)
    {

        if (!contains(str))
            return false;

        /** find position key and delete **/
        int i = hash(str);
        while (!str.equals(keys[i]))
            i = (i + 1) % maxSize;
        keys[i] = null;
        currentSize--;

        return true;
    }

    /** Function to remove key and its value **/

    /** Function to print HashTable **/
    public void printHashTable()
    {
        System.out.println("\nHash Table: ");
        for (int i = 0; i < maxSize; i++)
            if (keys[i] != null)
                System.out.println(keys[i]);
        System.out.println();
    }

}





