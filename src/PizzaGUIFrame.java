//imports
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.*;

import static java.awt.Color.black;

public class PizzaGUIFrame extends JFrame
{
    //Declarations

    //JPanels
    JPanel mainPnl;
    JPanel sizePnl;
    JPanel crustPnl;
    JPanel toppingsPnl;
    JPanel receiptPnl;
    JPanel buttonPnl;
    JPanel bottomPnl;

    //JButtons
    JButton orderbtn;
    JButton clearbtn;
    JButton quitbtn;

    //JRadioButtons
    JRadioButton thinCrust;
    JRadioButton regularCrust;
    JRadioButton deepDishCrust;
    JRadioButton invisibleButton;

    //Button Group
    ButtonGroup crustButtons;

    //JComboBox
    JComboBox sizeSelect;

    //JCheckBoxes
    JCheckBox pepBox;
    JCheckBox oliveBox;
    JCheckBox mushroomBox;
    JCheckBox pineappleBox;
    JCheckBox hamBox;
    JCheckBox pepperBox;

    //JScroller
    JScrollPane scroller;

    //JTextAres
    JTextArea receipt;

    //booleans
    boolean crustSelected;


    //for JoptionPane
    int reply;

    double beforeTax = 0;
    double toppingsTotal = 0;
    double sizePrice = 0;
    double taxTotal = 0;
    double finalTotal = 0;

    

    public PizzaGUIFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createSizePnl();
        mainPnl.add(sizePnl, BorderLayout.WEST);

        createCrustPnl();
        mainPnl.add(crustPnl, BorderLayout.CENTER);

        createToppingsPnl();
        mainPnl.add(toppingsPnl, BorderLayout.EAST);

