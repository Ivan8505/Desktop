package Style;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.util.ArrayList;
import java.util.List;

public class NewJPanel extends javax.swing.JPanel {

    public NewJPanel() {
        setOpaque(false);
        colors = new ArrayList<>();
    }
    private List<ModelColor> colors;

    public void addColor(ModelColor... color) {
        for (ModelColor c : color) {
            colors.add(c);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics graphics) {
        if (!colors.isEmpty()) {
            int width = getWidth();
            int heigth = getHeight();
            Graphics2D g2 = (Graphics2D) graphics;
            Color color[] =new Color[colors.size()];   
            float position[] = new float[colors.size()];
            for (int i = 0; i < colors.size(); i++) {
                color[i] = colors.get(i).getColor();
                position[i] = colors.get(i).getPosition();
            }
            int sx = 0;
            int sy = 0;
            int ex = width;
            int ey = 0;
            LinearGradientPaint g = new LinearGradientPaint(sx, sy, ex, ey, position, color);
            g2.setPaint(g);
            g2.fillRect(0, 0, width, heigth);
            
        }
        super.paintComponent(graphics);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
