package projectTodolist;

import java.io.*;
import javax.swing.*;

/**
 *
 * @author BRUNO
 */
public class ProjectToDoList {
    public static void main(String args[]) {
        JTable table;
        ToDoLists page;
        
        try{
            FileInputStream inFile = new FileInputStream ("SavedList.save");
            ObjectInputStream in = new ObjectInputStream(inFile);
            
            table = (JTable)in.readObject();
            page = new ToDoLists(table);
            
            
            in.close();
            inFile.close();
            page.setVisible(true);
            
        }catch(IOException e){
            System.err.println("File Not Found Error");
            page = new ToDoLists();
            page.setVisible(true);
        }
        catch(ClassNotFoundException cl){
            page = new ToDoLists();
            page.setVisible(true);
        }
        
                
        
    }
    
    public static void save(tryal page){
        try{
            FileOutputStream outFile = new FileOutputStream ("SavedList.dat");
            ObjectOutputStream out = new ObjectOutputStream(outFile);
            out.writeObject(page);
            out.close();
            outFile.close();
            
        JOptionPane.showMessageDialog(page, "Save successful!");
            
        }catch(IOException e){
            System.err.println("Error: " + e);
        }
    }
    
    
    public static void save(JTable page){
        try{
            FileOutputStream outFile = new FileOutputStream ("SavedList.dat");
            ObjectOutputStream out = new ObjectOutputStream(outFile);
            out.writeObject(page);
            out.close();
            outFile.close();
            
        JOptionPane.showMessageDialog(page, "Save successful!");
            
        }catch(IOException e){
            System.err.println("Error: " + e);
        }
    }
}
