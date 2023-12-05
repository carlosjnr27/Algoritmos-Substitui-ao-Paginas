import java.util.Random;

public class AlgoritimoNRU implements Substituicao {
    @Override
    public void substituiPagina(Matriz ramMatriz, Matriz swapMatriz, int instrucao) {
        // Lógica de seleção de página com base nos bits R e M
        for (int i = 0; i < ramMatriz.matriz.length; i++) {
            for (int j = 0; j < ramMatriz.matriz[i].length; j++) {
                Pagina pagina = ramMatriz.matriz[i][j];
                if (pagina.getBitAcesso() == 0 && pagina.getBitModificador() == 0) {
                    // Classe 0
                } else if (pagina.getBitAcesso() == 0 && pagina.getBitModificador() == 1) {
                    // Classe 1
                } else if (pagina.getBitAcesso() == 1 && pagina.getBitModificador() == 0) {
                    // Classe 2
                } else if (pagina.getBitAcesso() == 1 && pagina.getBitModificador() == 1) {
                    // Classe 3
                }
            }
        }

        // Selecionar aleatoriamente uma página de uma classe não vazia
        int selectedClass = new Random().nextInt(4);
        Pagina selectedPage = getRandomPageFromClass(ramMatriz, selectedClass);

        // Substituir a página
        if (selectedPage != null) {
            int selectedPageIndex = findPageIndexInMatrix(ramMatriz, selectedPage);
            if (selectedPageIndex != -1) {
                ramMatriz.matriz[selectedClass][selectedPageIndex] = swapMatriz.matriz[instrucao - 1][0];
                swapMatriz.matriz[instrucao - 1][0] = selectedPage;
            } else {
                System.out.println("Índice fora dos limites: " + selectedPageIndex);
            }
        }
    }

    private Pagina getRandomPageFromClass(Matriz ramMatriz, int selectedClass) {
        for (int j = 0; j < ramMatriz.matriz[selectedClass].length; j++) {
            Pagina pagina = ramMatriz.matriz[selectedClass][j];
            if (pagina != null) {
                return pagina;
            }
        }
        return null;
    }

    private int findPageIndexInMatrix(Matriz ramMatriz, Pagina pagina) {
        for (int i = 0; i < ramMatriz.matriz.length; i++) {
            for (int j = 0; j < ramMatriz.matriz[i].length; j++) {
                if (ramMatriz.matriz[i][j] != null && ramMatriz.matriz[i][j].getNum() == pagina.getNum()) {
                    return j;
                }
            }
        }
        return -1;
    }
}
