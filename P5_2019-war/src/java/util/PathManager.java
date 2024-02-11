/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author dello
 */
public class PathManager
{
    public static String getUrlFile(String caminhoRelativo)
    {
        String urlCompleto = PathManager.class.getResource(".." + caminhoRelativo).getFile().replaceAll("%40", " ");
        File file = new File(urlCompleto);
        if(file.exists())
            return file.toString().trim();
        
        return "";
    }
}
