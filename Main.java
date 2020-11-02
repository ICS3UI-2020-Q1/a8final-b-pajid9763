import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JButton countButton;
  JButton resetButton;

  JLabel counterLabel;

  JTextField numberInput;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Counter");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    // initialize the main JPanel
    mainPanel = new JPanel();
    // turn on manual layouts 
    mainPanel.setLayout(null);
    // add the mainPanel to the JFrame 
    frame.add(mainPanel);


    // initialize the JButtons 
    countButton = new JButton("Count");
    resetButton = new JButton("Reset");

    // add an ActionListener to the buttons 
    countButton.addActionListener(this);
    resetButton.addActionListener(this);

    // give the buttons an action command 
    countButton.setActionCommand("count");
    resetButton.setActionCommand("reset");

    // set the location and size of the buttons 
    countButton.setBounds(40, 50, 100, 30);
    resetButton.setBounds(150, 50, 100, 30);

    // add the buttons to the mainPanel 
    mainPanel.add(countButton);
    mainPanel.add(resetButton);


    // create the label 
    counterLabel = new JLabel("Counter:");

    // set the size and location of the label 
    counterLabel.setBounds(40, 100, 80, 30);

    // add the label to the mainPanel 
    mainPanel.add(counterLabel);


    // initialize the JTextField 
    numberInput = new JTextField("0");

    // set the size and location of the JTextField
    numberInput.setBounds(120, 100, 130, 30);

    // disable the JTextField so the user cannot type inside it 
    numberInput.setEnabled(false);

    // add the JTextField to the mainPanel 
    mainPanel.add(numberInput);


    
    }
    // create a method that does the math for the count numbers 1-10
    public void finalCount(){
      // get the text from numberInput 
      String numberInputText = numberInput.getText();
      // convert that String to an int 
      int countNumber = Integer.parseInt(numberInputText);
      
      // if statement says to display num to screen if it is less than 10
      if (countNumber < 10){
        // add 1 to the countNumber
        countNumber++;
        // convert the int to String 
        String countNumberText = String.valueOf(countNumber);
        // set the text of the JTextField to the new number 
        numberInput.setText(countNumberText);

      // if the number is higher than 10, do nothing 
      } else {
    }
    }

    // create a method that will set the text of the JTextField to 0
    public void resetCount(){
      numberInput.setText("0");
    }
      


  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    // if statement for what button was pressed 
    if(command.equals("count")){
      // if count button was pressed call out the finalCount method 
      finalCount();
      
    } else if (command.equals("reset")){
      // if reset button was pressed call out the resetCount method 
      resetCount();
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
