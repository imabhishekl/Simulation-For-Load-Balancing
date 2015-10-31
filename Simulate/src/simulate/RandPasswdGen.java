/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulate;

import com.Ostermiller.util.RandPass;

public class RandPasswdGen
{
    public static String getRandPasswd(int len)
    {
        char symbol_list[] = setCharArray();
        
        String rp = new RandPass(symbol_list).getPass(len);
        //System.out.print(rp);
        return rp;
    }

    static char[] setCharArray()
    {
        char a[] = new char[68];
        int i = 0;
        for(;i < 26;i++)
        {
            a[i] = (char)(i + 65);
        }

        for(int j = 0;j < 26;j++)
        {
            a[i++] = (char)(j + 97);
        }

        for(int j = 0;j < 10;j++)
        {
            a[i++] = (char)(j + 48);
        }

        a[i++] = '_';a[i++] = '-';a[i++] = '@';a[i++] = '!';a[i++] = '#';a[i++] = '+';
        return a;
    }
}