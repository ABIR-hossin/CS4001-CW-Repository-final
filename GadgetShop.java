import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GadgetShop extends JFrame implements ActionListener
{
    private ArrayList<Gadget> gadgets;

    // Text fields
    private JTextField modelField, priceField, weightField, sizeField;
    private JTextField creditField, memoryField;
    private JTextField phoneField, durationField, downloadField, displayField;

    // Buttons
    private JButton addMobileBtn, addMP3Btn, clearBtn;
    private JButton displayBtn, callBtn, downloadBtn;

    public GadgetShop()
    {
        gadgets = new ArrayList<>();

        setTitle("Gadget Shop");
        setSize(700, 500);
        setLayout(new GridLayout(0, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Input fields
        add(new JLabel("Model:"));
        modelField = new JTextField();
        add(modelField);

        add(new JLabel("Price:"));
        priceField = new JTextField();
        add(priceField);

        add(new JLabel("Weight:"));
        weightField = new JTextField();
        add(weightField);

        add(new JLabel("Size:"));
        sizeField = new JTextField();
        add(sizeField);

        add(new JLabel("Initial Credit (Mobile):"));
        creditField = new JTextField();
        add(creditField);

        add(new JLabel("Initial Memory (MP3):"));
        memoryField = new JTextField();
        add(memoryField);

        add(new JLabel("Phone Number:"));
        phoneField = new JTextField();
        add(phoneField);

        add(new JLabel("Call Duration:"));
        durationField = new JTextField();
        add(durationField);

        add(new JLabel("Download Size:"));
        downloadField = new JTextField();
        add(downloadField);

        add(new JLabel("Display Number:"));
        displayField = new JTextField();
        add(displayField);

        // Buttons
        addMobileBtn = new JButton("Add Mobile");
        addMobileBtn.addActionListener(this);
        add(addMobileBtn);

        addMP3Btn = new JButton("Add MP3");
        addMP3Btn.addActionListener(this);
        add(addMP3Btn);

        displayBtn = new JButton("Display All");
        displayBtn.addActionListener(this);
        add(displayBtn);

        callBtn = new JButton("Make A Call");
        callBtn.addActionListener(this);
        add(callBtn);

        downloadBtn = new JButton("Download Music");
        downloadBtn.addActionListener(this);
        add(downloadBtn);

        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(this);
        add(clearBtn);

        setVisible(true);
    }

    // Handle buttons
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == addMobileBtn)
            addMobile();
        else if (e.getSource() == addMP3Btn)
            addMP3();
        else if (e.getSource() == displayBtn)
            displayAll();
        else if (e.getSource() == callBtn)
            makeCall();
        else if (e.getSource() == downloadBtn)
            downloadMusic();
        else if (e.getSource() == clearBtn)
            clearFields();
    }

    // Add Mobile
    private void addMobile()
    {
        try {
            Mobile m = new Mobile(
                modelField.getText(),
                Double.parseDouble(priceField.getText()),
                Integer.parseInt(weightField.getText()),
                sizeField.getText(),
                Integer.parseInt(creditField.getText())
            );
            gadgets.add(m);
            JOptionPane.showMessageDialog(this, "Mobile added!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input.");
        }
    }

    // Add MP3
    private void addMP3()
    {
        try {
            MP3 mp3 = new MP3(
                modelField.getText(),
                Double.parseDouble(priceField.getText()),
                Integer.parseInt(weightField.getText()),
                sizeField.getText(),
                Integer.parseInt(memoryField.getText())
            );
            gadgets.add(mp3);
            JOptionPane.showMessageDialog(this, "MP3 added!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input.");
        }
    }

    // Display All
    private void displayAll()
    {
        for (int i = 0; i < gadgets.size(); i++) {
            System.out.println("Gadget " + i);
            gadgets.get(i).display();
            System.out.println("-------------------");
        }
    }

    // Get display number safely
    private int getDisplayNumber()
    {
        try {
            int num = Integer.parseInt(displayField.getText());
            if (num >= 0 && num < gadgets.size())
                return num;
            else
                JOptionPane.showMessageDialog(this, "Number out of range.");
        } catch (NumberFormatException e) 
        {
            {  
              JOptionPane.showMessageDialog(this, "Enter a valid number.");
            }
         }
        return -1;
    }

    // Make a call
    private void makeCall()
    {
        int index = getDisplayNumber();
        if (index != -1 && gadgets.get(index) instanceof Mobile) {
            Mobile m = (Mobile) gadgets.get(index);
            m.makeCall(phoneField.getText(),
                       Integer.parseInt(durationField.getText()));
        }
    }

    // Download music
    private void downloadMusic()
{
    int index = getDisplayNumber();

    if (index != -1 && gadgets.get(index) instanceof MP3)
    {
        MP3 mp3 = (MP3) gadgets.get(index);

        try
        {
            int size = Integer.parseInt(downloadField.getText());
            mp3.downloadMusic(size);
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Enter a valid download size");
        }
        {
            JOptionPane.showMessageDialog(this, "Enter a valid number");
        }
    }
}

    // Clear fields
    private void clearFields()
    {
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        phoneField.setText("");
        durationField.setText("");
        downloadField.setText("");
        displayField.setText("");
    }

    public static void main(String[] args)
    {
        new GadgetShop();
    }
}
