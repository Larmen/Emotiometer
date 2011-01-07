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

/*public class GraphicPanel extends JPanel {


	private JTextArea textArea;
    
	//Create the panel.

	public GraphicPanel() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
				null), "Thermometer %", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		// add(scrollPane);

		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

	}

	public JTextArea getTextArea() {
		return textArea;
	}
}
*/

/* tryck på rutan i övre högra hörnet, då slumpas ett tal för smilies 
respektive frownies. De delas genom sig själva ((s/f+s)+(f/f+s)/2). ut får man en 
jämkning av procentsatserna som visas längs status-baren.*/


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

		markers[0] = new Marker(color (0,0,0),0,158);
	}

	public void draw() {

		// println(mouseX + " " + mouseY); //skriver ut musens placering för
		// enklare programmering

		background(255);
		PImage I = loadImage("tronemotiometer.jpg"); // banner logo on top
		image((I), 10, 0);
		PImage G = loadImage("gradient emoticons.jpg"); // gradient status bar,
														// x=200pxl, y=25pxl.
		image((G), width / 2 - 100, 145);
		PImage F = loadImage("frowny.jpg"); // frowny face
		image((F), width / 2 - 250, 93);
		PImage S = loadImage("smiley.jpg"); // frowny face
		image((S), width / 2 + 150, 95);

		stroke(0); // grafik för knapp 1.
		fill(255);
		rectMode(CORNER);
		rect(width / 2 - 42, 180, 84, 28);
		fill(0);
		textAlign(CENTER);
		text("GET TWEETS", width / 2, 197);

		markers[0].display();

	}

	class Marker {
		int c;
		float xpos;
		float ypos;

		Marker(int tempC, float tempXpos, float tempYpos) {
			c = tempC;
			xpos = tempXpos;
			ypos = tempYpos;

		}

		void display() {

			xpos = (width / 2) - 100 + (smiley / (smiley + frowny)) * 200;
			stroke(0);
			fill(c);
			rectMode(CENTER);
			rect(xpos, ypos, 1, 32);
			//println(smiley + "smiley" + frowny + "frowny");
		}

	}

	public void mousePressed() { // funktion för knapp 1, slumpar värden för
									// smilies & frownies.
		if (mouseX > width / 2 - 42 && mouseX < width / 2 + 42 && mouseY > 180
				&& mouseY < 208) {
			frowny = random(100); // Här skall värdena från tweetlistener in
			smiley = random(100); // Här skall värdena från tweetlistener in
		}
	}

	public void setFrowny(int frowny) {
		this.frowny = frowny;
	}
	
	public void setSmiley(int smiley) {
		this.smiley = smiley;
	}
	
	}
