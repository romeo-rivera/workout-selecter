import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EnumMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainWindow {
  
  private final JFrame mainFrame = new JFrame(Config.APPLICATIONNAME);
  private final JDialog selectWorkout = new JDialog(mainFrame, "Select Workout");
  private JComboBox<String> cboType, cboGoal;
  private JSpinner spnDuration;
  private final Workouts workouts;
  private final EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> muscleGroups;
  
  private JButton JBtop = new JButton("Upper Body Workout"); 
	private JButton JBmid = new JButton("Lower Body Workout"); 
	private JButton JBbot = new JButton("Whole Body Workout"); 


  MainWindow(Workouts workouts, EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> muscleGroups) {
  	this.workouts = workouts;
  	this.muscleGroups = muscleGroups;  	
  	launchHomeScreen();
  }
  
  private void launchHomeScreen() {
  	JPanel jp = new JPanel();
  	jp.setLayout(null);
  	ImageIcon img = new ImageIcon("data/jframePic.jpeg");
  	mainFrame.setIconImage(img.getImage());
  	JButton JBtop = new JButton("Upper Body Workout"); 
  	JBtop.setBounds(0, 0, 600, 120);
    JBtop.addActionListener(new ButtonListener());
  	JButton JBmid = new JButton("Lower Body Workout"); 
  	JBmid.setBounds(0, 120, 600, 120);
  	JBmid.addActionListener(new ButtonListener());
  	JButton JBbot = new JButton("Whole Body Workout"); 
  	JBbot.setBounds(0, 245, 600, 120);
  	JBbot.addActionListener(new ButtonListener());
  	jp.add(JBtop);
  	jp.add(JBmid);
  	jp.add(JBbot);
  	mainFrame.add(jp);
  	mainFrame.setSize(600,400);
  	mainFrame.setVisible(true);
  }
  private class ButtonListener implements ActionListener{
  	public void actionPerformed(ActionEvent e){
  		String actionCommand = e.getActionCommand();
  		if (actionCommand.equals("Upper Body Workout")){
  			showWorkouts(muscleGroups.get(Config.MuscleGroup.UPPERBODY));
  			return; 
  		}
  		if (actionCommand == "Lower Body Workout"){
  			showWorkouts(muscleGroups.get(Config.MuscleGroup.LOWERBODY));
  			return;
  		}
  		if (actionCommand.equals("Whole Body Workout")){
  			showWorkouts(muscleGroups.get(Config.MuscleGroup.WHOLEBODY));
  			return; 
  		}
  		mainFrame.setVisible(true);
  	}
  }
  private void showWorkouts(ArrayList<Config.Muscle> muscles) {
  	WorkoutsPanel wpanel = new WorkoutsPanel(muscles,workouts);
  	mainFrame.getContentPane().removeAll();
  	mainFrame.add(wpanel);
  	mainFrame.pack();
  	mainFrame.setSize(600,400);
  	mainFrame.setVisible(true);
  // Code goes here.
  }
}
