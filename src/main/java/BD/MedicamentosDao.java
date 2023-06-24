package BD;

import Objs.Medicamentos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MedicamentosDao {

    ConectionDB CDB;

    public boolean adicionar(Medicamentos m) {
        CDB = new ConectionDB();
        try {
            PreparedStatement stmt = CDB.c.prepareStatement("INSERT INTO Medicamentos "
                    + "(Cod_Med, Nome_Med, Tipo, Descricao, Valor_Venda, Valor_Custo, Qntd_Med) VALUES (null, '"
                    + m.getNomeMed() + " ','"
                    + m.getTipo() + " ','"
                    + m.getDescrição() + " ',"
                    + m.getValorVenda() + ","
                    + m.getValorCusto() + ",'"
                    + m.getQuantidade() + "');");
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Medicamentos Verifica(Medicamentos m) {
        String query = "SELECT *FROM Medicamentos WHERE Cod_Med = '" + m.getCodMed() + "'";
        CDB = new ConectionDB();
        try {
            PreparedStatement stmt = CDB.c.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                m.setNomeMed(rs.getString("Nome_Med"));
                m.setTipo(rs.getString("Tipo"));
                m.setDescrição(rs.getString("Descricao"));
                m.setValorVenda(rs.getString("Valor_Venda"));
                m.setValorCusto(rs.getString("Valor_Custo"));
                m.setQuantidade(rs.getString("Qntd_Med"));
                m.setDataUltCompra(rs.getString("Data_UltCompra"));
            }
        } catch (Exception e) {
        }
        return m;
    }

    public ArrayList<Medicamentos> VerificaLike(Medicamentos m, String ID, String Nome, String order, String desc) {
        ArrayList<Medicamentos> a = new ArrayList<>();
        String query = "SELECT *FROM Medicamentos WHERE Cod_Med LIKE '%"
                + ID + "%' && Nome_Med LIKE '%"
                + Nome + "%' ORDER BY "
                + order + " "
                + desc + " LIMIT 25;";
        CDB = new ConectionDB();
        PreparedStatement stmt;
        try {
            stmt = CDB.c.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                m = new Medicamentos();

                m.setCodMed(rs.getString("Cod_Med"));
                m.setNomeMed(rs.getString("Nome_Med"));
                m.setTipo(rs.getString("Tipo"));
                m.setDescrição(rs.getString("Descricao"));
                m.setValorVenda(rs.getString("Valor_Venda"));
                m.setValorCusto(rs.getString("Valor_Custo"));
                m.setQuantidade(rs.getString("Qntd_Med"));
                m.setDataUltCompra(rs.getString("Data_UltCompra"));

                a.add(m);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return a;
    }

    public boolean update(Medicamentos m) {
        String query = "UPDATE Medicamentos SET Descricao = '"
                + m.getDescrição() + "', Tipo = '"
                + m.getTipo() + "', Valor_Venda = '"
                + m.getValorVenda() + "' WHERE Cod_Med = "
                + m.getCodMed() + "";
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
}
