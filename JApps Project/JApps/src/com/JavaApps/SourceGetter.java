package com.JavaApps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SourceGetter extends JFrame implements ActionListener {
    JTextField tf;
    JTextArea ta;
    JButton b;
    JLabel l;

    SourceGetter() {
        super("Source Getter Tool - JTP");
        l = new JLabel("Enter Website URL:");
        l.setBounds(50, 50, 250, 20);

        tf = new JTextField("linkedin.com/in/rushikesh-gaikwad6219");
        tf.setBounds(50, 100, 250, 20);

        b = new JButton("Get Source Code");
        b.setBounds(50, 150, 180, 30);
        b.addActionListener(this);

        ta = new JTextArea();
        JScrollPane sp = new JScrollPane(ta);
        sp.setBounds(50, 200, 350, 250);

        add(l);
        add(tf);
        add(b);
        add(sp);
        setSize(500, 500);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = tf.getText();
        if (s == null) {
        } else {
            try {
                URL u = new URL(s);
                URLConnection uc = u.openConnection();

                InputStream is = uc.getInputStream();
                int i;
                StringBuilder sb = new StringBuilder();
                while ((i = is.read()) != -1) {
                    sb.append((char) i);
                }
                String source = sb.toString();
                ta.setText(source);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Exception: " + ex);
            }
        }
    }

    public static void main(String[] args) {
        new SourceGetter();
    }
}