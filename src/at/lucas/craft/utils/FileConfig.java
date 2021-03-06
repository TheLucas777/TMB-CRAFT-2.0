package at.lucas.craft.utils;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.IOException;

public class FileConfig extends YamlConfiguration {
    private String path;
    public FileConfig(String folder, String filename){
        this.path="plugins/"+folder+"/"+filename;
        try {
            load(path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
    public FileConfig(String filename){
        this("TMB-Craft-2.0", filename);
    }
    public void saveConfig(){
        try {
            save(this.path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
