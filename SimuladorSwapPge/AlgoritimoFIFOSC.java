import java.util.LinkedList;
import java.util.Queue;

public class AlgoritimoFIFOSC implements Substituicao {
    private Queue<Pagina> fifoQueue = new LinkedList<>();

    @Override
    public void substituiPagina(Matriz ramMatriz, Matriz swapMatriz, int instrucao) {
        Pagina selectedPage = fifoQueue.poll();
        // Substituir a página
        if (selectedPage != null) {
            int selectedPageIndex = findPageIndexInMatrix(ramMatriz, selectedPage);
            if (selectedPageIndex != -1) {
                ramMatriz.matriz[selectedPage.getNum()][selectedPageIndex] = swapMatriz.matriz[instrucao - 1][0];
                swapMatriz.matriz[instrucao - 1][0] = selectedPage;
                fifoQueue.add(swapMatriz.matriz[instrucao - 1][0]);
            } else {
                System.out.println("Índice fora dos limites: " + selectedPageIndex);
            }
        }
    }

    private int findPageIndexInMatrix(Matriz ramMatriz, Pagina pagina) {
        for (int j = 0; j < ramMatriz.matriz[pagina.getNum()].length; j++) {
            if (ramMatriz.matriz[pagina.getNum()][j] != null && ramMatriz.matriz[pagina.getNum()][j].getNum() == pagina.getNum()) {
                return j;
            }
        }
        return -1;
    }
}
