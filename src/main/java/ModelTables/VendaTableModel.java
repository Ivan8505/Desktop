/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelTables;

import Objs.Vendas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ivan2
 */
public class VendaTableModel extends AbstractTableModel{
    
    private List<Vendas> vendas = new ArrayList<>();
    private String[] colunas = {"Numero da nota Fiscal", "CNPJ", "Forma de pagamento","Data de entrega","Data da compra","Total Nota","Codigo do medicamento","Quantidade","Valor Unitario", "Valor total"};
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return vendas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0 -> {return vendas.get(linha).getNumNotaFiscal_V();}
            case 1 -> {return vendas.get(linha).getCnpj_Cliente();}
            case 2 -> {return vendas.get(linha).getFormaPag_V();}
            case 3 -> {return vendas.get(linha).getDataEntrega_V();}
            case 4 -> {return vendas.get(linha).getDataCompra_V();}
            case 5 -> {return vendas.get(linha).getTotalNota_V();}
            case 6 -> {return vendas.get(linha).getCod_Med();}
            case 7 -> {return vendas.get(linha).getQntd_Med();}
            case 8 -> {return vendas.get(linha).getValor_Unit();}
            case 9 -> {return vendas.get(linha).getValorTotal();}
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0 -> vendas.get(linha).setNumNotaFiscal_V((String) valor);
            case 1 -> vendas.get(linha).setCnpj_Cliente((String) valor);
            case 2 -> vendas.get(linha).setFormaPag_V(((String) valor));
            case 3 -> vendas.get(linha).setDataEntrega_V(((String) valor));
            case 4 -> vendas.get(linha).setDataCompra_V(((String) valor));
            case 5 -> vendas.get(linha).setTotalNota_V(((Double) valor));
            case 6 -> vendas.get(linha).setCod_Med(((String) valor));
            case 7 -> vendas.get(linha).setQntd_Med(((int) valor));
            case 8 -> vendas.get(linha).setValor_Unit(((Double) valor));
            case 9 -> vendas.get(linha).setValorTotal(((Double) valor));
        }
        this.fireTableRowsUpdated(linha, linha);
    }

    public void addLinha(Vendas v) {
        this.vendas.add(v);
        this.fireTableDataChanged();
    }

    public void removeAll() {
        this.vendas.clear();
        this.fireTableDataChanged();
    }
    
    /*public void removelinha(){
    this.vendas.clear();
    this.fireTableDataChanged();
    }*/
    
}