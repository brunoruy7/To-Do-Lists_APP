package projectTodolist;

import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author BRUNO
 */
public class ProjectToDoList {
    public static void main(String args[]) {
        ArrayList<ArrayList<Object[]>> tables = new ArrayList();
        ArrayList<String> names = new ArrayList();
        ToDoLists page;
        
        try{
            FileInputStream inFile1 = new FileInputStream ("dist//Saved_Files//DataArray.save");
            ObjectInputStream in1 = new ObjectInputStream(inFile1);
            
            FileInputStream inFile2 = new FileInputStream ("dist//Saved_Files//TableNames.save");
            ObjectInputStream in2 = new ObjectInputStream(inFile2);
            
            tables = (ArrayList)in1.readObject();
            names = (ArrayList)in2.readObject();
            page = new ToDoLists();
            
            for (int i = 0; i < tables.size(); i++){
                page.tableList.setValueAt(names.get(i), i, 0);
                page.lists.add(new List(i, page, names.get(i)));
                page.c = tables.size();
                page.lists.get(i).ref = page;
                for (int j = 0; j < tables.get(i).size(); j++){
                    
                    page.lists.get(i).toDoTable.setValueAt((boolean)tables.get(i).get(j)[0], j, 0);
                    page.lists.get(i).toDoTable.setValueAt((String)tables.get(i).get(j)[1], j, 1);
                }
            }
            
            in1.close();
            inFile1.close();
            in2.close();
            inFile2.close();
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
    
    public static boolean save(Object obj, String name){
        boolean state = true;
        try{
            FileOutputStream outFile = new FileOutputStream ("Saved_Files//"+ name + ".save");
            ObjectOutputStream out = new ObjectOutputStream(outFile);
            out.writeObject(obj);
            out.close();
            outFile.close();
            
        
            
        }catch(IOException e){
            System.err.println("Error: " + e);
            state = false;
        }
        finally {
            return state;
        }
    }
}
