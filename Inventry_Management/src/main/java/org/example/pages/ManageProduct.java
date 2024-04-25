package org.example.pages;

import org.example.ConfigDBConnection;
import org.example.Models.Category;
import org.example.Models.Product;
import org.example.ServiceImp;

import javax.naming.Name;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ManageProduct extends JPanel {
    public JButton Add;
    public JButton Update;
    public JButton Delete;
    public JButton Actualiser;
    public List<Category> CtegList;
    public List<Product> ProdList;
    public List<Product> ALLPROD;

    public int Cteg1id;
    public int Cteg2id;
    public int Cteg3id;
    public ManageProduct() {
        try{
           CtegList=ServiceImp.getCtegories();
           CtegList.add(0, new Category(-1, "Select Category"));

            ProdList=ServiceImp.getProducts();
            ALLPROD = ServiceImp.getProducts();
            ProdList.add(0, new Product(-1, "Select Product" , 0));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        JLabel Add_label =new JLabel("Add Product :");

    JLabel Name_Product=new JLabel("Name Product :");
    JTextField Name_Prod_Field=new JTextField();
    Name_Prod_Field.setPreferredSize(new Dimension(200,20));

    JLabel Cteg=new JLabel("Categorie_Name");
    JComboBox dropdown3 = new JComboBox<>(CtegList.toArray(new Category[0]));
    dropdown3.setSelectedIndex(0);
        dropdown3.addActionListener(e -> {
            Category selectedCategory = (Category) dropdown3.getSelectedItem();
            Cteg1id = selectedCategory.getId();
            System.out.println(Cteg1id);
        });

    JPanel fieldspanel = new JPanel();
    fieldspanel.setLayout(new GridLayout(2,1));
    fieldspanel.add(Name_Product);
    fieldspanel.add(Name_Prod_Field);

    JLabel Quantitie_Product=new JLabel("Quantitie Product :");
    JTextField Quantitie_Product_Field=new JTextField();
    Quantitie_Product_Field.setPreferredSize(new Dimension(200,20));

    JPanel fieldspanel1 = new JPanel();
    fieldspanel1.setLayout(new GridLayout(2,1));
    fieldspanel1.add(Quantitie_Product);
    fieldspanel1.add(Quantitie_Product_Field);

    JPanel fieldspanelCAT = new JPanel();
    fieldspanelCAT.setLayout(new GridLayout(2,1));
    fieldspanelCAT.add(Cteg);
    fieldspanelCAT.add(dropdown3);

    Add = new JButton("Add");
    Add.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int quantity = Integer.parseInt(Quantitie_Product_Field.getText());
            ServiceImp.AddProd(Name_Prod_Field.getText() , quantity , Cteg1id);
        }
    });
        //==============================================================//

        JLabel Update_label =new JLabel("Update Product :");
        JLabel Name_Product_To_Update=new JLabel("Name Product :");

        JComboBox<Product> dropdown = new JComboBox<>(ProdList.toArray(new Product[ProdList.size()]));

        dropdown.setSelectedIndex(0);
        dropdown.setPreferredSize(new Dimension(Name_Prod_Field.getPreferredSize().width,getHeight()));
        dropdown.addActionListener(e -> {
            Product selectedProduct = (Product) dropdown.getSelectedItem();
            Cteg2id = selectedProduct.getId();
        });
        JPanel fieldspanel_To_Update = new JPanel();
        fieldspanel_To_Update.setLayout(new GridLayout(2,1));
        fieldspanel_To_Update.add(Name_Product_To_Update);
        fieldspanel_To_Update.add(dropdown);

        JLabel Quantitie_Product_To_Update=new JLabel("Quantitie Product :");
        JTextField Quantitie_Product_Field_To_Update=new JTextField();
        Quantitie_Product_Field_To_Update.setPreferredSize(new Dimension(200,20));

        JPanel fieldspanel1_To_Update = new JPanel();
        fieldspanel1_To_Update.setLayout(new GridLayout(2,1));
        fieldspanel1_To_Update.add(Quantitie_Product_To_Update);
        fieldspanel1_To_Update.add(Quantitie_Product_Field_To_Update);

        Update = new JButton("Update");
        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiceImp.UpdateProduct(Cteg2id ,Integer.parseInt(Quantitie_Product_Field_To_Update.getText()) );
            }
        });


        //==============================================================//

        JLabel Delete_label =new JLabel("Delete Product :");

        JLabel Name_Product_To_Delete=new JLabel("Name Product :");
        JComboBox<Product> dropdown2 = new JComboBox<>(ProdList.toArray(new Product[ProdList.size()]));
        dropdown2.setSelectedIndex(0);
        dropdown2.setPreferredSize(new Dimension(Name_Prod_Field.getPreferredSize().width,getHeight()));
        dropdown2.addActionListener(e -> {
            Product selectedProduct = (Product) dropdown2.getSelectedItem();
            Cteg3id = selectedProduct.getId();
            System.out.println(Cteg3id);
        });

        JPanel fieldspanel_To_Delete = new JPanel();
        fieldspanel_To_Delete.setLayout(new GridLayout(2,1));
        fieldspanel_To_Delete.add(Name_Product_To_Delete);
        fieldspanel_To_Delete.add(dropdown2);

        Delete = new JButton("Delete");
        Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    ServiceImp.DeleteProd(Cteg3id);
            }
        });

        //==============================================================//

        JLabel ALL_Prod_label =new JLabel("All Product :");


        String[] columns = {"Name_Prod", "Qte_Prod"};

        Object[][] data = new Object[ALLPROD.size()][2];
        for (int i = 0; i < ALLPROD.size(); i++) {
            Product product = ALLPROD.get(i);
            data[i][0] = product.getName();
            data[i][1] = product.getQte();
        }

        DefaultTableModel tableModel = new DefaultTableModel(data, columns);
        JTable table_Prod = new JTable(tableModel);
        Actualiser = new JButton("Actualiser");
        Actualiser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ALLPROD = ServiceImp.getProducts();

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        //==============================================================//



    JPanel panel1=new JPanel();
    panel1.setLayout(new FlowLayout());
    panel1.add(Add_label);
    panel1.add(Box.createHorizontalStrut(30));
    panel1.add(fieldspanel);
    panel1.add(Box.createHorizontalStrut(30));
    panel1.add(fieldspanel1);
    panel1.add(Box.createHorizontalStrut(30));
    panel1.add(fieldspanelCAT);
    panel1.add(Box.createHorizontalStrut(30));
    panel1.add(Add);


    JPanel panel2=new JPanel();
    panel2.setLayout(new FlowLayout());
    panel2.add(Update_label);
    panel2.add(Box.createHorizontalStrut(50));
    panel2.add(fieldspanel_To_Update);
    panel2.add(Box.createHorizontalStrut(70));
    panel2.add(fieldspanel1_To_Update);
    panel2.add(Box.createHorizontalStrut(30));
    panel2.add(Update);

    JPanel panel3=new JPanel();
    panel3.setLayout(new FlowLayout());
    panel3.add(Box.createHorizontalStrut(90));
    panel3.add(Delete_label);
    panel3.add(Box.createHorizontalStrut(50));
    panel3.add(fieldspanel_To_Delete);
    panel3.add(Box.createHorizontalStrut(30));
    panel3.add(Delete);
    panel3.setAlignmentX(Component.RIGHT_ALIGNMENT);

    JPanel Actpanel = new JPanel();
    Actpanel.setLayout(new FlowLayout());
    Actpanel.add(ALL_Prod_label);
    Actpanel.add(Box.createHorizontalStrut(100));
    Actpanel.add(Actualiser);
    Actpanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

    JPanel panel4=new JPanel();
    panel4.setLayout(new BoxLayout(panel4 , BoxLayout.Y_AXIS));
    panel4.add(Box.createHorizontalStrut(20));
    panel4.add(Actpanel);
    panel4.add(Box.createHorizontalStrut(20));
    panel4.add(table_Prod);
    panel4.setAlignmentX(Component.RIGHT_ALIGNMENT);

    JPanel panelBox=new JPanel();
    panelBox.setLayout(new BoxLayout(panelBox , BoxLayout.Y_AXIS));
    panelBox.add(panel1);
    panelBox.add(panel2);
    panelBox.add(panel3);
    panelBox.add(panel4);

    JPanel princ=new JPanel();
    princ.setLayout(new BorderLayout());
    princ.setPreferredSize(new Dimension(900,400));
    princ.add(panelBox , BorderLayout.WEST);


    add(Box.createVerticalStrut(500));
    add(princ);
    table_Prod.setMaximumSize(new Dimension(princ.getPreferredSize().width, getHeight()));

    }
}
