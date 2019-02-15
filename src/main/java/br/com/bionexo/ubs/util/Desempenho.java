package br.com.bionexo.ubs.util;

public enum Desempenho {
	ACIMA_MEDIA(1, "Desempenho acima da média"),
	MEDIANO_POUCO_ABAIXO(2, "Desempenho mediano ou  um pouco abaixo da média"),
	MUITO_ACIMA(3, "Desempenho muito acima da média"), 
	
	NAO_ENCONTRADO(0, "Não Encontrado"); 
	
	private final int num;
	private final String descricao;
	
	private Desempenho(int num, String descricao) {
		this.num = num;
		this.descricao = descricao;
	}
	
    public static int buscaPorString(String text) {
        for (Desempenho num : Desempenho.values()) {
            if (num.descricao.equalsIgnoreCase(text)) {
                return num.getNum();
            }
        }
        return NAO_ENCONTRADO.getNum();
    }

	public int getNum() {
		return num;
	}

	public String getDescricao() {
		return descricao;
	}
}
