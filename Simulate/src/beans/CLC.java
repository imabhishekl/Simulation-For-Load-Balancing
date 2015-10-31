
package beans;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author root
 */
public class CLC implements Serializable{

    private String name;
    private LinkedList<Cluster> clusters = new LinkedList<Cluster>();

    public CLC(String name, LinkedList<Cluster> clusters) {
        this.name = name;
        this.clusters = clusters;
    }

    public CLC() {
        clusters = new LinkedList<Cluster>();
    }
    
    public CLC(String name) {
        this.name = name;
    }
    
    public LinkedList<Cluster> getClusters() {
        return clusters;
    }

    public void setClusters(LinkedList<Cluster> clusters) {
        this.clusters = clusters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String toString()
    {
        int  i = 0;        
        
        String clc_name = this.getName();
        String toString = clc_name + "\n" + "------------" + "\n";
        Iterator<Cluster> cluster_list = this.getClusters().iterator();
        
        while(cluster_list.hasNext())
        {
            toString = toString + cluster_list.next().toString() + "\n" + "-----------------------";            
        }
        return toString;
    }
    
}