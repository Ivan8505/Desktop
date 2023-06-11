package BD;

import Objs.Drogarias;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DrogariasDao {

    ConectionDB CDB;

    public boolean adicionar(Drogarias d) {
        CDB = new ConectionDB();
        return CDB.inserir("INSERT INTO Drogarias"
                + "(Status_Drog, Cnpj_Droga, Nome_Droga, Rua_Droga, Numero_Droga, Bairro_Droga, Comple_Droga, Cidade_Droga, Estado_Droga, CEP_Droga)  VALUES "
                + "('"
                + d.getStatus() + "','"
                + d.getCNPJ() + "','"
                + d.getDrogaria() + "','"
                + d.getRua() + "','"
                + d.getNumero() + "','"
                + d.getBairro() + "','"
                + d.getComplemento() + "','"
                + d.getCidade() + "','"
                + d.getEstado() + "','"
                + d.getCEP() + "');");
    }

    public Drogarias Verifica(Drogarias d) {
        String query = "SELECT *FROM Drogarias WHERE ID_Droga = '"
                + d.getIDdroga() + "';";
        CDB = new ConectionDB();
        PreparedStatement stmt;
        try {
            stmt = CDB.c.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                d = new Drogarias();

                d.setStatus(rs.getString(1));
                d.setIDdroga(rs.getString(2));
                d.setCNPJ(rs.getString(3));
                d.setDrogaria(rs.getString(4));
                d.setRua(rs.getString(5));
                d.setNumero(rs.getString(6));
                d.setBairro(rs.getString(7));
                d.setComplemento(rs.getString(8));
                d.setCidade(rs.getString(9));
                d.setEstado(rs.getString(10));
                d.setCEP(rs.getString(11));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return d;
    }

    public ArrayList<Drogarias> VerificaLike(Drogarias d, String ID, String CNPJ, String Nome, String Status, String order, String desc) {
        ArrayList<Drogarias> a = new ArrayList<>();
        String query = "SELECT *FROM Drogarias WHERE ID_Droga LIKE '%"
                + ID + "%' && CNPJ_Droga LIKE '%"
                + CNPJ + "%' && Nome_Droga LIKE '%"
                + Nome + "%' && Status_Drog = "
                + Status + " ORDER BY "
                + order + " "
                + desc + " LIMIT 25;";
        CDB = new ConectionDB();
        PreparedStatement stmt;
        try {
            stmt = CDB.c.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                d = new Drogarias();

                d.setStatus(rs.getString(1));
                d.setIDdroga(rs.getString(2));
                d.setCNPJ(rs.getString(3));
                d.setDrogaria(rs.getString(4));
                d.setRua(rs.getString(5));
                d.setNumero(rs.getString(6));
                d.setBairro(rs.getString(7));
                d.setComplemento(rs.getString(8));
                d.setCidade(rs.getString(9));
                d.setEstado(rs.getString(10));
                d.setCEP(rs.getString(11));

                a.add(d);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return a;
    }

    public boolean update(Drogarias d) {
        String query = "UPDATE Drogarias SET Rua_Droga = '"
                + d.getRua() + "', Numero_Droga = '"
                + d.getNumero() + "', Bairro_Droga= '"
                + d.getBairro() + "', Comple_Droga= '"
                + d.getComplemento() + "', Cidade_Droga= '"
                + d.getCidade() + "', Estado_Droga= '"
                + d.getEstado() + "', CEP_Droga= '"
                + d.getCEP() + "' WHERE Id_Droga = '"
                + d.getIDdroga() + "';";
        System.out.println(query);
        CDB = new ConectionDB();
        PreparedStatement stmt;
        try {
            stmt = CDB.c.prepareStatement(query);
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean updateStatus(Drogarias d) {
        String query = "UPDATE Drogarias SET Status_Drog = '"
                + d.getStatus() + "' WHERE ID_Droga = '"
                + d.getIDdroga() + "';";
        CDB = new ConectionDB();
        PreparedStatement stmt;
        try {
            stmt = CDB.c.prepareStatement(query);
            return stmt.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
