package com.neuedu;

import org.hibernate.dialect.MySQL5Dialect;

public class UTF8MySql5Dialect extends MySQL5Dialect {
    @Override
    public String getTableTypeString() {
        return  " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
