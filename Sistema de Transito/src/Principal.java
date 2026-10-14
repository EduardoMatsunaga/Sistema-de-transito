import javax.swing.*;
public class Principal {
	public static void main (String args []) {
		Cidade [] cidade = new Cidade [10];
		Metodos m = new Metodos ();
		
		int i;
		for (i=0;i<10;i++) {
			cidade [i] = new Cidade(); 
		}
		int opc = 0;
		while (opc!=9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Estatisticas de acidentes em 2020\n 1 - Cadastro Estatisticas\n"
				+ "2-Consulta por quantidade de acidentes\n 3-Consulta por estatísticas de acidentes\n"
				+ "4-Acidentes acima da média das 10 cidades\n 9-Fim do programa"));
			
			switch (opc) {
				case 1: m.FCadastraEstatistica(cidade);
				break;
				
				case 2: m.PQTAcidentes(cidade);
				break;
				
				case 3: m.PMaiorMenor(cidade);
				break;
				
				case 4: m.PAcima(cidade);
				break;
				
				case 9: JOptionPane.showMessageDialog(null, "O programa foi finalizado");
				break;
				
				default:
					JOptionPane.showMessageDialog(null, "Opção Invalida");
			}
		}
	}
}
