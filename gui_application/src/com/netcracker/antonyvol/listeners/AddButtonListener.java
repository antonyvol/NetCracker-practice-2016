package com.netcracker.antonyvol.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by antonyvol on 26.03.16.
 */

/*
    TODO
    Слушатель кнопки добавления нового резюме
 */

public class AddButtonListener implements ActionListener {
    public AddButtonListener() {}

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("add button clicked!");
    }
}
