package emotiometer.control;

public class Counter {

	int positiveCounter;
	int negativeCounter;
	int productCounter;
	int totalCounter;
	// Dont know if these are needed yet as they are referred to in Constant.java under other names. ME
	
	
    public Counter()
    {
    positiveCounter = 0;
    negativeCounter = 0;
    productCounter = 0;
    totalCounter = 0;
    }
    // Constructs counters whose value is zero.
    
    
    public Counter(int init)
    {
    positiveCounter = 0;
    negativeCounter = 0;
    productCounter = 0;
    totalCounter = 0;
    }
    // Constructs 4 counters with given initial values.
    // @param init is the initial value of each counter
    // This also almost redundant in our code so far, could be used later -ME
    
    
    /*
    public int getValue()
    {
	return positiveCounter;
    return negativeCounter;
    return productCounter;
    return totalCounter;
    }
    // Returns the value of the counters.
    // @return the value of each counter
    // This part is not needed yet, as we do not need to fetch any values except for 0 -ME
    */
    
    public void clear()
    {
    positiveCounter = 0;
    negativeCounter = 0;
    productCounter = 0;
    totalCounter = 0;
    }
    // Zeros the counter so getValue() == 0.
    
    
    public void increment()
    {
    positiveCounter++;
    negativeCounter++;
    productCounter++;
    totalCounter++;
    }
    // Increase the value of the counter by one.
    
    public String RESULTAT_POSITIVE()
    {
	return ""+positiveCounter;
    }
    public String RESULTAT_NEGATIVE()
    {
    return ""+negativeCounter;
    }
    public String RESULTAT_BOTH()
    {
    return ""+productCounter;
    }
    public String RESULTAT_NOTHING()
    {
    return ""+totalCounter;
    }
    // Return strings representing the value of each counter.
    // @return a string representation of the value
    // there might be conflicts considering strings in Constant.java are named differently
}



