

public class AlgoritimoRelogio implements Substituicao {
    private int ponteiro = 0;

    @Override
    public void substituiPagina(Matriz ramMatriz, Matriz swapMatriz, int instrucao) {
        while (true) {
            // Verificar a página mais antiga
            int li = ponteiro / ramMatriz.matriz[0].length;
            int col = ponteiro % ramMatriz.matriz[0].length;

            if (li < ramMatriz.matriz.length && col < ramMatriz.matriz[li].length) {
                Pagina pagina = ramMatriz.matriz[li][col];

                if (pagina.getBitAcesso() == 0) {
                    if (pagina.getBitModificador() == 1) {
                        int swapli = pagina.getNum() / swapMatriz.matriz[0].length;
                        int swapCol = pagina.getNum() % swapMatriz.matriz[0].length;

                        if (swapli >= 0 && swapli < swapMatriz.matriz.length && swapCol < swapMatriz.matriz[swapli].length) {
                            ramMatriz.matriz[li][col] = swapMatriz.matriz[swapli][swapCol];
                            swapMatriz.matriz[pagina.getNum()][0] = pagina;
                            pagina.setBitModificador(0);
                        }
                    }

                    for (int i = 0; i < swapMatriz.matriz.length; i++) {
                        for (int j = 0; j < swapMatriz.matriz[i].length; j++) {
                            Pagina novaPagina = swapMatriz.matriz[i][j];
                            if (novaPagina != null && novaPagina.getInstrucao() == instrucao) {
                                ramMatriz.matriz[li][col] = novaPagina;
                                return;
                            }
                        }
                    }
                } else {
                    pagina.setBitAcesso(0);
                }
            }

            ponteiro = (ponteiro + 1) % (ramMatriz.matriz.length * ramMatriz.matriz[0].length);
        }
    }
}
