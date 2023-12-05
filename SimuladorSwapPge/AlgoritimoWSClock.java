
public class AlgoritimoWSClock implements Substituicao {
    private int ponteiro = 0;

    @Override
    public void substituiPagina(Matriz ramMatriz, Matriz swapMatriz, int instrucao) {
        while (true) {
            // Verificar a página mais antiga
            int li = ponteiro / ramMatriz.matriz[0].length;
            int col = ponteiro % ramMatriz.matriz[0].length;

            if (li < ramMatriz.matriz.length && col < ramMatriz.matriz[li].length) {
                Pagina pagina = ramMatriz.matriz[li][col];

                if (pagina.getBitAcesso() == 1) {
                    pagina.setBitAcesso(0);
                } else if (pagina.getBitAcesso() == 0 && pagina.getBitModificador() == 1) { 
                    pagina.setBitModificador(0);
                } else { // Substituir a página
                    int swapli = pagina.getNum() / swapMatriz.matriz[0].length;
                    int swapCol = pagina.getNum() % swapMatriz.matriz[0].length;

                    if (swapli < swapMatriz.matriz.length && swapCol < swapMatriz.matriz[swapli].length) {
                        ramMatriz.matriz[li][col] = swapMatriz.matriz[swapli][swapCol];
                        swapMatriz.matriz[pagina.getNum()][0] = pagina;
                        break;
                    } else {
                        System.out.println("Índice de swap fora dos limites: [" + swapli + "][" + swapCol + "]");
                    }
                }
            } else {
                System.out.println("Índice de ramMatriz fora dos limites: [" + li + "][" + col + "]");
            }

            ponteiro = (ponteiro + 1) % (ramMatriz.matriz.length * ramMatriz.matriz[0].length);
        }
    }
}
