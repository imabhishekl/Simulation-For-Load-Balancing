/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulate;

import java.io.IOException;

/**
 *
 * @author root
 */
public class Execute 
{
    public static void generateClusterGraph()throws IOException
    {
        Runtime executer = Runtime.getRuntime();
        Process result = executer.exec("bash /scripts/generate_graph.sh");
    }
}
