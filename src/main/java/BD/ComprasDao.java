package BD;

import Objs.Compras;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ComprasDao {

    ConectionDB CDB = new ConectionDB();

    public boolean inserir(Compras c) {
        CDB = new ConectionDB();
        PreparedStatement stmt;
        ResultSet rs;
        String query = "INSERT INTO Pedidos_Compra"
                + "(Cnpj_Lab, FormaPag_L, DataEntega_L, DataCompra_L, TotalNota_L) VALUES('"
                + c.getCnpj_Lab() + "', '"
                + c.getFormaPag_L() + "', '"
                + c.getDataEntega_L() + "', '"
                + c.getDataCompra_L() + "', '"
                + c.getTotalNota_L() + "');";
        String query5 = "SELECT NumNotaFiscal_L FROM Pedidos_Compra ORDER BY NumNotaFiscal_L DESC LIMIT 1;";
        String query3 = "SELECT Qntd_Med FROM Medicamentos WHERE Cod_Med = '"
                + c.getCod_Med() + "'";
        try {
            stmt = CDB.c.prepareStatement(query);
            stmt.execute();
            stmt = CDB.c.prepareStatement(query5);
            rs = stmt.executeQuery();
            if (rs.next()) {
                String query1 = "INSERT INTO Itens_Compra "
                        + "(NumNotaFiscal_L, Cod_Med, Valor_Unit, Valor_Total, Qntd_Med) VALUES('"
                        + rs.getString(1) + "', '"
                        + c.getCod_Med() + "', '"
                        + c.getValor_Unit() + "', '"
                        + c.getValorTotal() + "','"
                        + c.getQntd_Med() + "');";
                stmt = CDB.c.prepareStatement(query1);
                stmt.execute();
            }
            stmt = CDB.c.prepareStatement(query3);
            rs = stmt.executeQuery();
            if (rs.next()) {
                String query2 = "UPDATE Medicamentos SET Qntd_Med = '"
                        + rs.getInt(1) + "', Data_UltCompra = '"
                        + c.getDataCompra_L() + "' WHERE Cod_Med = '"
                        + c.getCod_Med() + "';";
                stmt = CDB.c.prepareStatement(query2);
                stmt.execute();
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public ArrayList comboboxCNPJ(String Cnpj) {
        CDB = new ConectionDB();
        ArrayList a = new ArrayList();
        String query = "SELECT CNPJ_LAB FROM Laboratorios WHERE CNPJ_LAB LIKE '%" + Cnpj + "%' LIMIT 100;";
        PreparedStatement stmt;
        try {
            stmt = CDB.c.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                a.add(rs.getString(1));
            }
            return a;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList comboboxMedicamento(String nome) {
        CDB = new ConectionDB();
        ArrayList a = new ArrayList();
        String query = "SELECT Nome_Med, Cod_Med FROM Medicamentos WHERE Nome_Med LIKE '%" + nome + "%' LIMIT 100;";
        PreparedStatement stmt;
        String codNome;
        try {
            stmt = CDB.c.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                codNome = rs.getString(2) + " - " + rs.getString(1);
                a.add(codNome);
            }
            return a;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String Valor(String cod) {
        CDB = new ConectionDB();
        String query = "SELECT Valor_Custo FROM Medicamentos WHERE Cod_Med = '" + cod + "';";
        PreparedStatement stmt;
        try {
            stmt = CDB.c.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
