public class Cidade {
	int cod_cid;
	String nome_cid;
	int acidentes;
	
	Cidade () {
		this(0,"",0);
	}
	
	Cidade (int codigo, String nome, int acid) {
		cod_cid = codigo;
		nome_cid = nome;
		acidentes = acid;
	}
}
