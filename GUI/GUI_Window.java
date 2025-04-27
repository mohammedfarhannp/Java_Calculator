// Package
package GUI;

// Importing classes
import javax.swing.*; // classes for window

// Classes for handling events like button clicks or menu selections in GUIs
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Class for color
import java.awt.Color;

// Window Class
public class GUI_Window
{
    // Set Global Variable
    public JFrame Window;

    // Constructor of Window class
    public GUI_Window(String Frame_Name, int Width, int Hieght)
    {
        // Window Name and Size Set
        this.Window = new JFrame(Frame_Name);
        this.Window.setSize(Width, Hieght);

        // Window Close Operation Set
        this.Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // For Manual Placement of elements
        this.Window.setLayout(null);

    }

    // Public method for rendering window
    public void Render_Window()
    {
        // Makes the window visible
        this.Window.setVisible(true);
    }

    // Public method for adding button
    public JButton Add_Button(String Button_Name, int x, int y, int width, int height)
    {
        // Button Name, Size, Coordinates
        JButton Button = new JButton(Button_Name);
        Button.setBounds(x, y, width, height);

        // Adds Button to window
        this.Window.add(Button);

        // Return Button Object for further manipulation
        return Button;
    }

    // Public method for adding text field
    public JTextField Add_Text_Field(int Columns, int x, int y, int width, int height)
    {
        // TextField Columns, Size, Coordinates
        JTextField TextField = new JTextField(Columns);
        TextField.setBounds(x, y, width, height);

        // Adds Text Field to window
        this.Window.add(TextField);

        // Return TextField Object for further manipulation
        return TextField;
    }

    // Public method for updating window
    public void Update()
    {
        this.Window.repaint();
    }
}

