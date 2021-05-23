public class Funcionario {
    protected int matricula;
    protected String nome;
    protected double pagtoAReceber = 2500;

    public  Funcionario(){}

    public Funcionario(int n,String nome){
        this.matricula=n;
        this.nome=nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPagtoAReceber() {
        return pagtoAReceber;
    }

    public void setPagtoAReceber(double pagtoAReceber) {
        this.pagtoAReceber = pagtoAReceber;
    }

    public double calcPagamento(){
        double salario=0;

        return salario;
    }
}
