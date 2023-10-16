//imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

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

    //JButtons
    JButton orderbtn;
    JButton clearbtn;
    JButton quitbtn;

    //JScroller
    JScrollPane scroller;

    //JTextAres
    JTextArea receipt;

    public PizzaGUIFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createSizePnl();
        mainPnl.add(sizePnl, BorderLayout.NORTH);

        createCrustPnl();
        mainPnl.add(crustPnl);

        createToppingsPnl();
        mainPnl.add(toppingsPnl);

        createReceiptPnl();
        mainPnl.add(receiptPnl);

        createButtonPnl();
        mainPnl.add(buttonPnl, BorderLayout.SOUTH);

        add(mainPnl);
        setTitle("Pizza GUI Order");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createSizePnl()
    {

    }

    private void createCrustPnl()
    {

    }

    private void createToppingsPnl()
    {

    }

    private void createReceiptPnl()
    {

    }

    private void createButtonPnl()
    {
        buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridLayout(1,3));

        orderbtn = new JButton("Order Now!");

        clearbtn = new JButton("Clear Order");

        quitbtn = new JButton("Quit");


    }
}
