import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private int width = 1024;
    private int height = 600;
    private int posX = 150;
    private int posY = 100;

    private JButton buttonStart;
    private JButton buttonExit;

    private JPanel mainToolsPanel;
    private JPanel settingsPanel;

    private Map map;



    GameWindow() {
        prepareWindow();
        prepareToolPanel();
        prepareButtons();
        prepareSettingsPanel();

        map = new Map();

        mainToolsPanel.add(settingsPanel,BorderLayout.NORTH);

        add(mainToolsPanel, BorderLayout.EAST);
        add(map);


        setVisible(true);

    }

    private void prepareWindow() {
        setSize(width, height);
        setLocation(posX, posY);
        setTitle("Application");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void prepareToolPanel() {
        mainToolsPanel = new JPanel();
        mainToolsPanel.setBackground(Color.orange);
        mainToolsPanel.setLayout(new GridLayout(2, 1));
    }

    private void prepareButtons() {
        buttonStart =new JButton("Start game");
        buttonExit =new JButton("End game");
    }

    private void prepareSettingsPanel() {
        settingsPanel = new JPanel();
        mainToolsPanel.setBackground(Color.blue);
        settingsPanel.setLayout(new GridLayout(4, 1));

        settingsPanel.add(buttonStart);
        settingsPanel.add(buttonExit);
    }

}
