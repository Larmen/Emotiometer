package mah.k3.pfi2.twitterstream;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


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

/* tryck p� rutan i �vre h�gra h�rnet, d� slumpas ett tal f�r smilies 
respektive frownies. De delas genom sig sj�lva ((s/f+s)+(f/f+s)/2). ut f�r man en 
j�mkning av procentsatserna som visas l�ngs status-baren.*/


public class GraphicPanel extends PApplet {
 	public GraphicPanel() {
	}


	
	  public void setup() {
		    size(200,200);
		    background(0);
		  }

	  public void draw() {
		    stroke(255);
		    if (mousePressed) {
		      line(mouseX,mouseY,pmouseX,pmouseY);
		    }
		  }


	}
