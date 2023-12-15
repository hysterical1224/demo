package com.sinner.demo.proxy_jdk;

import java.sql.SQLException;

public interface Target {
    public void save() throws SQLException;

    public void error() throws SQLException;
}
