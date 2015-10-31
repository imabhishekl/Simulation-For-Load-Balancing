/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulate;

import beans.CLC;
import beans.Cluster;
import beans.Node;
import java.sql.*;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author Abhishek
 */
public class DBActivity 
{           
    
    public static void addNodeLoad(Cluster cluster,Node node)throws SQLException
    {
        Connection conn = DBConnect.getSQLConnection();
        String query = "insert into node values (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        
        Timestamp ts = new Timestamp(new Date().getTime());
        
        ps.setString(1, node.getName());
        ps.setString(2, cluster.getName());
        ps.setFloat(3, node.getLoad());                
        ps.setTimestamp(4, ts);
        
        ps.execute();
        
        conn.close();
    }
    
    public static void addClusterLoad(Cluster cluster)throws SQLException
    {
        Connection conn = DBConnect.getSQLConnection();
        String query = "insert into cluster (cluster_id,avg_load,max_load) values (?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, cluster.getName());
        ps.setFloat(2, cluster.getAvg_load());
        ps.setFloat(3, cluster.getMax_load());        
        
        ps.execute();
        
        conn.close();
    }
    
    public static void addClusterLoad(CLC clc)throws SQLException
    {
        Connection conn = DBConnect.getSQLConnection();
        
        Iterator<Cluster> cluster_i = clc.getClusters().iterator();
        Cluster temp_cluster = null;
        
        while(cluster_i.hasNext())
        {
            temp_cluster = cluster_i.next();
            String query = "insert into cluster (cluster_id,avg_load,max_load) values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, temp_cluster.getName());
            ps.setFloat(2, temp_cluster.getAvg_load());
            ps.setFloat(3, temp_cluster.getMax_load());        

            ps.execute();
        }
        
        conn.close();
    }
    
    public static float[][] getAvgLoadOfClusters(CLC clc)throws SQLException
    {
        int len = clc.getClusters().size();
        String[] cluster_name = new String[len];

        for(int i = 0;i < len;i++)
        {
            cluster_name[i] = clc.getClusters().get(i).getName();
        }

        Connection conn = simulate.DBConnect.getSQLConnection();
        int i = 0;
        float[][] avg_load = new float[cluster_name.length][20];
        //System.out.println("row=" + avg_load[0].length + ":col" + avg_load.length);
        while(i < cluster_name.length)
        {
            String query = "select avg_load from cluster where cluster_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cluster_name[i]);
            ResultSet rs = ps.executeQuery();

            int count = 0;

            while(rs.next() && count < 20)
            {
                //System.out.println("i=" + i + ":count=" + count);
                avg_load[i][count] = rs.getFloat("avg_load");
                count++;
            }
            
            i++;
        }
        conn.close();     
        
        return avg_load;
    }
}
