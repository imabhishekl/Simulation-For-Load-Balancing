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
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author root
 */
public class SimulateFunction 
{
    /*public static CLC getClusters()
    {                
        return clc;
    }*/
    
    public static Cluster selectCluster(Instance instance,CLC clc)
    {
        Cluster selected_cluster = null;
        Cluster temp_cluster = null;
        float min_load = Variables.max_load;
        
        Iterator<Cluster> cluster_list_i = clc.getClusters().iterator();
        
        while(cluster_list_i.hasNext())
        {
            //out.println("in while <br/>");
            temp_cluster = cluster_list_i.next();
            //out.println(min_load + ">" + temp_cluster.getAvg_load() + ":" + instance.getLoad() + "<" + temp_cluster.getMax_load() + ":" + instance.getRam() + "<" + temp_cluster.getMax_ram() + ":" /*+ instance.getMemory() + "<" + temp_cluster.getMax_hd()*/);            
            /*if(temp_cluster.getMax_load() == Variables.max_load){
                min_load = temp_cluster.getAvg_load();
                selected_cluster = temp_cluster;
                break;
            }*/            
            if((min_load > temp_cluster.getAvg_load()) && (instance.getLoad() < temp_cluster.getMax_load()))
            {
                //out.println("cluster <br/>" + temp_cluster.getAvg_load());                
                min_load = temp_cluster .getAvg_load();
                selected_cluster = temp_cluster;
            }                                    
        }        
        return selected_cluster;
    }
    
    public static Cluster selectPSCluster(Instance instance,CLC clc)
    {
        Cluster selected_cluster = null;
        Cluster temp_cluster = null;
        float min_load = Variables.max_load;
        
        Iterator<Cluster> cluster_list_i = clc.getClusters().iterator();
        
        while(cluster_list_i.hasNext())
        {
            //out.println("in while <br/>");
            temp_cluster = cluster_list_i.next();
            //out.println(min_load + ">" + temp_cluster.getAvg_load() + ":" + instance.getLoad() + "<" + temp_cluster.getMax_load() + ":" + instance.getRam() + "<" + temp_cluster.getMax_ram() + ":" /*+ instance.getMemory() + "<" + temp_cluster.getMax_hd()*/);            
            /*if(temp_cluster.getMax_load() == Variables.max_load){
                min_load = temp_cluster.getAvg_load();
                selected_cluster = temp_cluster;
                break;
            }*/            
            if((temp_cluster.getAvg_load() > 0f) && (instance.getLoad() < temp_cluster.getMax_load()))
            {
                //out.println("cluster <br/>" + temp_cluster.getAvg_load());                
                min_load = temp_cluster .getAvg_load();
                selected_cluster = temp_cluster;
                break;
            }                                    
        }        
        if(selected_cluster == null)
            return selectCluster(instance, clc);
        else
            return selected_cluster;
    }
    
    public static Instance SetInstanceBeans(Images img)
    {        
        String uuid = "";//InstanceFactory.getUUID();
        String domain_name = getDomainName(uuid);
        Instance instance = new Instance(img.getImage_name(),uuid,domain_name); 
        
        instance.setLoad(img.getLoad());

        return instance;
    }
    
    public static String getDomainName(String image_name)
    {
        String domain_name;
        
        String random_entity = RandPasswdGen.getRandPasswd(6);            
        
        domain_name = image_name + "_" + random_entity;        
        
        return domain_name;
    }
    
    public static Node selectNode(Cluster cluster,Instance inst)
    {              
        Iterator<Node> nodes_i = cluster.getActive_list().iterator();
        float min = Variables.max_load;
        Node select_node = null;
        
        //find the min load
        while(nodes_i.hasNext())
        {
            Node temp_node = nodes_i.next();
            if(min > temp_node.getLoad())
            {
                min = temp_node.getLoad();
                select_node = temp_node;
            }
        }
        
        if(min == Variables.max_load)
            select_node = null;
        
        return select_node;
    }
    
    public static Node selectPSNode(Cluster cluster,Instance inst)
    {              
        Iterator<Node> nodes_i = cluster.getActive_list().iterator();
        
        LinkedList<Node> currently_active = new LinkedList<Node>();
        LinkedList<Node> currently_inactive = new LinkedList<Node>();
        
        Node temp = null;
        
        while(nodes_i.hasNext())
        {
            temp = nodes_i.next();
            if(temp.getLoad() != 0f)
            {
                currently_active.add(temp);                
            }            
            else
            {
                currently_inactive.add(temp);
            }
        }
        
        temp = null;
        
        Iterator<Node> currently_active_i = currently_active.iterator();                
        
        float max = 0f;//Variables.max_load;
        Node select_node = null;
        
        //find the power save load
        
        while(currently_active_i.hasNext())
        {
            Node temp_node = currently_active_i.next();
            if(max < (Variables.max_load - (temp_node.getLoad() + inst.getLoad())))
            {
                max = (Variables.max_load - (temp_node.getLoad() + inst.getLoad()));
                select_node = temp_node;
            }
        }
        
        max = 0;        
        
        if(select_node == null)
        {      
            select_node = currently_inactive.getFirst();
            /*while(nodes_i.hasNext())
            {                
                Node temp_node = nodes_i.next();
                if(max < (Variables.max_load - (temp_node.getLoad() + inst.getLoad())))
                {
                    max = (Variables.max_load - (temp_node.getLoad() + inst.getLoad()));
                    select_node = temp_node;
                }
            }*/
        }
        
        
        if(max == Variables.max_load)
            select_node = null;
        
        return select_node;
    }
    
    public static void setNodeLoad(Node node,Instance instance)
    {
        node.setLoad(node.getLoad() + instance.getLoad());              
        //System.out.println(node.getName() + " load = " + node.getLoad());
    }    
}
