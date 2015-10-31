/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author root
 */
public class Cluster implements Serializable{
    private String name;
    private String ip;
    private LinkedList<Node> active_list = new LinkedList<Node>();
    private LinkedList<Node> inactive_list = new LinkedList<Node>();
    private LinkedList<Node> dead_list = new LinkedList<Node>();
    private Node backupNC = new Node();

    private float max_load;
    private float max_ram;
    private double max_hd;
    private float avg_load;
    
    public Cluster(String name) {
        this.name = name;
    }

    public LinkedList<Node> getActive_list() {
        return active_list;
        
    }

    public void setActive_list(LinkedList<Node> active_list) {
        this.active_list = active_list;
    }

    public LinkedList<Node> getDead_list() {
        return dead_list;
    }

    public void setDead_list(LinkedList<Node> dead_list) {
        this.dead_list = dead_list;
    }

    public LinkedList<Node> getInactive_list() {
        return inactive_list;
    }

    public void setInactive_list(LinkedList<Node> inactive_list) {
        this.inactive_list = inactive_list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAvg_load() {
        return avg_load;
    }

    public void setAvg_load(float avg_load) {
        this.avg_load = avg_load;
    }

    public double getMax_hd() {
        return max_hd;
    }

    public void setMax_hd(double max_hd) {
        this.max_hd = max_hd;
    }

    public float getMax_load() {
        return max_load;
    }

    public void setMax_load(float max_load) {
        this.max_load = max_load;
    }

    public float getMax_ram() {
        return max_ram;
    }

    public void setMax_ram(float max_ram) {
        this.max_ram = max_ram;
    }

    public void setClusterData(){
        //set avg_load = (sum of all the active nodes)/(sum of the active )
        //set max_hd
        //set max_ram
        //set max_load
        
        //avg load
        
        Node node;
        Node min_load_node = null;
        float min_load_in_cluster = simulate.Variables.max_load;
        float active_load = 0;
        Iterator<Node> active_list_i = active_list.iterator();
        while(active_list_i.hasNext())
        {
            node = active_list_i.next();
            //node.getLoad_fifteen();
            if(min_load_in_cluster > node.getLoad())
            {
                min_load_in_cluster = node.getLoad();
                min_load_node = node;
            }
            active_load = active_load + node.getLoad();            
        }
        avg_load = active_load / (active_list.size() + inactive_list.size());
        
        //max load
        if(inactive_list.isEmpty())
        {
            max_load = simulate.Variables.max_load - min_load_in_cluster;
            //max_hd = min_load_node.getDisk_free();
            //max_ram = min_load_node.getMem_free();
        }
        else
        {
            max_load = simulate.Variables.max_load;
        }
        
        //System.out.println("avg load of " + this.getName() + "= " + avg_load);
        
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Node getBackupNC() {
        return backupNC;
    }

    public void setBackupNC(Node backupNC) {
        this.backupNC = backupNC;
    }
    
    
    
    public String toString()
    {
        int i = 0;
        Iterator<Node> active_node_list = this.getActive_list().iterator();
        Iterator<Node> inactive_node_list = this.getInactive_list().iterator();
        Iterator<Node> dead_node_list = this.getDead_list().iterator();
        
        String toString = this.getName() + "\n" + this.getAvg_load() + "\n" + this.getMax_load() + "\n" + this.getMax_ram() + ":" + this.getMax_hd();
        
        toString = toString + "\n" + "------------------------------";
        
        while(active_node_list.hasNext())
        {
            toString = toString + active_node_list.next().toString();
        }
        
        toString = toString + "\n" + "------------------------------";
        
        while(inactive_node_list.hasNext())
        {
            toString = toString + inactive_node_list.next().toString();
        }
        
        toString = toString + "\n" + "------------------------------";
        
        while(dead_node_list.hasNext())
        {
            toString = toString + dead_node_list.next().toString();
        }
        
        toString = toString + "\n" + "------------------------------";
        
        return toString;
    }
}