        createBottomPnl();
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);


        add(mainPnl);
        setTitle("Pizza GUI Order");
        setSize(900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createBottomPnl()
    {
        bottomPnl = new JPanel();
        bottomPnl.setLayout(new BorderLayout());
        bottomPnl.setPreferredSize(new Dimension(900, 450));

        createReceiptPnl();
        createButtonPnl();

        bottomPnl.add(receiptPnl, BorderLayout.NORTH);
        bottomPnl.add(buttonPnl, BorderLayout.SOUTH);
    }

    private void createSizePnl()
    {
        sizePnl = new JPanel();

        //border created for SizePnl
        sizePnl.setBorder(new TitledBorder((new LineBorder(black, 4 )), "Pick A Size!"));
        sizePnl.setPreferredSize(new Dimension(300, 300));

        String sizes[] = {"","Small","Medium", "Large", "Super"};
        sizeSelect = new JComboBox(sizes);

        sizePnl.add(sizeSelect);
    }


    private void createCrustPnl()
    {
        crustPnl = new JPanel();

        //border created for CrustPnl
        crustPnl.setBorder(new TitledBorder((new LineBorder(black, 4 )), "Pick A Crust!"));
        crustPnl.setPreferredSize(new Dimension(300, 300));

        //initialize the buttons
        thinCrust = new JRadioButton("Thin");
        regularCrust = new JRadioButton("Regular");
        deepDishCrust = new JRadioButton("Deep Dish");

        invisibleButton = new JRadioButton();
        invisibleButton.setVisible(false);
        invisibleButton.setSelected(false);

        crustButtons = new ButtonGroup();

        crustButtons.add(invisibleButton);
        crustButtons.add(thinCrust);
        crustButtons.add(regularCrust);
        crustButtons.add(deepDishCrust);

        crustPnl.add(thinCrust);
        crustPnl.add(regularCrust);
        crustPnl.add(deepDishCrust);

    }

    private void createToppingsPnl()
    {
        toppingsPnl = new JPanel();

        toppingsPnl.setBorder(new TitledBorder((new LineBorder(black, 4 )), "Pick Some Toppings!"));
        toppingsPnl.setPreferredSize(new Dimension(300, 300));

        toppingsPnl.setLayout(new FlowLayout());

        pepBox = new JCheckBox("Pepperoni");
        oliveBox = new JCheckBox("Olives");
        mushroomBox = new JCheckBox("Mushrooms");
        pineappleBox = new JCheckBox("Pineapple");
        hamBox = new JCheckBox("Ham");
        pepperBox = new JCheckBox("Peppers");

        toppingsPnl.add(pepBox);
        toppingsPnl.add(oliveBox);
        toppingsPnl.add(mushroomBox);
        toppingsPnl.add(pineappleBox);
        toppingsPnl.add(hamBox);
        toppingsPnl.add(pepperBox);

    }


    private void createReceiptPnl()
    {
        receiptPnl = new JPanel();
        receiptPnl.setPreferredSize(new Dimension(900, 400));

        receipt = new JTextArea(20,40);
        receipt.setEditable(false);

        receiptPnl.setBorder(new TitledBorder((new LineBorder(black, 4 )), "Receipt:"));


        scroller = new JScrollPane(receipt);
        receiptPnl.add(scroller);

    }

    private void createButtonPnl()
    {
        buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridLayout(1,3));
        buttonPnl.setPreferredSize(new Dimension(900, 50));

        orderbtn = new JButton("Order Now!");
        orderbtn.addActionListener((ActionEvent ae) ->
                validInput());

        clearbtn = new JButton("Clear Order");
        clearbtn.addActionListener((ActionEvent ae) -> clearBoard());

        quitbtn = new JButton("Quit");
        quitbtn.addActionListener((ActionEvent ae) -> quitProgram());

        buttonPnl.add(orderbtn);

        buttonPnl.add(clearbtn);

        buttonPnl.add(quitbtn);
    }

    private void makeReceipt()
    {
        beforeCalcTotal();
        plusTax();

        receipt.append("\n=======================================");

        receipt.append(String.format("\n%-10s%8s%36.2f", sizeSelect.getSelectedItem(),getJButton(), sizePrice));

        receipt.append("\n");

        if(pepBox.isSelected())
        {
            receipt.append("\nPepperoni"+ String.format("%51s", "1.00"));
        }
        if(mushroomBox.isSelected())
        {

            receipt.append("\nMushrooms"+ String.format("%49s", "1.00"));
        }
        if(pineappleBox.isSelected())
        {
            receipt.append("\nPineapple"+ String.format("%51s", "1.00"));
        }
        if(hamBox.isSelected())
        {
            receipt.append("\nHam"+ String.format("%60s", "1.00"));
        }
        if(oliveBox.isSelected())
        {
            receipt.append("\nOlives"+ String.format("%57s", "1.00"));
        }
        if(pepperBox.isSelected())
        {
            receipt.append("\nPeppers"+ String.format("%54s", "1.00"));
        }

        receipt.append("\n");
        receipt.append("\n");

        receipt.append("\n"+ String.format("%-25s%37.2f", "Sub Total: ", beforeTax));
        receipt.append("\n"+ String.format("%-25s%40.2f", "Tax: ", taxTotal));
        receipt.append("\n------------------------------------------------------------------------");
        receipt.append("\n"+ String.format("%-25s%40.2f", "Total: ", finalTotal));
        receipt.append("\n=======================================");

    }

    private String getJButton()
    {
        crustSelected = false;

        if (thinCrust.isSelected())
        {
            crustSelected = true;

            return "Thin";
        }

        if (regularCrust.isSelected())
        {
            crustSelected = true;

            return "Regular";
        }

        if (deepDishCrust.isSelected())
        {
            crustSelected = true;

            return "Deep Dish";
        }

        crustSelected = false;
        return "n/a";
    }

    private void beforeCalcTotal()
    {
         toppingsTotal= 0;

        if(pepBox.isSelected())
        {
            toppingsTotal++;
        }

        if(oliveBox.isSelected())
        {
            toppingsTotal++;
        }

        if(mushroomBox.isSelected())
        {
            toppingsTotal++;
        }

        if(pineappleBox.isSelected())
        {
            toppingsTotal++;
        }

        if(hamBox.isSelected())
        {
            toppingsTotal++;
        }

        if(pepperBox.isSelected())
        {
            toppingsTotal++;
        }


        //gets price based on size
        if(sizeSelect.getSelectedItem()=="Small")
        {
            sizePrice = 8.00;
        }

        if(sizeSelect.getSelectedItem()=="Medium")
        {
            sizePrice = 12.00;
        }

        if(sizeSelect.getSelectedItem()=="Large")
        {
            sizePrice = 16.00;
        }

        if(sizeSelect.getSelectedItem()=="Super")
        {
            sizePrice = 20.00;
        }




       beforeTax = sizePrice + toppingsTotal;

    }

    private void validInput()
    {
        getJButton();
        beforeCalcTotal();

        if(crustSelected==true && sizePrice > 0 && toppingsTotal > 0)
        {
            makeReceipt();
        }

        else
        {
            JOptionPane.showMessageDialog(null,"Please Select a Size, Crust, and Topping");
        }
    }

    private void plusTax()
    {
        beforeCalcTotal();

        taxTotal = beforeTax * 0.07;
        finalTotal = taxTotal + beforeTax;
    }

    private void quitProgram()
    {
        reply=JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?");

        if (reply == JOptionPane.YES_OPTION) //resets board
        {
            System.exit(0);
        }

    }

    private void clearBoard()
    {
        //clears sizeSelect
            sizeSelect.setSelectedIndex(0);

        //clears crust

            thinCrust.setSelected(false);
            regularCrust.setSelected(false);
            deepDishCrust.setSelected(false);
            invisibleButton.setSelected(true);

        //clears toppings
            pepBox.setSelected(false);
            oliveBox.setSelected(false);
            pepperBox.setSelected(false);
            pineappleBox.setSelected(false);
            hamBox.setSelected(false);
            mushroomBox.setSelected(false);

         //clear JTextArea
        receipt.selectAll();
        receipt.replaceSelection("");

            beforeTax = 0;
            toppingsTotal = 0;
            sizePrice = 0;
            crustSelected = false;


    }




}
