// Calculator Program

// Importing classes
import javax.swing.*; // classes for window

// Classes for handling events like button clicks or menu selections in GUIs
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Class for color
import java.awt.Color;

// GUI Window class ( Custom Class ) // MathBox class ( Custom Class )
import GUI.GUI_Window;
import GUI.MathBox;

// Main Class
class main {
    // Main method of main class
    public static void main(String[] args)
    {
        // Creating and Rendering a window with custom class
        GUI_Window Win = new GUI_Window("Calculator", 400, 600);
        Win.Render_Window();

        // Adding a Text Field to window using the custom class instance
        JTextField Text_Field = Win.Add_Text_Field(20, 100, 100, 200, 30);
        Text_Field.setBackground(Color.LIGHT_GRAY);

        // Buttons from 0 - 9
        int x_pos = 100, y_pos = 200, j; // Variable Positions for iteration

        for(int i = 1; i <= 10; i++)
        {
            if(i == 10)
            {
                j = 0;
                x_pos += 50;
            } else {
                j = i;
            }

            // final int for safe use in inner anonymous class for button functionality below
            final int value = j;

            // Button Object Creation
            JButton btn = Win.Add_Button(""+j, x_pos, y_pos, 45, 40);

            // Change in Position for next Button placement
            x_pos += 50;
            if(i % 3 == 0)
            {
                x_pos = 100;
                y_pos += 50;
            }

            // Adding Functionality to Buttons
            btn.addActionListener(new ActionListener() {
                // @Override is used to override a method of superclass with the below method
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    // Perform Action When Button Clicked
                    String Field_Text = Text_Field.getText() + "" + value;
                    Text_Field.setText(Field_Text);
                }
            });
        }

        // Adding Arithmetic Operation Buttons +, -, /, *, (, )
        String Symbols[] = {"+", "-", "/", "*", "(",")"};

        y_pos = 200;
        for(String Symbol : Symbols)
        {
            final String value = Symbol;
            JButton btn = Win.Add_Button(value, 280, y_pos, 60, 40);
            y_pos += 50;

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String Field_Text = Text_Field.getText() + "" + value;
                    Text_Field.setText(Field_Text);
                }
            });
        }

        // Compute Button
        JButton Compute_Btn = Win.Add_Button("Compute", 100, 450, 150, 40);

        Compute_Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MathBox Compute_Engine = new MathBox();
                String Expression = Text_Field.getText();
                try {
                    double Computation = Compute_Engine.parse(Expression);
                    Text_Field.setText(""+Computation);
                } catch (RuntimeException err) {
                    Text_Field.setText("SyNtAx ErRoR!");
                }
            }
        });

        // All Clear Button
        JButton AC_Btn = Win.Add_Button("AC", 100, 400, 150, 40);

        AC_Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Text_Field.setText("");
            }
        });

        // Update Window
        Win.Update();

    }

}


