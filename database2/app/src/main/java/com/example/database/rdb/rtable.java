package com.example.database.rdb;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity

public class rtable {
    @NonNull
    @PrimaryKey
    String srn;
    String sname,snumber;

    @NonNull
    public String getSrn() {
        return srn;
    }

    public String getSname() {
        return sname;
    }

    public void setSrn(@NonNull String srn) {
        this.srn = srn;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    public String getSnumber() {
        return snumber;
    }

    public rtable(@NonNull String srn, String sname, String snumber) {
        this.srn = srn;
        this.sname = sname;
        this.snumber = snumber;
    }
}
