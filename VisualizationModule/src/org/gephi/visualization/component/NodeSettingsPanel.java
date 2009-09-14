/*
Copyright 2008 WebAtlas
Authors : Mathieu Bastian, Mathieu Jacomy, Julian Bilcke
Website : http://www.gephi.org

This file is part of Gephi.

Gephi is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Gephi is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gephi.visualization.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.gephi.visualization.VizController;
import org.gephi.visualization.api.VizConfig;
import org.gephi.visualization.api.initializer.Modeler;
import org.gephi.visualization.api.objects.ModelClass;

/**
 *
 * @author Mathieu Bastian
 */
public class NodeSettingsPanel extends javax.swing.JPanel {

    /** Creates new form NodeSettingsPanel */
    public NodeSettingsPanel() {
        initComponents();
    }

    public void setup() {
        final VizConfig vizConfig = VizController.getInstance().getVizConfig();
        adjustTextCheckbox.setSelected(vizConfig.isAdjustByText());

        final DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        final ModelClass nodeClass = VizController.getInstance().getModelClassLibrary().getNodeClass();
        for (Modeler modeler : nodeClass.getModelers()) {
            comboModel.addElement(modeler);
        }
        comboModel.setSelectedItem(nodeClass.getCurrentModeler());
        shapeCombo.setModel(comboModel);
        shapeCombo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                nodeClass.setCurrentModeler((Modeler) comboModel.getSelectedItem());
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelShape = new javax.swing.JLabel();
        adjustTextCheckbox = new javax.swing.JCheckBox();
        shapeCombo = new javax.swing.JComboBox();

        labelShape.setText(org.openide.util.NbBundle.getMessage(NodeSettingsPanel.class, "NodeSettingsPanel.labelShape.text")); // NOI18N

        adjustTextCheckbox.setText(org.openide.util.NbBundle.getMessage(NodeSettingsPanel.class, "NodeSettingsPanel.adjustTextCheckbox.text")); // NOI18N

        shapeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelShape)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(shapeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(adjustTextCheckbox))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelShape)
                    .addComponent(shapeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(adjustTextCheckbox)
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox adjustTextCheckbox;
    private javax.swing.JLabel labelShape;
    private javax.swing.JComboBox shapeCombo;
    // End of variables declaration//GEN-END:variables
}
