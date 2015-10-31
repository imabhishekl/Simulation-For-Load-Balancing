/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulate;

import beans.CLC;
import beans.Cluster;
import beans.Images;
import beans.Instance;
import beans.Node;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Simulate 
{
    /**
     * @param args the command line arguments
     */
    
    private static CLC clc = null;
    
    private static LinkedList<Images> image_list = new LinkedList();
    
    
    
    public static void initialize()
    {
        setImageData(getImage_list());
        
        setClc(new CLC("simulate"));
        
        LinkedList<Cluster> clusters_list = new LinkedList<Cluster>();
        
        Cluster cluster = new Cluster("cluster 1");
        
        LinkedList<Node> node_list = new LinkedList<Node>();
        
        for(int i = 0;i < 5;i++)
        {
            node_list.add(new Node("node[c1]" + i));
        }
        
        cluster.setActive_list(node_list);
        
        cluster.setClusterData();
        
        clusters_list.add(cluster);
        
        cluster = new Cluster("cluster 2");
        
        node_list = new LinkedList<Node>();
        
        for(int i = 0;i < 5;i++)
        {
            node_list.add(new Node("node[c2]" + i));
        }
        
        cluster.setActive_list(node_list);
        
        cluster.setClusterData();
        
        clusters_list.add(cluster);
        
        getClc().setClusters(clusters_list);
    }
    
    public static  void setImageData(LinkedList<Images> image_list)
    {
        Images img = new Images();
        img.setImage_name("img 1");
        img.setLoad(0.3f);
        
        image_list.add(img);
        
        img = new Images();
        img.setImage_name("img 2");
        img.setLoad(0.1f);
        
        image_list.add(img);
        
        img = new Images();
        img.setImage_name("img 3");
        img.setLoad(0.25f);
        
        image_list.add(img);
        
        img = new Images();
        img.setImage_name("img 4");
        img.setLoad(0.11f);
        
        image_list.add(img);
        
        img = new Images();
        img.setImage_name("img 5");
        img.setLoad(0.33f);
        
        image_list.add(img);
        
        img = new Images();
        img.setImage_name("img 6");
        img.setLoad(0.52f);
        
        image_list.add(img);
    }
    
    public static void main(String[] args) 
    {        
        initialize();
                     
        Scanner cin = new Scanner(System.in);
        
        /*int select = cin.nextInt();
        
        switch(select)
        {
            case 1 :
                
                break;
        }*/
        
        //String image_name = cin.next();
        
        try
        {
            int img_index = 0;
            
            System.out.println("Select Mode to operate in \n 1: Non Power Save Mode \n 2: Power Save Mode");
            
            int mode = cin.nextInt();
            
            if(mode == 1) // non power saver mode
            {
                while(true)
                {                    
                    displayImageList();
                    img_index = cin.nextInt();
                    processAddRequest(img_index);
                }
            }
            else if(mode == 2)  //power saver mode
            {
                while(true)
                {
                    displayImageList();
                    img_index = cin.nextInt();
                    processAddPowerSaverRequest(img_index);
                }
            }
            
              
        }
        catch(SQLException sqle)
        {
            System.out.println(sqle.toString());
        }
        
    }
    
    public static void processAddPowerSaverRequest(int img_index)throws SQLException
    {
        Instance instance = SimulateFunction.SetInstanceBeans(getImage_list().get(img_index));
        
        //CLC clc = SimulateFunction.getClusters();
        
        Cluster selected_cluster = SimulateFunction.selectPSCluster(instance, getClc());
        
        if(selected_cluster == null)
        {
            System.out.println("the clusters is not selected");
            System.exit(0);
        }
        else
        {
            //selected_cluster.setClusterData();
            //DBActivity.addClusterLoad(selected_cluster);
            //System.out.println("cluster selected = " + selected_cluster.getName());
        }
        
        Node selected_node = SimulateFunction.selectPSNode(selected_cluster, instance);
        
        if(selected_node == null)
        {
            System.out.println("the node is not selected");
            System.exit(1);
        }
        
        SimulateFunction.setNodeLoad(selected_node, instance);
        DBActivity.addNodeLoad(selected_cluster, selected_node);
        
        System.out.println("the node selected is :" + selected_node.getName() + " with load = " + selected_node.getLoad());
        
        selected_cluster.setClusterData();
        DBActivity.addClusterLoad(getClc());
        
        displayCloudLoad(getClc());
        
    }
    
    public static void processAddRequest(int img_index)throws SQLException
    {
        Instance instance = SimulateFunction.SetInstanceBeans(getImage_list().get(img_index));
        
        //CLC clc = SimulateFunction.getClusters();
        
        Cluster selected_cluster = SimulateFunction.selectCluster(instance, getClc());
        
        if(selected_cluster == null)
        {
            System.out.println("the clusters is not selected");
            System.exit(0);
        }
        else
        {
            //selected_cluster.setClusterData();
            //DBActivity.addClusterLoad(selected_cluster);
            //System.out.println("cluster selected = " + selected_cluster.getName());
        }
        
        Node selected_node = SimulateFunction.selectNode(selected_cluster, instance);
        
        if(selected_node == null)
        {
            System.out.println("the node is not selected");
            System.exit(1);
        }
        
        SimulateFunction.setNodeLoad(selected_node, instance);
        DBActivity.addNodeLoad(selected_cluster, selected_node);
        
        System.out.println("the node selected is :" + selected_node.getName() + " with load = " + selected_node.getLoad());
        selected_cluster.setClusterData();
        DBActivity.addClusterLoad(getClc());
        
        displayCloudLoad(getClc());
                        
    }
    
    public static void displayCloudLoad(CLC clc)
    {
        Iterator<Cluster> cluster_i = clc.getClusters().iterator();
        Cluster temp_cluster = null;
        Node temp_node = null;
        
        Iterator<Node> node_i = null;
        
        while(cluster_i.hasNext())
        {
            temp_cluster = cluster_i.next();
            System.out.println("\n" + temp_cluster.getName() + " avg_load[" + temp_cluster.getAvg_load() + "]");
            node_i = temp_cluster.getActive_list().iterator();
            while(node_i.hasNext())
            {
                temp_node = node_i.next();
                System.out.print(temp_node.getName() + "[" + temp_node.getLoad() + "]\t");
            }
        }
    }
    
    public static void displayImageList()
    {
        int len = getImage_list().size();
        System.out.println("\nList Of Images Available");
        for(int i = 0;i < len;i++)
        {
            System.out.println((i+1) + " : " + getImage_list().get(i).getImage_name());
        }
    }

    /**
     * @return the clc
     */
    public static CLC getClc() {
        return clc;
    }

    /**
     * @param aClc the clc to set
     */
    public static void setClc(CLC aClc) {
        clc = aClc;
    }

    /**
     * @return the image_list
     */
    public static LinkedList<Images> getImage_list() {
        return image_list;
    }

    /**
     * @param aImage_list the image_list to set
     */
    public static void setImage_list(LinkedList<Images> aImage_list) {
        image_list = aImage_list;
    }
}
