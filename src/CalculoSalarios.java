import java.util.Scanner;

public class CalculoSalarios {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("# PROJETO: Cálculo de Salário #\n");
        double salarios[] = new double[5];

        obterPagamentos(salarios, sc);
        calcularEimprimirRelatorio(salarios);

        sc.close();
    }

    private static void obterPagamentos(double[] salarios, Scanner sc) {
        for (int i = 0; i < salarios.length; i++) {
            System.out.println("Informe o valor bruto do " + (i + 1) + "º pagamento:");
            salarios[i] = sc.nextDouble();
        }
    }

    private static void calcularEimprimirRelatorio(double[] salarios) {
        System.out.println("\n# RELATÓRIO DE PAGAMENTOS E DESCONTOS #\n");

        for (int i = 0; i < salarios.length; i++) {
            double descontoINSS = calculaDescontoINSS(salarios[i]);
            double descontoIR = calculaDescontoIR(salarios[i]);
            double salarioLiquido = salarios[i] - (descontoINSS + descontoIR);
            System.out.printf("Para o %dº pagamento informado:\n" +
                    "Salário bruto: R$ %.2f\n" +
                    "Desconto INSS: R$ %.2f\n" +
                    "Desconto IR: R$ %.2f\n"+
                    "Salário líquido: R$ %.2f\n\n", (i + 1), salarios[i], descontoINSS, descontoIR, salarioLiquido);
        }
    }

    private static double calculaDescontoINSS(double salario) {
        if(salario <= 1212.00) {
            return salario * 0.075;
        } else if(salario <= 2427.35) {
            return salario * 0.09;
        } else if(salario <= 3641.03) {
            return salario * 0.12;
        } else {
            return salario * 0.14;
        }
    }

    private static double calculaDescontoIR(double salario) {
        if(salario <= 1903.98) {
            return 0.0;
        } else if(salario <= 2826.65) {
            return salario * 0.075;
        } else if(salario <= 3751.05) {
            return salario * 0.15;
        } else if(salario <= 4664.68) {
            return salario * 0.22;
        } else {
            return salario * 0.275;
        }
    }
}
