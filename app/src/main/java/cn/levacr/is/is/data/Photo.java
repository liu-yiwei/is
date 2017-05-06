package cn.levacr.is.is.data;

import java.util.List;

/**
 * Created by hello on 2017/5/7.
 */

public class Photo {
    private String srcPath;
    private String name;
    private String key;
    public Photo(String srcPath, String name) {
        this.srcPath = srcPath;
        this.name = name;
    }

    public void setSrcPath(String srcPath) {
        this.srcPath = srcPath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrcPath() {

        return srcPath;
    }

    public String getName() {
        return name;
    }

    //加密照片的次序: 得到要加密的文件路径,文件路径和文件名字写入数据库,
    //把文件加密移动入本应用文件夹,删除原有文件夹,在本文件夹中显示;
    public List<Photo> getPhoto(){

    }

    public void encrPhoto(List<String> list){
        //list里面有所有的文件路径,'
        for (int i = 0; i<list.size(); i++){
            toDB(list.get(i));
            encrFile(list.get(i));
        }
        //加密完成

    }

    //先把文件名字都写入数据库,包括key;
    private void toDB(String photoPath){
        //// TODO: 2017/5/7 写入数据库的操作
    }

    private void encrFile(String photoPath){
        // TODO: 2017/5/7 加密然后删除文件
    }
}
