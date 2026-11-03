import javax.swing.*;
import java.io.*;
public class Metodos {
	String fileName = "ArquivoSistemaTransito.txt";
    public Cidade [] FCadastraEstatistica (Cidade[] cidade) throws IOException {
	int i;
 
    BufferedWriter gravar = new BufferedWriter (new FileWriter (fileName));
	for (i=0;i<10;i++) {
            cidade[i].cod_cid = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo da cidade " + (i+1)+":"));
            gravar.write(Integer.toString(cidade[i].cod_cid)); gravar.newLine();
            
            cidade[i].nome_cid = JOptionPane.showInputDialog("Digite o nome da cidade: ");
            gravar.write(cidade[i].nome_cid); gravar.newLine();
            
            cidade[i].acidentes = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de acidentes em 2020: "));
            gravar.write(Integer.toString(cidade[i].acidentes)); gravar.newLine();
	}
        System.out.println("Gravação feita com sucesso");
        gravar.close();
	return cidade;
    }
    
    public Cidade [] FLeArquivo (Cidade[] cidade) throws IOException {
        int i;
        BufferedReader ler = new BufferedReader (new FileReader (fileName));
        for (i=0;i<10;i++) {
            cidade[i].cod_cid = Integer.parseInt(ler.readLine());
            cidade[i].nome_cid = ler.readLine();
            cidade[i].acidentes = Integer.parseInt(ler.readLine());
        }
        ler.close();
        return cidade;
    }
    
    public void PQTAcidentes (Cidade [] cidade) throws IOException {
        int i, qtd;
        cidade = FLeArquivo(cidade);
		qtd = 0;
        
	for(i=0;i<10;i++) {
            if (cidade[i].acidentes > 100 && cidade[i].acidentes < 500) {
		System.out.println(cidade[i].cod_cid + " " + cidade[i].nome_cid + " acidentes: " + cidade[i].acidentes);
		qtd +=1;
            }
	}
	if (qtd == 0) {
            System.out.println("Nenhuma cidade registrada entra na faixa de 100 a 500 acidentes.");
	}
    }
    public void PMaiorMenor(Cidade [] cidade) throws IOException {
        int maior, menor, i;
	maior = 0; 
	menor = 0;
	cidade = FLeArquivo(cidade);
	for (i = 0;i<10;i++) {
            if (cidade[i].acidentes > cidade[maior].acidentes ) {
		maior = i;
            }
            else if (cidade[i].acidentes < cidade[menor].acidentes ) {
		menor = i;
            }
	}
		
	System.out.println("Maior: " + cidade[maior].cod_cid + " " + cidade[maior].nome_cid + " acidentes: " + cidade[maior].acidentes);
	System.out.println("Menor: " + cidade[menor].cod_cid + " " + cidade[menor].nome_cid + " acidentes: " + cidade[menor].acidentes);
        
    }
    public void PAcima (Cidade [] cidade) throws IOException {
        double media = 0;
	int i, qtd;
	cidade = FLeArquivo(cidade);
	for (i=0;i<10;i++) {
            media += cidade[i].acidentes;
	}
        media = media / 10;
	qtd = 0;
	for(i=0;i<10;i++) {
            if (cidade[i].acidentes > media) {
		System.out.println(cidade[i].cod_cid + " " + cidade[i].nome_cid + " acidentes: " + cidade[i].acidentes);
		qtd +=1;
			}
        }
	if (qtd == 0) {
            System.out.println("Nenhuma cidade está acima da média de " + media + " acidentes.");
	}
        
    }
}

