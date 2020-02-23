package com;

import java.io.*;

public class MyClassLoader extends ClassLoader {

    private String myPath;//文件路径

    public MyClassLoader( String myPath) {
        this.myPath = myPath;
    }

    @Override
    protected Class<?> findClass(String name)  throws  ClassNotFoundException{
          //name：文件名

        String  classPath=myPath+name+".class";
        //System.out.println(classPath);
        InputStream in=null;
        ByteArrayOutputStream out=null;

        try {
            in = new FileInputStream(classPath);
            out=new ByteArrayOutputStream();
            int value=-1;
            while ((value=in.read())!=-1){
                out.write(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(out!=null){
                    out.close();
                }

                if(in!=null) {
                    in.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        byte[] bytes= out.toByteArray();

        return defineClass(name,bytes,0,bytes.length);
    }

}
