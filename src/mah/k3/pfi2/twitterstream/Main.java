package mah.k3.pfi2.twitterstream;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import emotiometer.control.Constant;

import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

@SuppressWarnings("serial")
public class Main extends JFrame implements StatusListener {

	private JPanel contentPane;
	private StreamPanel streamPanel;
	private LoginPanel loginPanel;
	//Two strings added, AL 23/12
	private String tweetContents;
	private String constantProd;
	private String tweetLowerCase;

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
		setBounds(100, 100, 600, 400);
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																loginPanel,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																560,
																Short.MAX_VALUE)
														.addComponent(
																streamPanel,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																560,
																Short.MAX_VALUE))
										.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.TRAILING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addComponent(streamPanel, GroupLayout.DEFAULT_SIZE,
								253, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(loginPanel, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE).addContainerGap()));
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
		if (arg0.getUser().getLang().equals("en")) {
			sb.append(arg0.getUser().getName() + " " + arg0.getText() + "\n");
			/*Adding the contents of the tweet to the String tweetContents.
			We can compare contents within this String to what we will load into the Constant class. AL 23/12*/
			tweetContents = arg0.getText();
			/*Here I convert the contents of the Tweet to be all lower case.
			 * This means that the tweet can contain Tron Legacy with whatever CaSe
			 * it should still pick up compared to prodName1 in the Constant class*/
			tweetLowerCase = tweetContents.toLowerCase();
			System.out.println(tweetLowerCase);
			checkTweetProd();
			
			
		}
		getStreamPanel().getTextArea().append(sb.toString());
	}

	@Override
	public void onTrackLimitationNotice(int arg0) {
		// TODO Auto-generated method stub

	}
	/*Added to check if tweets contain the Prodnames defined in the Constant class.
	 * We'll have to do a workaround to get the Constant-variable in here though*/
public void checkTweetProd(){
	
	//Adding to get the value from Constant in here, instanatiated one instance of the class Constant. AL 23/12
	Constant mainConstant = new Constant();
	String constantProd1 = mainConstant.prodName1;
	
	int index1 = tweetLowerCase.indexOf(constantProd1);
	
	
	
	if(index1 != -1){
	System.out.println("xtrue");
		}

else {
	System.out.println("xfalse");
	}
	

}

}
