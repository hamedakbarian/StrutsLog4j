package jndi;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;


public class ConnectionFactory{
    //forces Singletone characteristics for the class
    private static interface Singleton {
        final ConnectionFactory INSTANCE = new ConnectionFactory();
    }
    private static DataSource dataSource; //shared data source among all objects
    //constructor which looks up and initializes datasource based on factory, provider, JNDI
    private ConnectionFactory() {
        try {
            Context ctx = null;
            Hashtable ht = new Hashtable();
            ht.put(Context.INITIAL_CONTEXT_FACTORY,
                    "weblogic.jndi.WLInitialContextFactory");
            ht.put(Context.PROVIDER_URL,
                    "t3://localhost:7001");
            ctx = new InitialContext(ht);
            dataSource =  (DataSource)ctx.lookup("logger");
//            Context context = new InitialContext();
//            dataSource = (javax.sql.DataSource) context.lookup("jdbc/logger");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //returnes a connection based on the iniialized datasource
    public static Connection getDatabaseConnection() throws SQLException {
        return Singleton.INSTANCE.dataSource.getConnection();
    }

//    protected Connection getConnection() throws SQLException {
//        try{
//            Context ctx = null;
//            Hashtable ht = new Hashtable();
//            ht.put(Context.INITIAL_CONTEXT_FACTORY,
//                    "weblogic.jndi.WLInitialContextFactory");
//            ht.put(Context.PROVIDER_URL,
//                    "t3://localhost:7001");
//            ctx = new InitialContext(ht);
//            dataSource =  (DataSource)ctx.lookup("logger");
//            return dataSource.getConnection();
//        }
//        catch (Exception ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }
}