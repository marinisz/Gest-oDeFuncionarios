import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    public List <Funcionario> funcionarios=new ArrayList<Funcionario>();

    public void addFuncionario(){
        Arquivo arq = new Arquivo();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Qual cargo:");
        System.out.println("1 - Analista\n2 - Gerente");
        int resp = 0;
        int matricula = arq.readMat()+1;
        while(resp>2||resp<1){
            System.out.print("Sua opção: ");
            resp = teclado.nextInt();
        }
        if (resp==1){
            Analista analista = new Analista();
            analista.newAnalista();
            analista.setMatricula(matricula);
            arq.writeFileAnalista(analista);
        }else{
            Gerente gerente = new Gerente();
            gerente.newGerente();
            gerente.setMatricula(matricula);
            arq.writeFileGerente(gerente);
        }
    }

    public double calcTotalAPagar(){
        double total = 0;
        Arquivo arq = new Arquivo();
        funcionarios = arq.readFile();
        if(funcionarios.size()>0){
            for(int i = 0;i<funcionarios.size();i++){
                total+=funcionarios.get(i).pagtoAReceber;
            }
        }else{
            return 0;
        }
        return total;
    };

    public double calcPagamento(int matricula){
        Arquivo arq = new Arquivo();
        funcionarios = arq.readFile();
        if(funcionarios.size()>0){
            for(int i = 0;i<funcionarios.size();i++){
                if(funcionarios.get(i).getMatricula()==matricula){
                    System.out.println(funcionarios.get(i).getNome()+" - "+funcionarios.get(i).getPagtoAReceber());
                    return funcionarios.get(i).getPagtoAReceber();
                }
            }
        }else{
            return 0;
        }
        System.out.println("Não encontrado");
        return 0;
    }

    public void menu(){
        System.out.println("Bem Vindo ao Sistema RH - 1-01-01");
        Scanner teclado = new Scanner(System.in);
        int resp = 0;
        while(resp!=4){
            System.out.println("1 - Adicionar Funcionario");
            System.out.println("2 - Calcular salario de funcionario");
            System.out.println("3 - Calcular folha de pagamento completa");
            System.out.println("4 - Sair");
            System.out.print("Sua opção: ");
            resp = teclado.nextInt();
            if(resp==1) this.addFuncionario();
            if(resp==2) {
                System.out.print("Informe a matricula do funcionario:");
                int a = teclado.nextInt();
                this.calcPagamento(a);
            }
            if(resp==3){
                System.out.println("O valor total da folha é: "+calcTotalAPagar());
            }
            if(resp>4||resp<1){
                System.out.println("Opção Inválida!");
            }
        }

    }
}
