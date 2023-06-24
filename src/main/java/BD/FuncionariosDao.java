package BD;

import Objs.Funcionarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FuncionariosDao {

    private ConectionDB CDB;
    PreparedStatement stmt;
    ResultSet rs;

    public String verifica(Funcionarios f) {
        CDB = new ConectionDB();
        String query = "SELECT Senha, Tipo_Func FROM Funcionarios WHERE Login = '"
                + f.getUser() + "';";
        try {
            stmt = CDB.c.prepareStatement(query);
            rs = stmt.executeQuery();
            if (rs.next()) {
                if (CDB.pass.authenticate(f.getSenha().toCharArray(), rs.getString(1))) {
                    return rs.getString(2);
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList verificaUser() {
        ArrayList a;
        CDB = new ConectionDB();
        String query = "SELECT Login FROM Funcionarios;";
        a = CDB.verifica(query, 1);
        return a;
    }

    public boolean adicionar(Funcionarios f) {
        CDB = new ConectionDB();

        if (CDB.verifica("SELECT *FROM USUARIOS_mortos WHERE Login = '" + f.getUser() + "';")) {
            return false;
        }
        return CDB.inserir("INSERT INTO Funcionarios"
                + "(Nome_Func, Login, Senha, Email, Tipo_Func, Data_Nasc, Fone_Cel, Fone_Alt, Fone_Res)  VALUES "
                + "('"
                + f.getNome() + "','"
                + f.getUser() + "','"
                + CDB.pass.hash(f.getSenha().toCharArray()) + "','"
                + f.getEmail() + "','"
                + f.getTipoFunc() + "','"
                + f.getDataNasc() + "','"
                + f.getFoneCel() + "','"
                + f.getFoneAlt() + "','"
                + f.getFoneRes() + "');");
    }

    public boolean alter(Funcionarios f) {
        String query = "UPDATE Funcionarios SET Data_Nasc = '2000-10-02' WHERE Login = '"
                + f.getDataNasc() + "';";
        CDB = new ConectionDB();
        return CDB.update(query);
    }

    public boolean delete(Funcionarios f) {
        CDB = new ConectionDB();
        try {
            stmt = CDB.c.prepareStatement("SELECT * FROM Funcionarios WHERE ID_Func = '" + f.getId() + "';");
            rs = stmt.executeQuery();
            if (rs.next()) {
                if (CDB.inserir("INSERT INTO Usuarios_Mortos"
                        + "(ID_Func, Nome_Func, Login, Senha, Email, Tipo_Func, Data_Nasc, Fone_Cel, Fone_Alt, Fone_Res)  VALUES "
                        + "('"
                        + rs.getString(1) + "','"
                        + rs.getString(2) + "','"
                        + rs.getString(3) + "','"
                        + CDB.pass.hash(rs.getString(4).toCharArray()) + "','"
                        + rs.getString(5) + "','"
                        + rs.getString(6) + "','"
                        + rs.getString(7) + "','"
                        + rs.getString(8) + "','"
                        + rs.getString(9) + "','"
                        + rs.getString(10) + "');")) {
                    return CDB.delete("DELETE FROM Funcionarios WHERE Login = '" + f.getUser() + "';");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public ArrayList<Funcionarios> VerificaLike(Funcionarios f, String order, String desc) {
        String query;
        if (f.getUser() != null && f.getEmail() != null) {
            query = "Select *From Funcionarios WHERE Login LIKE '%"
                    + f.getUser() + "%' && Email LIKE '%"
                    + f.getEmail() + "%' && Tipo_Func = '"
                    + f.getTipoFunc() + "' ORDER BY "
                    + order + " "
                    + desc + " LIMIT 25;";
        } else if (f.getUser() != null) {
            query = "Select *From Funcionarios WHERE Login LIKE '%"
                    + f.getUser() + "%'&& Tipo_Func = '"
                    + f.getTipoFunc() + "' ORDER BY "
                    + order + " "
                    + desc + " LIMIT 25;";
        } else if (f.getUser() == null) {
            query = "Select *From Funcionarios WHERE Email LIKE '%"
                    + f.getEmail() + "%'&& Tipo_Func = '"
                    + f.getTipoFunc() + "' ORDER BY "
                    + order + " "
                    + desc + " LIMIT 25;";
        } else {
            query = "Select *From Funcionarios WHERE Tipo = '"
                    + f.getTipoFunc() + "' ORDER BY "
                    + order + " "
                    + desc + " LIMIT 25;";
        }
        CDB = new ConectionDB();
        PreparedStatement stmt;
        ArrayList<Funcionarios> a = new ArrayList<>();
        try {

            stmt = CDB.c.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                f = new Funcionarios();

                f.setId(rs.getString(1));
                f.setNome(rs.getString(2));
                f.setUser(rs.getString(3));
                f.setSenha(rs.getString(4));
                f.setEmail(rs.getString(5));
                f.setTipoFunc(rs.getString(6));
                f.setDataNasc(rs.getString(7));
                f.setFoneCel(rs.getString(8));
                f.setFoneAlt(rs.getString(9));
                f.setFoneRes(rs.getString(10));

                a.add(f);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return a;
    }

    public Funcionarios Verifica(Funcionarios f) {
        try {
            stmt = CDB.c.prepareStatement("SELECT *FROM Funcionarios WHERE Login = '" + f.getUser() + "';");
            rs = stmt.executeQuery();
            if (rs.next()) {
                f.setId(rs.getString(1));
                f.setNome(rs.getString(2));
                f.setUser(rs.getString(3));
                //f.setSenha(rs.getString(4));
                f.setEmail(rs.getString(5));
                f.setTipoFunc(rs.getString(6));
                f.setDataNasc(rs.getString(7));
                f.setFoneCel(rs.getString(8));
                f.setFoneAlt(rs.getString(9));
                f.setFoneRes(rs.getString(10));
            }
        } catch (Exception e) {
        }
        return f;
    }
}
