import java.util.Scanner;

public class Gerente extends Funcionario implements PJ{
    static int MAXPR = 5;
    protected int qtProjetos=0;

    public Gerente(){
        this.setMatricula(0);
    }

    public Gerente(int n, String nome) {
        super(n, nome);
        this.setPagtoAReceber(2500);
    }

    public Gerente newGerente(){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Nome: ");
        this.setNome(teclado.nextLine());
        System.out.println("Insira quantidade de projetos, ou 0 para nenhum");
        try {
            this.setQtProjetos(teclado.nextInt());
        }catch (Exception ex){
            System.out.println("Erro"+ex);
            this.setQtProjetos(0);
        }
        return this;
    }

    public int getQtProjetos() {
        return qtProjetos;
    }

    public void setQtProjetos(int qtProjetos) {
        if(qtProjetos<=MAXPR){
            this.qtProjetos = qtProjetos;
        }else{
            this.qtProjetos = 5;
        }

    }

    @Override
    public double valorBonus() {
        return this.getPagtoAReceber()*(1+this.getQtProjetos()*20);
    }

    @Override
    public double calcPagamento(){
        if(qtProjetos>0){
            this.setPagtoAReceber(this.getPagtoAReceber()*valorBonus());
            return this.getPagtoAReceber()*valorBonus();
        }else {
            return this.pagtoAReceber;
        }
    }
}
