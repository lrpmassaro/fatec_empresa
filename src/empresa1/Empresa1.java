package empresa1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Empresa1 {

    public static void main(String[] args) throws FileNotFoundException {
        File arq = new File("dados.txt");
        Scanner entrada = new Scanner(arq);

        String nome[] = new String[9];
        int anoContrato[] = new int[9];
        double salario[] = new double[9];
        int numDep[] = new int[9];
        double valorHe[] = new double[9];

        //cabeçalho
        System.out.printf("%6s %12s %10s %7s %8s \n",
                entrada.next(), entrada.next(), entrada.next(),
                entrada.next(), entrada.next());

        //leitura e escrita dos dados
        for (int lin = 0; lin < 9; lin++) {
            nome[lin] = entrada.next();
            anoContrato[lin] = entrada.nextInt();
            salario[lin] = entrada.nextDouble();
            numDep[lin] = entrada.nextInt();
            valorHe[lin] = entrada.nextDouble();

            System.out.printf("%6s %12s %10.2f %7s %8.2f \n",
                    nome[lin], anoContrato[lin], salario[lin],
                    numDep[lin], valorHe[lin]);
        }

        //gerentes
        System.out.println("");
        System.out.printf("Gerente:   Salário: \n");
        boolean achou = false;
        while (!achou) {
            for (int lin = 0; lin < 9; lin++) {
                if (valorHe[lin] == 0) {
                    achou = true;
                    System.out.printf("%8s %10.2f \n", nome[lin], salario[lin]);
                }
            }
        }
        
        //funcionario mais antigo
        System.out.println("");
        int ano = 2012;
        int pos = 0;
        for(int lin=0; lin<9; lin++){
            if(anoContrato[lin] < ano){
                ano = anoContrato[lin];
                pos = lin;
            }
        }
        System.out.println("Funcionário mais antigo: " + nome[pos]);
        System.out.println("Contratado em: " + ano);
        
        //média dos salarios
        System.out.println("");
        double somaSal = 0;
        double mediaSal = 0;
        for(int lin=0; lin<9; lin++){
            somaSal = somaSal + salario[lin];
        }
        mediaSal = somaSal/9;
        System.out.printf("Média salarial: R$%.2f \n", mediaSal);
        
        //reajuste salarial
        System.out.println("");
        double salFinal[] = new double[9];
        double valorHeFinal[] = new double[9];
        for(int lin=0; lin<9; lin++){
            if(salario[lin] > mediaSal){
                valorHeFinal[lin] = valorHe[lin] + (valorHe[lin] * 0.10);
                salFinal[lin] = (salario[lin] + (salario[lin] * 0.10));
            }
            if(salario[lin] < mediaSal){
                valorHeFinal[lin] = valorHe[lin] + (valorHe[lin] * 0.20);
                salFinal[lin] = (salario[lin] + (salario[lin] * 0.20));
            }
            System.out.println("Nome: " + nome[lin]);
            System.out.printf("Salário antigo: R$%.2f \n", salario[lin]);
            System.out.printf("Novo salário: R$%.2f \n", salFinal[lin]);
            System.out.printf("Valor hora extra antigo: R$%.2f \n", valorHe[lin]);
            System.out.printf("Novo valor hora extra: R$%.2f \n", valorHeFinal[lin]);
            System.out.println("");
        }
    }
}
