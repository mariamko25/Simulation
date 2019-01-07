package com.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import com.evenement.Evenement;
import com.model.Simulation;

public class SimulationView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimulationView frame = new SimulationView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SimulationView() {
		
		setTitle("Simulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JComboBox<String> comboLoiArrivee = new JComboBox<String>();
		JComboBox<String> comboLoiService = new JComboBox<String>();
		JTextPane paramLoiArrivee = new JTextPane();
		paramLoiArrivee.setBounds(321, 86, 123, 27);
		contentPane.add(paramLoiArrivee);
		
		JTextPane paramLoiService = new JTextPane();
		paramLoiService.setBounds(321, 141, 123, 27);
		contentPane.add(paramLoiService);
		
		JButton btnLancer = new JButton("Lancer");
		btnLancer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!paramLoiArrivee.getText().isEmpty())
				{
					if(!paramLoiService.getText().isEmpty())
					{
						Evenement evt=new Evenement();
						
						//on r�cup�re le type de loi et le param�tre
						evt.setInterArrivee(Float.valueOf(paramLoiArrivee.getText()));
						evt.setLoiInterArrivee(comboLoiArrivee.getSelectedItem().toString());
						
						evt.setLoiDureeService(comboLoiService.getSelectedItem().toString());
						evt.setDureeService(Float.valueOf(paramLoiService.getText()));	
						//evt.setDureeService(Float.valueOf(paramLoiService.getText()));
						
						//lyy begin---
						Simulation sim=new Simulation(evt,"sim.csv",7200);
						//lyy end---
						try {
							sim.simulate();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				}
				
			}
		});
		btnLancer.setBounds(163, 243, 117, 29);
		contentPane.add(btnLancer);
		
		comboLoiArrivee.setModel(new DefaultComboBoxModel<String>(new String[] {"Loi exponentielle", "Loi normale","Loi uniforme", "Loi de poisson"}));
		comboLoiArrivee.setBounds(108, 86, 123, 27);
		contentPane.add(comboLoiArrivee);
		
		JLabel lblParamtre = new JLabel("parametre:");
		lblParamtre.setBounds(249, 86, 67, 27);
		contentPane.add(lblParamtre);
		
	
		JLabel lblNewLabel = new JLabel("arrivee");
		lblNewLabel.setBounds(29, 90, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblService = new JLabel("service");
		lblService.setBounds(29, 145, 61, 16);
		contentPane.add(lblService);
		
		//lyy begin---
//		comboLoiService.setModel(new DefaultComboBoxModel<String>(new String[] {"Loi exponentielle", "Loi normale","Loi uniforme", "Loi beta"}));
		comboLoiService.setModel(new DefaultComboBoxModel<String>(new String[] {"Loi exponentielle", "Loi normale","Loi uniforme", "Loi beta", "Constante"}));
		//lyy end---
		comboLoiService.setBounds(108, 141, 123, 27);
		contentPane.add(comboLoiService);
		
		JLabel label = new JLabel("parametre:");
		label.setBounds(249, 145, 67, 27);
		contentPane.add(label);	
		
	}
}
