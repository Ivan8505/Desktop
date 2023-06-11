package ModelTables;

import Objs.Drogarias;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class DrogariasTableModel extends AbstractTableModel {

    private List<Drogarias> drog = new ArrayList<>();
    private String[] colunas = {"ID", "Nome", "CNPJ", "CEP", "Cidade", "Bairro", "Rua", "Complemnto", "Número", "Estado"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return drog.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0 -> {
                return drog.get(linha).getIDdroga();
            }
            case 1 -> {
                return drog.get(linha).getDrogaria();
            }
            case 2 -> {
                return drog.get(linha).getCNPJ();
            }
            case 3 -> {
                return drog.get(linha).getCEP();
            }
            case 4 -> {
                return drog.get(linha).getCidade();
            }
            case 5 -> {
                return drog.get(linha).getBairro();
            }
            case 6 -> {
                return drog.get(linha).getRua();
            }
            case 7 -> {
                return drog.get(linha).getComplemento();
            }
            case 8 -> {
                return drog.get(linha).getNumero();
            }
            case 9 -> {
                return drog.get(linha).getEstado();
            }
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0 ->
                drog.get(linha).setIDdroga((String) valor);
            case 1 ->
                drog.get(linha).setDrogaria((String) valor);
            case 2 ->
                drog.get(linha).setCNPJ((String) valor);
            case 3 ->
                drog.get(linha).setCEP(((String) valor));
            case 4 ->
                drog.get(linha).setCidade(((String) valor));
            case 5 ->
                drog.get(linha).setBairro(((String) valor));
            case 6 ->
                drog.get(linha).setRua(((String) valor));
            case 7 ->
                drog.get(linha).setComplemento(((String) valor));
            case 8 ->
                drog.get(linha).setNumero(((String) valor));
            case 9 ->
                drog.get(linha).setEstado(((String) valor));
        }
        this.fireTableRowsUpdated(linha, linha);
    }

    public void addLinha(Drogarias m) {
        this.drog.add(m);
        this.fireTableDataChanged();
    }

    public void removeLinha(int linha) {
        this.drog.remove(linha);
        this.fireTableDataChanged();
    }

    public void removeall() {
        this.drog.clear();
        this.fireTableDataChanged();
    }

    public void addlist(ArrayList<Drogarias> ls) {
        this.drog = ls;
        this.fireTableDataChanged();
    }

}
