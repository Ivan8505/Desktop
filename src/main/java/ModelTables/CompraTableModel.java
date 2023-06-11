/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelTables;

import Objs.Compras;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Vitor.hvieira1
 */
public class CompraTableModel extends AbstractTableModel{
    
    private List<Compras> compras = new ArrayList<>();
    private String[] colunas = {"Numero da nota Fiscal", "CNPJ", "Forma de pagamento","Data de entrega","Data da compra","Total Nota","Codigo do medicamento","Quantidade","Valor Unitario", "Valor total"};
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return compras.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0 -> {return compras.get(linha).getNumNotaFiscal_L();}
            case 1 -> {return compras.get(linha).getCnpj_Lab();}
            case 2 -> {return compras.get(linha).getFormaPag_L();}
            case 3 -> {return compras.get(linha).getDataEntega_L();}
            case 4 -> {return compras.get(linha).getDataCompra_L();}
            case 5 -> {return compras.get(linha).getTotalNota_L();}
            case 6 -> {return compras.get(linha).getCod_Med();}
            case 7 -> {return compras.get(linha).getQntd_Med();}
            case 8 -> {return compras.get(linha).getValor_Unit();}
            case 9 -> {return compras.get(linha).getValorTotal();}
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0 -> compras.get(linha).setNumNotaFiscal_L((String) valor);
            case 1 -> compras.get(linha).setCnpj_Lab((String) valor);
            case 2 -> compras.get(linha).setFormaPag_L(((String) valor));
            case 3 -> compras.get(linha).setDataEntega_L(((String) valor));
            case 4 -> compras.get(linha).setDataCompra_L(((String) valor));
//            case 5 -> compras.get(linha).setTotalNota_L(((Double) valor));
            case 6 -> compras.get(linha).setCod_Med(((String) valor));
            case 7 -> compras.get(linha).setQntd_Med(((int) valor));
    //        case 8 -> compras.get(linha).setValor_Unit(((Double) valor));
  //          case 9 -> compras.get(linha).setValorTotal(((Double) valor));
        }
        this.fireTableRowsUpdated(linha, linha);
    }

    public void addLinha(Compras c) {
        this.compras.add(c);
        this.fireTableDataChanged();
    }

    public void removeLinha() {
        this.compras.clear();
        this.fireTableDataChanged();
    }
    
    
}
