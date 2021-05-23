import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {
    public String path = "C:\\Users\\marin\\OneDrive\\Área de Trabalho\\revisaoModular\\func.txt";

    public void writeFileAnalista(Analista analista){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(path,true));
            bw.write(analista.getNivel().toString()+";");
            bw.write(analista.getMatricula()+";");
            bw.write(analista.getNome()+";");
            bw.write(analista.getQtHorasExtras()+";");
            bw.write("\n");
            bw.close();
        }catch (Exception ex){
            System.out.println("error");
            ex.printStackTrace();
        }
    }

    public void writeFileGerente(Gerente gerente){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(path,true));
            bw.write("Gerente;");
            bw.write(gerente.getMatricula()+";");
            bw.write(gerente.getNome()+";");
            bw.write(gerente.getQtProjetos()+";");
            bw.write("\n");
            bw.close();
        }catch (Exception ex){
            System.out.println("error");
            ex.printStackTrace();
        }
    }

    public List<Funcionario> readFile(){
        List <Funcionario> listaFunc = new ArrayList<Funcionario>();
        try{
            FileReader fw = new FileReader(path);
            BufferedReader br = new BufferedReader(fw);
            String s;
            ArrayList<String> func = new ArrayList();
            while((s = br.readLine())!=null){
                StringBuilder leitura = new StringBuilder();
                String[] a =s.split(";");

                if(a[0].equals("Junior")){
                    Analista analista = new Analista();
                    analista.setNivel(Nivel.Junior);
                    analista.setNome(a[2]);
                    analista.setQtHorasExtras(Integer.parseInt(a[3]));
                    analista.setMatricula(Integer.parseInt(a[1]));
                    listaFunc.add(analista);
                }
                else if(a[0].equals("Senior")){
                    Analista analista = new Analista();
                    analista.setNivel(Nivel.Senior);
                    analista.setNome(a[2]);
                    analista.setQtHorasExtras(Integer.parseInt(a[3]));
                    analista.setMatricula(Integer.parseInt(a[1]));
                    listaFunc.add(analista);
                }
                else if(a[0].equals("Gerente")){
                    Gerente gerente = new Gerente();
                    gerente.setNome(a[2]);
                    gerente.setQtProjetos(Integer.parseInt(a[3]));
                    gerente.setMatricula(Integer.parseInt(a[1]));
                    listaFunc.add(gerente);
                }

                for(int i = 0;i<a.length;i++){
                    leitura.append(a[i]);
                }
                func.add(leitura.toString());
            }
            br.close();
            return listaFunc;
        }catch (Exception ex){
            System.out.println(ex);
            return null;
        }
    }

    public int readMat(){
        try{
            FileReader fw = new FileReader(path);
            BufferedReader br = new BufferedReader(fw);
            String s;
            int mat = 0;
            while((s = br.readLine())!=null){
                StringBuilder leitura = new StringBuilder();
                String[] a =s.split(";");
                for(int i = 0;i<a.length;i++){
                    leitura.append(a[i]);
                }
                mat = Integer.parseInt(a[1]);
            }
            br.close();
            return mat;
        }catch (Exception ex){
            System.out.println(ex);
            return 0;
        }
    }

}