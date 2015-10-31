/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import simulate.Execute;

/**
 *
 * @author root
 */
public class CreateGraph 
{
    public static void main(String[] arg)
    {
        try
        {
            simulate.Simulate.initialize();
            graph.CreateDataFile.createClusterDataFile(simulate.Simulate.getClc());
            Execute.generateClusterGraph();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
