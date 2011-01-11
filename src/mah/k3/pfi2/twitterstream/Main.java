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
import emotiometer.control.DateUtils;
import emotiometer.visuals.About;

import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Main extends JFrame implements StatusListener {

	private JPanel contentPane;

	private LoginPanel loginPanel;
	// Two strings added, AL 23/12
	private String tweetContents;
	private String constantProd;
	private String tweetLowerCase;
	public Constant mainConstant = new Constant();
	public Counter mainCounter = new Counter();
	public DateUtils dateUtil = new DateUtils();
	private String dateTime;
	private boolean running = true;
	private GraphicPanel graphicPanel;

	
	private int totalTweetInt;
	public String totalTweets;
	private TotalPanel totalPanel;
	private NegativePanel negativePanel;
	private PositivePanel positivePanel;
	private ProductPanel productPanel;
	private TimePanel timePanel;
	private JMenuBar menuBar;
	private JMenu mnFile;
	
	private About about;
	
	

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
		setBounds(100, 100, 800, 556);
		
		about = new About();
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				about.setVisible(true);
				
			}
		});
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);


		loginPanel = new LoginPanel();
		loginPanel.getButton().setText("Start Emotiometer");
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


		totalPanel = new TotalPanel();
		totalPanel.getLabel().setToolTipText("Total number of tweets in the stream");

		negativePanel = new NegativePanel();

		positivePanel = new PositivePanel();

		productPanel = new ProductPanel();
		productPanel.getLabel().setToolTipText("Number of tweets containing \"Tron Legacy\"");

		/*
		 * Below is the start & stop function for the tweet stream. The button
		 * just controls one boolean, which in turn sets the result of the
		 * method onStatus further below. AL 4/1
		 */
		JButton btnStartStop = new JButton("START / STOP");
		btnStartStop.setToolTipText("Start or stop the reading of the feed");
		btnStartStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (running == false) {
					running = true;
					dateTime = dateUtil.now();
				} else if (running == true) {
					running = false;
				}
				
				/*
				 * This thing above updates the date & time to reflect when the stream has
				 * been started/stopped. AL 4/1
				 */
			}
		});

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		
		timePanel = new TimePanel();
		timePanel.getLabel().setToolTipText("Time that the reading of the Twitter feed initiated");
		
		JButton btnResetStats = new JButton("RESET STATS");
		btnResetStats.setToolTipText("Sets all values to zero");
		btnResetStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainCounter.reset();
				dateTime = dateUtil.now();
				
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnStartStop, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnResetStats))
								.addComponent(negativePanel, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(productPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(totalPanel, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(positivePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(timePanel, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)))
						.addComponent(loginPanel, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(productPanel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(timePanel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnStartStop)
								.addComponent(btnResetStats))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(negativePanel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(totalPanel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addComponent(positivePanel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(loginPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(92))
		);

		graphicPanel = new GraphicPanel();
		FlowLayout flowLayout = (FlowLayout) graphicPanel.getLayout();
		flowLayout.setAlignOnBaseline(true);
		graphicPanel.init();
		panel.add(graphicPanel);
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

		/*
		 * Start reading the Twitter Stream This value is supposed to be changed
		 * with the button in the bottom of our JFrame.
		 */

		mTwitterStream.sample();

		/*
		 * Sets the value for String dateTime to the date and time when the
		 * stream starts to be read. AL 2/1
		 */

		dateTime = dateUtil.now();

		/* Disable the login UI */
		loginPanel.getButton().setEnabled(false);
		loginPanel.getUsernameField().setEnabled(false);
		loginPanel.getPasswordField().setEnabled(false);
	}


	protected TotalPanel getTotalPanel() {
		return totalPanel;
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
		/*
		 * The result of this method is dependent on what the boolean running is
		 * set to. If false, nothing happens. AL 4/1
		 */

		if (running == true) {
			/* Read the message and append it to the JTextArea */
			StringBuilder sb = new StringBuilder();

			sb.append(arg0.getUser().getName() + " " + arg0.getText() + "\n");

			mainCounter.plusTotalCounter();
			/*
			 * Adding the contents of the tweet to the String tweetContents. We
			 * can compare contents within this String to what we will load into
			 * the Constant class. AL 23/12
			 */
			tweetContents = arg0.getText();
			/*
			 * Here I convert the contents of the Tweet to be all lower case.
			 * This means that the tweet can contain Tron Legacy with whatever
			 * CaSe it should still pick up compared to prodName1 in the
			 * Constant class
			 */
			tweetLowerCase = tweetContents.toLowerCase();

			System.out.println(dateTime);
			System.out.println(tweetLowerCase); // Good for copying and pasting
												// when testing

			

			checkTweetProd();

			
		}
	}

	@Override
	public void onTrackLimitationNotice(int arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * Added to check if tweets contain the Prodnames defined in the Constant
	 * class.
	 * We get the product name in here through the instantiation of the Constant class: mainConstant
	 */
	public void checkTweetProd() {

		/*
		 * Adding to get the value from Constant in here, instantiated one
		 * instance of the class Constant at the top (mainConstant). AL 23/12
		 */

		String constantProd = mainConstant.prodName1;

		int index1 = tweetLowerCase.indexOf(constantProd);
		/*
		 * This is the index with which we check if the product name is in the
		 * tweet
		 */

		if (index1 != -1) {
			
			/*Adding +1 tweet to the product category */
			mainCounter.plusProductCounter();
			

			for (int i = 0; i < mainConstant.Positive.length; i++) {
				int indexHappyEmoticon = tweetContents
						.indexOf(mainConstant.Positive[i]);
				if (indexHappyEmoticon != -1) {
					//adds +1 to the positive product tweets
					mainCounter.plusPositiveCounter();
				}

			}
			for (int i = 0; i < mainConstant.Negative.length; i++) {
				int indexSadEmoticon = tweetContents
						.indexOf(mainConstant.Negative[i]);
				if (indexSadEmoticon != -1) {
					//adds +1 to the negative product tweets
					mainCounter.plusNegativeCounter();
				}
			}
			
			/*
			 * Print lines for error checking
			 * */
			System.out.println("Positive " + mainCounter.getPositiveCounter());
			System.out.println("Negative " + mainCounter.getNegativeCounter());
			System.out.println("Product " + mainCounter.getProductCounter());
			System.out.println("Total " + mainCounter.getTotalCounter());
			
			
			/*
			 * Updates the values in the panels for each of our categories.
			 * */
			this.positivePanel.getLabel().setText(
					"" + mainCounter.getPositiveCounter());
			this.negativePanel.getLabel().setText(
					"" + mainCounter.getNegativeCounter());
			this.productPanel.getLabel().setText(
					"" + mainCounter.getProductCounter());
			this.totalPanel.getLabel().setText(
					"" + mainCounter.getTotalCounter());
			
			this.timePanel.getLabel().setText(
					"" + dateTime);
			
			/*
			 * Updates the values for graphicPanel, to amke sure our temperature bar indicator is at
			 * the correct position
			 * */
			this.graphicPanel.setFrowny(mainCounter.getNegativeCounter());
			this.graphicPanel.setSmiley(mainCounter.getPositiveCounter());
		}

		else {
			
			System.out.println("Positive " + mainCounter.getPositiveCounter());
			System.out.println("Negative " + mainCounter.getNegativeCounter());
			System.out.println("Product " + mainCounter.getProductCounter());
			System.out.println("Total " + mainCounter.getTotalCounter());
			this.positivePanel.getLabel().setText(
					"" + mainCounter.getPositiveCounter());
			this.negativePanel.getLabel().setText(
					"" + mainCounter.getNegativeCounter());
			this.productPanel.getLabel().setText(
					"" + mainCounter.getProductCounter());
			this.totalPanel.getLabel().setText(
					"" + mainCounter.getTotalCounter());
			
			
			this.timePanel.getLabel().setText(
					"" + dateTime);

		}

	}
}
