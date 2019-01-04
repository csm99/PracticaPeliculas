/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapeliculas;

import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class VentanaPreguntas extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPreguntas
     */
    
    private Partida partida;
    private Pregunta pregunta;
    private Pregunta[] listaPreguntas;
    private int contadorPistas = 0;
    private int contadorPreguntas = 0;     // el contador siempre tiene un valor menos del que realmente tendría para tener en cuenta el rango del array (0-5)
    private String pistas;
    private int puntosActuales = 50;
    private int puntosTotales = 0;
    private Usuario jugador;
    
    public VentanaPreguntas() {
        initComponents();
        //pregunta = listaPreguntas[1].toString();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        preguntaNumero = new javax.swing.JLabel();
        textoPregunta = new javax.swing.JLabel();
        textoRespuesta = new javax.swing.JTextField();
        bResponder = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        textoPistas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        preguntaNumero.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        preguntaNumero.setText("Pregunta " + contadorPreguntas + 1);

        textoPregunta.setText("<pregunta>");

        bResponder.setText("Responder");
        bResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bResponderActionPerformed(evt);
            }
        });

        jLabel1.setText("Pistas:");

        textoPistas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoPistas.setText("TextoPistas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bResponder)
                .addGap(206, 206, 206))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(textoRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(preguntaNumero)
                            .addComponent(textoPregunta)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(textoPistas, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(preguntaNumero)
                .addGap(18, 18, 18)
                .addComponent(textoPregunta)
                .addGap(37, 37, 37)
                .addComponent(textoRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(bResponder)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(textoPistas, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bResponderActionPerformed
        // TODO add your handling code here:
        if (pregunta.comprobarRespuesta(textoRespuesta.getText())) {
            JOptionPane.showMessageDialog(this, "¡Respuesta correcta! +" + puntosActuales + " puntos", "Respuesta correcta", JOptionPane.PLAIN_MESSAGE);
            puntosTotales += puntosActuales;
            if(contadorPreguntas == 6){
                finalizar();
            }else{
                ofrecerNuevaPregunta();
            }
            
        } else {
            JOptionPane.showMessageDialog(this, "¡Respuesta incorrecta!", "Respuesta correcta", JOptionPane.PLAIN_MESSAGE);
            contadorPistas++;
            if(contadorPistas < 5){
                pistas += "\r\n" + pregunta.ofrecerNuevaPista();
                textoPistas.setText(pistas);
                puntosActuales -= 10;
            }
        }

        if (contadorPistas > 4 && contadorPreguntas < 6){
            ofrecerNuevaPregunta();
        }        
        else if(contadorPistas > 4 && contadorPreguntas == 6){
            finalizar();      
            // prueba blablabla
            
        }
        
    }//GEN-LAST:event_bResponderActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPreguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPreguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPreguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPreguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPreguntas().setVisible(true);
                
            }
        });
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public void inicializar() {
        ofrecerNuevaPregunta();
    }

    public void setListaPreguntas(Pregunta[] listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }

    public void setJugador(Usuario jugador) {
        this.jugador = jugador;
    }
    
    public void ofrecerNuevaPregunta(){       
        preguntaNumero.setText("Pregunta " + (contadorPreguntas + 1));
        pregunta = listaPreguntas[contadorPreguntas];
        textoPregunta.setText(pregunta.toString());
        contadorPistas = 0;
        contadorPreguntas++;
        // editame esto
        
    }
    
    public void finalizar(){
        if (jugador.equals(partida.getJ1())) {
            partida.setPtos_jugador1(puntosActuales);
            partida.ponerEnPendientes();
            JOptionPane.showMessageDialog(this, "¡Todas las preguntas completadas!\nHas ganado un total de " + puntosTotales + " puntos. \nQueda pendiente que el contrincante responda sus preguntas para conocer el resultado.", "Preguntas completadas", JOptionPane.PLAIN_MESSAGE);
        } else if (jugador.equals(partida.getJ2())) {
            partida.setPtos_jugador2(puntosActuales);
            partida.finalizarPartida();
            JOptionPane.showMessageDialog(this, "¡Todas las preguntas completadas!\nHas ganado un total de " + puntosTotales + " puntos. \nResultado:\n" + partida.toString(), "Partida completada", JOptionPane.PLAIN_MESSAGE);
        }

        this.setVisible(false);
        this.dispose();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bResponder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel preguntaNumero;
    private javax.swing.JLabel textoPistas;
    private javax.swing.JLabel textoPregunta;
    private javax.swing.JTextField textoRespuesta;
    // End of variables declaration//GEN-END:variables
}
