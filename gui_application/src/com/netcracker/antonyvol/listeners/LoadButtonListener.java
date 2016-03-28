package com.netcracker.antonyvol.listeners;

import com.netcracker.antonyvol.cv.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by antonyvol on 26.03.16.
 */

/*
    Слушатель кнопки загрузки, про нажатии которой
    записывает резюме в экземпляр CV и выводит диалоговое
    окно с его содержимым
 */

public class LoadButtonListener implements ActionListener{
    public LoadButtonListener() {}

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        /*
            Осторожно, путь захардкожен, нужно сменить
         */
        CV cv = new CV("/home/antonyvol/IdeaProjects/gui_application/src/test_cv");

        JDialog dialog = new JDialog();
        dialog.setTitle(cv.getFullname());
        dialog.setSize(350, 300);
        dialog.setModal(true);

        dialog.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        for (int i = 0 ; i < 6 ; i++) {
            JPanel temp = new JPanel();
            switch (i) {
                case 0:
                    temp.add(new JLabel("ФИО: "));
                    temp.add(new JLabel(cv.getFullname()));
                    break;
                case 1:
                    temp.add(new JLabel("Пол: "));
                    temp.add(new JLabel(cv.getGender().equals("MALE") ? "Мужской" : "Женский"));
                    break;
                case 2:
                    temp.add(new JLabel("Дата рождения: "));
                    temp.add(new JLabel(cv.getBirthdate()));
                    break;
                case 3:
                    temp.add(new JLabel("Желаемая должность: "));
                    temp.add(new JLabel(cv.getJob()));
                    break;
                case 4:
                    temp.add(new JLabel("Желаемая зарплата: "));
                    temp.add(new JLabel(String.valueOf(cv.getSalary())));
                    break;
                case 5:
                    temp.add(new JLabel("О себе: "));
                    temp.add(new JLabel(cv.getAbout()));
                    break;
            }
            c.gridy = i;
            dialog.add(temp, c);
        }

        dialog.show();
    }
}
