package com.teamword.dao;

import com.teamword.model.Giuongbenh;
import java.util.List;

public interface GiuongbenhDao {
    public void create (Giuongbenh gb);
    public void update (Giuongbenh gb);
    public void delete ( int id );
    public Giuongbenh get (int id);
    public List<Giuongbenh> getall();
}
