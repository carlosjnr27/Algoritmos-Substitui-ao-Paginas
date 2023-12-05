public class Pagina {
    private int num;
    private int instrucao;
    private int data;
    private int bitAcesso;
    private int bitModificador;
    private int agingTime;

    public Pagina(int num, int instrucao, int data, int agingTime) {
        this.num = num;
        this.instrucao = instrucao;
        this.data = data;
        this.bitAcesso = 0;
        this.bitModificador = 0;
        this.agingTime = agingTime;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getInstrucao() {
        return this.instrucao;
    }

    public void setInstrucao(int instrucao) {
        this.instrucao = instrucao;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getBitAcesso() {
        return this.bitAcesso;
    }

    public void setBitAcesso(int bitAcesso) {
        this.bitAcesso = bitAcesso;
    }

    public int getBitModificador() {
        return this.bitModificador;
    }

    public void setBitModificador(int bitModificador) {
        this.bitModificador = bitModificador;
    }

    public int getAgingTime() {
        return this.agingTime;
    }

    public void setAgingTime(int agingTime) {
        this.agingTime = agingTime;
    }
    
}
