package mah.k3.pfi2.twitterstream;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import emotiometer.control.Constant;
import emotiometer.control.Counter;

import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Main extends JFrame implements StatusListener {

	private JPanel contentPane;
	private StreamPanel streamPanel;
	private LoginPanel loginPanel;
	//Two strings added, AL 23/12
	private String tweetContents;
	private String constantProd;
	private String tweetLowerCase;
	public Constant mainConstant = new Constant();
	public Counter mainCounter = new Counter();
	/**
	 * @wbp.nonvisual location=412,329
	 */
	private final GraphicPanel graphicPanel = new GraphicPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 747);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		streamPanel = new StreamPanel();
		
		
		

		loginPanel = new LoginPanel();
		loginPanel.getPasswordField().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				readTweets();
			}
		});
		loginPanel.getButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				readTweets();
			}
		});
		
		StreamPanel streamPanel = new StreamPanel();
		
		TotalPanel totalPanel = new TotalPanel();
		
		NegativePanel negativePanel = new NegativePanel();
		
		PositivePanel positivePanel = new PositivePanel();
		
		ProductPanel productPanel = new ProductPanel();
		
		JButton btnStartStop = new JButton("START / STOP");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(streamPanel, GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
						.addComponent(loginPanel, GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addComponent(negativePanel, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(74)
							.addComponent(btnStartStop)))
					.addGap(94)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(productPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
						.addComponent(totalPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
					.addGap(88)
					.addComponent(positivePanel, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addGap(52))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(streamPanel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(411)
							.addComponent(productPanel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnStartStop)
							.addGap(33)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(negativePanel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(positivePanel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(totalPanel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(loginPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * Launching the SwingWorker class defined above, this method is used in
	 * both the button and the password field.
	 * 
	 * This should obviously fetch the result of the login to Twitter before
	 * starting the MyTweetWorker SwingWorker, so we don't try to read the
	 * TwitterStream without an authenticated login.
	 */
	private void readTweets() {
		/* Create the TweetStream thread */
		TwitterStream mTwitterStream = new TwitterStreamFactory(this)
				.getInstance(getLoginPanel().getUsernameField().getText(),
						new String(getLoginPanel().getPasswordField()
								.getPassword()));

		/* Start reading the Twitter Stream */
		mTwitterStream.sample();

		/* Disable the login UI */
		loginPanel.getButton().setEnabled(false);
		loginPanel.getUsernameField().setEnabled(false);
		loginPanel.getPasswordField().setEnabled(false);
	}

	/**
	 * Returns the StreamPanel, we use this method to access any sub-components
	 * of the StreamPanel.
	 * 
	 * @return
	 */
	protected StreamPanel getStreamPanel() {
		return streamPanel;
	}

	/**
	 * Returns the LoginPanel, we use this method to access any sub-components
	 * of the LoginPanel.
	 * 
	 * @return
	 */
	public LoginPanel getLoginPanel() {
		return loginPanel;
	}

	/* Status Listener methods */
	@Override
	public void onDeletionNotice(StatusDeletionNotice arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onException(Exception arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatus(Status arg0) {
		
		
		/* Read the message and append it to the JTextArea */
		StringBuilder sb = new StringBuilder();

			sb.append(arg0.getUser().getName() + " " + arg0.getText() + "\n");
			
			mainCounter.plusTotalCounter();
			/*Adding the contents of the tweet to the String tweetContents.
			We can compare contents within this String to what we will load into the Constant class. AL 23/12*/
			tweetContents = arg0.getText();
			/*Here I convert the contents of the Tweet to be all lower case.
			 * This means that the tweet can contain Tron Legacy with whatever CaSe
			 * it should still pick up compared to prodName1 in the Constant class*/
			tweetLowerCase = tweetContents.toLowerCase();
			
			System.out.println(tweetLowerCase); //Good for copying and pasting when testing
			
			checkTweetProd();
			
			/*
			 * Two for loops that probably should be moved into the Constant class. 
			 * We can have the instance mainConstant run the method from within its class instead I guess,
			 * I just didn't want to screw up anything of the Constant class teams work. AL 27/12
			 * 
			 * */
			
			
	
		getStreamPanel().getTextArea().append(sb.toString());
	}

	@Override
	public void onTrackLimitationNotice(int arg0) {
		// TODO Auto-generated method stub

	}
	/*Added to check if tweets contain the Prodnames defined in the Constant class.
	 * We'll have to do a workaround to get the Constant-variable in here though*/
public void checkTweetProd(){
	
	/*
	 * Adding to get the value from Constant in here, 
	 * instantiated one instance of the class Constant at the top (mainConstant). AL 23/12
	*/
	
	String constantProd = mainConstant.prodName1;
	
	int index1 = tweetLowerCase.indexOf(constantProd);
	/*
	 * This is the index with which we check if the product name is in the tweet
	 * */
	
	
	
	if(index1 != -1){
		
		mainCounter.plusProductCounter();
		
		for(int i = 0; i < mainConstant.Positive.length; i++){
			int indexHappyEmoticon = tweetContents.indexOf(mainConstant.Positive[i]);
			if(indexHappyEmoticon != -1){
				System.out.println("glad emoticon funnen");
				mainCounter.plusPositiveCounter();
			}
			
		}
		for(int i = 0; i < mainConstant.Negative.length; i++){
			int indexSadEmoticon = tweetContents.indexOf(mainConstant.Negative[i]);
			if(indexSadEmoticon != -1){
				System.out.println("suris emoticon funnen");
				mainCounter.plusNegativeCounter();
			}
		}
		
	System.out.println("Positive " + mainCounter.getPositiveCounter());
	System.out.println("Negative " + mainCounter.getNegativeCounter());
	System.out.println("Product " + mainCounter.getProductCounter());
	System.out.println("Product " + mainCounter.getTotalCounter());
	
		}

else {
	System.out.println("xfalse");
	System.out.println("Positive " + mainCounter.getPositiveCounter());
	System.out.println("Negative " + mainCounter.getNegativeCounter());
	System.out.println("Product " + mainCounter.getProductCounter());
	System.out.println("Total " + mainCounter.getTotalCounter());
	
	}
	

}
}
