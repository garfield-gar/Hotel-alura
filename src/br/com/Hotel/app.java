package br.com.Hotel;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class app {
    public static void main(String[] args) {
        // Criar uma nova instância de JFrame
        JFrame frame = new JFrame("Hotel Alura ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Criar um JLabel com texto
        JLabel label = new JLabel("Olá, Mundo!");
        
        // Adicionar o JLabel ao JFrame
        frame.getContentPane().add(label);
        
        // Configurar o tamanho do JFrame
        frame.setSize(300, 200);
        
        // Tornar o JFrame visível
        frame.setVisible(true);
    }
}
