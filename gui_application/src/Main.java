import com.netcracker.antonyvol.listeners.*;
import javax.swing.*;
import java.awt.*;

/*
    CV tool v0.01
    Программа, позволяющая считывать резюме
    из файла и записывать его в файл
    Представляет собой фрейм с панелью из двух кнопок
    Load CV - выводит резюме из файла
    Add CV - добавляет резюме в файл (не реализовано)
 */

public class Main {

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("CV tool v0.01");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        frame.setLayout(new GridBagLayout());

        JButton addButton = new JButton("Add CV");
        JButton loadButton = new JButton("Load CV");

        addButton.addActionListener(new AddButtonListener());
        loadButton.addActionListener(new LoadButtonListener());

        JPanel panel = new JPanel(new GridLayout(1, 2, 5, 0));
        panel.add(addButton);
        panel.add(loadButton);

        frame.add(panel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}