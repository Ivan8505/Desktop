package BD;

import Objs.Compras;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ComprasDao {

    ConectionDB CDB = new ConectionDB();

    public boolean inserir(Compras c) {
        CDB = new ConectionDB();
        return CDB.inserir("INSERT INTO Pedidos_Compra"
                + "(Cnpj_Lab, FormaPag_L, DataEntega_L, DataCompra_L, TotalNota_L) VALUES('"
                + c.getCnpj_Lab() + "', '"
                + c.getFormaPag_L() + "', '"
                + c.getDataEntega_L() + "', '"
                + c.getDataCompra_L() + "', '"
                + c.getTotalNota_L() + "');");
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
