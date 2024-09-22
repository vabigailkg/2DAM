package main;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import views.AccessPanel;
import views.NoUsar;
import views.Nousar2;
import views.FavoritePanel;
import views.GroupPanel;
import views.GroupsManagementPanel;
import views.LoginPanel;
import views.MainPanel;
import views.ModifyAuthorPanel;
import views.PlayPanel;
import views.PodcastPanel;
import views.NoUsar7;
import views.ProfilePanel;
import views.RegisterPanel;
import views.NoUsar4;
import views.NoUsar6;
import views.NoUsar5;
import views.StatisticsPanel;
import views.WelcomePanel;

public class Main {
	private JFrame frame;
	private ArrayList<JPanel> panels = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Main().frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		inicialize();
	}

	public void inicialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panels = new ArrayList<JPanel>();
		
		WelcomePanel welcomePanel = new WelcomePanel(panels);
		JPanel panel1 = welcomePanel.getPanel();
		panel1.setVisible(true);

		panels.add(panel1);
		frame.getContentPane().add(panel1);
		
		AccessPanel accessPanel = new AccessPanel(panels);
		JPanel panel2 = accessPanel.getPanel();
		panel2.setVisible(false);

		panels.add(panel2);
		frame.getContentPane().add(panel2);
		
		NoUsar noUsar = new NoUsar(panels);
		JPanel panel3 = noUsar.getPanel();
		panel3.setVisible(false);

		panels.add(panel3);
		frame.getContentPane().add(panel3);
		
		Nousar2 nousar2 = new Nousar2(panels);
		JPanel panel4 = nousar2.getPanel();
		panel4.setVisible(false);

		panels.add(panel4);
		frame.getContentPane().add(panel4);
		
		FavoritePanel favoritePanel = new FavoritePanel(panels);
		JPanel panel5 = favoritePanel.getPanel();
		panel5.setVisible(false);

		panels.add(panel5);
		frame.getContentPane().add(panel5);
		
		GroupPanel groupPanel = new GroupPanel(panels);
		JPanel panel6 = groupPanel.getPanel();
		panel6.setVisible(false);

		panels.add(panel6);
		frame.getContentPane().add(panel6);
		
		GroupsManagementPanel groupsManagementPanel = new GroupsManagementPanel(panels);
		JPanel panel7 = groupsManagementPanel.getPanel();
		panel7.setVisible(false);

		panels.add(panel7);
		frame.getContentPane().add(panel7);
		
		LoginPanel loginPanel = new LoginPanel(panels);
		JPanel panel8 = loginPanel.getPanel();
		panel8.setVisible(false);

		panels.add(panel8);
		frame.getContentPane().add(panel8);
		
		MainPanel mainPanel = new MainPanel(panels);
		JPanel panel9 = mainPanel.getPanel();
		panel9.setVisible(false);

		panels.add(panel9);
		frame.getContentPane().add(panel9);
		
		ModifyAuthorPanel modifyAuthorPanel = new ModifyAuthorPanel(panels);
		JPanel panel10 = modifyAuthorPanel.getPanel();
		panel10.setVisible(false);

		panels.add(panel10);
		frame.getContentPane().add(panel10);
		
		PlayPanel playPanel = new PlayPanel(panels);
		JPanel panel11 = playPanel.getPanel();
		panel11.setVisible(false);

		panels.add(panel11);
		frame.getContentPane().add(panel11);
		
		NoUsar7 noUsar7 = new NoUsar7(panels);
		JPanel panel12 = noUsar7.getPanel();
		panel12.setVisible(false);

		panels.add(panel12);
		frame.getContentPane().add(panel12);
		
		PodcastPanel podcastPanel = new PodcastPanel(panels);
		JPanel panel13 = podcastPanel.getPanel();
		panel13.setVisible(false);

		panels.add(panel13);
		frame.getContentPane().add(panel13);
		
		ProfilePanel profilePanel = new ProfilePanel(panels);
		JPanel panel14 = profilePanel.getPanel();
		panel14.setVisible(false);

		panels.add(panel14);
		frame.getContentPane().add(panel14);
		
		RegisterPanel registerPanel = new RegisterPanel(panels);
		JPanel panel15 = registerPanel.getPanel();
		panel15.setVisible(false);

		panels.add(panel15);
		frame.getContentPane().add(panel15);
		
		NoUsar4 noUsar4 = new NoUsar4(panels);
		JPanel panel16 = noUsar4.getPanel();
		panel16.setVisible(false);

		panels.add(panel16);
		frame.getContentPane().add(panel16);
		
		NoUsar6 noUsar6 = new NoUsar6(panels);
		JPanel panel17 = noUsar6.getPanel();
		panel17.setVisible(false);

		panels.add(panel17);
		frame.getContentPane().add(panel17);
		
		NoUsar5 noUsar5 = new NoUsar5(panels);
		JPanel panel18 = noUsar5.getPanel();
		panel18.setVisible(false);

		panels.add(panel18);
		frame.getContentPane().add(panel18);
		
		StatisticsPanel statisticsPanel = new StatisticsPanel(panels);
		JPanel panel19 = statisticsPanel.getPanel();
		panel19.setVisible(false);

		panels.add(panel19);
		frame.getContentPane().add(panel19);
	}
}