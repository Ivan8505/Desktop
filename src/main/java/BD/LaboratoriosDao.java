package BD;

import Objs.Laboratorios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LaboratoriosDao {

    ConectionDB CDB;

    public boolean adicionar(Laboratorios l) {
        CDB = new ConectionDB();
        return CDB.inserir("INSERT INTO Laboratorios"
                + "(Status_Lab, Cnpj_Lab, Nome_Lab, Rua_Lab, Num_Lab, Bairro_Lab, Comple_Lab, Cidade_Lab, Estado_Lab, CEP_Lab, Insc_Estadual)  VALUES "
                + "('"
                + l.getStatus() + "','"
                + l.getCNPJ() + "','"
                + l.getFornecedor() + "','"
                + l.getRua() + "','"
                + l.getNumero() + "','"
                + l.getBairro() + "','"
                + l.getComplemento() + "','"
                + l.getCidade() + "','"
                + l.getEstado() + "','"
                + l.getCEP() + "','"
                + l.getInscriçãoEstadual() + "');");
    }

    public Laboratorios Verifica(Laboratorios l) {
        String query = "SELECT *FROM Laboratorios WHERE ID_Lab = '"
                + l.getIdFornecedor() + "';";
        CDB = new ConectionDB();
        PreparedStatement stmt;
        try {
            stmt = CDB.c.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                l = new Laboratorios();

                l.setStatus(rs.getString(1));
                l.setIdFornecedor(rs.getString(2));
                l.setCNPJ(rs.getString(3));
                l.setFornecedor(rs.getString(4));
                l.setRua(rs.getString(5));
                l.setNumero(rs.getString(6));
                l.setBairro(rs.getString(7));
                l.setComplemento(rs.getString(8));
                l.setCidade(rs.getString(9));
                l.setEstado(rs.getString(10));
                l.setInscriçãoEstadual(rs.getString(12));
                l.setCEP(rs.getString(12));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return l;
    }

    public ArrayList<Laboratorios> VerificaLike(Laboratorios l, String ID, String CNPJ, String Nome, String insEst, String order, String desc, String Status) {
        ArrayList<Laboratorios> a = new ArrayList<>();
        String query = "SELECT *FROM Laboratorios WHERE ID_Lab LIKE '%"
                + ID + "%' && CNPJ_Lab LIKE '%"
                + CNPJ + "%' && Nome_Lab LIKE '%"
                + Nome + "%' && Insc_Estadual LIKE '%"
                + insEst + "%' && Status_Lab = "
                + Status + " ORDER BY "
                + order + " "
                + desc + " LIMIT 25;";
        CDB = new ConectionDB();
        PreparedStatement stmt;
        try {
            stmt = CDB.c.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                l = new Laboratorios();

                l.setStatus(rs.getString(1));
                l.setIdFornecedor(rs.getString(2));
                l.setCNPJ(rs.getString(3));
                l.setFornecedor(rs.getString(4));
                l.setRua(rs.getString(5));
                l.setNumero(rs.getString(6));
                l.setBairro(rs.getString(7));
                l.setComplemento(rs.getString(8));
                l.setCidade(rs.getString(9));
                l.setEstado(rs.getString(10));
                l.setInscriçãoEstadual(rs.getString(11));
                l.setCEP(rs.getString(12));

                a.add(l);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return a;
    }

    public boolean update(Laboratorios l) {
        String query = "UPDATE Laboratorios SET Rua_Lab = '"
                + l.getRua() + "', Num_Lab = '"
                + l.getNumero() + "', Bairro_Lab = '"
                + l.getBairro() + "', Comple_Lab = '"
                + l.getComplemento() + "', Cidade_Lab = '"
                + l.getCidade() + "', Estado_Lab = '"
                + l.getEstado() + "', CEP_Lab = '"
                + l.getCEP() + "' WHERE Id_Lab = '"
                + l.getIdFornecedor() + "';";
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

    public boolean updateStatus(Laboratorios l) {
        String query = "UPDATE Laboratorios SET Status_Lab = '"
                + l.getStatus() + "' WHERE ID_Lab = '"
                + l.getIdFornecedor() + "';";
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
