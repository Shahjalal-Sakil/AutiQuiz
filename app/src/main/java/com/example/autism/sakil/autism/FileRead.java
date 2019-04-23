package com.example.autism.sakil.autism;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileRead {

    private Context mContext;

    public FileRead(Context context) {
        this.mContext = context;
    }


   public List<DatasetInstance> readLine(String path) {
       List<DatasetInstance> dataset = new ArrayList<>();

       AssetManager am = mContext.getAssets();

       try {
           InputStream is = am.open(path);
           BufferedReader reader = new BufferedReader(new InputStreamReader(is));
           String line;

           while ((line = reader.readLine()) != null) {
               if (line.startsWith("Case")) {
                   continue;
               }
               String[] columns = line.split("\\s+");

               // skip first column and last column is the label
               int i ;
               int[] data = new int[columns.length-1];
               data[0] = 1 ;
               for (i=1; i<columns.length-1; i++) {
                   data[i] = Integer.parseInt(columns[i]);
               }
               int label = Integer.parseInt(columns[i]);
               DatasetInstance instance = new DatasetInstance(label, data);
               dataset.add(instance);
           }
       } catch (IOException e) {
           e.printStackTrace();
       }

       return dataset;
   }


}
