package com.unab;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.function.*;

public class LambdaForm {
    private JPanel jpnlPanelPrincipal;
    private JPanel jpnlPanel1;
    private JPanel jpnlConsumidor;
    private JPanel jpnlFunciones;
    private JPanel jpnlPredicados;
    private JLabel lblEjemplo1;
    private JLabel lblResultado1;
    private JLabel lblResultado2;
    private JLabel lblResultado3;
    private JLabel lblResultado4;
    private JLabel lblResultado5;
    private JLabel lblResultado6;
    private JPanel jpnlProveedores;
    private JLabel lblResultado7;
    private JLabel lblResultado8;
    private JPanel jpnlCustom;
    private JLabel lblResultado9;
    private JLabel lblResultado10;
    private JMenuBar menuBar;
    private JPanel jpnlDesktop;
    private JDesktopPane dskpnlEscritorio;

    private HashMap<String, JInternalFrame> jFormInternal;

    public LambdaForm() {
        Runnable consumidorSinArgumentos = () -> lblResultado1.setText("No regreso nada...");
        Consumer<String> consumidorConArgumento = (String mensaje) -> lblResultado2.setText(mensaje);
        BiConsumer<String, String> consumidorConMultipleArgumentos = (mensaje, nombre) -> {
            StringBuilder mensajeCompleto = new StringBuilder();
            mensajeCompleto.append(mensaje).append(" ");
            mensajeCompleto.append(nombre);
            lblResultado3.setText(mensajeCompleto.toString());
        };
        consumidorSinArgumentos.run();
        consumidorConArgumento.accept("Hola");
        consumidorConMultipleArgumentos.accept("Hola", "Pastor");
        Supplier<Integer> funcionSinArgumentos = () -> 15;
        Function<String, String> funcion = (String mensaje) -> "Retorno de " + mensaje;
        BiFunction<String, String, String> funcionMultiple = (String pregunta, String nombre) -> "Mensaje " + pregunta + " " + nombre;
        lblResultado4.setText(funcion.apply("Hola"));
        lblResultado5.setText(funcionMultiple.apply("¿Como estas?", "¿Pastor?"));
        lblResultado6.setText(funcionSinArgumentos.get().toString());
        System.out.println("Mod");
        Predicate<Integer> predicado = numero -> numero > 16;
        BiPredicate<Integer, Integer> predicados = (numero1, numero2) -> numero1 > numero2;
        lblResultado7.setText(String.valueOf(predicado.test(15)));
        lblResultado8.setText(String.valueOf(predicados.test(17, 10)));
        CustomFunctional<String, String> mensajeCustom = (String nombre) -> {
            return nombre;
        };
        lblResultado9.setText(mensajeCustom.saludame("Gilberto"));
        lblResultado10.setText(mensajeCustom.defaultSaludo());
        JMenu menu1 = new JMenu("Archivo");
        JMenuItem item1 = new JMenuItem("Abrir nuevo");
        item1.addActionListener(this::actionPerformed);
        menu1.add(item1);
        menuBar.add(menu1);
    }

    @PostConstruct
    private void construirMenu() {
        System.out.println("Hola");
    }

    public JPanel getJpnlPanelPrincipal() {
        return jpnlPanelPrincipal;
    }

    private void actionPerformed(ActionEvent evt) {
        try {
            JInternalFrame frmIn = new JInternalFrame("Ventana Nueva", true, true, true, true);
            frmIn.setLayout(new FlowLayout(SwingConstants.CENTER, 10, 10));
            JTextArea textArea = new JTextArea();
            frmIn.add(textArea);
            frmIn.setBounds(10,10,200,200);
            frmIn.show();
            dskpnlEscritorio.add(frmIn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}