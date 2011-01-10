package mah.k3.pfi2.twitterstream;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import mah.k3.pfi2.twitterstream.GraphicPanel.Marker;


import processing.core.*;
// added so it can import processing sketches into the frame -ME

/**
 * Just a simple TextArea widget. The textarea by itself doesn't allow for
 * scrolling, so to make it simplistic in the Main Panel we define our own
 * custom composite components on JPanel classes.
 * 
 * @author andreas
 * 
 */




public class GraphicPanel extends PApplet {
 	public GraphicPanel() {
	}


	
 	Marker[] markers = new Marker[1];

	float smiley; // value of smilies.
	float frowny; // value of frownies
	int c; // color
	float xpos; // position in x axis of marker
	float ypos; // position in y axis of marker

	public void setup() {
		size(750, 250);

		markers[0] = new Marker(color (255,255,255),0,150);
	}

	public void draw() {

		// println(mouseX + " " + mouseY); //skriver ut musens placering för
		// enklare programmering

		background(0);
		PImage I = loadImage("tronemotiometer.jpg"); // banner logo on top
		image((I), 8, 10);
		PImage G = loadImage("gradient emoticons.jpg"); // gradient status bar,
														// x=200pxl, y=25pxl.
		image((G), width / 2 - 230, 125);
		PImage F = loadImage("frowny.jpg"); // frowny face
		image((F), width / 2 - 340, 110);
		PImage S = loadImage("smiley.jpg"); // frowny face
		image((S), width / 2 + 265, 110);

		/*
		stroke(0); // grafik för knapp 1.
		fill(255);
		rectMode(CORNER);
		rect(width / 2 - 42, 180, 84, 28);
		fill(0);
		textAlign(CENTER);
		text("GET TWEETS", width / 2, 197);
		* Commented out for cleanliness in the graphics. AL 7/1
		*/

		markers[0].display();

	}

	class Marker {
		// int c;
		float xpos;
		float ypos;

		Marker(int tempC, float tempXpos, float tempYpos) {
			c = tempC;
			xpos = tempXpos;
			ypos = tempYpos;

		}

		void display() {

			xpos = (width / 2) - 230 + (smiley / (smiley + frowny)) * 460;
			stroke(255);
			fill(255);
			rectMode(CENTER);
			rect(xpos, ypos, 2, 75);
			//println(smiley + "smiley" + frowny + "frowny");
		}

	}



	public void setFrowny(int frowny) {
		this.frowny = frowny;
	}
	
	public void setSmiley(int smiley) {
		this.smiley = smiley;
	}
	
	}
