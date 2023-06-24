package BD;

import Objs.Vendas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VendasDao {

    ConectionDB CDB = new ConectionDB();

    public boolean inserir(Vendas v) {
        CDB = new ConectionDB();
        PreparedStatement stmt;
        ResultSet rs;
        String query = "INSERT INTO Pedidos_Venda"
                + "(Cnpj_Cliente, FormaPag_V, DataEntrega_V, DataCompra_V, TotalNota_V) VALUES('"
                + v.getCnpj_Cliente() + "', '"
                + v.getFormaPag_V() + "', '"
                + v.getDataEntrega_V() + "', '"
                + v.getDataCompra_V() + "', '"
                + v.getTotalNota_V() + "');";
        String query5 = "SELECT NumNotaFiscal_V FROM Pedidos_Venda ORDER BY NumNotaFiscal_V DESC LIMIT 1;";
        try {
            stmt = CDB.c.prepareStatement(query);
            stmt.execute();
            stmt = CDB.c.prepareStatement(query5);
            rs = stmt.executeQuery();
            if (rs.next()) {
                String query1 = "INSERT INTO Itens_Venda"
                        + "(NumNotaFiscal_V, Cod_Med, Valor_Unit, Valor_Total, Qntd_Med) VALUES('"
                        + rs.getString(1) + "', '"
                        + v.getCod_Med() + "', '"
                        + v.getValor_Unit() + "', '"
                        + v.getValorTotal() + "','"
                        + v.getQntd_Med() + "');";
                stmt = CDB.c.prepareStatement(query1);
                stmt.execute();
                return true;
            }
        } catch (Exception e) {
            System.out.println("inserir"+e.getMessage());
        }
        return false;
    }

    public ArrayList comboboxCNPJ(String Cnpj) {
        CDB = new ConectionDB();
        ArrayList a = new ArrayList();
        String query = "SELECT CNPJ_Droga FROM Drogarias WHERE CNPJ_Droga LIKE '%" + Cnpj + "%' LIMIT 100;";
        PreparedStatement stmt;
        try {
            stmt = CDB.c.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                a.add(rs.getString(1));
            }
            return a;
        } catch (Exception e) {
            System.out.println("comboboxCNPJ"+e.getMessage());
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

    public String quantidade(String cod) {
        CDB = new ConectionDB();
        String query = "SELECT Qntd_Med FROM Medicamentos WHERE Cod_Med = '" + cod + "'";
        PreparedStatement stmt;
        try {
            stmt = CDB.c.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return null;
    }

}
