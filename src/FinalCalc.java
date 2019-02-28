import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
//TODO: Make sure two decimal place, check combo box, String check. GOOD LUCK MAN
public class FinalCalc extends JFrame {
    String acceptedChars="1 2 3 4 5 6 7 8 9 0";
    public static final String ALPHA = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String[] accepChar=acceptedChars.split(" ");
    ArrayList<JTextField> terms;
    JLabel totalWeightLabel=new JLabel("Total Term Weight: ");
    JTextField totalWeight=new JTextField();
    JLabel finalWeightLabel=new JLabel("Final Weight: ");
    JTextField finalWeight=new JTextField();
    JLabel gradeWantedLabel=new JLabel("Final Weight: ");
    JTextField gradeWanted=new JTextField();
    JTextField result=new JTextField();
    JLabel resultLabel=new JLabel("Grade Needed:");
    JTextField term1=new JTextField();
    JLabel term1Label=new JLabel("Term 1:");
    JTextField term2=new JTextField();
    JLabel term2Label=new JLabel("Term 2:");
    JTextField term3=new JTextField();
    JLabel term3Label=new JLabel("Term 3:");
    JTextField term4=new JTextField();
    JLabel term4Label=new JLabel("Term 4:");
    JTextField term5=new JTextField();
    JLabel term5Label=new JLabel("Term 5:");
    JButton calculate=new JButton("Calculate");
    JButton clear=new JButton("Clear");
    JLabel noOfTerms=new JLabel("Number of Terms:");
    Integer[] termNos={1,2,3,4,5};
    JComboBox termList;
    Font font;

    public FinalCalc() {
        super("K0904676");
        font = new Font("Monotype Corsiva", Font.BOLD,24);
        termList=new JComboBox(termNos);
        termList.setSelectedIndex(0);
        terms=new ArrayList<JTextField>(Arrays.asList(term1,term2,term3,term4,term5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,650);
        setLayout(null);
        setVisible(true);

        totalWeightLabel.setFont(font);
        totalWeight.setFont(font);
        totalWeightLabel.setBounds(0,20,200,40);
        totalWeight.setBounds(200,20,150,40);

        finalWeightLabel.setFont(font);
        finalWeight.setFont(font);
        noOfTerms.setFont(font);
        termList.setFont(font);
        gradeWantedLabel.setFont(font);
        gradeWanted.setFont(font);
        finalWeightLabel.setBounds(0,70,200,40);
        finalWeight.setBounds(200,70,150,40);
        termList.setBounds(200, 120, 150,40);
        noOfTerms.setBounds(0,120,200,40);
        gradeWanted.setBounds(200, 170,150,40);
        gradeWantedLabel.setBounds(0,170,150,40);
        term1.setBounds(200,230,150,30);
        term2.setBounds(200,270,150,30);
        term3.setBounds(200,310,150,30);
        term4.setBounds(200,350,150,30);
        term5.setBounds(200,390,150,30);
        term1Label.setFont(font);
        term1.setFont(font);
        term2Label.setFont(font);
        term2.setFont(font);
        term3Label.setFont(font);
        term3.setFont(font);
        term4Label.setFont(font);
        term4.setFont(font);
        term5Label.setFont(font);
        term5.setFont(font);
        term1Label.setBounds(125,225,200,40);
        term2Label.setBounds(125,265,200,40);
        term3Label.setBounds(125,305,200,40);
        term4Label.setBounds(125,345,200,40);
        term5Label.setBounds(125,385,200,40);
        calculate.setFont(font);
        clear.setFont(font);

        calculate.setBounds(25,450,335,40);
        clear.setBounds(25,500,335,40);
        result.setBounds(205,550,130,40);
        resultLabel.setBounds(75,550,75,40);

        resultLabel.setFont(font);
        calculate.addActionListener(e -> process(e));
        clear.addActionListener(e -> process(e));
        termList.addActionListener(e -> process(e));
        term1.addActionListener(e -> process(e));
        term2.addActionListener(e -> process(e));
        term3.addActionListener(e -> process(e));
        term4.addActionListener(e -> process(e));
        term5.addActionListener(e -> process(e));
        finalWeight.addActionListener(e -> process(e));
        totalWeight.addActionListener(e -> process(e));
        gradeWanted.addActionListener(e -> process(e));
        add(totalWeight);
        add(totalWeightLabel);
        add(finalWeight);
        add(finalWeightLabel);
        add(termList);
        add(noOfTerms);
        add(gradeWanted);
        add(gradeWantedLabel);
        add(term1);
        add(term2);
        add(term3);
        add(term4);
        add(term5);
        add(term1Label);
        add(term2Label);
        add(term3Label);
        add(term4Label);
        add(term5Label);
        add(calculate);
        add(clear);
        add(result);
        add(resultLabel);

    }

    public void process(ActionEvent e) {
        boolean stringFound=false;
        try {
            for (int x = (Integer) termList.getSelectedItem(); x < 5; x++) {
                terms.get(x).setText("");
                terms.get(x).setEditable(false);
            }
            for (int x = (Integer) termList.getSelectedItem()-1; x >=0; x--) {
                terms.get(x).setEditable(true);
            }
        }catch (Exception y) {y.printStackTrace();}
        if(e.getActionCommand().equals("Clear")) {
            term1.setText("");
            term2.setText("");
            term3.setText("");
            term4.setText("");
            term5.setText("");
            finalWeight.setText("");
            totalWeight.setText("");
            gradeWanted.setText("");
            termList.setSelectedIndex(0);
        }


        if(e.getActionCommand().equals("Calculate")) {
            if(textFilterer(term1.getText())==null||textFilterer(term2.getText())==null||
                    textFilterer(term3.getText())==null){

            }
        }
    }
    public Double textFilterer(String s) {
        for(int x=0;x<ALPHA.length();x++) {
            if(s.equals(ALPHA.charAt(x)+"")) {
                return null;
            }
        }
        if(!(s==null)) {
            if (!s.equals("")) {
                return Double.parseDouble(s);
            }
        }
        return null;
    }
}

