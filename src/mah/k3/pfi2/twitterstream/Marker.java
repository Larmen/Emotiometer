package mah.k3.pfi2.twitterstream;
import processing.core.PApplet;

public class Marker {
	float smiley;   // value of smilies.
	float frowny;   // value of frownies
	int c;          // color
	float xpos;   // position in x axis of marker
	float ypos;   // position in y axis of marker
  
	PApplet parent; // The parent PApplet that we will render ourselves onto

	Marker(PApplet p) {
	//	parent = p;
		frowny = 45;//random (100); //Här skall värdena från tweetlistener in
	    smiley = 2; //random (100); //Här skall värdena från tweetlistener in
	//	x = 0;              // All stripes start at 0
	//	speed = parent.random(1);  // All stripes have a random positive speed
	//	w = parent.random(10,30);
	//	mouse = false;
	}

	void display() {
		
	    xpos = (375/2)-100+(smiley/(smiley+frowny))*200;
	    parent.stroke (0);
	    parent.fill (c);
	    parent.rectMode (parent.CENTER);
	    parent.rect (xpos,ypos, 1, 32);
	//  println (smiley+"smiley"+frowny+"frowny");
	  }

	
		  
	
}

