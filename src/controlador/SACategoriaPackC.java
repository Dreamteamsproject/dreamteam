package controlador;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.Consultas;
import vista.ModificarCatPack;


public class SACategoriaPackC {
    static Consultas consultaSQL = new Consultas();
    
    public static void AgregarCat(){
    
        String SQL = "Insert into categoria_pack (categoria_descripcion) values('"+SuperAdmC.superAdm.categoriaText.getText()+"')";
        if(consultaSQL.doQueryPost(SQL)){
            JOptionPane.showMessageDialog(null, "categoria añadida");
            
        }
        else{JOptionPane.showMessageDialog(null, "error al añadir categoria");}
        SuperAdmC.superAdm.categoriaText.setText("");
        RellenarCat();
    
    }
    
    public static void RellenarCat(){
        try {
            
            DefaultListModel modelPack = new DefaultListModel();
            String SQL = "select categoria_descripcion from categoria_pack";
            var rs = consultaSQL.doQueryGet(SQL);
            while(rs.next()){
                modelPack.addElement(rs.getString("Categoria_descripcion"));
            }
            SuperAdmC.superAdm.categoriaPackList.setModel(modelPack);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(SACategoriaPackC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void Modificar(){
    
        try {
            String SQL = "select * from categoria_pack where categoria_descripcion='"+SuperAdmC.superAdm.categoriaPackList.getSelectedValue()+"'";
            var rs = consultaSQL.doQueryGet(SQL);
            if(rs.next()){
                
                ModificarCatPack modificar = new ModificarCatPack(rs.getString("categoria_id"),rs.getString("categoria_descripcion"));
                modificar.setVisible(true);
                
            }
            else{JOptionPane.showMessageDialog(null, "hubo un error para encontrar los datos");}
            
        } catch (SQLException ex) {
            Logger.getLogger(SACategoriaPackC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public static void GuardarModificar(String id, String descripcion){
        
        String SQL = "update categoria_pack SET categoria_descripcion='"+descripcion+"' where categoria_id="+id;
        if(consultaSQL.doQueryPost(SQL)){JOptionPane.showMessageDialog(null, "Categoria actualizada");}
        else{JOptionPane.showMessageDialog(null, "ocurrio un error al actualizar");}
        RellenarCat();
    }
    
    public static void Buscar(){
        try {
            String SQL = "select categoria_descripcion from categoria_pack where categoria_descripcion like '%"+SuperAdmC.superAdm.catPackBuscar2.getText()+"%'";
            DefaultListModel model = new DefaultListModel();
            var rs = consultaSQL.doQueryGet(SQL);
            while(rs.next()){
                model.addElement(rs.getString("categoria_descripcion"));   
            }
            SuperAdmC.superAdm.categoriaPackList.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(SACategoriaPackC.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static void BuscarVacio(){
        
        if(SuperAdmC.superAdm.catPackBuscar2.getText().equals("")){
            RellenarCat();
        }
        
    }
}
