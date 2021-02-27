package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String[] args) {
		
		KillController op = new KillController();
		int pid;
		int opc = 0;
		String name;
		
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada: \n"
					+ "1 - Listar processos; \n"
					+ "2 - Matar processo por PID; \n"
					+ "3 - Matar processo por nome; \n"
					+ "0 - Sair da aplicação."));
			
			switch(opc) {
			case 1: op.listarProcessos();
			break;
			case 2: pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID do processo a ser finalizado"));
			op.killProcessByPID(pid);
			break;
			case 3: name = JOptionPane.showInputDialog("Digite o nome do processo a ser finalizado: ");
			op.killProcessByName(name);
			break;
			case 0: JOptionPane.showMessageDialog(null, "Obrigado por utilizar a aplicação");
			break;
			default: JOptionPane.showMessageDialog(null, "Opção inválida");
			} 		
		} while (opc!=0);
		
	}

}
