package ToDo_List;

import Dynamiczna_lista_zakupow.ShoppingListApp;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TaskManager extends JFrame {
    private JPanel panel1;
    private JPanel topPanel;
    private JTextField taskInput;
    private JButton addButton;
    private JPanel centerPanel;
    private JPanel bottomPanel;
    private JButton deleteButton;
    private JLabel taskCounter;
    private JLabel newTaskLabel;
    private JList taskList;
    private DefaultListModel<String> listModel;

    public TaskManager() {
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Task Manager");
        listModel = new DefaultListModel<>();
        taskList.setModel(listModel);

        addButton.addActionListener(e -> {
            String text = taskInput.getText();
            if(!text.isEmpty()){
                listModel.addElement(text);
                taskInput.setText("");
                updateCounter();
            } else {
                JOptionPane.showMessageDialog(null, "Zadanie nie może być puste", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        deleteButton.addActionListener(e -> {
            int idItem = taskList.getSelectedIndex();
            if(idItem != -1){
                listModel.remove(idItem);
                updateCounter();
            } else {
                JOptionPane.showMessageDialog(null, "Nie zaznaczono żadnego elementu", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        taskList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getClickCount() == 2){
                    int index = taskList.locationToIndex(e.getPoint());
                    if(index != -1){
                        listModel.remove(index);
                        updateCounter();
                    }
                }
            }
        });

        add(panel1);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateCounter() {
        taskCounter.setText("Liczba zadań: " + listModel.getSize());
    }

    static void main() {
        TaskManager app = new TaskManager();
    }
}
