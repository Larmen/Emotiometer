package emotiometer.control;

public class Counter {

 private int positiveCounter = 0;
 private int negativeCounter = 0;
 private int productCounter = 0;
 private int totalCounter = 0;
 // Dont know if these are needed yet as they are referred to in Constant.java under other names. ME
 
public void reset() {
    setPositiveCounter(0);
    setNegativeCounter(0);
    setProductCounter(0);
    setTotalCounter(0);
    }
    // Zeros the counter so getValue() == 0.




/*
 * Below here is the methods we use for counting up our variables one by one in the Main class
 * */

public void plusPositiveCounter(){
	setPositiveCounter(getPositiveCounter() + 1);
}

public void plusNegativeCounter(){
	setNegativeCounter(getNegativeCounter() + 1);
}

public void plusProductCounter(){
	setProductCounter(getProductCounter() + 1);
}

public void plusTotalCounter(){
	setTotalCounter(getTotalCounter()+ 1);
}




/*
 * Setters and getters for getting the values of variables sent over to the Main class. * 
 * 
 * */

public void setPositiveCounter(int positiveCounter) {
	this.positiveCounter = positiveCounter;
}

public int getPositiveCounter() {
	return positiveCounter;
}

public void setNegativeCounter(int negativeCounter) {
	this.negativeCounter = negativeCounter;
}

public int getNegativeCounter() {
	return negativeCounter;
}
 

public void setProductCounter(int productCounter) {
	this.productCounter = productCounter;
}

public int getProductCounter() {
	return productCounter;
}

public void setTotalCounter(int totalCounter) {
	this.totalCounter = totalCounter;
}

public int getTotalCounter() {
	return totalCounter;
}

}