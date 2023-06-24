//PACOTES
package BD;
//IMPORTES

import API.PasswordAuthentication;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//AUTOR ivan8505

public class ConectionDB {//Classe

    public ConectionDB() {//Construtor
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());//mensagem se der erro
        }
        try {
            c = java.sql.DriverManager.getConnection("jdbc:mysql://"
                    + serverName + ":"
                    + port + "/"
                    + databaseName + "?user="
                    + user + "&password="
                    + password);//Conexão com o banco
            s = c.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage() + " " + e.getMessage());//mensagem se der erro
        }
    }

    public boolean verifica(String query) {
        boolean a = false;
        try {
            rs = s.executeQuery(query);
            a = rs.next();
            closeConnection(c);
            closeConnection(rs);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage() + "\n" + e.getMessage());
        }
        return a;
    }

    public ArrayList verifica(String query, int qntCol) {
        ArrayList array = new ArrayList();
        try {
            stmt = c.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                for (int i = 0; i < qntCol; i++) {
                    array.add(rs.getString(i + 1));
                }
            }
            closeConnection(c);
            closeConnection(stmt);
            closeConnection(s);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage() + "\n" + e.getMessage());
        }
        return array;
    }

    public boolean inserir(String query) {
        try {
            s.execute(query);
            closeConnection(s);
            closeConnection(c);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage() + "\n" + e.getMessage());
            return false;
        }
    }

    public boolean update(String query) {
        boolean a = false;
        try {
            a = s.execute(query);
            closeConnection(c);
            closeConnection(s);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage() + "\n" + e.getMessage());
        }
        return a;
    }

    public boolean delete(String query) {
        try {
            s.execute(query);
            closeConnection(c);
            closeConnection(s);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage() + "\n" + e.getMessage());
            return false;
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Fechar as Conexões">
    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar conexão: " + e);
        }
    }

    public static void closeConnection(Statement s) {
        try {
            if (s != null) {
                s.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar conexão: " + e);
        }
    }

    public static void closeConnection(PreparedStatement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar conexão: " + ex);
        }
    }

    public static void closeConnection(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar conexão: " + e);
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Variaveis">
    private final String user = "root";//User do Banco de dados
    private final String password = "123456";//Senha do Banco de dados
    private final String serverName = "127.0.0.1";
    private final String databaseName = "BD_MSHELF";//Nome do Banco de dados
    private final String port = "3306";//Número da porta para a conexão com o Banco de Dados
    public Connection c;
    private Statement s;
    private PreparedStatement stmt;
    private ResultSet rs;
    public PasswordAuthentication pass = new PasswordAuthentication();
//</editor-fold>
}
