package Dynamiczna_lista_zakupow;

import javax.swing.*;

public class ShoppingListApp extends JFrame {
    private JPanel panel1;
    private JTextField itemInput;
    private JButton addButton;
    private JList itemsList;
    private JPanel centerPanel;
    private JPanel topPanel;
    private JButton deleteButton;
    private DefaultListModel<String> listModel;

    public ShoppingListApp() {
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Shopping List");
        listModel = new DefaultListModel<>();
        itemsList.setModel(listModel);

        addButton.addActionListener(e -> {
            String text = itemInput.getText();
            if(!text.isEmpty()){
                listModel.addElement(text);
                itemInput.setText("");
            }
        });

        deleteButton.addActionListener(e -> {
            int idItem = itemsList.getSelectedIndex();
            if(idItem != -1){
                listModel.remove(idItem);
            } else {
                JOptionPane.showMessageDialog(null, "Nie zaznaczono żadnego elementu", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(panel1);
        setVisible(true);
    }

    static void main() {
        ShoppingListApp app = new ShoppingListApp();
    }
}
