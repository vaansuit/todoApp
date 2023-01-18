package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

public class MainView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 949, 886);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel imageHeader = new JLabel("");
		imageHeader.setIcon(new ImageIcon("C:\\Users\\Usuario\\Documents\\JAVA\\JAVA_APPS\\TodoApp\\src\\img\\background.jpg"));
		imageHeader.setBounds(0, 0, 933, 240);
		frame.getContentPane().add(imageHeader);
		
		JPanel projectHeaderPanel = new JPanel();
		projectHeaderPanel.setBackground(Color.WHITE);
		projectHeaderPanel.setBounds(10, 251, 208, 50);
		frame.getContentPane().add(projectHeaderPanel);
		projectHeaderPanel.setLayout(null);
		
		JLabel projectHeaderLabel = new JLabel("PROJETOS");
		projectHeaderLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		projectHeaderLabel.setHorizontalAlignment(SwingConstants.LEFT);
		projectHeaderLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		projectHeaderLabel.setBounds(10, 11, 119, 28);
		projectHeaderPanel.add(projectHeaderLabel);
		
		JLabel labelProjectAddIcon = new JLabel("");
		labelProjectAddIcon.setBackground(Color.BLACK);
		labelProjectAddIcon.setBounds(139, 0, 59, 50);
		ImageIcon addProjectIcon = new ImageIcon("C:\\\\Users\\\\Usuario\\\\Documents\\\\JAVA\\\\JAVA_APPS\\\\TodoApp\\\\src\\\\img\\\\addIcon.png");
		Image imageAddProjectIcon = addProjectIcon.getImage();
		Image addProjectIconScale = imageAddProjectIcon.getScaledInstance(labelProjectAddIcon.getWidth(), labelProjectAddIcon.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon = new ImageIcon(addProjectIconScale);
		labelProjectAddIcon.setIcon(scaleIcon);
		projectHeaderPanel.add(labelProjectAddIcon);
		
		
		JPanel taskHeaderPanel = new JPanel();
		taskHeaderPanel.setBackground(Color.WHITE);
		taskHeaderPanel.setBounds(228, 251, 695, 50);
		frame.getContentPane().add(taskHeaderPanel);
		taskHeaderPanel.setLayout(null);
		
		JLabel taskHeaderLabel = new JLabel("TAREFAS");
		taskHeaderLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		taskHeaderLabel.setBounds(10, 11, 102, 28);
		taskHeaderPanel.add(taskHeaderLabel);
		
		JLabel labelAddTaskIcon = new JLabel("");
		labelAddTaskIcon.setBounds(139, 0, 59, 50);
		ImageIcon addTaskIcon = new ImageIcon("C:\\\\\\\\Users\\\\\\\\Usuario\\\\\\\\Documents\\\\\\\\JAVA\\\\\\\\JAVA_APPS\\\\\\\\TodoApp\\\\\\\\src\\\\\\\\img\\\\\\\\addIcon.png");
		Image imageAddTaskIcon = addTaskIcon.getImage();
		Image addTaskIconScale = imageAddTaskIcon.getScaledInstance(labelAddTaskIcon.getWidth(), labelAddTaskIcon.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleTaskIcon = new ImageIcon(addTaskIconScale);
		labelAddTaskIcon.setIcon(scaleTaskIcon);
		
		taskHeaderPanel.add(labelAddTaskIcon);
		
		JPanel projectBodyPanel = new JPanel();
		projectBodyPanel.setBackground(Color.WHITE);
		projectBodyPanel.setBounds(10, 306, 208, 530);
		frame.getContentPane().add(projectBodyPanel);
		projectBodyPanel.setLayout(null);
		
		JPanel projectBodyTask = new JPanel();
		projectBodyTask.setBackground(Color.WHITE);
		projectBodyTask.setBounds(228, 306, 695, 530);
		frame.getContentPane().add(projectBodyTask);
		projectBodyTask.setLayout(null);
		
	}
}
