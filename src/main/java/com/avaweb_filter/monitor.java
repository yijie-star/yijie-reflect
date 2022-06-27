package com.avaweb_filter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class monitor {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("记事本");
        jFrame.setSize(500,200);

        jFrame.setLocation(200,200);
        jFrame.setLayout(new FlowLayout());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btn = new JButton("确定");
        jFrame.add(btn, BorderLayout.NORTH);

        //监听器
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("HEllo");
            }
        });

        jFrame.setVisible(true);
    }
}
