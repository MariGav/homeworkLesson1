import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameWindow extends JFrame {

        private int width = 1024;
        private int height = 600;
        private int posX = 150;
        private int posY = 100;

        private JButton buttonStart;
        private JButton buttonExit;
        private JButton buttonClearLog;

        private final int MIN_SIZE_MAP = 3;
        private final int MAX_SIZE_MAP = 10;
        private final int MIN_WIN_LENGTH = 3;

        private JPanel mainToolsPanel;
        private JPanel settingsPanel;

        private JSlider setupMapSize;
        private JLabel labelMapSize;

        private JSlider setupWinLength;
        private JLabel labelWinLength;

        private JTextArea log;
        private JScrollPane scrollLog;

        private Map map;


        GameWindow() {
            prepareWindow();
            prepareToolPanel();
            prepareButtons();
            prepareSettingsPanel();
            prepareGameLog();

            map = new Map(this);

            mainToolsPanel.add(settingsPanel, BorderLayout.NORTH);
            mainToolsPanel.add(scrollLog, BorderLayout.SOUTH);

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
            mainToolsPanel.setLayout(new GridLayout(2, 1));
        }

        private void prepareButtons() {
            buttonStart = new JButton("Start game");
            buttonStart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    collectSettings();
                }
            });

            buttonExit = new JButton("End game");
            buttonExit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            buttonClearLog = new JButton("Clear");
            buttonClearLog.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    log.setText("");
                }
            });
        }

        private void prepareSettingsPanel() {
            settingsPanel = new JPanel();
            settingsPanel.setLayout(new GridLayout(7, 1));

            labelMapSize = new JLabel("Map size " + MIN_SIZE_MAP + "x" + MIN_SIZE_MAP);
            setupMapSize = new JSlider(MIN_SIZE_MAP, MAX_SIZE_MAP, MIN_SIZE_MAP);
            setupMapSize.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                  int currentPosition = setupMapSize.getValue();
                  labelMapSize.setText("Map size " + currentPosition + "x" + currentPosition);
                  setupWinLength.setMaximum(currentPosition);

                }
            });

            labelWinLength = new JLabel("Win length " + MIN_WIN_LENGTH);
            setupWinLength = new JSlider(MIN_WIN_LENGTH, MIN_SIZE_MAP, MIN_WIN_LENGTH);
            setupWinLength.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    labelWinLength.setText("Win length " + setupWinLength.getValue());
                }
            });

            settingsPanel.add(buttonStart);
            settingsPanel.add(buttonExit);
            settingsPanel.add(buttonClearLog);
            settingsPanel.add(labelMapSize);
            settingsPanel.add(setupMapSize);
            settingsPanel.add(labelWinLength);
            settingsPanel.add(setupWinLength);
        }

        private void prepareGameLog() {
            log = new JTextArea();
            scrollLog = new JScrollPane(log);
            log.setEditable(false);
            log.setLineWrap(true);
        }

        void saveLog(String text) {
            log.append(text + "\n");
        }

        private void collectSettings() {
            int mapSize = setupMapSize.getValue();
            int winLen = setupWinLength.getValue();
            log.setText("");
            saveLog("==Start New Game==");
            saveLog("Map Size is" + mapSize + "x" + mapSize);
            saveLog("Win Length is" + winLen);
            map.startGame(mapSize, mapSize, winLen);
        }

    }



