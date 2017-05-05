package cn.levacr.is.is.data;

import java.util.ArrayList;

/**
 * Created by hello on 2017/5/5.
 */

//一堆数据的数据结构的定义;
public class Data {

    //联系人的数据结构
    public static class Contract {
        private String mName;
        private String mPhoneNum;

        public Contract() {
        }

        public void setmName(String mName) {
            this.mName = mName;
        }

        public void setmPhoneNum(String mPhoneNum) {
            this.mPhoneNum = mPhoneNum;
        }

        public String getmName() {
            return mName;
        }

        public String getmPhoneNum() {
            return mPhoneNum;
        }
    }

    //短信的数据结构
    public class Sms {

    }

}
