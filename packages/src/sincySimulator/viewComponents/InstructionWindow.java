package sincySimulator.viewComponents;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sincySimulator.Controller;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class InstructionWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Controller cont;
	private JEditorPane editorPane;

	/**
	 * Create the frame.
	 * @param controller 
	 */
	public InstructionWindow(Controller controller) {
		cont = controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		editorPane = new JEditorPane();
		contentPane.add(editorPane, BorderLayout.CENTER);
		
		JLabel lblEnterInstructions = new JLabel("Enter Instructions:");
		contentPane.add(lblEnterInstructions, BorderLayout.NORTH);
		
		JButton btnFinished = new JButton("Finished");
		contentPane.add(btnFinished, BorderLayout.SOUTH);
		btnFinished.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cont.passText(editorPane);
		cont.operation(e.getActionCommand());
	}
}
