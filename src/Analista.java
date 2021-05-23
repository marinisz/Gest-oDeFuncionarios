import java.util.Scanner;

public class Analista extends Funcionario implements INivel,CLT{
    static int MAXHR = 40;
    protected int qtHorasExtras;
    protected Nivel nivel;
    //nivel

    public Analista(){
        this.setMatricula(0);
    }
    public Analista(int n, String nome) {
        super(n, nome);
    }

    public int getQtHorasExtras() {
        return qtHorasExtras;
    }

    public void setQtHorasExtras(int qtHorasExtras) {
        if(qtHorasExtras<=MAXHR){
            this.qtHorasExtras = qtHorasExtras;
        }else{
            this.qtHorasExtras = MAXHR;
        }

    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Analista newAnalista(){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Nome: ");
        this.setNome(teclado.nextLine());
        System.out.println("1 - Senior\n2 - Junior");
        int resp2 = 0;
        while(resp2>2||resp2<1){
            System.out.print("Sua opção: ");
            resp2 = teclado.nextInt();
        }
        if(resp2==1){
            this.setNivel(Nivel.Senior);
        }else{
            this.setNivel(Nivel.Junior);
        }
        System.out.println("Insira horas extra, ou 0 para nenhuma");
        try {
            this.setQtHorasExtras(teclado.nextInt());
        }catch (Exception ex){
            System.out.println("Erro: "+ex);
            this.setQtHorasExtras(0);
        }

        return this;
    }

    @Override
    public double getSalarioBase() {
        double salario = 0;
        if(this.nivel==Nivel.Senior){
            salario = Nivel.Senior.salario;
        }if(this.nivel==Nivel.Junior){
            salario = Nivel.Junior.salario;
        }
        return salario;
    }

    @Override
    public double calcPagamento(){
        double extra=valorHorasExtras();
        this.setPagtoAReceber(this.getSalarioBase()+extra);
        return this.getSalarioBase()+extra;
    }

    @Override
    public double valorHorasExtras() {
        double extra=0;
        if(this.getQtHorasExtras()>0){
            extra = this.getQtHorasExtras()*((1/90)*this.getSalarioBase());
        }
        return extra;
    }

    @Override
    public double valorFerias(int meses) {
        return 0;
    }

    @Override
    public double impostoAPagar() {
        double salario = calcPagamento();
        if(salario > 3305.22){
            return 0.14*salario;
        }
        else{
            return 0.12*salario;
        }
    }
}
