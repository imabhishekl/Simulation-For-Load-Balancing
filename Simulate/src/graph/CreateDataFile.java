/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import beans.CLC;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root
 */
public class CreateDataFile 
{
    public static void createClusterDataFile(CLC clc)throws SQLException,IOException
    {
        float[][] avg_load = simulate.DBActivity.getAvgLoadOfClusters(clc);
        String temp_ts = "06-02-2009 09:16:";
        int sec = 0;
        //final int MOD = 60;
        PrintWriter pw = new PrintWriter(new FileWriter("/scripts/cluster.dat"),false);
        //pw.println();
        
        int col = avg_load.length;
        int row = avg_load[0].length;
        int i = 0,j = 0;
        
        System.out.println("col=" + col + "row" + row);
        
        String row_data = "";
        
        while(i < row)
        {            
            row_data = row_data + temp_ts + sec;
            j = 0;
            while(j < col)
            {
                row_data = row_data + "  " + avg_load[j][i] + "  "; 
                j++;
            }            
            row_data = row_data + "\n";System.out.println(row_data);
            pw.write(row_data);
            row_data = "";
            i++;
            sec++;
        }
        pw.close();
    }
}
