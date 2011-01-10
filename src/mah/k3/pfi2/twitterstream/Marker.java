package mah.k3.pfi2.twitterstream;
import processing.core.PApplet;

public class Marker {
	float smiley;   // value of smilies.
	float frowny;   // value of frownies
	// int c;          // color
	float xpos;   // position in x axis of marker
	float ypos;   // position in y axis of marker
  
	PApplet parent; // The parent PApplet that we will render ourselves onto

	Marker(PApplet p) {
	//	parent = p;
		frowny = 45;//random (100); //Här skall värdena från tweetlistener in
	    smiley = 2; //random (100); //Här skall värdena från tweetlistener in
	}		  
	
}

