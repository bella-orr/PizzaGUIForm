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
    JScrollPane receiptPnl;
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

    //for JoptionPane
    int reply;

    //ints for selected
    int selSize;
    int amountToppings;
    int selTopping = 0;
    

    public PizzaGUIFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new GridLayout(5,1));

        createSizePnl();
        mainPnl.add(sizePnl);

        createCrustPnl();
        mainPnl.add(crustPnl);

        createToppingsPnl();
        mainPnl.add(toppingsPnl);

        createReceiptPnl();
        mainPnl.add(receiptPnl);

        createButtonPnl();
        mainPnl.add(buttonPnl);


        add(mainPnl);
        setTitle("Pizza GUI Order");
        setSize(900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createSizePnl()
    {
        sizePnl = new JPanel();

        //border created for SizePnl
        sizePnl.setBorder(new TitledBorder((new LineBorder(black, 4 )), "Pick A Size!"));

        String sizes[] = {"Small","Medium", "Large", "Super"};
        sizeSelect = new JComboBox(sizes);

        sizePnl.add(sizeSelect);
    }

    private void createCrustPnl()
    {
        crustPnl = new JPanel();

        //border created for CrustPnl
        crustPnl.setBorder(new TitledBorder((new LineBorder(black, 4 )), "Pick A Crust!"));

        //initialize the buttons
        thinCrust = new JRadioButton("Thin");
        regularCrust = new JRadioButton("Regular");
        deepDishCrust = new JRadioButton("Deep Dish");

        crustPnl.add(thinCrust);
        crustPnl.add(regularCrust);
        crustPnl.add(deepDishCrust);

    }

    private void createToppingsPnl()
    {
        toppingsPnl = new JPanel();

        toppingsPnl.setBorder(new TitledBorder((new LineBorder(black, 4 )), "Pick Some Toppings!"));

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

        getTotalToppings();

    }

    private void getTotalToppings() {
    }


    private void createReceiptPnl()
    {
        receiptPnl = new JScrollPane();

        receipt = new JTextArea(40,50);
        receipt.setEditable(false);

        receiptPnl.setBorder(new TitledBorder((new LineBorder(black, 4 )), "Receipt:"));


        scroller = new JScrollPane(receipt);
        receiptPnl.add(scroller);

    }

    private void createButtonPnl()
    {
        buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridLayout(1,3));

        orderbtn = new JButton("Order Now!");
        orderbtn.addActionListener((ActionEvent ae) -> calcTotal());

        clearbtn = new JButton("Clear Order");

        quitbtn = new JButton("Quit");
        quitbtn.addActionListener((ActionEvent ae) -> quitProgram());

        buttonPnl.add(orderbtn);

        buttonPnl.add(clearbtn);

        buttonPnl.add(quitbtn);
    }

    private void calcTotal()
    {

    }

    private void quitProgram()
    {
        reply=JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?");

        if (reply == JOptionPane.YES_OPTION) //resets board
        {
            System.exit(0);
        }

    }




}
