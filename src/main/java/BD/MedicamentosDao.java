package BD;

import Objs.Medicamentos;

public class MedicamentosDao {
    ConectionDB CDB;
    
        public boolean adicionar(Medicamentos m) {
        CDB = new ConectionDB();
        return CDB.inserir("INSERT INTO Medicamentos "
                + "(Cod_Med, Nome_Med, Tipo, Descricao, Valor_Venda, Valor_Custo, Qntd_Med, Data_UltCompra) VALUES (null, '" + 
                m.getNomeMed() + " ','" + 
                m.getTipo() + " ','" + 
                m.getDescrição() + " '," + 
                m.getValorVenda() + "," + 
                m.getValorCusto() + "," + 
                m.getQuantidade() + ",'" + 
                m.getDataUltimaCompra() + "');");

    }
}
