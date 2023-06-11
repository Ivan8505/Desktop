/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelTables;

import Objs.Laboratorios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ivan
 */
public class LaboratoriosTableModel extends AbstractTableModel {

    private List<Laboratorios> f = new ArrayList<>();
    private final String[] colunas = {"ID", "Nome", "CNPJ", "CEP", "Cidade", "Bairro", "Rua", "Complemnto", "Número", "Estado", "Inscrição Estadual"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return f.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0 -> {
                return f.get(linha).getIdFornecedor();
            }
            case 1 -> {
                return f.get(linha).getFornecedor();
            }
            case 2 -> {
                return f.get(linha).getCNPJ();
            }
            case 3 -> {
                return f.get(linha).getCEP();
            }
            case 4 -> {
                return f.get(linha).getCidade();
            }
            case 5 -> {
                return f.get(linha).getBairro();
            }
            case 6 -> {
                return f.get(linha).getRua();
            }
            case 7 -> {
                return f.get(linha).getComplemento();
            }
            case 8 -> {
                return f.get(linha).getNumero();
            }
            case 9 -> {
                return f.get(linha).getEstado();
            }
            case 10 -> {
                return f.get(linha).getInscriçãoEstadual();
            }
        }
        return null;
    }
    
    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0 ->
                f.get(linha).setIdFornecedor((String) valor);
            case 1 ->
                f.get(linha).setFornecedor((String) valor);
            case 2 ->
                f.get(linha).setCNPJ(((String) valor));
            case 3 ->
                f.get(linha).setCEP(((String) valor));
            case 4 ->
                f.get(linha).setCidade(((String) valor));
            case 5 ->
                f.get(linha).setBairro(((String) valor));
            case 6 ->
                f.get(linha).setRua(((String) valor));
            case 7 ->
                f.get(linha).setComplemento(((String) valor));
            case 8 ->
                f.get(linha).setNumero(((String) valor));
            case 9 ->
                f.get(linha).setEstado(((String) valor));
            case 10 ->
                f.get(linha).setInscriçãoEstadual((String) valor);
        }
        this.fireTableRowsUpdated(linha, linha);
    }

    public void addLinha(Laboratorios f) {
        this.f.add(f);
        this.fireTableDataChanged();
    }

    public void removeall() {
        this.f.clear();
        this.fireTableDataChanged();
    }

    public void addlist(ArrayList<Laboratorios> ls) {
        this.f = ls;
        this.fireTableDataChanged();
    }
}
