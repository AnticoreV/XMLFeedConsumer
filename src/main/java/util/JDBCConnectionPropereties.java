package util;

import XML.INIReader;

public interface JDBCConnectionPropereties {
    INIReader iniReader = INIReader.getINIReader();
    public static final String driver = iniReader.getIniData().get(3);
    public static final String url = iniReader.getIniData().get(4);
    public static final String pass = iniReader.getIniData().get(2);
    public static final String user = iniReader.getIniData().get(1);
    public static final String dial = iniReader.getIniData().get(5);
}
