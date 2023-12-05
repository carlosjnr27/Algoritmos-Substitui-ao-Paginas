import java.util.Random;

public class SubstituicaoDePagina {
    public static void main(String[] args) {
        Matriz swapMatriz = initializeMatriz(100, 6);
        Matriz ramMatriz = initializeMatriz(10, 6);

        System.out.println("### Início da execução ###");
        printMatrices(swapMatriz, ramMatriz);

        Substituicao[] algoritimos = {
                new AlgoritimoNRU(),
                new AlgoritimoFIFO(),
                new AlgoritimoFIFOSC(),
                new AlgoritimoRelogio(),
                new AlgoritimoWSClock()
        };

        for (Substituicao algoritimo : algoritimos) {
            executeInstructions(algoritimo, ramMatriz, swapMatriz);
            System.out.println("### Fim da execução do algoritmo " + algoritimo.getClass().getSimpleName() + " ###");
            printMatrices(swapMatriz, ramMatriz);
        }
    }

    private static Matriz initializeMatriz(int li, int col) {
        Matriz matriz = new Matriz(li, col);

        for (int i = 0; i < matriz.matriz.length; i++) {
            for (int j = 0; j < matriz.matriz[i].length; j++) {
                int pageNumber = i * matriz.matriz[i].length + j;
                int instruction = pageNumber + 1;
                int data = new Random().nextInt(50) + 1;
                int agingTime = new Random().nextInt(9900) + 100;

                matriz.matriz[i][j] = new Pagina(pageNumber, instruction, data, agingTime);
            }
        }
        return matriz;
    }

    private static void printMatrices(Matriz swapMatriz, Matriz ramMatriz) {
        System.out.println("### MATRIZ SWAP ###");
        printMatrix(swapMatriz);

        System.out.println("\n### MATRIZ RAM ###");
        printMatrix(ramMatriz);

        System.out.println("####################\n");
    }

    private static void printMatrix(Matriz matriz) {
        for (Pagina[] row : matriz.matriz) {
            for (Pagina pagina : row) {
                System.out.printf("%-8d", pagina.getInstrucao());
            }
            System.out.println();
        }
    }

    private static void executeInstructions(Substituicao algoritmo, Matriz ramMatriz, Matriz swapMatriz) {
        for (int i = 0; i < 1000; i++) {
            int instrucao = new Random().nextInt(100) + 1;
            algoritmo.substituiPagina(ramMatriz, swapMatriz, instrucao);

            // Zera o bit de acesso a cada 10 instruções
            if (i % 10 == 0) {
                for (Pagina[] row : ramMatriz.matriz) {
                    for (Pagina pagina : row) {
                        if (pagina != null) {
                            pagina.setBitAcesso(0);
                        }
                    }
                }
            }
        }
    }
}
